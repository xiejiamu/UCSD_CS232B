package org.example.queries.cond;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;

public class SatisfyCond implements BaseXQuery {

    private final boolean condRes;

    public SatisfyCond(List<Node> condRes) {
        this.condRes = (condRes != null);
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return this.condRes ? Arrays.asList():null;
    }
}
