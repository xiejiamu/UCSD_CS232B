package org.example.expressions.rp;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class ParenthesizedRp implements Expression {

    final private Expression rp;

    public ParenthesizedRp(Expression rp) {
        this.rp = rp;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes){
        return this.rp.evaluate(inputNodes);
    }

}
