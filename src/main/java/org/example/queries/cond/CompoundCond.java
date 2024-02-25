package org.example.queries.cond;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CompoundCond implements BaseXQuery {

    private final BaseXQuery cond1;
    private final BaseXQuery cond2;
    private final String conj;

    public CompoundCond(BaseXQuery c1, BaseXQuery c2, String conj) {
        this.cond1 = c1;
        this.cond2 = c2;
        this.conj = conj;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> leftRes = this.cond1.evaluate(doc);
        List<Node> rightRes = this.cond2.evaluate(doc);
        return (this.conj.equals("or"))?
                ((null != leftRes || rightRes != null)?Arrays.asList():null):
                ((null != leftRes && rightRes != null)?Arrays.asList():null);
    }
}
