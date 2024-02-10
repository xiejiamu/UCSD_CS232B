// Generated from XPath.g4 by ANTLR 4.9.3

package org.example.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(XPathParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(XPathParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XPathParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XPathParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code All}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAll(XPathParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code All}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAll(XPathParser.AllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParaRp(XPathParser.ParaRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParaRp(XPathParser.ParaRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParent(XPathParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParent(XPathParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(XPathParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(XPathParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SlashRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSlashRp(XPathParser.SlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SlashRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSlashRp(XPathParser.SlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterText(XPathParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitText(XPathParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Tag}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTag(XPathParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Tag}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTag(XPathParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCurrent(XPathParser.CurrentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCurrent(XPathParser.CurrentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCommaRp(XPathParser.CommaRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCommaRp(XPathParser.CommaRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterLogicFilter(XPathParser.LogicFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitLogicFilter(XPathParser.LogicFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompareFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterCompareFilter(XPathParser.CompareFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompareFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitCompareFilter(XPathParser.CompareFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XPathParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XPathParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterConstantFilter(XPathParser.ConstantFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitConstantFilter(XPathParser.ConstantFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParaFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterParaFilter(XPathParser.ParaFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParaFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitParaFilter(XPathParser.ParaFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XPathParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XPathParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#slash}.
	 * @param ctx the parse tree
	 */
	void enterSlash(XPathParser.SlashContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#slash}.
	 * @param ctx the parse tree
	 */
	void exitSlash(XPathParser.SlashContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#docName}.
	 * @param ctx the parse tree
	 */
	void enterDocName(XPathParser.DocNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#docName}.
	 * @param ctx the parse tree
	 */
	void exitDocName(XPathParser.DocNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(XPathParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(XPathParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(XPathParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(XPathParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(XPathParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(XPathParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(XPathParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(XPathParser.DocContext ctx);
}