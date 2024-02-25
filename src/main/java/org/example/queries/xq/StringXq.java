package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Deprecated
public class StringXq implements BaseXQuery {
    final private String str;

    public StringXq(String content) {
        this.str = content;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return new ArrayList<>(Collections.singletonList(makeText(doc, this.str)));
    }
}
