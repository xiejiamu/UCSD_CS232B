package org.example.expressions;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class SlashRp implements Expression{
    final private Expression leftRp;
    final private Expression rightRp;
    final private Slash op;
    public SlashRp(Expression leftRp, Expression rightRp, Slash op) {
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


}
