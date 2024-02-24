package org.example.XQuery;

import org.example.XPath.ExpressionVisitor;
import org.example.XPath.XPathEvaluator;
import org.example.parsers.XQueryBaseVisitor;
import org.example.parsers.XQueryParser;
import org.example.queries.BaseXQuery;
import org.example.queries.xq.ApXq;
import org.example.queries.xq.BinaryXq;
import org.example.queries.xq.VarXq;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class XQueryVisitor extends XQueryBaseVisitor<BaseXQuery> {
    private Map<String, List<Node>> map;
    private Stack<Map<String, List<Node>>> stack;
    private XPathEvaluator xPathEvaluator;
    private ExpressionVisitor expressionVisitor;
    private Document document;

    public XQueryVisitor(Map<String, List<Node>> map, Stack<Map<String, List<Node>>> stack, XPathEvaluator xPathEvaluator, ExpressionVisitor expressionVisitor, Document document) {
        this.map = map;
        this.stack = stack;
        this.xPathEvaluator = xPathEvaluator;
        this.expressionVisitor = expressionVisitor;
        this.document = document;
    }

    @Override
    public BaseXQuery visitVarXq(XQueryParser.VarXqContext ctx) {
        List<Node> nodes = this.map.get(ctx.VAR().getText());
        List<Node> reslist = new ArrayList<>(nodes);
        return new VarXq(reslist);
    }

    @Override
    public BaseXQuery visitApXq(XQueryParser.ApXqContext ctx) {
        List<Node> list = new ArrayList<>();
        try {
            list = this.xPathEvaluator.evaluateXPath(ctx.ap().getText());
        } catch (Exception e) { // Replace SpecificException with the actual exception type
            e.printStackTrace();
        }
        return new ApXq(list);
    }

    @Override
    public BaseXQuery visitBinaryXq(XQueryParser.BinaryXqContext ctx) {
        return new BinaryXq(this.visit(ctx.xq(0)), this.visit(ctx.xq(1)));
    }
}
