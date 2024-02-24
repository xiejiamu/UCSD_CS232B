package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringXq implements BaseXQuery {
    final private String str;

    public StringXq(String content) {
        this.str = content;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return new ArrayList<>(Arrays.asList(makeText(doc, this.str)));
    }
}
