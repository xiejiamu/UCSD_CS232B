package org.example.XPath;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            System.err.println("Number of Arguments have to be 2!");
            System.exit(1);
        }

        String filepath = args[0];  // extra paras would be ignored
        String outputpath = args[1];
        try {
            BufferedReader in = new BufferedReader(new FileReader(filepath));
            StringBuilder query = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                query.append(str.replaceAll("\r\n|\r|\n", " "));
                query.append(" ");
            }
//            XPath xpath = new XPath();
//            List<Node> result = xpath.evaluate(query.toString());
//            System.out.printf("returned results: %d\n", result.size());
//            xpath.transform(result);
//            xpath.transform(result, outputpath);
            System.out.println("Query: " + query.toString());
            XPathEvaluator xpath = new XPathEvaluator();
            xpath.execute(query.toString());
            xpath.execute(query.toString(), outputpath);
        } catch (IOException e) {
            System.err.println("Failed to read file: " + filepath);
            System.err.println(e);
            System.exit(2);
        }
    }
}
