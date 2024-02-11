package org.example.expressions;

import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class ParenthesizedRp implements Expression{

    final private Expression rp;

    public ParenthesizedRp(Expression rp) {
        Objects.requireNonNull(rp, "rp is NULL!");

        this.rp = rp;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes){
        return this.rp.evaluate(inputNodes);
    }

}
