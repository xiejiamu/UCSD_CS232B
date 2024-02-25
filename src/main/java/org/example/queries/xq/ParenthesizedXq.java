package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
@Deprecated
public class ParenthesizedXq implements BaseXQuery {
    private final BaseXQuery query;

    public ParenthesizedXq(BaseXQuery query) {
        this.query = query;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return this.query.evaluate(doc);
    }
}
