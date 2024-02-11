package org.example.XPath;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.antlr.v4.runtime.*;
import org.example.expressions.AbsolutePath;
import org.example.expressions.Expression;
import org.example.parsers.XPathLexer;
import org.example.parsers.XPathParser;
import org.w3c.dom.*;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XPathEvaluator {
    private final DocumentBuilder documentBuilder;

    public XPathEvaluator() {
        this.documentBuilder = createDocumentBuilder();
    }

    private DocumentBuilder createDocumentBuilder() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(this::resolveEntity);
            return builder;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create DocumentBuilder", e);
        }
    }

    private InputSource resolveEntity(String publicId, String systemId) {
        if (systemId.contains("play.dtd")) {
            InputStream dtdStream = getClass().getClassLoader().getResourceAsStream("play.dtd");
            return new InputSource(dtdStream);
        }
        return null; // Default behavior
    }

    public List<Node> evaluateXPath(String path) throws Exception {
        Expression rootExpression = parseExpression(path);
        AbsolutePath ap = (AbsolutePath) rootExpression;
        InputStream is = getResourceAsStream(ap.getDoc());
        Document document = documentBuilder.parse(is);


        List<Node> initialContext = new ArrayList<>();
        initialContext.add(document);
        return rootExpression.evaluate(initialContext);
    }

    private InputStream getResourceAsStream(String resourcePath) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
    }

    private Expression parseExpression(String expression) throws IOException {
        XPathLexer lexer = new XPathLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        ParserRuleContext tree = parser.ap();
        ExpressionVisitor visitor = new ExpressionVisitor();
        return visitor.visit(tree);
    }

    public void outputTransformedNodes(List<Node> nodes) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        configureTransformer(transformer);
        for (Node node : nodes) {
            printNodeContent(node, transformer);
        }
    }

    private void configureTransformer(Transformer transformer) {
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    }

    private void printNodeContent(Node node, Transformer transformer) throws Exception {
        transformer.transform(new DOMSource(node), new StreamResult(System.out));
    }

    /**
     * Evaluates an XPath expression and prints the results directly to the console.
     *
     * @param path The XPath expression to evaluate.
     * @throws Exception if an error occurs during evaluation or parsing.
     */
    public void execute(String path) throws Exception {
        // Assuming the path includes both the document location and the XPath expression.
        // You might need to adjust the logic based on how the input string is structured.
        List<Node> nodes = evaluateXPath(path);
        outputTransformedNodes(nodes);
    }

    public void execute(String path, String outputpath) throws Exception {
        List<Node> nodes = evaluateXPath(path);
        outputTransformedNodes(nodes, outputpath);
    }

    private void outputTransformedNodes(List<Node> result, String outputpath) throws Exception {
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

}
