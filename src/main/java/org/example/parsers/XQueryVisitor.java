// Generated from XQuery.g4 by ANTLR 4.9.3

    package org.example.parsers;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code RpXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpXq(XQueryParser.RpXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringXq(XQueryParser.StringXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApXq(XQueryParser.ApXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JoinXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinXq(XQueryParser.JoinXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryXq(XQueryParser.BinaryXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarXq(XQueryParser.VarXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedXq(XQueryParser.ParenthesizedXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForXq(XQueryParser.ForXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagXq(XQueryParser.TagXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleJoin}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleJoin(XQueryParser.SimpleJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedJoinLeft}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedJoinLeft(XQueryParser.NestedJoinLeftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedJoinRight}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedJoinRight(XQueryParser.NestedJoinRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#constantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantList(XQueryParser.ConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCond2(XQueryParser.EqCond2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundCond(XQueryParser.CompoundCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedCond(XQueryParser.ParenthesizedCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegatedCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatedCond(XQueryParser.NegatedCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCond1(XQueryParser.EqCond1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyCond(XQueryParser.EmptyCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCond1(XQueryParser.IsCond1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code IsCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCond2(XQueryParser.IsCond2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SatisfyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSatisfyCond(XQueryParser.SatisfyCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#satisfy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSatisfy(XQueryParser.SatisfyContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#startTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTag(XQueryParser.StartTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp(XQueryParser.ApContext ctx);
	/**
	 * Visit a parse tree produced by the {@code All}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(XQueryParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedRp(XQueryParser.ParenthesizedRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(XQueryParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(XQueryParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashRp(XQueryParser.SlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(XQueryParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(XQueryParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrent(XQueryParser.CurrentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaRp(XQueryParser.CommaRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicFilter(XQueryParser.LogicFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompareFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareFilter(XQueryParser.CompareFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantFilter(XQueryParser.ConstantFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedFilter(XQueryParser.ParenthesizedFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#slash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlash(XQueryParser.SlashContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#docName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocName(XQueryParser.DocNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#attrName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrName(XQueryParser.AttrNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(XQueryParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(XQueryParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(XQueryParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(XQueryParser.DocContext ctx);
}