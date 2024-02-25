package org.example.queries.xq;


import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleXq<T> implements BaseXQuery {
    private final Type type;
    private final T content;
    public SimpleXq(T content, Type type) {
        this.content = content;
        this.type = type;
    }

    public enum Type {
        AP, VAR, STRING, PARENTHESIZED
    }

    @Override
    public List<Node> evaluate(Document document) throws Exception {
        switch (this.type) {
            case VAR:
            case AP:
                if (!(this.content instanceof List)) {
                    throw new IllegalArgumentException("Content must be a List for VAR or AP type.");
                }
                // Assuming all elements should be Node instances, additional checks could be placed here if necessary
                return (List<Node>) this.content;

            case STRING:
                if (!(this.content instanceof String)) {
                    throw new IllegalArgumentException("Content must be a String for STRING type.");
                }
                return new ArrayList<>(Collections.singletonList(makeText(document, (String) this.content)));

            case PARENTHESIZED:
                if (!(this.content instanceof BaseXQuery)) {
                    throw new IllegalArgumentException("Content must be an instance of BaseXQuery for PARENTHESIZED type.");
                }
                return ((BaseXQuery) this.content).evaluate(document);

            default:
                return null;
        }
    }


}
