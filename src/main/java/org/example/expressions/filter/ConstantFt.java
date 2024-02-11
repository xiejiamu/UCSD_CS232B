package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConstantFt implements Filter {

    // default EQS comparator
    final private Expression leftRp;
    final private String constant;

    public ConstantFt(Expression leftRp, String constant) {
        this.leftRp = leftRp;
        this.constant = constant;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> resultList = new ArrayList<>();
        for(Node n : inputNodes) {
            for(Node m : this.filter(this.leftRp, n)) {
                if(this.constant.equals(m.getNodeValue())) {
                    resultList.add(n);
                    break;
                }
            }
        }
        return resultList;
    }
}
