package org.example.queries.xq;

import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class VarXq implements BaseXQuery {
    private List<Node> nodeList;

    public VarXq(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public List<Node> evaluate(Document document) throws Exception {
        return nodeList;
    }
}
