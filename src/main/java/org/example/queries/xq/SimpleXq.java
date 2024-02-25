package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class SimpleXq<T> implements BaseXQuery {
    private final Type type;
    private final T list;
    public SimpleXq(T list, Type type) {
        this.list = list;
        this.type = type;
    }

    public enum Type {
        AP, VAR
    }

    @Override
    public List<Node> evaluate(Document document) throws Exception {
        return (List<Node>) this.list;
    }
}
