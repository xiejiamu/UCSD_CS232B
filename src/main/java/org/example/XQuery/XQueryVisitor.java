package org.example.XQuery;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.XPath.ExpressionVisitor;
import org.example.XPath.XPathEvaluator;
import org.example.expressions.Expression;
import org.example.parsers.XQueryBaseVisitor;
import org.example.parsers.XQueryParser;
import org.example.queries.BaseXQuery;
import org.example.queries.cond.*;
import org.example.queries.join.Join;
import org.example.queries.xq.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.*;

public class XQueryVisitor extends XQueryBaseVisitor<BaseXQuery> {
    private Map<String, List<Node>> map;
    private Stack<Map<String, List<Node>>> stack;
    private XPathEvaluator xPathEvaluator;
    private ExpressionVisitor expressionVisitor;
    private final Document document;

    public XQueryVisitor(Document document) {
        this.init();
        this.document = document;
    }

    private void init() {
        this.map = new HashMap<>();
        this.stack = new Stack<>();
        this.xPathEvaluator = new XPathEvaluator();
        this.expressionVisitor = new ExpressionVisitor();
    }

    @Override
    public BaseXQuery visitVarXq(XQueryParser.VarXqContext ctx) {
        List<Node> nodes = this.map.get(ctx.VAR().getText());
        List<Node> reslist = new ArrayList<>(nodes);
        return new SimpleXq<>(reslist, SimpleXq.Type.VAR);
    }

    @Override
    public BaseXQuery visitApXq(XQueryParser.ApXqContext ctx) {
        List<Node> list = new ArrayList<>();
        try {
            list = this.xPathEvaluator.evaluateXPath(ctx.ap().getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleXq<>(list, SimpleXq.Type.AP);
    }

    @Override
    public BaseXQuery visitBinaryXq(XQueryParser.BinaryXqContext ctx) {
        return new BinaryXq(this.visit(ctx.xq(0)), this.visit(ctx.xq(1)));
    }

    @Override
    public BaseXQuery visitTagXq(XQueryParser.TagXqContext ctx) {
        return new TagXq(ctx.startTag().tagName().getText(), visit(ctx.xq()));
    }

    @Override
    public BaseXQuery visitTagXqNoBrackets(XQueryParser.TagXqNoBracketsContext ctx) {
        return new TagXq(ctx.startTag().tagName().getText(), visit(ctx.xq()));
    }

    @Override
    public BaseXQuery visitStringXq(XQueryParser.StringXqContext ctx) {
        String stringConstant = ctx.STRING().getText();
        stringConstant = stringConstant.substring(1, stringConstant.length()-1);
        return new SimpleXq<>(stringConstant, SimpleXq.Type.STRING);
    }

    @Override
    public BaseXQuery visitRpXq(XQueryParser.RpXqContext ctx) {
        BaseXQuery query = visit(ctx.xq());
        Expression exp = this.expressionVisitor.visit(xPathEvaluator.createParser(ctx.rp().getText()).rp());
        String op = ctx.slash().getText();
        return new RpXq(query, BaseXQuery.getSlashType(op), exp);
    }

    @Override
    public BaseXQuery visitParenthesizedXq(XQueryParser.ParenthesizedXqContext ctx) {
        BaseXQuery query = visit(ctx.xq());
        return new SimpleXq<>(query, SimpleXq.Type.PARENTHESIZED);
    }

    @Override
    public BaseXQuery visitLetXq(XQueryParser.LetXqContext ctx) {
        List<TerminalNode> var = ctx.letClause().VAR();
        List<XQueryParser.XqContext> query = ctx.letClause().xq();
        this.constructClause(var, query);
        BaseXQuery res = visit(ctx.xq());
        this.deconstructClause(ctx.letClause().VAR().size());
        return res;
    }

    private void constructClause(List<TerminalNode> varList, List<XQueryParser.XqContext> queryList) {
        if(null == varList || null == queryList || varList.size() != queryList.size()) {
            throw new IllegalArgumentException();
        }

        int count = varList.size();
        for(int i=0; i<count; i++) {
            try {
                List<Node> valueList = visit(queryList.get(i)).evaluate(this.document);
                String varName = varList.get(i).getText();
                Map<String, List<Node>> oldMap = new HashMap<>(this.map);
                this.map.put(varName, valueList);
                this.stack.push(oldMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deconstructClause(int count) {
        if(count < 0 || count > this.stack.size()) {
            throw new IllegalArgumentException();
        }
        for(int i=0; i<count; i++) {
            this.map = this.stack.pop();
        }
    }

    private void forXq(int count, List<Node> res, XQueryParser.ForXqContext ctx) throws Exception {
        int size = ctx.forClause().VAR().size();
        if(count == size) {
            // should execute where
            if(null != ctx.letClause()) {
                this.constructClause(ctx.letClause().VAR(), ctx.letClause().xq());
            }
            if(null == ctx.whereClause() || (null != ctx.whereClause() && null != visit(ctx.whereClause().cond()).evaluate(this.document))) {
                res.addAll(visit(ctx.returnClause().xq()).evaluate(this.document));
            }
            if(null != ctx.letClause()) {
                this.deconstructClause(ctx.letClause().VAR().size());
            }
        } else {
            String varName = ctx.forClause().VAR(count).getText();
            List<Node> nodeList = visit(ctx.forClause().xq(count)).evaluate(this.document);
            for(Node node : nodeList) {
                Map<String, List<Node>> oldMap = new HashMap<>(this.map);
                this.stack.push(oldMap);
                this.map.put(varName, Collections.singletonList(node));
                this.forXq(count+1, res, ctx);
                this.map = this.stack.pop();
            }
        }
    }

    @Override
    public BaseXQuery visitForXq(XQueryParser.ForXqContext ctx) {
        List<Node> res = new ArrayList<>();
        try {
            this.forXq(0, res, ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // use VarXq as a simple solution
        return new SimpleXq<>(res, SimpleXq.Type.VAR);
    }

    @Override
    public BaseXQuery visitEqCond1(XQueryParser.EqCond1Context ctx) {
        BaseXQuery q1 = visit(ctx.xq(0));
        BaseXQuery q2 = visit(ctx.xq(1));
        return new EqCond(q1, q2);
    }

    @Override
    public BaseXQuery visitEqCond2(XQueryParser.EqCond2Context ctx) {
        BaseXQuery q1 = visit(ctx.xq(0));
        BaseXQuery q2 = visit(ctx.xq(1));
        return new EqCond(q1, q2);
    }

    @Override
    public BaseXQuery visitIsCond1(XQueryParser.IsCond1Context ctx) {
        BaseXQuery q1 = visit(ctx.xq(0));
        BaseXQuery q2 = visit(ctx.xq(1));
        return new IsCond(q1, q2);
    }

    @Override
    public BaseXQuery visitIsCond2(XQueryParser.IsCond2Context ctx) {
        BaseXQuery q1 = visit(ctx.xq(0));
        BaseXQuery q2 = visit(ctx.xq(1));
        return new IsCond(q1, q2);
    }

    @Override
    public BaseXQuery visitEmptyCond(XQueryParser.EmptyCondContext ctx) {
        BaseXQuery query = visit(ctx.xq());
        return new EmptyCond(query);
    }

    @Override
    public BaseXQuery visitSatisfyCond(XQueryParser.SatisfyCondContext ctx) {
        this.constructClause(ctx.satisfy().VAR(), ctx.satisfy().xq());

        BaseXQuery finalCond = visit(ctx.cond());
        BaseXQuery condQuery = null;
        try {
            condQuery = new SatisfyCond(finalCond.evaluate(this.document));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.deconstructClause(ctx.satisfy().VAR().size());
        }

        return condQuery;
    }

    @Override
    public BaseXQuery visitParenthesizedCond(XQueryParser.ParenthesizedCondContext ctx) {
        return visit(ctx.cond());
    }

    @Override
    public BaseXQuery visitCompoundCond(XQueryParser.CompoundCondContext ctx) {
        BaseXQuery c1 = visit(ctx.cond(0));
        BaseXQuery c2 = visit(ctx.cond(1));
        String conj = ctx.logic().getText();
        return new CompoundCond(c1, c2, conj);
    }

    @Override
    public BaseXQuery visitNegatedCond(XQueryParser.NegatedCondContext ctx) {
        return new NegatedCond(visit(ctx.cond()));
    }

    @Override public BaseXQuery visitJoinXq(XQueryParser.JoinXqContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public BaseXQuery visitSimpleJoin(XQueryParser.SimpleJoinContext ctx) {
        BaseXQuery left = visit(ctx.xq(0));
        BaseXQuery right = visit(ctx.xq(1));
        List<String> leftAtt = new ArrayList<>();
        ctx.constantList(0).ID().forEach(id -> leftAtt.add(id.getText()));
        List<String> rightAtt = new ArrayList<>();
        ctx.constantList(1).ID().forEach(id -> rightAtt.add(id.getText()));
        return new Join(left, right, leftAtt, rightAtt);
    }

    @Override
    public BaseXQuery visitNestedJoinLeft(XQueryParser.NestedJoinLeftContext ctx) {
        BaseXQuery left = visit(ctx.joinClause());
        BaseXQuery right = visit(ctx.xq());
        List<String> leftAtt = new ArrayList<>();
        ctx.constantList(0).ID().forEach(id -> leftAtt.add(id.getText()));
        List<String> rightAtt = new ArrayList<>();
        ctx.constantList(1).ID().forEach(id -> rightAtt.add(id.getText()));
        return new Join(left, right, leftAtt, rightAtt);
    }

    @Override
    public BaseXQuery visitNestedJoinRight(XQueryParser.NestedJoinRightContext ctx) {
        BaseXQuery left = visit(ctx.xq());
        BaseXQuery right = visit(ctx.joinClause());
        List<String> leftAtt = new ArrayList<>();
        ctx.constantList(0).ID().forEach(id -> leftAtt.add(id.getText()));
        List<String> rightAtt = new ArrayList<>();
        ctx.constantList(1).ID().forEach(id -> rightAtt.add(id.getText()));
        return new Join(left, right, leftAtt, rightAtt);
    }

}
