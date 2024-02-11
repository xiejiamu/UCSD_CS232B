package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;


import java.util.Arrays;
import java.util.List;

public interface Filter extends Expression{
    default List<Node> filter(Expression ft, Node inputNodes){
        List<Node> list = Arrays.asList(inputNodes);
        return ft.evaluate(list);
    }
}
