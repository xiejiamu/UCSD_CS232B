package org.example.XPath;

import org.w3c.dom.Node;

import java.util.List;

public class MileStone_ONE {
    public static void main(String[] args) throws Exception {

        XPath xPath = new XPath();

        System.out.println("Milestone_ONE");

        // Test Case 1: query = "doc(\"j_caesar.xml\")//PERSONA"
        System.out.println("Test Case 1: query = \"doc(\"j_caesar.xml\")//PERSONA\"");
        String query = "doc(\"j_caesar.xml\")//PERSONA";
        List<Node>  res = xPath.evaluate(query);
        xPath.transform(res);

    }
}
