package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LogicFt implements Filter{

    final private Expression ft1;
    final private Expression ft2;
    final private String conj;

    public LogicFt(Expression ft1, Expression ft2, String conj) {

        this.ft1 = ft1;
        this.ft2 = ft2;
        this.conj = conj;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        if(this.conj.equals("and")) {
            List<Node> leftResult = this.ft1.evaluate(inputNodes);  // subset of original inputNodes
            return this.ft2.evaluate(leftResult);
        }
        // else if(this.conj.equals("or"))
        List<Node> result = new ArrayList<>();
        for (Node n : inputNodes) {
            if (!this.ft1.evaluate(Arrays.asList(n)).isEmpty() || !this.ft2.evaluate(Arrays.asList(n)).isEmpty()) {
                result.add(n);
            }
        }
        return result;
    }
}
