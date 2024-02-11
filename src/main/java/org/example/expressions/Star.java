package org.example.expressions;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Star implements Expression{

    public Star() {
    }
    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> result = new ArrayList<>();
        for(Node n: inputNodes) {
            NodeList childNodes = n.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                result.add(childNode);
            }
        }
        return result;
    }
}
