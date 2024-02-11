package org.example.expressions.filter;

import org.example.expressions.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class CompareFt implements Filter{
    public enum Sign {
        EQ, EQ_N, IS, IS_N
    }
    private Expression leftRp;
    private Expression rightRp;
    private Sign sign;

    public CompareFt(Expression leftRp, Expression rightRp, String s) {
        this.leftRp = leftRp;
        this.rightRp = rightRp;
        this.sign = getSign(s);
    }

    private Sign getSign(String s) {
        switch (s) {
            case "eq":
                return Sign.EQ;
            case "=":
                return Sign.EQ_N;
            case "is":
                return Sign.IS;
            case "==":
                return Sign.IS_N;
            default:
                throw new IllegalArgumentException("Invalid sign: " + s);
        }
    }
    public boolean checkEqual(List<Node> list1, List<Node> list2) {
        for(Node n : list1) {
            for(Node m : list2) {
                if(n.isEqualNode(m)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSame(List<Node> list1, List<Node> list2) {
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
        switch (this.sign){
            case EQ:
            case EQ_N:
                for (Node n: inputNodes){
                    List<Node> leftRes = this.filter(this.leftRp, n);
                    List<Node> rightRes = this.filter(this.rightRp, n);
                    if (this.checkEqual(leftRes, rightRes)){
                        resultList.add(n);
                    }

                }
                return resultList;
            case IS:
            case IS_N:
                for (Node n: inputNodes){
                    List<Node> leftRes = this.filter(this.leftRp, n);
                    List<Node> rightRes = this.filter(this.rightRp, n);
                    if (this.checkSame(leftRes, rightRes)){
                        resultList.add(n);
                    }
                }
                return resultList;
            default:
                throw new IllegalArgumentException("Invalid sign: " + this.sign);
        }
    }
}
