package org.example.expressions.rp;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.List;


public class FilterRp implements Expression {

    final private Expression rp;
    final private Expression ft;

    public FilterRp(Expression rp, Expression ft) {
        this.rp = rp;
        this.ft = ft;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes){
        List<Node> interResult = this.rp.evaluate(inputNodes);
        return this.ft.evaluate(interResult);
    }
}
