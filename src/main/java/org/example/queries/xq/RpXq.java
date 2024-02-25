package org.example.queries.xq;

import org.example.expressions.Expression;
import org.example.queries.BaseXQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RpXq implements BaseXQuery {

    private final BaseXQuery query;
    private final BaseXQuery.Slash op;
    private final Expression rp;

    public RpXq(BaseXQuery query, BaseXQuery.Slash op, Expression rp) {
        this.query = query;
        this.op = op;
        this.rp = rp;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> res = this.query.evaluate(doc);
        if (this.op == Slash.SSLASH) {
            return new ArrayList<>(new HashSet<>(this.rp.evaluate(res)));
        } else {
            List<Node> descendingList = new ArrayList<>();
            getAllDescentNodes(res, descendingList);
            return new ArrayList<>(new HashSet<>(this.rp.evaluate(descendingList)));
        }
    }
}
