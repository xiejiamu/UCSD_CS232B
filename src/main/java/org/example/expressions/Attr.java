package org.example.expressions;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Attr implements Expression{
    private String attr;
    public Attr(String attr) {
        this.attr = attr;
    }
    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> result = new ArrayList<>();
        for(Node n: inputNodes) {
            if (n.getAttributes() != null) {
                Node attrNode = n.getAttributes().getNamedItem(attr);
                if (attrNode != null) {
                    result.add(attrNode);
                }
            }
        }
        return result;
    }
}
