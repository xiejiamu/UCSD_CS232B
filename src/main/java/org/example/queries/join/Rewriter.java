package org.example.queries.join;

import org.antlr.v4.runtime.misc.Pair;
import org.example.parsers.XQueryParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Rewriter {
    public static String convert(XQueryParser.ForXqContext ctx) {
        StringBuilder sb = new StringBuilder();
        List<Map<String, String>> forList = new ArrayList<>();
        List<Map<Integer, String>> forOrderList = new ArrayList<>();
        // Construct forList and forOrderList
        IntStream.range(0, ctx.forClause().VAR().size()).forEach(i -> {
            String var = ctx.forClause().VAR(i).getText();
            String xq = ctx.forClause().xq(i).getText();
            String root = xq.split("/")[0];

            OptionalInt index = IntStream.range(0, forList.size())
                    .filter(j -> forList.get(j).containsKey(root))
                    .findFirst();

            if (index.isPresent()) {
                forList.get(index.getAsInt()).put(var, xq);
                forOrderList.get(index.getAsInt()).put(forOrderList.get(index.getAsInt()).size(), var);
            } else {
                Map<String, String> forMap = new HashMap<>();
                forMap.put(var, xq);
                forList.add(forMap);
                Map<Integer, String> orderMap = new HashMap<>();
                orderMap.put(0, var);
                forOrderList.add(orderMap);
            }
        });

        // Process where clause and construct whereList
        List<List<Pair<String, String>>> whereList = new ArrayList<>();
        forList.forEach(ignored -> whereList.add(new ArrayList<>()));
        constructWhereList(ctx, forList, whereList);


        // Generate rewriters from forList and whereList
        List<Rewriter> reWriterList = IntStream.range(0, forList.size())
                .mapToObj(i -> {
                    Rewriter reWriter = new Rewriter();
                    reWriter.setForMap(forList.get(i), forOrderList.get(i));
                    reWriter.setCondList(whereList.get(i));
                    return reWriter;
                }).collect(Collectors.toList());

        if (reWriterList.isEmpty()) {
            return "";
        }

        // Build the rewriter string using forList, whereList, and reWriterList
        Set<Integer> picked = new HashSet<>();
        picked.add(0);
        Set<String> varSet = new HashSet<>(forList.get(0).keySet());
        sb.append(reWriterList.get(0).convertToString());
        buildRewriterString(forList, whereList, reWriterList, picked, varSet, sb);


        // Append return clause
        appendReturnClause(ctx, sb);
        return sb.toString();
    }

    private static void constructWhereList(XQueryParser.ForXqContext ctx, List<Map<String, String>> forList, List<List<Pair<String, String>>> whereList) {
        Arrays.stream(ctx.whereClause().cond().getText().split("and")).forEach(where -> {
            String[] parts = where.split("eq|=");
            String left = parts[0].trim();
            String right = parts[1].trim();

            IntStream.range(0, forList.size()).forEach(i -> {
                if (forList.get(i).containsKey(left) || forList.get(i).containsKey(right)) {
                    whereList.get(i).add(new Pair<>(left, right));
                }
            });
        });
    }

    private static void buildRewriterString(List<Map<String, String>> forList, List<List<Pair<String, String>>> whereList,
                                            List<Rewriter> reWriterList, Set<Integer> picked, Set<String> varSet, StringBuilder sb) {
        while (picked.size() < forList.size()) {
            boolean updated = false;
            for (int i = 1; i < forList.size(); i++) {
                if (!picked.contains(i)) {
                    List<String> condLeft = new ArrayList<>();
                    List<String> condRight = new ArrayList<>();

                    // Determine join conditions
                    for (Pair<String, String> pair : whereList.get(i)) {
                        String left = pair.a;
                        String right = pair.b;
                        if ((varSet.contains(left) && forList.get(i).containsKey(right)) ||
                                (varSet.contains(right) && forList.get(i).containsKey(left))) {
                            condLeft.add(left);
                            condRight.add(right);
                        }
                    }

                    // Update the StringBuilder and tracking sets if a match is found
                    if (!condLeft.isEmpty()) {
                        sb.insert(0, "join (");
                        sb.append(", ");
                        sb.append(reWriterList.get(i).convertToString());
                        sb.append("[").append(String.join(", ", condLeft.stream().map(s -> s.substring(1)).collect(Collectors.toList()))).append("], ");
                        sb.append("[").append(String.join(", ", condRight.stream().map(s -> s.substring(1)).collect(Collectors.toList()))).append("]");
                        sb.append("),\n");
                        picked.add(i);
                        varSet.addAll(forList.get(i).keySet());
                        updated = true;
                    }
                }
            }

            if (!updated) {
                // Handle cases with no join conditions (i.e., Cartesian products)
                handleNoJoinConditions(forList, picked, varSet, sb, reWriterList);
                break;
            }
        }
    }
    private static void appendReturnClause(XQueryParser.ForXqContext ctx, StringBuilder sb) {
        String returnText = ctx.returnClause().xq().getText();
        Pattern varPattern = Pattern.compile("\\$(\\w+)");
        Matcher matcher = varPattern.matcher(returnText);
        while (matcher.find()) {
            String var = matcher.group();
            // Use Matcher.quoteReplacement to avoid illegal group reference
            returnText = returnText.replaceAll(Pattern.quote(var), Matcher.quoteReplacement("$tuple/" + var.substring(1)));
        }
        sb.append("return ").append(returnText);
    }

    private static void handleNoJoinConditions(List<Map<String, String>> forList, Set<Integer> picked, Set<String> varSet,
                                               StringBuilder sb, List<Rewriter> reWriterList) {
        for (int i = 0; i < forList.size(); i++) {
            if (!picked.contains(i)) {
                picked.add(i);
                varSet.addAll(forList.get(i).keySet());
                sb.insert(0, "join (");
                sb.append(reWriterList.get(i).convertToString());
                sb.append("[], []),\n");
            }
        }
        trimStringBuilder(sb);
    }
    private static void trimStringBuilder(StringBuilder sb) {
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private final Map<String, String> forMap = new HashMap<>();
    private final Map<Integer, String> forOrderMap = new HashMap<>();
    private final List<Pair<String, String>> condList = new ArrayList<>();

    private Rewriter() {
    }

    public void setForMap(Map<String, String> map, Map<Integer, String> order) {
        this.forMap.clear();
        this.forMap.putAll(map);
        this.forOrderMap.clear();
        this.forOrderMap.putAll(order);
    }

    public void setCondList(List<Pair<String, String>> list) {
        this.condList.clear();
        this.condList.addAll(list);
    }

    private String convertToString() {
        StringBuilder sb = new StringBuilder();
        forOrderMap.keySet().stream().sorted().forEach(key -> {
            String var = forOrderMap.get(key);
            String xq = forMap.get(var);
            sb.append("for ").append(var).append(" in ").append(xq).append(",\n");
        });
        trimStringBuilder(sb);
        if (!condList.isEmpty()) {
            sb.append("where ");
            condList.forEach(pair -> sb.append(pair.a).append(" eq ").append(pair.b).append(",\n"));
            trimStringBuilder(sb);
        }
        sb.append("return <tuple>{\n");
        forOrderMap.keySet().stream().sorted().forEach(key -> {
            String var = forOrderMap.get(key);
            sb.append("<").append(var.substring(1)).append(">{").append(var).append("}</").append(var.substring(1)).append(">,\n");
        });
        trimStringBuilder(sb);
        sb.append("}</tuple>\n");
        return sb.toString();
    }
}
