package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.List;

public class ParaFt implements Filter{
    private final Expression ft;

    public ParaFt(Expression ft) {
        this.ft = ft;
    }
    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        return this.ft.evaluate(inputNodes);
    }
}
