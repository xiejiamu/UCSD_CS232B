package org.example.XPath;

import org.w3c.dom.Node;

import java.util.List;

public class MileStone_ONE_test {
    public static void main(String[] args) throws Exception {
        XPath xPath = new XPath();
        String query;
        List<Node> res;

        System.out.println("Milestone_ONE_TEST");

//        // Test Case 1: query = "doc(\"j_caesar.xml\")//PERSONA"
//        System.out.println("Test Case 1: query = \"doc(\"j_caesar.xml\")//PERSONA\"");
//        query = "doc(\"j_caesar.xml\")//PERSONA";
//        res = xPath.evaluate(query);
//        xPath.transform(res);

        // Test Case 1: query = "doc(\"j_caesar.xml\")/FM/*"
//        System.out.println("Test Case 2: query = \"doc(\"j_caesar.xml\")/FM/*\"");
//        query = "doc(\"j_caesar.xml\")/*";
//        res = xPath.evaluate(query);
//        xPath.transform(res);

        // Test Case 2: query = "doc('j_caesar.xml')//PERSONA/text()";
//        System.out.println("Test Case 2: query = \"doc(\"j_caesar.xml\")/FM/*\"");
        query = "doc('j_caesar.xml')/PLAY/FM";
        res = xPath.evaluate(query);
        xPath.transform(res);



    }
}
