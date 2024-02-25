import org.example.XQuery.XQueryEvaluator;
import org.junit.Test;
import org.w3c.dom.Node;

import java.util.List;

public class MileStone2_test {
    @Test
    public void test1() throws Exception {
        // TODO
        String query;
        XQueryEvaluator xq = new XQueryEvaluator();
        query = "<result>{\n" +
                "for $a in doc(\"j_caesar.xml\")//ACT,\n" +
                "$sc in $a//SCENE,\n" +
                "$sp in $sc/SPEECH\n" +
                "where $sp/LINE/text() = \"Et tu, Brute! Then fall, Caesar.\"\n" +
                "return <who>{$sp/SPEAKER/text()}</who>,\n" +
                "<when>{<act>{$a/TITLE/text()}</act>,\n" +
                "<scene>{$sc/TITLE/text()}</scene>}\n" +
                "</when>\n" +
                "}</result>";

        xq.execute(query);
    }
    @Test
    public void test2() throws Exception {
        // TODO
        String query;
        XQueryEvaluator xq = new XQueryEvaluator();
        query = "<result>{\n" +
                "for $s in doc(\"j_caesar.xml\")//SPEAKER\n" +
                "return <speaks>{<who>{$s/text()}</who>,\n" +
                "for $a in doc(\"j_caesar.xml\")//ACT\n" +
                "where some $s1 in $a//SPEAKER satisfies $s1 eq $s\n" +
                "return <when>{$a/TITLE/text()}</when>}\n" +
                "</speaks>\n" +
                "}</result>";

        xq.execute(query);
    }
    @Test
    public void test3() throws Exception {
        String query;
        XQueryEvaluator xq = new XQueryEvaluator();
        query = "for $act in doc(\"j_caesar.xml\")//ACT,\n" +
                "    $title in $act/SCENE/TITLE,\n" +
                "    $speaker1 in $act//SPEAKER/text(),\n" +
                "    $speaker2 in $act//SPEAKER/text(),\n" +
                "    $pg in doc(\"j_caesar.xml\")//PGROUP,\n" +
                "    $persona1 in $pg/PERSONA/text(),\n" +
                "    $persona2 in $pg/PERSONA/text()\n" +
                "where $speaker1 eq $persona1 and $speaker2 eq $persona2\n" +
                "return\n" +
                "    <tuple>{\n" +
                "        <scene>{$title/text()}</scene>,\n" +
                "        <persona1>{$persona1}</persona1>,\n" +
                "        <persona2>{$persona2}</persona2>\n" +
                "    }</tuple>";

        xq.execute(query);
    }
    @Test
    public void test4() throws Exception {
        String query;
        XQueryEvaluator xq = new XQueryEvaluator();
        query = "for $tuple in\n" +
                " join(\n" +
                "for  $a1 in doc(\"j_caesar.xml\")//ACT/..//ACT,\n" +
                "      $sc1 in $a1//SCENE,\n" +
                "      $sp1 in $sc1//SPEAKER/text(),\n" +
                "      $sl1 in $sc1//LINE\n" +
                "            where $sp1 = \"FLAVIUS\"\n" +
                "return <tuple> {<sl1>{$sl1}</sl1>,<sc1>{$sc1}</sc1>} </tuple>,\n" +
                "for\n" +
                "    $a2 in doc(\"j_caesar.xml\")//ACT/..//ACT,\n" +
                "    $sc2 in $a2//SCENE,\n" +
                "                $sp2 in $sc2//SPEAKER,\n" +
                "                $sl2 in $sc2//LINE\n" +
                "return <tuple> {<sl2>{$sl2}</sl2>,<sc2>{$sc2}</sc2>} </tuple>,\n" +
                "[sl1, sc1], [sl2, sc2])\n" +
                "return <result>{<title>{$tuple/sc1/*/TITLE/text()}</title>}</result>";

        xq.execute(query);
    }
    @Test
    public void test5() throws Exception {
        String query;
        XQueryEvaluator xq = new XQueryEvaluator();
        query = "for $a in doc(\"j_caesar.xml\")//ACT,\n" +
                "    $b in doc(\"j_caesar.xml\")//ACT,\n" +
                "    $sa in $a//SCENE,\n" +
                "    $sb in $b//SCENE,\n" +
                "    $spa in $sa//SPEAKER,\n" +
                "    $spb in $sb//SPEAKER/text(),\n" +
                "    $spc in $sb//SPEAKER\n" +
                "where $spb=\"FLAVIUS\" and $sa eq $sb and $spa eq $spc\n" +
                "return <result>{ <title>{$sa/TITLE/text()}</title> }</result>";
        xq.execute(query);
    }
}
