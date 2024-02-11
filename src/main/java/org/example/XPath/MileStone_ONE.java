package org.example.XPath;



public class MileStone_ONE {
    public static void main(String[] args) throws Exception {
        XPathEvaluator xpathEvaluator = new XPathEvaluator();
        String query;
        System.out.println("Milestone_ONE");

        // testcase 1
        System.out.println("Demo testcase1:");
        query = "doc(\"j_caesar.xml\")//PERSONA";
        xpathEvaluator.execute(query);

        // testcase 2
        System.out.println("Demo testcase2:");
        query = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"]";
        xpathEvaluator.execute(query);

        // testcase 3
        System.out.println("Demo testcase3:");
        query = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text()=\"BRUTUS\"]]";
        xpathEvaluator.execute(query);

        // testcase 4
        System.out.println("Demo testcase4:");
        query = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"] [SPEECH/SPEAKER/text()=\"BRUTUS\"]]";
        xpathEvaluator.execute(query);

        // testcase 5
        System.out.println("Demo testcase5:");
        query = "doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text()=\"CAESAR\"]";
        xpathEvaluator.execute(query);

        // testcase 6
        System.out.println("Demo testcase6:");
        query = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE";
        xpathEvaluator.execute(query);

        // testcase 7
        System.out.println("Demo testcase7:");
        query = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../TITLE";
        xpathEvaluator.execute(query);

        // testcase 8
        System.out.println("Demo testcase8:");
        query = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE";
        xpathEvaluator.execute(query);

        // testcase 9
        System.out.println("Demo testcase9:");
        query = "doc(\"j_caesar.xml\")//ACT[(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE/text()";
        xpathEvaluator.execute(query);

        // testcase 10
        System.out.println("Demo testcase10:");
        query = "doc(\"j_caesar.xml\")//ACT[not((./TITLE)==(./TITLE))]/*/SPEECH/../TITLE";
        xpathEvaluator.execute(query);

    }
}
