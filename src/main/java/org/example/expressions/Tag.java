package org.example.expressions;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Tag implements Expression {
    private String text;
    public Tag(String text) {
        this.text = text;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> result = new ArrayList<>();
        for(Node n: inputNodes) {
            NodeList childNodes = n.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                if (childNode.getNodeType() == Node.ELEMENT_NODE && childNode.getNodeName().equals(text)) {
                    result.add(childNode);
                }
            }
        }
        return result;
    }
}
