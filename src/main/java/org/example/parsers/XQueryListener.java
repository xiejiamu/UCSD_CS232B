// Generated from XQuery.g4 by ANTLR 4.9.3

    package org.example.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code RpXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterRpXq(XQueryParser.RpXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitRpXq(XQueryParser.RpXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterStringXq(XQueryParser.StringXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitStringXq(XQueryParser.StringXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterApXq(XQueryParser.ApXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitApXq(XQueryParser.ApXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JoinXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterJoinXq(XQueryParser.JoinXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JoinXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitJoinXq(XQueryParser.JoinXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterBinaryXq(XQueryParser.BinaryXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitBinaryXq(XQueryParser.BinaryXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterVarXq(XQueryParser.VarXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitVarXq(XQueryParser.VarXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedXq(XQueryParser.ParenthesizedXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedXq(XQueryParser.ParenthesizedXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterForXq(XQueryParser.ForXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitForXq(XQueryParser.ForXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterTagXq(XQueryParser.TagXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitTagXq(XQueryParser.TagXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleJoin}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterSimpleJoin(XQueryParser.SimpleJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleJoin}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitSimpleJoin(XQueryParser.SimpleJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedJoinLeft}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterNestedJoinLeft(XQueryParser.NestedJoinLeftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedJoinLeft}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitNestedJoinLeft(XQueryParser.NestedJoinLeftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedJoinRight}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterNestedJoinRight(XQueryParser.NestedJoinRightContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedJoinRight}
	 * labeled alternative in {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitNestedJoinRight(XQueryParser.NestedJoinRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(XQueryParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(XQueryParser.ConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqCond2(XQueryParser.EqCond2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code EqCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqCond2(XQueryParser.EqCond2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCompoundCond(XQueryParser.CompoundCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCompoundCond(XQueryParser.CompoundCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedCond(XQueryParser.ParenthesizedCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedCond(XQueryParser.ParenthesizedCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegatedCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNegatedCond(XQueryParser.NegatedCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegatedCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNegatedCond(XQueryParser.NegatedCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqCond1(XQueryParser.EqCond1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code EqCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqCond1(XQueryParser.EqCond1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEmptyCond(XQueryParser.EmptyCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEmptyCond(XQueryParser.EmptyCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterIsCond1(XQueryParser.IsCond1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code IsCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitIsCond1(XQueryParser.IsCond1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code IsCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterIsCond2(XQueryParser.IsCond2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code IsCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitIsCond2(XQueryParser.IsCond2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code SatisfyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterSatisfyCond(XQueryParser.SatisfyCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SatisfyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitSatisfyCond(XQueryParser.SatisfyCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#satisfy}.
	 * @param ctx the parse tree
	 */
	void enterSatisfy(XQueryParser.SatisfyContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#satisfy}.
	 * @param ctx the parse tree
	 */
	void exitSatisfy(XQueryParser.SatisfyContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#startTag}.
	 * @param ctx the parse tree
	 */
	void enterStartTag(XQueryParser.StartTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#startTag}.
	 * @param ctx the parse tree
	 */
	void exitStartTag(XQueryParser.StartTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 */
	void enterEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 */
	void exitEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XQueryParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XQueryParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code All}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAll(XQueryParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code All}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAll(XQueryParser.AllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedRp(XQueryParser.ParenthesizedRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedRp(XQueryParser.ParenthesizedRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParent(XQueryParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParent(XQueryParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(XQueryParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(XQueryParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSlashRp(XQueryParser.SlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSlashRp(XQueryParser.SlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterText(XQueryParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitText(XQueryParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTag(XQueryParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTag(XQueryParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCurrent(XQueryParser.CurrentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCurrent(XQueryParser.CurrentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCommaRp(XQueryParser.CommaRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCommaRp(XQueryParser.CommaRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterLogicFilter(XQueryParser.LogicFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitLogicFilter(XQueryParser.LogicFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompareFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterCompareFilter(XQueryParser.CompareFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompareFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitCompareFilter(XQueryParser.CompareFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterConstantFilter(XQueryParser.ConstantFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitConstantFilter(XQueryParser.ConstantFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedFilter(XQueryParser.ParenthesizedFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedFilter(XQueryParser.ParenthesizedFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#slash}.
	 * @param ctx the parse tree
	 */
	void enterSlash(XQueryParser.SlashContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#slash}.
	 * @param ctx the parse tree
	 */
	void exitSlash(XQueryParser.SlashContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#docName}.
	 * @param ctx the parse tree
	 */
	void enterDocName(XQueryParser.DocNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#docName}.
	 * @param ctx the parse tree
	 */
	void exitDocName(XQueryParser.DocNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(XQueryParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(XQueryParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(XQueryParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(XQueryParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(XQueryParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(XQueryParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(XQueryParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(XQueryParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(XQueryParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(XQueryParser.DocContext ctx);
}