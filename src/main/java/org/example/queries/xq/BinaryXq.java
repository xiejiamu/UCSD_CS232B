package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class BinaryXq implements BaseXQuery {
    private final BaseXQuery queryLeft;
    private final BaseXQuery queryRight;

    public BinaryXq(BaseXQuery queryLeft, BaseXQuery queryRight) {
        this.queryLeft = queryLeft;
        this.queryRight = queryRight;
    }

    @Override
    public List<Node> evaluate(Document document) throws Exception {
        List<Node> left = this.queryLeft.evaluate(document);
        List<Node> right = this.queryRight.evaluate(document);
        left.addAll(right);
        return left;
    }
}
