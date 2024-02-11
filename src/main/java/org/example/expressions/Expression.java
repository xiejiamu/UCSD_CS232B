package org.example.expressions;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public interface Expression {
    List<Node> evaluate(List<Node> inputNodes);

    public static Slash getSlashType(String s){
        if(s.equals("/")) {
            return Slash.SSLASH;
        } else if (s.equals("//")){
            return Slash.DSLASH;
        } else {
            return null;
        }
    }

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

    enum Slash{
        SSLASH, DSLASH
    }
}
