package org.example.expressions;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class DOT implements Expression{
    enum DotType {
        CURR, PARENT
    }
    public static DotType getdotType(String s) {
        if (s.equals(".")) {
            return DotType.CURR;
        } else {
            return DotType.PARENT;
        }
    }
    private DotType dotType;
    public DOT(DotType dotType) {
        this.dotType = dotType;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> result = new ArrayList<>();
        for(Node n: inputNodes) {
            if (dotType == DotType.CURR) {
                result.add(n);
            } else {
                Node parent = n.getParentNode();
                if (parent != null) {
                    result.add(parent);
                }
            }
        }
        return result;
    }
}
