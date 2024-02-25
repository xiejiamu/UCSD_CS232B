package org.example.queries.cond;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EmptyCond implements BaseXQuery {

    private final BaseXQuery query;

    public EmptyCond(BaseXQuery query) {
        this.query = query;
    }

    @Override
    // if returned list is NULL, then the condition is false
    // Or it is true
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> res = this.query.evaluate(doc);
        if(null == res || res.isEmpty()) {
            return Arrays.asList();
        }
        return null;
    }
}
