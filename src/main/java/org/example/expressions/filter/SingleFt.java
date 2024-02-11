package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class SingleFt implements Filter {
    private final Expression ft;
    public SingleFt(Expression ft) {
        this.ft = ft;
    }
    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> result = new ArrayList<>();
        for(Node n: inputNodes) {
            if (!this.filter(ft, n).isEmpty()) {
                result.add(n);
            }
        }
        return result;
    }
}
