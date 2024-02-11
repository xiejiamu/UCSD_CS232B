package org.example.XPath;

import org.example.expressions.*;
import org.example.expressions.filter.*;
import org.example.parsers.XPathBaseVisitor;
import org.example.parsers.XPathParser;

public class ExpressionVisitor extends XPathBaseVisitor<Expression>{
    @Override
    public Expression visitAp(XPathParser.ApContext ctx) {
        String doc = ctx.docName().STRING().getText();
        return new AbsolutePath(doc.substring(1, doc.length()-1), Expression.getSlashType(ctx.slash().getText()), visit(ctx.rp()));
    }

    @Override
    public Expression visitAll(XPathParser.AllContext ctx) {
        return new Star();
    }

    @Override
    public Expression visitParenthesizedRp(XPathParser.ParenthesizedRpContext ctx) {
        return visit(ctx.rp());
    }

    @Override
    public Expression visitParent(XPathParser.ParentContext ctx) {
        return new DOT(DOT.getdotType(ctx.getText()));
    }

    @Override
    public Expression visitAttribute(XPathParser.AttributeContext ctx) {
        return new Attr(ctx.attrName().ID().getText());
    }

    @Override
    public Expression visitSlashRp(XPathParser.SlashRpContext ctx) {
        Expression left = visit(ctx.rp(0));
        Expression right = visit(ctx.rp(1));
        return new SlashRp(left, right, Expression.getSlashType(ctx.slash().getText()));
    }

    @Override
    public Expression visitFilterRp(XPathParser.FilterRpContext ctx) {
        Expression rp = visit(ctx.rp());
        Expression ft = visit(ctx.f());
        return new FilterRp(rp, ft);
    }

    @Override
    public Expression visitText(XPathParser.TextContext ctx) {
        return new Text();
    }

    @Override
    public Expression visitTag(XPathParser.TagContext ctx) {
        return new Tag(ctx.tagName().getText());
    }

    @Override
    public Expression visitCurrent(XPathParser.CurrentContext ctx) {
        return new DOT(DOT.getdotType(ctx.getText()));
    }

    @Override
    public Expression visitCommaRp(XPathParser.CommaRpContext ctx) {
        Expression left = visit(ctx.rp(0));
        Expression right = visit(ctx.rp(1));
        return new CommaRp(left, right);
    }

    @Override
    public Expression visitLogicFilter(XPathParser.LogicFilterContext ctx) {
        return new LogicFt(visit(ctx.f(0)), visit(ctx.f(1)), ctx.logic().getText());
    }

    @Override
    public Expression visitCompareFilter(XPathParser.CompareFilterContext ctx) {
        return new CompareFt(visit(ctx.rp(0)), visit(ctx.rp(1)), ctx.comp().getText());
    }

    @Override
    public Expression visitNotFilter(XPathParser.NotFilterContext ctx) {
        Expression ft = visit(ctx.f());
        return new NotFt(ft);
    }

    @Override
    public Expression visitConstantFilter(XPathParser.ConstantFilterContext ctx) {
        return new ConstantFt(visit(ctx.rp()), ctx.stringConstant().getText());
    }

    @Override
    public Expression visitRpFilter(XPathParser.RpFilterContext ctx) {
        return new SingleFt(visit(ctx.rp()));
    }

    @Override
    public Expression visitParenthesizedFilter(XPathParser.ParenthesizedFilterContext ctx) {
        return super.visitParenthesizedFilter(ctx);
    }

    @Override
    public Expression visitSlash(XPathParser.SlashContext ctx) {
        return super.visitSlash(ctx);
    }
}
