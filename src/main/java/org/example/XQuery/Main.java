package org.example.XQuery;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.example.parsers.XQueryLexer;
import org.example.parsers.XQueryParser;
import org.example.queries.BaseXQuery;
import org.example.queries.join.Rewriter;
import org.w3c.dom.Node;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String filepath = args[0];  // extra paras would be ignored
        String resultpath = args[1];

        try {
            BufferedReader in = new BufferedReader(new FileReader(filepath));
            StringBuilder query = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                query.append(str.replaceAll("\r\n|\r|\n", " "));
                query.append(" ");
            }

            System.out.println("Query: " + query.toString());

            if(resultpath.equals("rewrite")){
                String rewritten = Rewriter.convert((XQueryParser.ForXqContext) new XQueryParser(new CommonTokenStream(new XQueryLexer(CharStreams.fromString(query.toString())))).xq() );
                BufferedWriter output = null;
                File file = new File("./rewriteOutput.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                output = new BufferedWriter(new FileWriter(file));
                output.write(rewritten);
                output.close();
                System.out.print("output rewritten result in rewriteOutput.txt");
            }else{
                XQueryEvaluator xquery = new XQueryEvaluator();
                xquery.execute(query.toString());
                xquery.execute(query.toString(), resultpath);
            }
        } catch (IOException e) {
            System.err.println("Failed to read file: " + filepath);
            System.err.println(e);
            System.exit(2);
        }
    }
}
