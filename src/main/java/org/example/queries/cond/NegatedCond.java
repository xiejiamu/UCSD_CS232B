package org.example.queries.cond;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NegatedCond implements BaseXQuery {

    private final BaseXQuery cond;

    public NegatedCond(BaseXQuery cond) {
        this.cond = cond;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> res = this.cond.evaluate(doc);
        if(null == res) {
            return Arrays.asList();
        }
        return null;
    }
}
