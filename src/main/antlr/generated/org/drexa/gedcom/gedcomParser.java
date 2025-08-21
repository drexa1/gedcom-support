// Generated from /home/diego/git/gedcom-support/src/main/antlr/gedcom.g4 by ANTLR 4.13.2
package org.drexa.gedcom;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class gedcomParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, ALPHA=17, 
		DIGIT=18, EOL=19, WS=20;
	public static final int
		RULE_gedcom = 0, RULE_line = 1, RULE_level = 2, RULE_opt_xref_id = 3, 
		RULE_tag = 4, RULE_line_value = 5, RULE_line_item = 6, RULE_escape = 7, 
		RULE_non_at = 8, RULE_escape_text = 9, RULE_pointer = 10, RULE_pointer_string = 11, 
		RULE_pointer_char = 12, RULE_alphanum = 13, RULE_anychar = 14, RULE_otherchar = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"gedcom", "line", "level", "opt_xref_id", "tag", "line_value", "line_item", 
			"escape", "non_at", "escape_text", "pointer", "pointer_string", "pointer_char", 
			"alphanum", "anychar", "otherchar"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'#'", "'@@'", "'!'", "'\"'", "'$'", "'&'", "'''", "'('", 
			"')'", "'*'", "'+'", "'-'", "','", "'.'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "ALPHA", "DIGIT", "EOL", "WS"
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

	@Override
	public String getGrammarFileName() { return "gedcom.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gedcomParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GedcomContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(gedcomParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public GedcomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gedcom; }
	}

	public final GedcomContext gedcom() throws RecognitionException {
		GedcomContext _localctx = new GedcomContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gedcom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				line();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public TerminalNode EOL() { return getToken(gedcomParser.EOL, 0); }
		public Opt_xref_idContext opt_xref_id() {
			return getRuleContext(Opt_xref_idContext.class,0);
		}
		public Line_valueContext line_value() {
			return getRuleContext(Line_valueContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			level();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(40);
				opt_xref_id();
				}
			}

			setState(43);
			tag();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 524286L) != 0)) {
				{
				setState(44);
				line_value();
				}
			}

			setState(47);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LevelContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(gedcomParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(gedcomParser.DIGIT, i);
		}
		public LevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level; }
	}

	public final LevelContext level() throws RecognitionException {
		LevelContext _localctx = new LevelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_level);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(49);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(52); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Opt_xref_idContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public Opt_xref_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_xref_id; }
	}

	public final Opt_xref_idContext opt_xref_id() throws RecognitionException {
		Opt_xref_idContext _localctx = new Opt_xref_idContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_opt_xref_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			pointer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagContext extends ParserRuleContext {
		public List<AlphanumContext> alphanum() {
			return getRuleContexts(AlphanumContext.class);
		}
		public AlphanumContext alphanum(int i) {
			return getRuleContext(AlphanumContext.class,i);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tag);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(56);
					alphanum();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(59); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Line_valueContext extends ParserRuleContext {
		public List<Line_itemContext> line_item() {
			return getRuleContexts(Line_itemContext.class);
		}
		public Line_itemContext line_item(int i) {
			return getRuleContext(Line_itemContext.class,i);
		}
		public Line_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_value; }
	}

	public final Line_valueContext line_value() throws RecognitionException {
		Line_valueContext _localctx = new Line_valueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				line_item();
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 524286L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Line_itemContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public EscapeContext escape() {
			return getRuleContext(EscapeContext.class,0);
		}
		public AnycharContext anychar() {
			return getRuleContext(AnycharContext.class,0);
		}
		public Line_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_item; }
	}

	public final Line_itemContext line_item() throws RecognitionException {
		Line_itemContext _localctx = new Line_itemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_line_item);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				escape();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				anychar();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscapeContext extends ParserRuleContext {
		public Escape_textContext escape_text() {
			return getRuleContext(Escape_textContext.class,0);
		}
		public Non_atContext non_at() {
			return getRuleContext(Non_atContext.class,0);
		}
		public EscapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escape; }
	}

	public final EscapeContext escape() throws RecognitionException {
		EscapeContext _localctx = new EscapeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_escape);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__0);
			setState(72);
			match(T__1);
			setState(73);
			escape_text();
			setState(74);
			match(T__0);
			setState(75);
			non_at();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Non_atContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(gedcomParser.ALPHA, 0); }
		public TerminalNode DIGIT() { return getToken(gedcomParser.DIGIT, 0); }
		public OthercharContext otherchar() {
			return getRuleContext(OthercharContext.class,0);
		}
		public Non_atContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_at; }
	}

	public final Non_atContext non_at() throws RecognitionException {
		Non_atContext _localctx = new Non_atContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_non_at);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(ALPHA);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(DIGIT);
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				otherchar();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Escape_textContext extends ParserRuleContext {
		public List<AnycharContext> anychar() {
			return getRuleContexts(AnycharContext.class);
		}
		public AnycharContext anychar(int i) {
			return getRuleContext(AnycharContext.class,i);
		}
		public Escape_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escape_text; }
	}

	public final Escape_textContext escape_text() throws RecognitionException {
		Escape_textContext _localctx = new Escape_textContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_escape_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				anychar();
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 524284L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerContext extends ParserRuleContext {
		public AlphanumContext alphanum() {
			return getRuleContext(AlphanumContext.class,0);
		}
		public Pointer_stringContext pointer_string() {
			return getRuleContext(Pointer_stringContext.class,0);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__0);
			setState(89);
			alphanum();
			setState(90);
			pointer_string();
			setState(91);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pointer_stringContext extends ParserRuleContext {
		public List<Pointer_charContext> pointer_char() {
			return getRuleContexts(Pointer_charContext.class);
		}
		public Pointer_charContext pointer_char(int i) {
			return getRuleContext(Pointer_charContext.class,i);
		}
		public Pointer_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer_string; }
	}

	public final Pointer_stringContext pointer_string() throws RecognitionException {
		Pointer_stringContext _localctx = new Pointer_stringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pointer_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				pointer_char();
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 524276L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pointer_charContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(gedcomParser.ALPHA, 0); }
		public TerminalNode DIGIT() { return getToken(gedcomParser.DIGIT, 0); }
		public OthercharContext otherchar() {
			return getRuleContext(OthercharContext.class,0);
		}
		public Pointer_charContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer_char; }
	}

	public final Pointer_charContext pointer_char() throws RecognitionException {
		Pointer_charContext _localctx = new Pointer_charContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pointer_char);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(ALPHA);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(DIGIT);
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				otherchar();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlphanumContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(gedcomParser.ALPHA, 0); }
		public TerminalNode DIGIT() { return getToken(gedcomParser.DIGIT, 0); }
		public AlphanumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphanum; }
	}

	public final AlphanumContext alphanum() throws RecognitionException {
		AlphanumContext _localctx = new AlphanumContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_alphanum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==ALPHA || _la==DIGIT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnycharContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(gedcomParser.ALPHA, 0); }
		public TerminalNode DIGIT() { return getToken(gedcomParser.DIGIT, 0); }
		public OthercharContext otherchar() {
			return getRuleContext(OthercharContext.class,0);
		}
		public AnycharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anychar; }
	}

	public final AnycharContext anychar() throws RecognitionException {
		AnycharContext _localctx = new AnycharContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_anychar);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(ALPHA);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(DIGIT);
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				otherchar();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OthercharContext extends ParserRuleContext {
		public OthercharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherchar; }
	}

	public final OthercharContext otherchar() throws RecognitionException {
		OthercharContext _localctx = new OthercharContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_otherchar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131056L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0014t\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000\f\u0000#\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001.\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004"+
		"\u00023\b\u0002\u000b\u0002\f\u00024\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0004\u0004:\b\u0004\u000b\u0004\f\u0004;\u0001\u0005\u0004\u0005?\b"+
		"\u0005\u000b\u0005\f\u0005@\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006F\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bR\b\b\u0001"+
		"\t\u0004\tU\b\t\u000b\t\f\tV\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0004\u000b_\b\u000b\u000b\u000b\f\u000b`\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\fg\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000ep\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0002\u0001\u0000"+
		"\u0011\u0012\u0001\u0000\u0004\u0010w\u0000!\u0001\u0000\u0000\u0000\u0002"+
		"\'\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000\u00066\u0001"+
		"\u0000\u0000\u0000\b9\u0001\u0000\u0000\u0000\n>\u0001\u0000\u0000\u0000"+
		"\fE\u0001\u0000\u0000\u0000\u000eG\u0001\u0000\u0000\u0000\u0010Q\u0001"+
		"\u0000\u0000\u0000\u0012T\u0001\u0000\u0000\u0000\u0014X\u0001\u0000\u0000"+
		"\u0000\u0016^\u0001\u0000\u0000\u0000\u0018f\u0001\u0000\u0000\u0000\u001a"+
		"h\u0001\u0000\u0000\u0000\u001co\u0001\u0000\u0000\u0000\u001eq\u0001"+
		"\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000\u0000"+
		"\"#\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000"+
		"\u0000$%\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000\u0001&\u0001\u0001"+
		"\u0000\u0000\u0000\')\u0003\u0004\u0002\u0000(*\u0003\u0006\u0003\u0000"+
		")(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+-\u0003\b\u0004\u0000,.\u0003\n\u0005\u0000-,\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0005\u0013"+
		"\u0000\u00000\u0003\u0001\u0000\u0000\u000013\u0005\u0012\u0000\u0000"+
		"21\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u000045\u0001\u0000\u0000\u00005\u0005\u0001\u0000\u0000\u000067\u0003"+
		"\u0014\n\u00007\u0007\u0001\u0000\u0000\u00008:\u0003\u001a\r\u000098"+
		"\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<\t\u0001\u0000\u0000\u0000=?\u0003\f"+
		"\u0006\u0000>=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u000b\u0001\u0000\u0000"+
		"\u0000BF\u0003\u0014\n\u0000CF\u0003\u000e\u0007\u0000DF\u0003\u001c\u000e"+
		"\u0000EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000"+
		"\u0000\u0000F\r\u0001\u0000\u0000\u0000GH\u0005\u0001\u0000\u0000HI\u0005"+
		"\u0002\u0000\u0000IJ\u0003\u0012\t\u0000JK\u0005\u0001\u0000\u0000KL\u0003"+
		"\u0010\b\u0000L\u000f\u0001\u0000\u0000\u0000MR\u0005\u0011\u0000\u0000"+
		"NR\u0005\u0012\u0000\u0000OR\u0003\u001e\u000f\u0000PR\u0005\u0002\u0000"+
		"\u0000QM\u0001\u0000\u0000\u0000QN\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QP\u0001\u0000\u0000\u0000R\u0011\u0001\u0000\u0000\u0000"+
		"SU\u0003\u001c\u000e\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W\u0013\u0001"+
		"\u0000\u0000\u0000XY\u0005\u0001\u0000\u0000YZ\u0003\u001a\r\u0000Z[\u0003"+
		"\u0016\u000b\u0000[\\\u0005\u0001\u0000\u0000\\\u0015\u0001\u0000\u0000"+
		"\u0000]_\u0003\u0018\f\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\u0017\u0001"+
		"\u0000\u0000\u0000bg\u0005\u0011\u0000\u0000cg\u0005\u0012\u0000\u0000"+
		"dg\u0003\u001e\u000f\u0000eg\u0005\u0002\u0000\u0000fb\u0001\u0000\u0000"+
		"\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000"+
		"\u0000\u0000g\u0019\u0001\u0000\u0000\u0000hi\u0007\u0000\u0000\u0000"+
		"i\u001b\u0001\u0000\u0000\u0000jp\u0005\u0011\u0000\u0000kp\u0005\u0012"+
		"\u0000\u0000lp\u0003\u001e\u000f\u0000mp\u0005\u0002\u0000\u0000np\u0005"+
		"\u0003\u0000\u0000oj\u0001\u0000\u0000\u0000ok\u0001\u0000\u0000\u0000"+
		"ol\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000p\u001d\u0001\u0000\u0000\u0000qr\u0007\u0001\u0000\u0000r\u001f"+
		"\u0001\u0000\u0000\u0000\f#)-4;@EQV`fo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}