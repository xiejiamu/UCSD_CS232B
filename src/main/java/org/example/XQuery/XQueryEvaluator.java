package org.example.XQuery;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.example.parsers.XPathLexer;
import org.example.parsers.XPathParser;
import org.example.parsers.XQueryLexer;
import org.example.parsers.XQueryParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.List;

public class XQueryEvaluator {
    private Document document;
    public XQueryEvaluator() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        this.document = documentBuilder.newDocument();
    }

    public XQueryParser createParser(String expression) {
        XQueryLexer lexer = new XQueryLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new XQueryParser(tokens);
    }

    public List<Node> evaluateXQuery(String path) throws Exception {
        ParserRuleContext xq = this.createParser(path).xq();
        XQueryVisitor visitor = new XQueryVisitor(this.document);
        return visitor.visit(xq).evaluate(this.document);
    }


    public void execute(String path) throws Exception {
        List<Node> result = evaluateXQuery(path);
        outputTransformedNodes(result);
    }

    public void execute(String path, String outputpath) throws Exception {
        List<Node> nodes = evaluateXQuery(path);
        outputTransformedNodes(nodes, outputpath);
    }

    public void outputTransformedNodes(List<Node> nodes) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        configureTransformer(transformer);
        for (Node node : nodes) {
            printNodeContent(node, transformer);
        }
    }

    public void outputTransformedNodes(List<Node> result, String outputpath) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        configureTransformer(transformer);

        // 使用FileOutputStream定向输出到文件，而不是System.out
        FileOutputStream fos = new FileOutputStream(outputpath, false); // false表示不追加，即覆盖原文件
        StreamResult streamResult = new StreamResult(fos);

        for (Node node : result) {
            transformer.transform(new DOMSource(node), streamResult);
        }

        fos.close(); // 完成后关闭文件输出流
    }

    private void configureTransformer(Transformer transformer) {
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    }
    private void printNodeContent(Node node, Transformer transformer) throws Exception {
        transformer.transform(new DOMSource(node), new StreamResult(System.out));
    }
}
