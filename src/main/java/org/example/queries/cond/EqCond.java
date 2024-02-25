package org.example.queries.cond;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EqCond implements BaseXQuery {

    private final BaseXQuery q1;
    private final BaseXQuery q2;

    public EqCond(BaseXQuery q1, BaseXQuery q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> resLeft = this.q1.evaluate(doc);
        List<Node> resRight = this.q2.evaluate(doc);
        for(Node n : resLeft) {
            for(Node m : resRight) {
                if(n.isEqualNode(m)) {
                    return Arrays.asList();
                }
            }
        }
        // false
        return null;
    }
}
