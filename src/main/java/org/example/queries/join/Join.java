package org.example.queries.join;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Join implements BaseXQuery {
    private BaseXQuery leftQuery;
    private BaseXQuery rightQuery;
    private List<String> leftAttributes;
    private List<String> rightAttributes;
    private Transformer transformerInstance;

    public Join(BaseXQuery left, BaseXQuery right, List<String> leftAtt, List<String> rightAtt) {
        this.leftQuery = left;
        this.rightQuery = right;
        this.leftAttributes = leftAtt;
        this.rightAttributes = rightAtt;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        TransformerFactory tfFactory = TransformerFactory.newInstance();
        this.transformerInstance = tfFactory.newTransformer();
        this.transformerInstance.setOutputProperty(OutputKeys.INDENT, "yes");
        this.transformerInstance.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        List<Node> resultNodes = new ArrayList<>();
        List<Node> nodesFromLeft = this.leftQuery.evaluate(doc);
        List<Node> nodesFromRight = this.rightQuery.evaluate(doc);
        Map<String, List<Node>> mapForLeft = new HashMap<>();

        if (this.leftAttributes.isEmpty() || this.rightAttributes.isEmpty()) {
            for (Node leftNode : nodesFromLeft) {
                for (Node rightNode : nodesFromRight) {
                    resultNodes.add(concatNodes(doc, leftNode, rightNode));
                }
            }
        } else {
            for (Node leftNode : nodesFromLeft) {
                String key = createHashKey(leftNode, this.leftAttributes);
                mapForLeft.computeIfAbsent(key, k -> new ArrayList<>()).add(leftNode);
            }
            for (Node rightNode : nodesFromRight) {
                String key = createHashKey(rightNode, this.rightAttributes);
                if (mapForLeft.containsKey(key)) {
                    for (Node matchingNode : mapForLeft.get(key)) {
                        resultNodes.add(concatNodes(doc, matchingNode, rightNode));
                    }
                }
            }
        }
        return resultNodes;
    }

    private String createHashKey(Node node, List<String> attributes) throws TransformerException, UnsupportedEncodingException {
        StringBuilder keyBuilder = new StringBuilder();
        Map<String, Node> mapping = new HashMap<>();
        NodeList childElements = node.getChildNodes();
        for (int i = 0; i < childElements.getLength(); i++) {
            Node current = childElements.item(i);
            assert current.getChildNodes().getLength() == 1;
            mapping.put(current.getNodeName(), current.getFirstChild());
        }
        for (String attr : attributes) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            this.transformerInstance.transform(new DOMSource(mapping.get(attr)), new StreamResult(new PrintStream(outputStream)));
            keyBuilder.append(outputStream.toString("UTF8")).append("|");
        }
        return keyBuilder.toString();
    }

    private Node concatNodes(Document doc, Node first, Node second) {
        Element combinedNode = doc.createElement("combinedTuple");
        NodeList firstChildNodes = first.getChildNodes();
        for (int i = 0; i < firstChildNodes.getLength(); i++) {
            combinedNode.appendChild(firstChildNodes.item(i).cloneNode(true));
        }
        NodeList secondChildNodes = second.getChildNodes();
        for (int i = 0; i < secondChildNodes.getLength(); i++) {
            combinedNode.appendChild(secondChildNodes.item(i).cloneNode(true));
        }
        return combinedNode;
    }
}
