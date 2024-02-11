package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConstantFt implements Filter {
    final private Expression leftRp;
    final private Expression rightRp;

    public ConstantFt(Expression leftRp, Expression rightRp) {
        Objects.requireNonNull(leftRp, "leftRp is NULL!");
        Objects.requireNonNull(rightRp, "rightRp is NULL!");

        this.leftRp = leftRp;
        this.rightRp = rightRp;
    }

    private boolean checkEqual(List<Node> list1, List<Node> list2) {
        Objects.requireNonNull(list1);
        Objects.requireNonNull(list2);
        for(Node n : list1) {
            for(Node m : list2) {
                if(n.isEqualNode(m)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkSame(List<Node> list1, List<Node> list2) {
        Objects.requireNonNull(list1);
        Objects.requireNonNull(list2);
        for(Node n : list1) {
            for(Node m : list2) {
                if(n.isSameNode(m)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        List<Node> resultList = new ArrayList<>();
        // TODO: a better way to compare two lists of nodes?
        for(Node n : inputNodes) {
            List<Node> left = this.filter(this.leftRp, n);
            List<Node> right = this.filter(this.rightRp, n);
            if(this.checkEqual(left, right)) {
                resultList.add(n);
            }
        }
        return resultList;
    }
}
