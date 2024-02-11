package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class NotFt implements Filter{
    private final Expression ft;
    public NotFt(Expression ft) {
        this.ft = ft;
    }
    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> result = new ArrayList<>(inputNodes);
        List<Node> filtered = this.ft.evaluate(inputNodes);
        for(Node n: filtered) {
            result.remove(n);
        }
        return result;
    }
}
