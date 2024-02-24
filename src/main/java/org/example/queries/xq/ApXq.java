package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class ApXq implements BaseXQuery {
    private List<Node> list;

    public ApXq(List<Node> list) {
        this.list = list;
    }

    @Override
    public List<Node> evaluate(Document document) throws Exception {
        return this.list;
    }
}
