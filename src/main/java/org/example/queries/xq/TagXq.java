package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagXq implements BaseXQuery {
    private String tag;
    private BaseXQuery query;

    public TagXq(String tag, BaseXQuery query) {
        this.tag = tag;
        this.query = query;
    }

    @Override
    public List<Node> evaluate(Document document) throws Exception {
        // TODO
        return new ArrayList<>(Arrays.asList(makeElement(document, this.tag, this.query.evaluate(document))));
    }
}
