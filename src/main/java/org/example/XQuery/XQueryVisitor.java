package org.example.XQuery;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.XPath.ExpressionVisitor;
import org.example.XPath.XPathEvaluator;
import org.example.expressions.Expression;
import org.example.parsers.XQueryBaseVisitor;
import org.example.parsers.XQueryParser;
import org.example.queries.BaseXQuery;
import org.example.queries.xq.ParenthesizedXq;
import org.example.queries.xq.RpXq;
import org.example.queries.xq.StringXq;
import org.example.queries.xq.ApXq;
import org.example.queries.xq.BinaryXq;
import org.example.queries.xq.TagXq;
import org.example.queries.xq.VarXq;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.*;

public class XQueryVisitor extends XQueryBaseVisitor<BaseXQuery> {
    private Map<String, List<Node>> map;
    private Stack<Map<String, List<Node>>> stack;
    private XPathEvaluator xPathEvaluator;
    private ExpressionVisitor expressionVisitor;
    private Document document;

    public XQueryVisitor(Document document) {

        this.map = new HashMap<>();
        this.stack = new Stack<>();
        this.xPathEvaluator = new XPathEvaluator();
        this.expressionVisitor = new ExpressionVisitor();
        this.document = document;
    }

    @Override
    public BaseXQuery visitVarXq(XQueryParser.VarXqContext ctx) {
        List<Node> nodes = this.map.get(ctx.VAR().getText());
        List<Node> reslist = new ArrayList<>(nodes);
        return new VarXq(reslist);
    }

    @Override
    public BaseXQuery visitApXq(XQueryParser.ApXqContext ctx) {
        List<Node> list = new ArrayList<>();
        try {
            list = this.xPathEvaluator.evaluateXPath(ctx.ap().getText());
        } catch (Exception e) { // Replace SpecificException with the actual exception type
            e.printStackTrace();
        }
        return new ApXq(list);
    }

    @Override
    public BaseXQuery visitBinaryXq(XQueryParser.BinaryXqContext ctx) {
        return new BinaryXq(this.visit(ctx.xq(0)), this.visit(ctx.xq(1)));
    }

    @Override
    public BaseXQuery visitTagXq(XQueryParser.TagXqContext ctx) {
        return new TagXq(ctx.startTag().tagName().getText(), visit(ctx.xq()));
    }

    @Override
    public BaseXQuery visitStringXq(XQueryParser.StringXqContext ctx) {
        String stringConstant = ctx.STRING().getText();
        return new StringXq(stringConstant.substring(1, stringConstant.length()-1));
    }

    @Override
    public BaseXQuery visitRpXq(XQueryParser.RpXqContext ctx) {
        BaseXQuery query = visit(ctx.xq());
        Expression exp = this.expressionVisitor.visit(xPathEvaluator.createParser(ctx.rp().getText()).rp());
        String op = ctx.slash().getText();
        return new RpXq(query, op, exp);
    }

    @Override
    public BaseXQuery visitParenthesizedXq(XQueryParser.ParenthesizedXqContext ctx) {
        BaseXQuery query = visit(ctx.xq());
        return new ParenthesizedXq(query);
    }

    @Override
    public BaseXQuery visitLetXq(XQueryParser.LetXqContext ctx) {
        List<TerminalNode> var = ctx.letClause().VAR();
        List<XQueryParser.XqContext> query = ctx.letClause().xq();
        this.constructClause(var, query);
        BaseXQuery res = visit(ctx.xq());
        this.deconstructClause(ctx.letClause().VAR().size());
        return res;
    }

    private void constructClause(List<TerminalNode> varList, List<XQueryParser.XqContext> queryList) {
        if(null == varList || null == queryList || varList.size() != queryList.size()) {
            throw new IllegalArgumentException();
        }

        int count = varList.size();
        for(int i=0; i<count; i++) {
            try {
                List<Node> valueList = visit(queryList.get(i)).evaluate(this.document);
                String varName = varList.get(i).getText();
                Map<String, List<Node>> oldMap = new HashMap<>(this.map);
                this.map.put(varName, valueList);
                this.stack.push(oldMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deconstructClause(int count) {
        if(count < 0 || count > this.stack.size()) {
            throw new IllegalArgumentException();
        }
        for(int i=0; i<count; i++) {
            this.map = this.stack.pop();
        }
    }

    private void forXq(int count, List<Node> res, XQueryParser.ForXqContext ctx) throws Exception {
        int size = ctx.forClause().VAR().size();
        if(count == size) {
            // should execute where
            if(null != ctx.letClause()) {
                this.constructClause(ctx.letClause().VAR(), ctx.letClause().xq());
            }
            if(null == ctx.whereClause() || (null != ctx.whereClause() && null != visit(ctx.whereClause().cond()).evaluate(this.document))) {
                res.addAll(visit(ctx.returnClause().xq()).evaluate(this.document));
            }
            if(null != ctx.letClause()) {
                this.deconstructClause(ctx.letClause().VAR().size());
            }
        } else {
            String varName = ctx.forClause().VAR(count).getText();
            List<Node> nodeList = visit(ctx.forClause().xq(count)).evaluate(this.document);
            for(Node node : nodeList) {
                Map<String, List<Node>> oldMap = new HashMap<>(this.map);
                this.stack.push(oldMap);
                this.map.put(varName, Arrays.asList(node));
                this.forXq(count+1, res, ctx);
                this.map = this.stack.pop();
            }
        }
    }

    @Override public BaseXQuery visitForXq(XQueryParser.ForXqContext ctx) {
        List<Node> res = new ArrayList<>();
        try {
            this.forXq(0, res, ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // use VarXq as a simple solution
        return new VarXq(res);
    }
}
