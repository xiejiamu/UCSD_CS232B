package org.example.expressions;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class AbsolutePath implements Expression{

    private String doc;
    private Slash slash;
    private Expression rp;

    public AbsolutePath(String doc, Slash s, Expression rp) {
        this.doc = doc;
        this.slash = s;
        this.rp = rp;
    }

    public String getDoc() {
        return doc;
    }
    @Override
    public List<Node> evaluate(List<Node> inputNodes) {
        if (this.slash == Slash.SSLASH) {
            return rp.evaluate(inputNodes);
        } else {
            List<Node> rpInput = new ArrayList<>();
            getAllDescentNodes(inputNodes, rpInput);
            return rp.evaluate(rpInput);
        }
    }

    private void getAllDescentNodes(List<Node> inputNodes, List<Node> result) {
        for(Node n: inputNodes) {
            result.add(n);
            NodeList childNodes = n.getChildNodes();
            List<Node> children = new ArrayList<>();
            for (int i = 0; i < childNodes.getLength(); i++) {
                children.add(childNodes.item(i));
            }
            getAllDescentNodes(children, result);
        }
    }

    @Override
    public String toString() {
        return "AbsolutePath{" +
                "doc='" + doc + '\'' +
                ", slash=" + slash +
                ", rp=" + rp +
                '}';
    }
}
