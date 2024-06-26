// Generated from XQuery.g4 by ANTLR 4.9.3

    package org.example.parsers;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, JOIN=3, VAR=4, LAB=5, RAB=6, LBB=7, RBB=8, FOR=9, IN=10, 
		LET=11, ASSIGN=12, WHERE=13, RETURN=14, EMPTY=15, SOME=16, SATISF=17, 
		LPR=18, RPR=19, LSB=20, RSB=21, SSLASH=22, DSLASH=23, CURRENT=24, PARENT=25, 
		STAR=26, COMMA=27, NOT=28, AND=29, OR=30, EQ_N=31, EQ=32, IS_N=33, IS=34, 
		TEXT=35, AT=36, ID=37, WS=38, STRING=39, ESCAPE=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "JOIN", "VAR", "LAB", "RAB", "LBB", "RBB", "FOR", "IN", 
			"LET", "ASSIGN", "WHERE", "RETURN", "EMPTY", "SOME", "SATISF", "LPR", 
			"RPR", "LSB", "RSB", "SSLASH", "DSLASH", "CURRENT", "PARENT", "STAR", 
			"COMMA", "NOT", "AND", "OR", "EQ_N", "EQ", "IS_N", "IS", "TEXT", "AT", 
			"ID", "WS", "STRING", "ESCAPE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc'", "'document'", null, null, "'<'", "'>'", "'{'", "'}'", 
			"'for'", "'in'", "'let'", "':='", "'where'", "'return'", "'empty'", "'some'", 
			"'satisfies'", "'('", "')'", "'['", "']'", "'/'", "'//'", "'.'", "'..'", 
			"'*'", "','", "'not'", "'and'", "'or'", "'='", "'eq'", "'=='", "'is'", 
			"'text()'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "JOIN", "VAR", "LAB", "RAB", "LBB", "RBB", "FOR", "IN", 
			"LET", "ASSIGN", "WHERE", "RETURN", "EMPTY", "SOME", "SATISF", "LPR", 
			"RPR", "LSB", "RSB", "SSLASH", "DSLASH", "CURRENT", "PARENT", "STAR", 
			"COMMA", "NOT", "AND", "OR", "EQ_N", "EQ", "IS_N", "IS", "TEXT", "AT", 
			"ID", "WS", "STRING", "ESCAPE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public XQueryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u00f8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3"+
		"%\3&\6&\u00d7\n&\r&\16&\u00d8\3\'\6\'\u00dc\n\'\r\'\16\'\u00dd\3\'\3\'"+
		"\3(\3(\3(\7(\u00e5\n(\f(\16(\u00e8\13(\3(\3(\3(\3(\7(\u00ee\n(\f(\16("+
		"\u00f1\13(\3(\5(\u00f4\n(\3)\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\13"+
		"\4\2LLll\4\2QQqq\4\2KKkk\4\2PPpp\7\2//\62;C\\aac|\5\2\13\f\17\17\"\"\4"+
		"\2$$^^\4\2))^^\5\2$$))^^\2\u00fe\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5W\3\2\2\2\7`\3\2\2\2\te\3\2\2\2\13h\3"+
		"\2\2\2\rj\3\2\2\2\17l\3\2\2\2\21n\3\2\2\2\23p\3\2\2\2\25t\3\2\2\2\27w"+
		"\3\2\2\2\31{\3\2\2\2\33~\3\2\2\2\35\u0084\3\2\2\2\37\u008b\3\2\2\2!\u0091"+
		"\3\2\2\2#\u0096\3\2\2\2%\u00a0\3\2\2\2\'\u00a2\3\2\2\2)\u00a4\3\2\2\2"+
		"+\u00a6\3\2\2\2-\u00a8\3\2\2\2/\u00aa\3\2\2\2\61\u00ad\3\2\2\2\63\u00af"+
		"\3\2\2\2\65\u00b2\3\2\2\2\67\u00b4\3\2\2\29\u00b6\3\2\2\2;\u00ba\3\2\2"+
		"\2=\u00be\3\2\2\2?\u00c1\3\2\2\2A\u00c3\3\2\2\2C\u00c6\3\2\2\2E\u00c9"+
		"\3\2\2\2G\u00cc\3\2\2\2I\u00d3\3\2\2\2K\u00d6\3\2\2\2M\u00db\3\2\2\2O"+
		"\u00f3\3\2\2\2Q\u00f5\3\2\2\2ST\7f\2\2TU\7q\2\2UV\7e\2\2V\4\3\2\2\2WX"+
		"\7f\2\2XY\7q\2\2YZ\7e\2\2Z[\7w\2\2[\\\7o\2\2\\]\7g\2\2]^\7p\2\2^_\7v\2"+
		"\2_\6\3\2\2\2`a\t\2\2\2ab\t\3\2\2bc\t\4\2\2cd\t\5\2\2d\b\3\2\2\2ef\7&"+
		"\2\2fg\5K&\2g\n\3\2\2\2hi\7>\2\2i\f\3\2\2\2jk\7@\2\2k\16\3\2\2\2lm\7}"+
		"\2\2m\20\3\2\2\2no\7\177\2\2o\22\3\2\2\2pq\7h\2\2qr\7q\2\2rs\7t\2\2s\24"+
		"\3\2\2\2tu\7k\2\2uv\7p\2\2v\26\3\2\2\2wx\7n\2\2xy\7g\2\2yz\7v\2\2z\30"+
		"\3\2\2\2{|\7<\2\2|}\7?\2\2}\32\3\2\2\2~\177\7y\2\2\177\u0080\7j\2\2\u0080"+
		"\u0081\7g\2\2\u0081\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083\34\3\2\2\2\u0084"+
		"\u0085\7t\2\2\u0085\u0086\7g\2\2\u0086\u0087\7v\2\2\u0087\u0088\7w\2\2"+
		"\u0088\u0089\7t\2\2\u0089\u008a\7p\2\2\u008a\36\3\2\2\2\u008b\u008c\7"+
		"g\2\2\u008c\u008d\7o\2\2\u008d\u008e\7r\2\2\u008e\u008f\7v\2\2\u008f\u0090"+
		"\7{\2\2\u0090 \3\2\2\2\u0091\u0092\7u\2\2\u0092\u0093\7q\2\2\u0093\u0094"+
		"\7o\2\2\u0094\u0095\7g\2\2\u0095\"\3\2\2\2\u0096\u0097\7u\2\2\u0097\u0098"+
		"\7c\2\2\u0098\u0099\7v\2\2\u0099\u009a\7k\2\2\u009a\u009b\7u\2\2\u009b"+
		"\u009c\7h\2\2\u009c\u009d\7k\2\2\u009d\u009e\7g\2\2\u009e\u009f\7u\2\2"+
		"\u009f$\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1&\3\2\2\2\u00a2\u00a3\7+\2\2\u00a3"+
		"(\3\2\2\2\u00a4\u00a5\7]\2\2\u00a5*\3\2\2\2\u00a6\u00a7\7_\2\2\u00a7,"+
		"\3\2\2\2\u00a8\u00a9\7\61\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7\61\2\2\u00ab"+
		"\u00ac\7\61\2\2\u00ac\60\3\2\2\2\u00ad\u00ae\7\60\2\2\u00ae\62\3\2\2\2"+
		"\u00af\u00b0\7\60\2\2\u00b0\u00b1\7\60\2\2\u00b1\64\3\2\2\2\u00b2\u00b3"+
		"\7,\2\2\u00b3\66\3\2\2\2\u00b4\u00b5\7.\2\2\u00b58\3\2\2\2\u00b6\u00b7"+
		"\7p\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7v\2\2\u00b9:\3\2\2\2\u00ba\u00bb"+
		"\7c\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f\2\2\u00bd<\3\2\2\2\u00be\u00bf"+
		"\7q\2\2\u00bf\u00c0\7t\2\2\u00c0>\3\2\2\2\u00c1\u00c2\7?\2\2\u00c2@\3"+
		"\2\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7s\2\2\u00c5B\3\2\2\2\u00c6\u00c7"+
		"\7?\2\2\u00c7\u00c8\7?\2\2\u00c8D\3\2\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb"+
		"\7u\2\2\u00cbF\3\2\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf"+
		"\7z\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7*\2\2\u00d1\u00d2\7+\2\2\u00d2"+
		"H\3\2\2\2\u00d3\u00d4\7B\2\2\u00d4J\3\2\2\2\u00d5\u00d7\t\6\2\2\u00d6"+
		"\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9L\3\2\2\2\u00da\u00dc\t\7\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\b\'\2\2\u00e0N\3\2\2\2\u00e1\u00e6\7$\2\2\u00e2\u00e5\5Q)\2\u00e3"+
		"\u00e5\n\b\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00f4\7$\2\2\u00ea\u00ef\7)\2\2\u00eb\u00ee\5Q)\2"+
		"\u00ec\u00ee\n\t\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f4\7)\2\2\u00f3\u00e1\3\2\2\2\u00f3\u00ea\3\2"+
		"\2\2\u00f4P\3\2\2\2\u00f5\u00f6\7^\2\2\u00f6\u00f7\t\n\2\2\u00f7R\3\2"+
		"\2\2\n\2\u00d8\u00dd\u00e4\u00e6\u00ed\u00ef\u00f3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}