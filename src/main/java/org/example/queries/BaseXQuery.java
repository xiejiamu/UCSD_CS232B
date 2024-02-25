package org.example.queries;

import org.example.expressions.Expression;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface BaseXQuery {

    List<Node> evaluate(Document document) throws Exception;

    default void getAllDescentNodes(List<Node> inputNodes, List<Node> result) {
        for(Node n: inputNodes) {
            result.add(n);
            NodeList childNodes = n.getChildNodes();
            List<Node> children = new ArrayList<>();
            for (int i = 0; i < childNodes.getLength(); i++) {
                children.add(childNodes.item(i));
            }
            getAllDescentNodes(children, result);
        }
    }
    default Node makeText(Document doc, String text) {
        return doc.createTextNode(text);
    }

    default Node makeElement(Document doc, String tagName, List<Node> list) {
        Node node = doc.createElement(tagName);
        for(Node n : list) {
            if(Objects.nonNull(n)) {
                node.appendChild(doc.importNode(n, true));
            }
        }
        return node;
    }
    static Slash getSlashType(String s){
        if(s.equals("/")) {
            return Slash.SSLASH;
        } else if (s.equals("//")){
            return Slash.DSLASH;
        } else {
            return null;
        }
    }
    enum Slash{
        SSLASH, DSLASH
    }

}
