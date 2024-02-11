package org.example.XPath;

import org.w3c.dom.Node;

import java.util.List;

public class MileStone_ONE {
    public static void main(String[] args) throws Exception {

        XPath xpath = new XPath();
        String query;
        List<Node> result;

        System.out.println("Milestone_ONE");

        // Demo
//        // testcase 1
//        System.out.println("Demo testcase1:");
//        query = "doc(\"j_caesar.xml\")//PERSONA";
//        result = xpath.evaluate(query);
//        xpath.transform(result);

        // testcase 2
        System.out.println("Demo testcase2:");
        query = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"]";
        result = xpath.evaluate(query);
        System.out.println(result);
        xpath.transform(result);
//
//        // testcase 3
//        System.out.println("Demo testcase3:");
//        query = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text()=\"BRUTUS\"]]";
//        result = xpath.evaluate(query);
//        xpath.transform(result);
//
//        // testcase 4
//        System.out.println("Demo testcase4:");
//        query = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"] [SPEECH/SPEAKER/text()=\"BRUTUS\"]]";
//        result = xpath.evaluate(query);
//        xpath.transform(result);
//
//        // testcase 5
//        System.out.println("Demo testcase5:");
//        query = "doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text()=\"CAESAR\"]";
//        result = xpath.evaluate(query);
//        xpath.transform(result);
//
//        // Extra testcases
//
//        // testcase 6
//        System.out.println("Demo testcase6:");
//        query = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE";
//        result = xpath.evaluate(query);
//        xpath.transform(result);
//
//        // testcase 7
//        System.out.println("Demo testcase7:");
//        query = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../TITLE";
//        result = xpath.evaluate(query);
//        xpath.transform(result);
//
//        // testcase 8
//        System.out.println("Demo testcase8:");
//        query = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE";
//        result = xpath.evaluate(query);
//        xpath.transform(result);
//
//        // testcase 9
//        System.out.println("Demo testcase9:");
//        query = "doc(\"j_caesar.xml\")//ACT[(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE/text()";
//        result = xpath.evaluate(query);
//        xpath.transform(result);
//
//        System.out.println();
//
//        // testcase 10
//        System.out.println("Demo testcase10:");
//        query = "doc(\"j_caesar.xml\")//ACT[not((./TITLE)==(./TITLE))]/*/SPEECH/../TITLE";
//        result = xpath.evaluate(query);
//        xpath.transform(result);

    }
}
