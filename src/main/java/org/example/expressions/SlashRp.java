package org.example.expressions;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class SlashRp implements Expression{
    public SlashRp(Expression leftRp, Expression rightRp, Slash op) {
        Objects.requireNonNull(leftRp, "leftRp is NULL!");
        Objects.requireNonNull(rightRp, "rightRp content is NULL!");
        Objects.requireNonNull(op, "op path is NULL!");

        this.leftRp = leftRp;
        this.rightRp = rightRp;
        this.op = op;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes){
        List<Node> leftResult = leftRp.evaluate(inputNodes);
        if (op == Slash.SSLASH) {
            return new ArrayList<>(new HashSet<>(rightRp.evaluate(leftResult)));
        }else{
            List<Node> rightInput = new ArrayList<>();
            getAllDescentNodes(leftResult, rightInput);
            return new ArrayList<>(new HashSet<>(rightRp.evaluate(rightInput)));
        }
    }

    final private Expression leftRp;
    final private Expression rightRp;
    final private Slash op;
}
