package org.example.expressions.rp;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class CommaRp implements Expression {
    public CommaRp(Expression leftRp, Expression rightRp) {
        this.leftRp = leftRp;
        this.rightRp = rightRp;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes){
        List<Node> leftResult = leftRp.evaluate(inputNodes);
        boolean success = leftResult.addAll(rightRp.evaluate(inputNodes));
        if(success) {
            return leftResult;
        }
        return null;
    }

    final private Expression leftRp;
    final private Expression rightRp;
}