package org.example.expressions;

import org.w3c.dom.Node;

import java.util.List;

public interface Expression {
    List<Node> evaluate(List<Node> inputNodes);

    public static Slash getSlashType(String s){
        if(s.equals("/")) {
            return Slash.SSLASH;
        } else if (s.equals("//")){
            return Slash.DSLASH;
        } else {
            return null;
        }
    }
    enum Slash{
        SSLASH, DSLASH
    }
}
