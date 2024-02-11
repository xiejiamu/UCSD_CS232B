package org.example.XPath;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.example.expressions.AbsolutePath;
import org.example.expressions.Expression;
import org.example.parsers.XPathLexer;
import org.example.parsers.XPathParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;

public class XPath {
    private DocumentBuilder builder;
    public XPath() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
            this.builder = factory.newDocumentBuilder();
            // Inline implementation of EntityResolver
            this.builder.setEntityResolver(new EntityResolver() {
                public InputSource resolveEntity(String publicId, String systemId) {
                    if (systemId.contains("play.dtd")) {
                        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                        InputStream myDtdRes = classloader.getResourceAsStream("play.dtd");
                        return new InputSource(myDtdRes);
                    } else {
                        return null; // Proceed with the default behavior
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Node> evaluate(String path) throws Exception {
        XPathLexer lexer = new XPathLexer(CharStreams.fromString(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserRuleContext tree = new XPathParser(tokens).ap();
        ExpressionVisitor visitor = new ExpressionVisitor();
        Expression root = visitor.visit(tree);

        AbsolutePath ap = (AbsolutePath) root;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String resourcePath = ap.getDoc();
        InputStream is = classloader.getResourceAsStream(resourcePath);

        Document doc = this.builder.parse(is);

        List<Node> inputNodes = new ArrayList<>();
        inputNodes.add(doc);
        return ap.evaluate(inputNodes);
    }

    public void transform(List<Node> result) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        for (Node node : result) {
            if (node instanceof Attr){
                System.out.println(node.getTextContent());
                continue;
            }
            if (node instanceof Text){
                System.out.println(node.getTextContent());
                continue;
            }
            transformer.transform(new DOMSource(node), new StreamResult(new PrintStream(System.out)));
        }
    }
}
