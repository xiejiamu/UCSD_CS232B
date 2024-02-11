package org.example.XPath;

import org.example.expressions.AbsolutePath;
import org.example.expressions.Expression;
import org.example.expressions.Tag;
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
        return super.visitAll(ctx);
    }

    @Override
    public Expression visitParenthesizedRp(XPathParser.ParenthesizedRpContext ctx) {
        return super.visitParenthesizedRp(ctx);
    }

    @Override
    public Expression visitParent(XPathParser.ParentContext ctx) {
        return super.visitParent(ctx);
    }

    @Override
    public Expression visitAttribute(XPathParser.AttributeContext ctx) {
        return super.visitAttribute(ctx);
    }

    @Override
    public Expression visitSlashRp(XPathParser.SlashRpContext ctx) {
        return super.visitSlashRp(ctx);
    }

    @Override
    public Expression visitFilterRp(XPathParser.FilterRpContext ctx) {
        return super.visitFilterRp(ctx);
    }

    @Override
    public Expression visitText(XPathParser.TextContext ctx) {
        return super.visitText(ctx);
    }

    @Override
    public Expression visitTag(XPathParser.TagContext ctx) {
        return new Tag(ctx.tagName().getText());
    }

    @Override
    public Expression visitCurrent(XPathParser.CurrentContext ctx) {
        return super.visitCurrent(ctx);
    }

    @Override
    public Expression visitCommaRp(XPathParser.CommaRpContext ctx) {
        return super.visitCommaRp(ctx);
    }

    @Override
    public Expression visitLogicFilter(XPathParser.LogicFilterContext ctx) {
        return super.visitLogicFilter(ctx);
    }

    @Override
    public Expression visitCompareFilter(XPathParser.CompareFilterContext ctx) {
        return super.visitCompareFilter(ctx);
    }

    @Override
    public Expression visitNotFilter(XPathParser.NotFilterContext ctx) {
        return super.visitNotFilter(ctx);
    }

    @Override
    public Expression visitConstantFilter(XPathParser.ConstantFilterContext ctx) {
        return super.visitConstantFilter(ctx);
    }

    @Override
    public Expression visitRpFilter(XPathParser.RpFilterContext ctx) {
        return super.visitRpFilter(ctx);
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
