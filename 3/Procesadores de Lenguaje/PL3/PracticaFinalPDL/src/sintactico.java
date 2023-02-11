// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class sintactico extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, IF=2, ELSE=3, WHILE=4, DO=5, FOR=6, FUNC=7, RETURN=8, VAL=9, PRINT=10, 
		PARIZ=11, PARDE=12, LLAVEI=13, LLAVED=14, OPR=15, OPS=16, OPM=17, OPD=18, 
		OPE=19, OPRESTO=20, OPMOD=21, OPAND=22, OPOR=23, OPEXC=24, OPNEG=25, OPMAYOR=26, 
		OPMENOR=27, OPMAYIG=28, OPMENIG=29, OPIGUAL=30, OPDIST=31, IGUAL=32, INCREMENTO=33, 
		DECREMENTO=34, PUNTO=35, COMA=36, FINLINEA=37, ENTERO=38, REAL=39, TEXTO=40, 
		VAR=41, MONOMIO=42, POLINOMIO=43, SIGNO=44, COMENTLINC=45, COMENTARIO=46, 
		WS=47;
	public static final int
		RULE_programa = 0, RULE_linea = 1, RULE_expr = 2, RULE_return = 3, RULE_parametroReturn = 4, 
		RULE_igual = 5, RULE_declaracion = 6, RULE_asignacion = 7, RULE_parametroAsignacion = 8, 
		RULE_incdec = 9, RULE_sim = 10, RULE_crearFuncion = 11, RULE_parametrosCrear = 12, 
		RULE_parametros = 13, RULE_parametro = 14, RULE_contenidoFunc = 15, RULE_contenidoBloque = 16, 
		RULE_llamarFuncion = 17, RULE_print = 18, RULE_parametroPrint = 19, RULE_condicional = 20, 
		RULE_if = 21, RULE_elif = 22, RULE_else = 23, RULE_condiciones = 24, RULE_parametroCondicion = 25, 
		RULE_while = 26, RULE_doWhile = 27, RULE_for = 28, RULE_val = 29, RULE_polinomioEvaluar = 30, 
		RULE_parametroPolinomio = 31, RULE_operandoVal = 32, RULE_operacionConPolinom = 33, 
		RULE_variable = 34, RULE_operadicion = 35, RULE_opermultipl = 36, RULE_operlogicos = 37, 
		RULE_opercomparac = 38, RULE_resto = 39, RULE_modulo = 40, RULE_elevado = 41, 
		RULE_finlinea = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "linea", "expr", "return", "parametroReturn", "igual", "declaracion", 
			"asignacion", "parametroAsignacion", "incdec", "sim", "crearFuncion", 
			"parametrosCrear", "parametros", "parametro", "contenidoFunc", "contenidoBloque", 
			"llamarFuncion", "print", "parametroPrint", "condicional", "if", "elif", 
			"else", "condiciones", "parametroCondicion", "while", "doWhile", "for", 
			"val", "polinomioEvaluar", "parametroPolinomio", "operandoVal", "operacionConPolinom", 
			"variable", "operadicion", "opermultipl", "operlogicos", "opercomparac", 
			"resto", "modulo", "elevado", "finlinea"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'if'", "'else'", "'while'", "'do'", "'for'", "'function'", 
			"'return'", "'val'", "'print'", "'('", "')'", "'{'", "'}'", "'-'", "'+'", 
			"'*'", "'/'", "'^'", "'%'", "'//'", "'&&'", "'||'", "'##'", "'!'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'='", "'++'", "'--'", "'.'", 
			"','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "IF", "ELSE", "WHILE", "DO", "FOR", "FUNC", "RETURN", "VAL", 
			"PRINT", "PARIZ", "PARDE", "LLAVEI", "LLAVED", "OPR", "OPS", "OPM", "OPD", 
			"OPE", "OPRESTO", "OPMOD", "OPAND", "OPOR", "OPEXC", "OPNEG", "OPMAYOR", 
			"OPMENOR", "OPMAYIG", "OPMENIG", "OPIGUAL", "OPDIST", "IGUAL", "INCREMENTO", 
			"DECREMENTO", "PUNTO", "COMA", "FINLINEA", "ENTERO", "REAL", "TEXTO", 
			"VAR", "MONOMIO", "POLINOMIO", "SIGNO", "COMENTLINC", "COMENTARIO", "WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public sintactico(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public List<CrearFuncionContext> crearFuncion() {
			return getRuleContexts(CrearFuncionContext.class);
		}
		public CrearFuncionContext crearFuncion(int i) {
			return getRuleContext(CrearFuncionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(sintactico.EOF, 0); }
		public List<LineaContext> linea() {
			return getRuleContexts(LineaContext.class);
		}
		public LineaContext linea(int i) {
			return getRuleContext(LineaContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					crearFuncion();
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FUNC );
				}
				}
				break;
			case LET:
			case IF:
			case WHILE:
			case DO:
			case FOR:
			case RETURN:
			case VAL:
			case PRINT:
			case INCREMENTO:
			case DECREMENTO:
			case ENTERO:
			case REAL:
			case TEXTO:
			case VAR:
			case POLINOMIO:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(91);
					linea();
					}
					}
					setState(94); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 12945031432054L) != 0 );
				}
				setState(96);
				match(EOF);
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
	public static class LineaContext extends ParserRuleContext {
		public FinlineaContext finlinea() {
			return getRuleContext(FinlineaContext.class,0);
		}
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LineaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linea; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterLinea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitLinea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitLinea(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineaContext linea() throws RecognitionException {
		LineaContext _localctx = new LineaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_linea);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(102);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LET:
					{
					setState(100);
					declaracion();
					}
					break;
				case IF:
				case WHILE:
				case DO:
				case FOR:
				case RETURN:
				case VAL:
				case PRINT:
				case INCREMENTO:
				case DECREMENTO:
				case ENTERO:
				case REAL:
				case TEXTO:
				case VAR:
				case POLINOMIO:
					{
					setState(101);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 12945031432054L) != 0 );
			setState(106);
			finlinea();
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
	public static class ExprContext extends ParserRuleContext {
		public LlamarFuncionContext llamarFuncion() {
			return getRuleContext(LlamarFuncionContext.class,0);
		}
		public SimContext sim() {
			return getRuleContext(SimContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public DoWhileContext doWhile() {
			return getRuleContext(DoWhileContext.class,0);
		}
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public TerminalNode TEXTO() { return getToken(sintactico.TEXTO, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ElevadoContext elevado() {
			return getRuleContext(ElevadoContext.class,0);
		}
		public OpermultiplContext opermultipl() {
			return getRuleContext(OpermultiplContext.class,0);
		}
		public OperadicionContext operadicion() {
			return getRuleContext(OperadicionContext.class,0);
		}
		public RestoContext resto() {
			return getRuleContext(RestoContext.class,0);
		}
		public ModuloContext modulo() {
			return getRuleContext(ModuloContext.class,0);
		}
		public OpercomparacContext opercomparac() {
			return getRuleContext(OpercomparacContext.class,0);
		}
		public OperlogicosContext operlogicos() {
			return getRuleContext(OperlogicosContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(109);
				llamarFuncion();
				}
				break;
			case 2:
				{
				setState(110);
				sim();
				}
				break;
			case 3:
				{
				setState(111);
				print();
				}
				break;
			case 4:
				{
				setState(112);
				variable();
				}
				break;
			case 5:
				{
				setState(113);
				condicional();
				}
				break;
			case 6:
				{
				setState(114);
				while_();
				}
				break;
			case 7:
				{
				setState(115);
				doWhile();
				}
				break;
			case 8:
				{
				setState(116);
				for_();
				}
				break;
			case 9:
				{
				setState(117);
				asignacion();
				}
				break;
			case 10:
				{
				setState(118);
				val();
				}
				break;
			case 11:
				{
				setState(119);
				return_();
				}
				break;
			case 12:
				{
				setState(120);
				match(ENTERO);
				}
				break;
			case 13:
				{
				setState(121);
				match(REAL);
				}
				break;
			case 14:
				{
				setState(122);
				match(POLINOMIO);
				}
				break;
			case 15:
				{
				setState(123);
				match(TEXTO);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(127);
						elevado();
						setState(128);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(131);
						opermultipl();
						setState(132);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(135);
						operadicion();
						setState(136);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(141);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case OPRESTO:
							{
							setState(139);
							resto();
							}
							break;
						case OPMOD:
							{
							setState(140);
							modulo();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(143);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(146);
						opercomparac();
						setState(147);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(150);
						operlogicos();
						setState(151);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(sintactico.RETURN, 0); }
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public ParametroReturnContext parametroReturn() {
			return getRuleContext(ParametroReturnContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_return);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(RETURN);
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(159);
				match(PARIZ);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 12919261626880L) != 0) {
					{
					setState(160);
					parametroReturn(0);
					}
				}

				setState(163);
				match(PARDE);
				}
				break;
			case 2:
				{
				setState(165);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(164);
					parametroReturn(0);
					}
					break;
				}
				}
				break;
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
	public static class ParametroReturnContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public TerminalNode TEXTO() { return getToken(sintactico.TEXTO, 0); }
		public LlamarFuncionContext llamarFuncion() {
			return getRuleContext(LlamarFuncionContext.class,0);
		}
		public List<ParametroReturnContext> parametroReturn() {
			return getRuleContexts(ParametroReturnContext.class);
		}
		public ParametroReturnContext parametroReturn(int i) {
			return getRuleContext(ParametroReturnContext.class,i);
		}
		public OpercomparacContext opercomparac() {
			return getRuleContext(OpercomparacContext.class,0);
		}
		public OpermultiplContext opermultipl() {
			return getRuleContext(OpermultiplContext.class,0);
		}
		public OperadicionContext operadicion() {
			return getRuleContext(OperadicionContext.class,0);
		}
		public ParametroReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametroReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametroReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametroReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametroReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroReturnContext parametroReturn() throws RecognitionException {
		return parametroReturn(0);
	}

	private ParametroReturnContext parametroReturn(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParametroReturnContext _localctx = new ParametroReturnContext(_ctx, _parentState);
		ParametroReturnContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_parametroReturn, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(170);
				variable();
				}
				break;
			case 2:
				{
				setState(171);
				val();
				}
				break;
			case 3:
				{
				setState(172);
				match(ENTERO);
				}
				break;
			case 4:
				{
				setState(173);
				match(REAL);
				}
				break;
			case 5:
				{
				setState(174);
				match(POLINOMIO);
				}
				break;
			case 6:
				{
				setState(175);
				match(TEXTO);
				}
				break;
			case 7:
				{
				setState(176);
				llamarFuncion();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(191);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ParametroReturnContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroReturn);
						setState(179);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(180);
						opercomparac();
						setState(181);
						parametroReturn(9);
						}
						break;
					case 2:
						{
						_localctx = new ParametroReturnContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroReturn);
						setState(183);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(184);
						opermultipl();
						setState(185);
						parametroReturn(8);
						}
						break;
					case 3:
						{
						_localctx = new ParametroReturnContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroReturn);
						setState(187);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(188);
						operadicion();
						setState(189);
						parametroReturn(7);
						}
						break;
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IgualContext extends ParserRuleContext {
		public TerminalNode IGUAL() { return getToken(sintactico.IGUAL, 0); }
		public IgualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_igual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterIgual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitIgual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitIgual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IgualContext igual() throws RecognitionException {
		IgualContext _localctx = new IgualContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_igual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(IGUAL);
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
	public static class DeclaracionContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(sintactico.LET, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(LET);
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(199);
				variable();
				}
				break;
			case 2:
				{
				setState(200);
				asignacion();
				}
				break;
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
	public static class AsignacionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public IgualContext igual() {
			return getRuleContext(IgualContext.class,0);
		}
		public ParametroAsignacionContext parametroAsignacion() {
			return getRuleContext(ParametroAsignacionContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			variable();
			setState(204);
			igual();
			setState(205);
			parametroAsignacion(0);
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
	public static class ParametroAsignacionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
		}
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public TerminalNode TEXTO() { return getToken(sintactico.TEXTO, 0); }
		public LlamarFuncionContext llamarFuncion() {
			return getRuleContext(LlamarFuncionContext.class,0);
		}
		public List<ParametroAsignacionContext> parametroAsignacion() {
			return getRuleContexts(ParametroAsignacionContext.class);
		}
		public ParametroAsignacionContext parametroAsignacion(int i) {
			return getRuleContext(ParametroAsignacionContext.class,i);
		}
		public ElevadoContext elevado() {
			return getRuleContext(ElevadoContext.class,0);
		}
		public OpercomparacContext opercomparac() {
			return getRuleContext(OpercomparacContext.class,0);
		}
		public OpermultiplContext opermultipl() {
			return getRuleContext(OpermultiplContext.class,0);
		}
		public OperadicionContext operadicion() {
			return getRuleContext(OperadicionContext.class,0);
		}
		public ParametroAsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametroAsignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametroAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametroAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametroAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroAsignacionContext parametroAsignacion() throws RecognitionException {
		return parametroAsignacion(0);
	}

	private ParametroAsignacionContext parametroAsignacion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParametroAsignacionContext _localctx = new ParametroAsignacionContext(_ctx, _parentState);
		ParametroAsignacionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_parametroAsignacion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(208);
				variable();
				}
				break;
			case 2:
				{
				setState(209);
				val();
				}
				break;
			case 3:
				{
				setState(222);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INCREMENTO:
				case DECREMENTO:
					{
					{
					setState(210);
					incdec();
					setState(214);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ENTERO:
						{
						setState(211);
						match(ENTERO);
						}
						break;
					case REAL:
						{
						setState(212);
						match(REAL);
						}
						break;
					case VAR:
						{
						setState(213);
						variable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				case ENTERO:
				case REAL:
				case VAR:
					{
					{
					setState(219);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ENTERO:
						{
						setState(216);
						match(ENTERO);
						}
						break;
					case REAL:
						{
						setState(217);
						match(REAL);
						}
						break;
					case VAR:
						{
						setState(218);
						variable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(221);
					incdec();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				{
				setState(224);
				match(ENTERO);
				}
				break;
			case 5:
				{
				setState(225);
				match(REAL);
				}
				break;
			case 6:
				{
				setState(226);
				match(POLINOMIO);
				}
				break;
			case 7:
				{
				setState(227);
				match(TEXTO);
				}
				break;
			case 8:
				{
				setState(228);
				llamarFuncion();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(247);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ParametroAsignacionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroAsignacion);
						setState(231);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(232);
						elevado();
						setState(233);
						parametroAsignacion(10);
						}
						break;
					case 2:
						{
						_localctx = new ParametroAsignacionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroAsignacion);
						setState(235);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(236);
						opercomparac();
						setState(237);
						parametroAsignacion(9);
						}
						break;
					case 3:
						{
						_localctx = new ParametroAsignacionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroAsignacion);
						setState(239);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(240);
						opermultipl();
						setState(241);
						parametroAsignacion(8);
						}
						break;
					case 4:
						{
						_localctx = new ParametroAsignacionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroAsignacion);
						setState(243);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(244);
						operadicion();
						setState(245);
						parametroAsignacion(7);
						}
						break;
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncdecContext extends ParserRuleContext {
		public TerminalNode INCREMENTO() { return getToken(sintactico.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(sintactico.DECREMENTO, 0); }
		public IncdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterIncdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitIncdec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitIncdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncdecContext incdec() throws RecognitionException {
		IncdecContext _localctx = new IncdecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_incdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
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
	public static class SimContext extends ParserRuleContext {
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
		}
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public SimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterSim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitSim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitSim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimContext sim() throws RecognitionException {
		SimContext _localctx = new SimContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sim);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCREMENTO:
			case DECREMENTO:
				{
				{
				setState(254);
				incdec();
				setState(258);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ENTERO:
					{
					setState(255);
					match(ENTERO);
					}
					break;
				case REAL:
					{
					setState(256);
					match(REAL);
					}
					break;
				case VAR:
					{
					setState(257);
					variable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case ENTERO:
			case REAL:
			case VAR:
				{
				{
				setState(263);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ENTERO:
					{
					setState(260);
					match(ENTERO);
					}
					break;
				case REAL:
					{
					setState(261);
					match(REAL);
					}
					break;
				case VAR:
					{
					setState(262);
					variable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(265);
				incdec();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class CrearFuncionContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(sintactico.FUNC, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public ContenidoFuncContext contenidoFunc() {
			return getRuleContext(ContenidoFuncContext.class,0);
		}
		public ParametrosCrearContext parametrosCrear() {
			return getRuleContext(ParametrosCrearContext.class,0);
		}
		public CrearFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crearFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterCrearFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitCrearFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitCrearFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CrearFuncionContext crearFuncion() throws RecognitionException {
		CrearFuncionContext _localctx = new CrearFuncionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_crearFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(FUNC);
			setState(269);
			variable();
			setState(270);
			match(PARIZ);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(271);
				parametrosCrear();
				}
			}

			setState(274);
			match(PARDE);
			setState(275);
			contenidoFunc();
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
	public static class ParametrosCrearContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(sintactico.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(sintactico.COMA, i);
		}
		public ParametrosCrearContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametrosCrear; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametrosCrear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametrosCrear(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametrosCrear(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosCrearContext parametrosCrear() throws RecognitionException {
		ParametrosCrearContext _localctx = new ParametrosCrearContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parametrosCrear);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			variable();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(278);
				match(COMA);
				setState(279);
				variable();
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(sintactico.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(sintactico.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			parametro();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(286);
				match(COMA);
				setState(287);
				parametro();
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class ParametroContext extends ParserRuleContext {
		public LlamarFuncionContext llamarFuncion() {
			return getRuleContext(LlamarFuncionContext.class,0);
		}
		public SimContext sim() {
			return getRuleContext(SimContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ElevadoContext elevado() {
			return getRuleContext(ElevadoContext.class,0);
		}
		public OperadicionContext operadicion() {
			return getRuleContext(OperadicionContext.class,0);
		}
		public OpermultiplContext opermultipl() {
			return getRuleContext(OpermultiplContext.class,0);
		}
		public RestoContext resto() {
			return getRuleContext(RestoContext.class,0);
		}
		public ModuloContext modulo() {
			return getRuleContext(ModuloContext.class,0);
		}
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public TerminalNode TEXTO() { return getToken(sintactico.TEXTO, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parametro);
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				llamarFuncion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				sim();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(296);
				val();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(297);
				expr(0);
				setState(298);
				elevado();
				setState(299);
				expr(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				expr(0);
				setState(302);
				operadicion();
				setState(303);
				expr(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(305);
				expr(0);
				setState(306);
				opermultipl();
				setState(307);
				expr(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(309);
				expr(0);
				setState(312);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPRESTO:
					{
					setState(310);
					resto();
					}
					break;
				case OPMOD:
					{
					setState(311);
					modulo();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(314);
				expr(0);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(316);
				match(ENTERO);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(317);
				match(REAL);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(318);
				match(POLINOMIO);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(319);
				match(TEXTO);
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
	public static class ContenidoFuncContext extends ParserRuleContext {
		public TerminalNode LLAVEI() { return getToken(sintactico.LLAVEI, 0); }
		public TerminalNode LLAVED() { return getToken(sintactico.LLAVED, 0); }
		public FinlineaContext finlinea() {
			return getRuleContext(FinlineaContext.class,0);
		}
		public List<LineaContext> linea() {
			return getRuleContexts(LineaContext.class);
		}
		public LineaContext linea(int i) {
			return getRuleContext(LineaContext.class,i);
		}
		public ContenidoFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contenidoFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterContenidoFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitContenidoFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitContenidoFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContenidoFuncContext contenidoFunc() throws RecognitionException {
		ContenidoFuncContext _localctx = new ContenidoFuncContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_contenidoFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(LLAVEI);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 12945031432054L) != 0) {
				{
				{
				setState(323);
				linea();
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(329);
			match(LLAVED);
			setState(330);
			finlinea();
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
	public static class ContenidoBloqueContext extends ParserRuleContext {
		public TerminalNode LLAVEI() { return getToken(sintactico.LLAVEI, 0); }
		public TerminalNode LLAVED() { return getToken(sintactico.LLAVED, 0); }
		public List<LineaContext> linea() {
			return getRuleContexts(LineaContext.class);
		}
		public LineaContext linea(int i) {
			return getRuleContext(LineaContext.class,i);
		}
		public ContenidoBloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contenidoBloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterContenidoBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitContenidoBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitContenidoBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContenidoBloqueContext contenidoBloque() throws RecognitionException {
		ContenidoBloqueContext _localctx = new ContenidoBloqueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_contenidoBloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(LLAVEI);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 12945031432054L) != 0) {
				{
				{
				setState(333);
				linea();
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(339);
			match(LLAVED);
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
	public static class LlamarFuncionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public LlamarFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamarFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterLlamarFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitLlamarFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitLlamarFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamarFuncionContext llamarFuncion() throws RecognitionException {
		LlamarFuncionContext _localctx = new LlamarFuncionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_llamarFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			variable();
			setState(342);
			match(PARIZ);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 12945031432052L) != 0) {
				{
				setState(343);
				parametros();
				}
			}

			setState(346);
			match(PARDE);
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
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(sintactico.PRINT, 0); }
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public ParametroPrintContext parametroPrint() {
			return getRuleContext(ParametroPrintContext.class,0);
		}
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(PRINT);
			setState(349);
			match(PARIZ);
			setState(350);
			parametroPrint(0);
			setState(351);
			match(PARDE);
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
	public static class ParametroPrintContext extends ParserRuleContext {
		public LlamarFuncionContext llamarFuncion() {
			return getRuleContext(LlamarFuncionContext.class,0);
		}
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
		}
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public TerminalNode TEXTO() { return getToken(sintactico.TEXTO, 0); }
		public List<ParametroPrintContext> parametroPrint() {
			return getRuleContexts(ParametroPrintContext.class);
		}
		public ParametroPrintContext parametroPrint(int i) {
			return getRuleContext(ParametroPrintContext.class,i);
		}
		public OpermultiplContext opermultipl() {
			return getRuleContext(OpermultiplContext.class,0);
		}
		public OperadicionContext operadicion() {
			return getRuleContext(OperadicionContext.class,0);
		}
		public ElevadoContext elevado() {
			return getRuleContext(ElevadoContext.class,0);
		}
		public RestoContext resto() {
			return getRuleContext(RestoContext.class,0);
		}
		public ModuloContext modulo() {
			return getRuleContext(ModuloContext.class,0);
		}
		public OpercomparacContext opercomparac() {
			return getRuleContext(OpercomparacContext.class,0);
		}
		public OperlogicosContext operlogicos() {
			return getRuleContext(OperlogicosContext.class,0);
		}
		public ParametroPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametroPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametroPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametroPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametroPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroPrintContext parametroPrint() throws RecognitionException {
		return parametroPrint(0);
	}

	private ParametroPrintContext parametroPrint(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParametroPrintContext _localctx = new ParametroPrintContext(_ctx, _parentState);
		ParametroPrintContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_parametroPrint, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(354);
				llamarFuncion();
				}
				break;
			case 2:
				{
				setState(367);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INCREMENTO:
				case DECREMENTO:
					{
					{
					setState(355);
					incdec();
					setState(359);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ENTERO:
						{
						setState(356);
						match(ENTERO);
						}
						break;
					case REAL:
						{
						setState(357);
						match(REAL);
						}
						break;
					case VAR:
						{
						setState(358);
						variable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				case ENTERO:
				case REAL:
				case VAR:
					{
					{
					setState(364);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ENTERO:
						{
						setState(361);
						match(ENTERO);
						}
						break;
					case REAL:
						{
						setState(362);
						match(REAL);
						}
						break;
					case VAR:
						{
						setState(363);
						variable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(366);
					incdec();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				setState(369);
				variable();
				}
				break;
			case 4:
				{
				setState(370);
				val();
				}
				break;
			case 5:
				{
				setState(371);
				match(ENTERO);
				}
				break;
			case 6:
				{
				setState(372);
				match(REAL);
				}
				break;
			case 7:
				{
				setState(373);
				match(POLINOMIO);
				}
				break;
			case 8:
				{
				setState(374);
				match(TEXTO);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(406);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(404);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new ParametroPrintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroPrint);
						setState(377);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(378);
						opermultipl();
						setState(379);
						parametroPrint(11);
						}
						break;
					case 2:
						{
						_localctx = new ParametroPrintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroPrint);
						setState(381);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(382);
						operadicion();
						setState(383);
						parametroPrint(10);
						}
						break;
					case 3:
						{
						_localctx = new ParametroPrintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroPrint);
						setState(385);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(386);
						elevado();
						setState(387);
						parametroPrint(9);
						}
						break;
					case 4:
						{
						_localctx = new ParametroPrintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroPrint);
						setState(389);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(392);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case OPRESTO:
							{
							setState(390);
							resto();
							}
							break;
						case OPMOD:
							{
							setState(391);
							modulo();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(394);
						parametroPrint(8);
						}
						break;
					case 5:
						{
						_localctx = new ParametroPrintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroPrint);
						setState(396);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(397);
						opercomparac();
						setState(398);
						parametroPrint(7);
						}
						break;
					case 6:
						{
						_localctx = new ParametroPrintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroPrint);
						setState(400);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(401);
						operlogicos();
						setState(402);
						parametroPrint(6);
						}
						break;
					}
					} 
				}
				setState(408);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionalContext extends ParserRuleContext {
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public List<ElifContext> elif() {
			return getRuleContexts(ElifContext.class);
		}
		public ElifContext elif(int i) {
			return getRuleContext(ElifContext.class,i);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitCondicional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_condicional);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			if_();
			setState(413);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(410);
					elif();
					}
					} 
				}
				setState(415);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(416);
				else_();
				}
				break;
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
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(sintactico.IF, 0); }
		public CondicionesContext condiciones() {
			return getRuleContext(CondicionesContext.class,0);
		}
		public ContenidoBloqueContext contenidoBloque() {
			return getRuleContext(ContenidoBloqueContext.class,0);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(IF);
			setState(420);
			condiciones();
			setState(421);
			contenidoBloque();
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
	public static class ElifContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(sintactico.ELSE, 0); }
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public ElifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterElif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitElif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitElif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifContext elif() throws RecognitionException {
		ElifContext _localctx = new ElifContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_elif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(ELSE);
			setState(424);
			if_();
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
	public static class ElseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(sintactico.ELSE, 0); }
		public ContenidoBloqueContext contenidoBloque() {
			return getRuleContext(ContenidoBloqueContext.class,0);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(ELSE);
			setState(427);
			contenidoBloque();
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
	public static class CondicionesContext extends ParserRuleContext {
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public ParametroCondicionContext parametroCondicion() {
			return getRuleContext(ParametroCondicionContext.class,0);
		}
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public CondicionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condiciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterCondiciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitCondiciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitCondiciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionesContext condiciones() throws RecognitionException {
		CondicionesContext _localctx = new CondicionesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_condiciones);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(PARIZ);
			setState(430);
			parametroCondicion(0);
			setState(431);
			match(PARDE);
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
	public static class ParametroCondicionContext extends ParserRuleContext {
		public LlamarFuncionContext llamarFuncion() {
			return getRuleContext(LlamarFuncionContext.class,0);
		}
		public SimContext sim() {
			return getRuleContext(SimContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public List<ParametroCondicionContext> parametroCondicion() {
			return getRuleContexts(ParametroCondicionContext.class);
		}
		public ParametroCondicionContext parametroCondicion(int i) {
			return getRuleContext(ParametroCondicionContext.class,i);
		}
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public TerminalNode OPNEG() { return getToken(sintactico.OPNEG, 0); }
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public TerminalNode TEXTO() { return getToken(sintactico.TEXTO, 0); }
		public OpercomparacContext opercomparac() {
			return getRuleContext(OpercomparacContext.class,0);
		}
		public OperlogicosContext operlogicos() {
			return getRuleContext(OperlogicosContext.class,0);
		}
		public ParametroCondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametroCondicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametroCondicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametroCondicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametroCondicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroCondicionContext parametroCondicion() throws RecognitionException {
		return parametroCondicion(0);
	}

	private ParametroCondicionContext parametroCondicion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParametroCondicionContext _localctx = new ParametroCondicionContext(_ctx, _parentState);
		ParametroCondicionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_parametroCondicion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(434);
				llamarFuncion();
				}
				break;
			case 2:
				{
				setState(435);
				sim();
				}
				break;
			case 3:
				{
				setState(436);
				variable();
				}
				break;
			case 4:
				{
				setState(437);
				val();
				}
				break;
			case 5:
				{
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPNEG) {
					{
					setState(438);
					match(OPNEG);
					}
				}

				setState(441);
				match(PARIZ);
				setState(442);
				parametroCondicion(0);
				setState(443);
				match(PARDE);
				}
				break;
			case 6:
				{
				setState(445);
				match(ENTERO);
				}
				break;
			case 7:
				{
				setState(446);
				match(REAL);
				}
				break;
			case 8:
				{
				setState(447);
				match(POLINOMIO);
				}
				break;
			case 9:
				{
				setState(448);
				match(TEXTO);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(461);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(459);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new ParametroCondicionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroCondicion);
						setState(451);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(452);
						opercomparac();
						setState(453);
						parametroCondicion(7);
						}
						break;
					case 2:
						{
						_localctx = new ParametroCondicionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parametroCondicion);
						setState(455);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(456);
						operlogicos();
						setState(457);
						parametroCondicion(6);
						}
						break;
					}
					} 
				}
				setState(463);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(sintactico.WHILE, 0); }
		public CondicionesContext condiciones() {
			return getRuleContext(CondicionesContext.class,0);
		}
		public ContenidoBloqueContext contenidoBloque() {
			return getRuleContext(ContenidoBloqueContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(WHILE);
			setState(465);
			condiciones();
			setState(466);
			contenidoBloque();
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
	public static class DoWhileContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(sintactico.DO, 0); }
		public TerminalNode LLAVEI() { return getToken(sintactico.LLAVEI, 0); }
		public TerminalNode LLAVED() { return getToken(sintactico.LLAVED, 0); }
		public TerminalNode WHILE() { return getToken(sintactico.WHILE, 0); }
		public CondicionesContext condiciones() {
			return getRuleContext(CondicionesContext.class,0);
		}
		public List<FinlineaContext> finlinea() {
			return getRuleContexts(FinlineaContext.class);
		}
		public FinlineaContext finlinea(int i) {
			return getRuleContext(FinlineaContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public DoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileContext doWhile() throws RecognitionException {
		DoWhileContext _localctx = new DoWhileContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_doWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(DO);
			setState(469);
			match(LLAVEI);
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 12945031432054L) != 0) {
				{
				{
				setState(472);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case DO:
				case FOR:
				case RETURN:
				case VAL:
				case PRINT:
				case INCREMENTO:
				case DECREMENTO:
				case ENTERO:
				case REAL:
				case TEXTO:
				case VAR:
				case POLINOMIO:
					{
					setState(470);
					expr(0);
					}
					break;
				case LET:
					{
					setState(471);
					declaracion();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(474);
				finlinea();
				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(481);
			match(LLAVED);
			setState(482);
			match(WHILE);
			setState(483);
			condiciones();
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
	public static class ForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(sintactico.FOR, 0); }
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<FinlineaContext> finlinea() {
			return getRuleContexts(FinlineaContext.class);
		}
		public FinlineaContext finlinea(int i) {
			return getRuleContext(FinlineaContext.class,i);
		}
		public CondicionesContext condiciones() {
			return getRuleContext(CondicionesContext.class,0);
		}
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
		}
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public ContenidoBloqueContext contenidoBloque() {
			return getRuleContext(ContenidoBloqueContext.class,0);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(FOR);
			setState(486);
			match(PARIZ);
			setState(487);
			variable();
			setState(488);
			finlinea();
			setState(489);
			condiciones();
			setState(490);
			finlinea();
			setState(491);
			variable();
			setState(492);
			incdec();
			setState(493);
			match(PARDE);
			setState(494);
			contenidoBloque();
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
	public static class ValContext extends ParserRuleContext {
		public TerminalNode VAL() { return getToken(sintactico.VAL, 0); }
		public TerminalNode PARIZ() { return getToken(sintactico.PARIZ, 0); }
		public PolinomioEvaluarContext polinomioEvaluar() {
			return getRuleContext(PolinomioEvaluarContext.class,0);
		}
		public TerminalNode COMA() { return getToken(sintactico.COMA, 0); }
		public ParametroPolinomioContext parametroPolinomio() {
			return getRuleContext(ParametroPolinomioContext.class,0);
		}
		public TerminalNode PARDE() { return getToken(sintactico.PARDE, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_val);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(VAL);
			setState(497);
			match(PARIZ);
			setState(498);
			polinomioEvaluar(0);
			setState(499);
			match(COMA);
			setState(500);
			parametroPolinomio(0);
			setState(501);
			match(PARDE);
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
	public static class PolinomioEvaluarContext extends ParserRuleContext {
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public TerminalNode VAR() { return getToken(sintactico.VAR, 0); }
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public List<PolinomioEvaluarContext> polinomioEvaluar() {
			return getRuleContexts(PolinomioEvaluarContext.class);
		}
		public PolinomioEvaluarContext polinomioEvaluar(int i) {
			return getRuleContext(PolinomioEvaluarContext.class,i);
		}
		public OpermultiplContext opermultipl() {
			return getRuleContext(OpermultiplContext.class,0);
		}
		public OperadicionContext operadicion() {
			return getRuleContext(OperadicionContext.class,0);
		}
		public ElevadoContext elevado() {
			return getRuleContext(ElevadoContext.class,0);
		}
		public PolinomioEvaluarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polinomioEvaluar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterPolinomioEvaluar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitPolinomioEvaluar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitPolinomioEvaluar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolinomioEvaluarContext polinomioEvaluar() throws RecognitionException {
		return polinomioEvaluar(0);
	}

	private PolinomioEvaluarContext polinomioEvaluar(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PolinomioEvaluarContext _localctx = new PolinomioEvaluarContext(_ctx, _parentState);
		PolinomioEvaluarContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_polinomioEvaluar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POLINOMIO:
				{
				setState(504);
				match(POLINOMIO);
				}
				break;
			case VAR:
				{
				setState(505);
				match(VAR);
				}
				break;
			case ENTERO:
				{
				setState(506);
				match(ENTERO);
				}
				break;
			case REAL:
				{
				setState(507);
				match(REAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(524);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(522);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new PolinomioEvaluarContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_polinomioEvaluar);
						setState(510);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(511);
						opermultipl();
						setState(512);
						polinomioEvaluar(8);
						}
						break;
					case 2:
						{
						_localctx = new PolinomioEvaluarContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_polinomioEvaluar);
						setState(514);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(515);
						operadicion();
						setState(516);
						polinomioEvaluar(7);
						}
						break;
					case 3:
						{
						_localctx = new PolinomioEvaluarContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_polinomioEvaluar);
						setState(518);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(519);
						elevado();
						setState(520);
						polinomioEvaluar(6);
						}
						break;
					}
					} 
				}
				setState(526);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroPolinomioContext extends ParserRuleContext {
		public List<OperandoValContext> operandoVal() {
			return getRuleContexts(OperandoValContext.class);
		}
		public OperandoValContext operandoVal(int i) {
			return getRuleContext(OperandoValContext.class,i);
		}
		public TerminalNode COMA() { return getToken(sintactico.COMA, 0); }
		public List<ParametroPolinomioContext> parametroPolinomio() {
			return getRuleContexts(ParametroPolinomioContext.class);
		}
		public ParametroPolinomioContext parametroPolinomio(int i) {
			return getRuleContext(ParametroPolinomioContext.class,i);
		}
		public ParametroPolinomioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametroPolinomio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterParametroPolinomio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitParametroPolinomio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitParametroPolinomio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroPolinomioContext parametroPolinomio() throws RecognitionException {
		return parametroPolinomio(0);
	}

	private ParametroPolinomioContext parametroPolinomio(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParametroPolinomioContext _localctx = new ParametroPolinomioContext(_ctx, _parentState);
		ParametroPolinomioContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_parametroPolinomio, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(528);
			operandoVal();
			setState(529);
			match(COMA);
			setState(530);
			operandoVal();
			}
			_ctx.stop = _input.LT(-1);
			setState(537);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParametroPolinomioContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parametroPolinomio);
					setState(532);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(533);
					match(COMA);
					setState(534);
					parametroPolinomio(2);
					}
					} 
				}
				setState(539);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperandoValContext extends ParserRuleContext {
		public TerminalNode POLINOMIO() { return getToken(sintactico.POLINOMIO, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ENTERO() { return getToken(sintactico.ENTERO, 0); }
		public TerminalNode REAL() { return getToken(sintactico.REAL, 0); }
		public OperandoValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operandoVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterOperandoVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitOperandoVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitOperandoVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandoValContext operandoVal() throws RecognitionException {
		OperandoValContext _localctx = new OperandoValContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_operandoVal);
		try {
			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				match(POLINOMIO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(541);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(542);
				match(ENTERO);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(543);
				match(REAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
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
	public static class OperacionConPolinomContext extends ParserRuleContext {
		public List<TerminalNode> POLINOMIO() { return getTokens(sintactico.POLINOMIO); }
		public TerminalNode POLINOMIO(int i) {
			return getToken(sintactico.POLINOMIO, i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public OperadicionContext operadicion() {
			return getRuleContext(OperadicionContext.class,0);
		}
		public OpermultiplContext opermultipl() {
			return getRuleContext(OpermultiplContext.class,0);
		}
		public OperacionConPolinomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacionConPolinom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterOperacionConPolinom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitOperacionConPolinom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitOperacionConPolinom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperacionConPolinomContext operacionConPolinom() throws RecognitionException {
		OperacionConPolinomContext _localctx = new OperacionConPolinomContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_operacionConPolinom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POLINOMIO:
				{
				setState(547);
				match(POLINOMIO);
				}
				break;
			case VAR:
				{
				setState(548);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(553);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPR:
			case OPS:
				{
				setState(551);
				operadicion();
				}
				break;
			case OPM:
			case OPD:
				{
				setState(552);
				opermultipl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(557);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POLINOMIO:
				{
				setState(555);
				match(POLINOMIO);
				}
				break;
			case VAR:
				{
				setState(556);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(sintactico.VAR, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(VAR);
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
	public static class OperadicionContext extends ParserRuleContext {
		public TerminalNode OPS() { return getToken(sintactico.OPS, 0); }
		public TerminalNode OPR() { return getToken(sintactico.OPR, 0); }
		public OperadicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterOperadicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitOperadicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitOperadicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperadicionContext operadicion() throws RecognitionException {
		OperadicionContext _localctx = new OperadicionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_operadicion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			_la = _input.LA(1);
			if ( !(_la==OPR || _la==OPS) ) {
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
	public static class OpermultiplContext extends ParserRuleContext {
		public TerminalNode OPM() { return getToken(sintactico.OPM, 0); }
		public TerminalNode OPD() { return getToken(sintactico.OPD, 0); }
		public OpermultiplContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opermultipl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterOpermultipl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitOpermultipl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitOpermultipl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpermultiplContext opermultipl() throws RecognitionException {
		OpermultiplContext _localctx = new OpermultiplContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_opermultipl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			_la = _input.LA(1);
			if ( !(_la==OPM || _la==OPD) ) {
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
	public static class OperlogicosContext extends ParserRuleContext {
		public TerminalNode OPAND() { return getToken(sintactico.OPAND, 0); }
		public TerminalNode OPOR() { return getToken(sintactico.OPOR, 0); }
		public TerminalNode OPEXC() { return getToken(sintactico.OPEXC, 0); }
		public TerminalNode OPNEG() { return getToken(sintactico.OPNEG, 0); }
		public OperlogicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operlogicos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterOperlogicos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitOperlogicos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitOperlogicos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperlogicosContext operlogicos() throws RecognitionException {
		OperlogicosContext _localctx = new OperlogicosContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_operlogicos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0) ) {
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
	public static class OpercomparacContext extends ParserRuleContext {
		public TerminalNode OPMAYOR() { return getToken(sintactico.OPMAYOR, 0); }
		public TerminalNode OPMENOR() { return getToken(sintactico.OPMENOR, 0); }
		public TerminalNode OPMAYIG() { return getToken(sintactico.OPMAYIG, 0); }
		public TerminalNode OPIGUAL() { return getToken(sintactico.OPIGUAL, 0); }
		public TerminalNode OPMENIG() { return getToken(sintactico.OPMENIG, 0); }
		public TerminalNode OPDIST() { return getToken(sintactico.OPDIST, 0); }
		public OpercomparacContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opercomparac; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterOpercomparac(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitOpercomparac(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitOpercomparac(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpercomparacContext opercomparac() throws RecognitionException {
		OpercomparacContext _localctx = new OpercomparacContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_opercomparac);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4227858432L) != 0) ) {
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
	public static class RestoContext extends ParserRuleContext {
		public TerminalNode OPRESTO() { return getToken(sintactico.OPRESTO, 0); }
		public RestoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterResto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitResto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitResto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestoContext resto() throws RecognitionException {
		RestoContext _localctx = new RestoContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_resto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			match(OPRESTO);
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
	public static class ModuloContext extends ParserRuleContext {
		public TerminalNode OPMOD() { return getToken(sintactico.OPMOD, 0); }
		public ModuloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modulo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitModulo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuloContext modulo() throws RecognitionException {
		ModuloContext _localctx = new ModuloContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_modulo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(OPMOD);
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
	public static class ElevadoContext extends ParserRuleContext {
		public TerminalNode OPE() { return getToken(sintactico.OPE, 0); }
		public ElevadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elevado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterElevado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitElevado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitElevado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElevadoContext elevado() throws RecognitionException {
		ElevadoContext _localctx = new ElevadoContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_elevado);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			match(OPE);
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
	public static class FinlineaContext extends ParserRuleContext {
		public TerminalNode FINLINEA() { return getToken(sintactico.FINLINEA, 0); }
		public FinlineaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finlinea; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).enterFinlinea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sintacticoListener ) ((sintacticoListener)listener).exitFinlinea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sintacticoVisitor ) return ((sintacticoVisitor<? extends T>)visitor).visitFinlinea(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinlineaContext finlinea() throws RecognitionException {
		FinlineaContext _localctx = new FinlineaContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_finlinea);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			match(FINLINEA);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 4:
			return parametroReturn_sempred((ParametroReturnContext)_localctx, predIndex);
		case 8:
			return parametroAsignacion_sempred((ParametroAsignacionContext)_localctx, predIndex);
		case 19:
			return parametroPrint_sempred((ParametroPrintContext)_localctx, predIndex);
		case 25:
			return parametroCondicion_sempred((ParametroCondicionContext)_localctx, predIndex);
		case 30:
			return polinomioEvaluar_sempred((PolinomioEvaluarContext)_localctx, predIndex);
		case 31:
			return parametroPolinomio_sempred((ParametroPolinomioContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean parametroReturn_sempred(ParametroReturnContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean parametroAsignacion_sempred(ParametroAsignacionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		case 12:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean parametroPrint_sempred(ParametroPrintContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 10);
		case 14:
			return precpred(_ctx, 9);
		case 15:
			return precpred(_ctx, 8);
		case 16:
			return precpred(_ctx, 7);
		case 17:
			return precpred(_ctx, 6);
		case 18:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean parametroCondicion_sempred(ParametroCondicionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 6);
		case 20:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean polinomioEvaluar_sempred(PolinomioEvaluarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 7);
		case 22:
			return precpred(_ctx, 6);
		case 23:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean parametroPolinomio_sempred(ParametroPolinomioContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0242\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000\u0004\u0000X\b\u0000"+
		"\u000b\u0000\f\u0000Y\u0001\u0000\u0004\u0000]\b\u0000\u000b\u0000\f\u0000"+
		"^\u0001\u0000\u0001\u0000\u0003\u0000c\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0004\u0001g\b\u0001\u000b\u0001\f\u0001h\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002}\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u008e\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u009a\b\u0002\n\u0002\f\u0002"+
		"\u009d\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a2\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a6\b\u0003\u0003\u0003\u00a8"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00b2\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00c0"+
		"\b\u0004\n\u0004\f\u0004\u00c3\t\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00ca\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00d7\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u00dc\b\b"+
		"\u0001\b\u0003\b\u00df\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00e6\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u00f8\b\b\n\b\f\b\u00fb\t\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u0103\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u0108\b\n\u0001"+
		"\n\u0003\n\u010b\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0111\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u0119\b\f\n\f\f\f\u011c\t\f\u0001\r\u0001\r\u0001\r"+
		"\u0005\r\u0121\b\r\n\r\f\r\u0124\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0139\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0141\b\u000e\u0001\u000f\u0001\u000f\u0005\u000f\u0145\b"+
		"\u000f\n\u000f\f\u000f\u0148\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u014f\b\u0010\n\u0010\f\u0010\u0152"+
		"\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u0159\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0168\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u016d\b\u0013\u0001\u0013\u0003\u0013\u0170"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0178\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u0189\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005"+
		"\u0013\u0195\b\u0013\n\u0013\f\u0013\u0198\t\u0013\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u019c\b\u0014\n\u0014\f\u0014\u019f\t\u0014\u0001\u0014\u0003"+
		"\u0014\u01a2\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01b8\b\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u01c2\b\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005"+
		"\u0019\u01cc\b\u0019\n\u0019\f\u0019\u01cf\t\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u01d9\b\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u01dd\b"+
		"\u001b\n\u001b\f\u001b\u01e0\t\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u01fd\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u020b\b\u001e\n\u001e\f\u001e\u020e"+
		"\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0218\b\u001f\n\u001f\f\u001f"+
		"\u021b\t\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0222\b \u0001"+
		"!\u0001!\u0003!\u0226\b!\u0001!\u0001!\u0003!\u022a\b!\u0001!\u0001!\u0003"+
		"!\u022e\b!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0000\u0007\u0004\b\u0010&2<>+\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"T\u0000\u0005\u0001\u0000!\"\u0001\u0000\u000f\u0010\u0001\u0000\u0011"+
		"\u0012\u0001\u0000\u0016\u0019\u0001\u0000\u001a\u001f\u0294\u0000b\u0001"+
		"\u0000\u0000\u0000\u0002f\u0001\u0000\u0000\u0000\u0004|\u0001\u0000\u0000"+
		"\u0000\u0006\u009e\u0001\u0000\u0000\u0000\b\u00b1\u0001\u0000\u0000\u0000"+
		"\n\u00c4\u0001\u0000\u0000\u0000\f\u00c6\u0001\u0000\u0000\u0000\u000e"+
		"\u00cb\u0001\u0000\u0000\u0000\u0010\u00e5\u0001\u0000\u0000\u0000\u0012"+
		"\u00fc\u0001\u0000\u0000\u0000\u0014\u010a\u0001\u0000\u0000\u0000\u0016"+
		"\u010c\u0001\u0000\u0000\u0000\u0018\u0115\u0001\u0000\u0000\u0000\u001a"+
		"\u011d\u0001\u0000\u0000\u0000\u001c\u0140\u0001\u0000\u0000\u0000\u001e"+
		"\u0142\u0001\u0000\u0000\u0000 \u014c\u0001\u0000\u0000\u0000\"\u0155"+
		"\u0001\u0000\u0000\u0000$\u015c\u0001\u0000\u0000\u0000&\u0177\u0001\u0000"+
		"\u0000\u0000(\u0199\u0001\u0000\u0000\u0000*\u01a3\u0001\u0000\u0000\u0000"+
		",\u01a7\u0001\u0000\u0000\u0000.\u01aa\u0001\u0000\u0000\u00000\u01ad"+
		"\u0001\u0000\u0000\u00002\u01c1\u0001\u0000\u0000\u00004\u01d0\u0001\u0000"+
		"\u0000\u00006\u01d4\u0001\u0000\u0000\u00008\u01e5\u0001\u0000\u0000\u0000"+
		":\u01f0\u0001\u0000\u0000\u0000<\u01fc\u0001\u0000\u0000\u0000>\u020f"+
		"\u0001\u0000\u0000\u0000@\u0221\u0001\u0000\u0000\u0000B\u0225\u0001\u0000"+
		"\u0000\u0000D\u022f\u0001\u0000\u0000\u0000F\u0231\u0001\u0000\u0000\u0000"+
		"H\u0233\u0001\u0000\u0000\u0000J\u0235\u0001\u0000\u0000\u0000L\u0237"+
		"\u0001\u0000\u0000\u0000N\u0239\u0001\u0000\u0000\u0000P\u023b\u0001\u0000"+
		"\u0000\u0000R\u023d\u0001\u0000\u0000\u0000T\u023f\u0001\u0000\u0000\u0000"+
		"VX\u0003\u0016\u000b\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Zc\u0001\u0000"+
		"\u0000\u0000[]\u0003\u0002\u0001\u0000\\[\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0005\u0000\u0000\u0001ac\u0001\u0000\u0000"+
		"\u0000bW\u0001\u0000\u0000\u0000b\\\u0001\u0000\u0000\u0000c\u0001\u0001"+
		"\u0000\u0000\u0000dg\u0003\f\u0006\u0000eg\u0003\u0004\u0002\u0000fd\u0001"+
		"\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000jk\u0003T*\u0000k\u0003\u0001\u0000\u0000\u0000lm\u0006\u0002\uffff"+
		"\uffff\u0000m}\u0003\"\u0011\u0000n}\u0003\u0014\n\u0000o}\u0003$\u0012"+
		"\u0000p}\u0003D\"\u0000q}\u0003(\u0014\u0000r}\u00034\u001a\u0000s}\u0003"+
		"6\u001b\u0000t}\u00038\u001c\u0000u}\u0003\u000e\u0007\u0000v}\u0003:"+
		"\u001d\u0000w}\u0003\u0006\u0003\u0000x}\u0005&\u0000\u0000y}\u0005\'"+
		"\u0000\u0000z}\u0005+\u0000\u0000{}\u0005(\u0000\u0000|l\u0001\u0000\u0000"+
		"\u0000|n\u0001\u0000\u0000\u0000|o\u0001\u0000\u0000\u0000|p\u0001\u0000"+
		"\u0000\u0000|q\u0001\u0000\u0000\u0000|r\u0001\u0000\u0000\u0000|s\u0001"+
		"\u0000\u0000\u0000|t\u0001\u0000\u0000\u0000|u\u0001\u0000\u0000\u0000"+
		"|v\u0001\u0000\u0000\u0000|w\u0001\u0000\u0000\u0000|x\u0001\u0000\u0000"+
		"\u0000|y\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|{\u0001\u0000"+
		"\u0000\u0000}\u009b\u0001\u0000\u0000\u0000~\u007f\n\u000b\u0000\u0000"+
		"\u007f\u0080\u0003R)\u0000\u0080\u0081\u0003\u0004\u0002\f\u0081\u009a"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\n\n\u0000\u0000\u0083\u0084\u0003"+
		"H$\u0000\u0084\u0085\u0003\u0004\u0002\u000b\u0085\u009a\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\n\t\u0000\u0000\u0087\u0088\u0003F#\u0000\u0088\u0089"+
		"\u0003\u0004\u0002\n\u0089\u009a\u0001\u0000\u0000\u0000\u008a\u008d\n"+
		"\b\u0000\u0000\u008b\u008e\u0003N\'\u0000\u008c\u008e\u0003P(\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0003\u0004\u0002\t\u0090\u009a"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\n\u0007\u0000\u0000\u0092\u0093\u0003"+
		"L&\u0000\u0093\u0094\u0003\u0004\u0002\b\u0094\u009a\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\n\u0006\u0000\u0000\u0096\u0097\u0003J%\u0000\u0097"+
		"\u0098\u0003\u0004\u0002\u0007\u0098\u009a\u0001\u0000\u0000\u0000\u0099"+
		"~\u0001\u0000\u0000\u0000\u0099\u0082\u0001\u0000\u0000\u0000\u0099\u0086"+
		"\u0001\u0000\u0000\u0000\u0099\u008a\u0001\u0000\u0000\u0000\u0099\u0091"+
		"\u0001\u0000\u0000\u0000\u0099\u0095\u0001\u0000\u0000\u0000\u009a\u009d"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u0005\u0001\u0000\u0000\u0000\u009d\u009b"+
		"\u0001\u0000\u0000\u0000\u009e\u00a7\u0005\b\u0000\u0000\u009f\u00a1\u0005"+
		"\u000b\u0000\u0000\u00a0\u00a2\u0003\b\u0004\u0000\u00a1\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a8\u0005\f\u0000\u0000\u00a4\u00a6\u0003\b\u0004"+
		"\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u009f\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u0007\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0006\u0004\uffff\uffff\u0000\u00aa\u00b2\u0003D\""+
		"\u0000\u00ab\u00b2\u0003:\u001d\u0000\u00ac\u00b2\u0005&\u0000\u0000\u00ad"+
		"\u00b2\u0005\'\u0000\u0000\u00ae\u00b2\u0005+\u0000\u0000\u00af\u00b2"+
		"\u0005(\u0000\u0000\u00b0\u00b2\u0003\"\u0011\u0000\u00b1\u00a9\u0001"+
		"\u0000\u0000\u0000\u00b1\u00ab\u0001\u0000\u0000\u0000\u00b1\u00ac\u0001"+
		"\u0000\u0000\u0000\u00b1\u00ad\u0001\u0000\u0000\u0000\u00b1\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b2\u00c1\u0001\u0000\u0000\u0000\u00b3\u00b4\n\b"+
		"\u0000\u0000\u00b4\u00b5\u0003L&\u0000\u00b5\u00b6\u0003\b\u0004\t\u00b6"+
		"\u00c0\u0001\u0000\u0000\u0000\u00b7\u00b8\n\u0007\u0000\u0000\u00b8\u00b9"+
		"\u0003H$\u0000\u00b9\u00ba\u0003\b\u0004\b\u00ba\u00c0\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\n\u0006\u0000\u0000\u00bc\u00bd\u0003F#\u0000\u00bd"+
		"\u00be\u0003\b\u0004\u0007\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00b3"+
		"\u0001\u0000\u0000\u0000\u00bf\u00b7\u0001\u0000\u0000\u0000\u00bf\u00bb"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\t\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005"+
		" \u0000\u0000\u00c5\u000b\u0001\u0000\u0000\u0000\u00c6\u00c9\u0005\u0001"+
		"\u0000\u0000\u00c7\u00ca\u0003D\"\u0000\u00c8\u00ca\u0003\u000e\u0007"+
		"\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\r\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003D\"\u0000\u00cc"+
		"\u00cd\u0003\n\u0005\u0000\u00cd\u00ce\u0003\u0010\b\u0000\u00ce\u000f"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0006\b\uffff\uffff\u0000\u00d0\u00e6"+
		"\u0003D\"\u0000\u00d1\u00e6\u0003:\u001d\u0000\u00d2\u00d6\u0003\u0012"+
		"\t\u0000\u00d3\u00d7\u0005&\u0000\u0000\u00d4\u00d7\u0005\'\u0000\u0000"+
		"\u00d5\u00d7\u0003D\"\u0000\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7"+
		"\u00df\u0001\u0000\u0000\u0000\u00d8\u00dc\u0005&\u0000\u0000\u00d9\u00dc"+
		"\u0005\'\u0000\u0000\u00da\u00dc\u0003D\"\u0000\u00db\u00d8\u0001\u0000"+
		"\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00da\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00df\u0003\u0012"+
		"\t\u0000\u00de\u00d2\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000\u0000"+
		"\u0000\u00df\u00e6\u0001\u0000\u0000\u0000\u00e0\u00e6\u0005&\u0000\u0000"+
		"\u00e1\u00e6\u0005\'\u0000\u0000\u00e2\u00e6\u0005+\u0000\u0000\u00e3"+
		"\u00e6\u0005(\u0000\u0000\u00e4\u00e6\u0003\"\u0011\u0000\u00e5\u00cf"+
		"\u0001\u0000\u0000\u0000\u00e5\u00d1\u0001\u0000\u0000\u0000\u00e5\u00de"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e0\u0001\u0000\u0000\u0000\u00e5\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e6\u00f9"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\n\t\u0000\u0000\u00e8\u00e9\u0003"+
		"R)\u0000\u00e9\u00ea\u0003\u0010\b\n\u00ea\u00f8\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\n\b\u0000\u0000\u00ec\u00ed\u0003L&\u0000\u00ed\u00ee\u0003"+
		"\u0010\b\t\u00ee\u00f8\u0001\u0000\u0000\u0000\u00ef\u00f0\n\u0007\u0000"+
		"\u0000\u00f0\u00f1\u0003H$\u0000\u00f1\u00f2\u0003\u0010\b\b\u00f2\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\n\u0006\u0000\u0000\u00f4\u00f5\u0003"+
		"F#\u0000\u00f5\u00f6\u0003\u0010\b\u0007\u00f6\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f7\u00e7\u0001\u0000\u0000\u0000\u00f7\u00eb\u0001\u0000\u0000"+
		"\u0000\u00f7\u00ef\u0001\u0000\u0000\u0000\u00f7\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u0011\u0001\u0000\u0000"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd\u0007\u0000\u0000"+
		"\u0000\u00fd\u0013\u0001\u0000\u0000\u0000\u00fe\u0102\u0003\u0012\t\u0000"+
		"\u00ff\u0103\u0005&\u0000\u0000\u0100\u0103\u0005\'\u0000\u0000\u0101"+
		"\u0103\u0003D\"\u0000\u0102\u00ff\u0001\u0000\u0000\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103\u010b"+
		"\u0001\u0000\u0000\u0000\u0104\u0108\u0005&\u0000\u0000\u0105\u0108\u0005"+
		"\'\u0000\u0000\u0106\u0108\u0003D\"\u0000\u0107\u0104\u0001\u0000\u0000"+
		"\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0106\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010b\u0003\u0012\t\u0000"+
		"\u010a\u00fe\u0001\u0000\u0000\u0000\u010a\u0107\u0001\u0000\u0000\u0000"+
		"\u010b\u0015\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u0007\u0000\u0000"+
		"\u010d\u010e\u0003D\"\u0000\u010e\u0110\u0005\u000b\u0000\u0000\u010f"+
		"\u0111\u0003\u0018\f\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0110\u0111"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0005\f\u0000\u0000\u0113\u0114\u0003\u001e\u000f\u0000\u0114\u0017\u0001"+
		"\u0000\u0000\u0000\u0115\u011a\u0003D\"\u0000\u0116\u0117\u0005$\u0000"+
		"\u0000\u0117\u0119\u0003D\"\u0000\u0118\u0116\u0001\u0000\u0000\u0000"+
		"\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u0019\u0001\u0000\u0000\u0000"+
		"\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u0122\u0003\u001c\u000e\u0000"+
		"\u011e\u011f\u0005$\u0000\u0000\u011f\u0121\u0003\u001c\u000e\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122"+
		"\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123"+
		"\u001b\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125"+
		"\u0141\u0003\"\u0011\u0000\u0126\u0141\u0003\u0014\n\u0000\u0127\u0141"+
		"\u0003D\"\u0000\u0128\u0141\u0003:\u001d\u0000\u0129\u012a\u0003\u0004"+
		"\u0002\u0000\u012a\u012b\u0003R)\u0000\u012b\u012c\u0003\u0004\u0002\u0000"+
		"\u012c\u0141\u0001\u0000\u0000\u0000\u012d\u012e\u0003\u0004\u0002\u0000"+
		"\u012e\u012f\u0003F#\u0000\u012f\u0130\u0003\u0004\u0002\u0000\u0130\u0141"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0003\u0004\u0002\u0000\u0132\u0133"+
		"\u0003H$\u0000\u0133\u0134\u0003\u0004\u0002\u0000\u0134\u0141\u0001\u0000"+
		"\u0000\u0000\u0135\u0138\u0003\u0004\u0002\u0000\u0136\u0139\u0003N\'"+
		"\u0000\u0137\u0139\u0003P(\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138"+
		"\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0003\u0004\u0002\u0000\u013b\u0141\u0001\u0000\u0000\u0000\u013c"+
		"\u0141\u0005&\u0000\u0000\u013d\u0141\u0005\'\u0000\u0000\u013e\u0141"+
		"\u0005+\u0000\u0000\u013f\u0141\u0005(\u0000\u0000\u0140\u0125\u0001\u0000"+
		"\u0000\u0000\u0140\u0126\u0001\u0000\u0000\u0000\u0140\u0127\u0001\u0000"+
		"\u0000\u0000\u0140\u0128\u0001\u0000\u0000\u0000\u0140\u0129\u0001\u0000"+
		"\u0000\u0000\u0140\u012d\u0001\u0000\u0000\u0000\u0140\u0131\u0001\u0000"+
		"\u0000\u0000\u0140\u0135\u0001\u0000\u0000\u0000\u0140\u013c\u0001\u0000"+
		"\u0000\u0000\u0140\u013d\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000"+
		"\u0000\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0141\u001d\u0001\u0000"+
		"\u0000\u0000\u0142\u0146\u0005\r\u0000\u0000\u0143\u0145\u0003\u0002\u0001"+
		"\u0000\u0144\u0143\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000"+
		"\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000"+
		"\u0000\u0147\u0149\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u0005\u000e\u0000\u0000\u014a\u014b\u0003T*\u0000\u014b"+
		"\u001f\u0001\u0000\u0000\u0000\u014c\u0150\u0005\r\u0000\u0000\u014d\u014f"+
		"\u0003\u0002\u0001\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014f\u0152"+
		"\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0001\u0000\u0000\u0000\u0151\u0153\u0001\u0000\u0000\u0000\u0152\u0150"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0005\u000e\u0000\u0000\u0154!\u0001"+
		"\u0000\u0000\u0000\u0155\u0156\u0003D\"\u0000\u0156\u0158\u0005\u000b"+
		"\u0000\u0000\u0157\u0159\u0003\u001a\r\u0000\u0158\u0157\u0001\u0000\u0000"+
		"\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000"+
		"\u0000\u015a\u015b\u0005\f\u0000\u0000\u015b#\u0001\u0000\u0000\u0000"+
		"\u015c\u015d\u0005\n\u0000\u0000\u015d\u015e\u0005\u000b\u0000\u0000\u015e"+
		"\u015f\u0003&\u0013\u0000\u015f\u0160\u0005\f\u0000\u0000\u0160%\u0001"+
		"\u0000\u0000\u0000\u0161\u0162\u0006\u0013\uffff\uffff\u0000\u0162\u0178"+
		"\u0003\"\u0011\u0000\u0163\u0167\u0003\u0012\t\u0000\u0164\u0168\u0005"+
		"&\u0000\u0000\u0165\u0168\u0005\'\u0000\u0000\u0166\u0168\u0003D\"\u0000"+
		"\u0167\u0164\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000"+
		"\u0167\u0166\u0001\u0000\u0000\u0000\u0168\u0170\u0001\u0000\u0000\u0000"+
		"\u0169\u016d\u0005&\u0000\u0000\u016a\u016d\u0005\'\u0000\u0000\u016b"+
		"\u016d\u0003D\"\u0000\u016c\u0169\u0001\u0000\u0000\u0000\u016c\u016a"+
		"\u0001\u0000\u0000\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016d\u016e"+
		"\u0001\u0000\u0000\u0000\u016e\u0170\u0003\u0012\t\u0000\u016f\u0163\u0001"+
		"\u0000\u0000\u0000\u016f\u016c\u0001\u0000\u0000\u0000\u0170\u0178\u0001"+
		"\u0000\u0000\u0000\u0171\u0178\u0003D\"\u0000\u0172\u0178\u0003:\u001d"+
		"\u0000\u0173\u0178\u0005&\u0000\u0000\u0174\u0178\u0005\'\u0000\u0000"+
		"\u0175\u0178\u0005+\u0000\u0000\u0176\u0178\u0005(\u0000\u0000\u0177\u0161"+
		"\u0001\u0000\u0000\u0000\u0177\u016f\u0001\u0000\u0000\u0000\u0177\u0171"+
		"\u0001\u0000\u0000\u0000\u0177\u0172\u0001\u0000\u0000\u0000\u0177\u0173"+
		"\u0001\u0000\u0000\u0000\u0177\u0174\u0001\u0000\u0000\u0000\u0177\u0175"+
		"\u0001\u0000\u0000\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178\u0196"+
		"\u0001\u0000\u0000\u0000\u0179\u017a\n\n\u0000\u0000\u017a\u017b\u0003"+
		"H$\u0000\u017b\u017c\u0003&\u0013\u000b\u017c\u0195\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\n\t\u0000\u0000\u017e\u017f\u0003F#\u0000\u017f\u0180"+
		"\u0003&\u0013\n\u0180\u0195\u0001\u0000\u0000\u0000\u0181\u0182\n\b\u0000"+
		"\u0000\u0182\u0183\u0003R)\u0000\u0183\u0184\u0003&\u0013\t\u0184\u0195"+
		"\u0001\u0000\u0000\u0000\u0185\u0188\n\u0007\u0000\u0000\u0186\u0189\u0003"+
		"N\'\u0000\u0187\u0189\u0003P(\u0000\u0188\u0186\u0001\u0000\u0000\u0000"+
		"\u0188\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000"+
		"\u018a\u018b\u0003&\u0013\b\u018b\u0195\u0001\u0000\u0000\u0000\u018c"+
		"\u018d\n\u0006\u0000\u0000\u018d\u018e\u0003L&\u0000\u018e\u018f\u0003"+
		"&\u0013\u0007\u018f\u0195\u0001\u0000\u0000\u0000\u0190\u0191\n\u0005"+
		"\u0000\u0000\u0191\u0192\u0003J%\u0000\u0192\u0193\u0003&\u0013\u0006"+
		"\u0193\u0195\u0001\u0000\u0000\u0000\u0194\u0179\u0001\u0000\u0000\u0000"+
		"\u0194\u017d\u0001\u0000\u0000\u0000\u0194\u0181\u0001\u0000\u0000\u0000"+
		"\u0194\u0185\u0001\u0000\u0000\u0000\u0194\u018c\u0001\u0000\u0000\u0000"+
		"\u0194\u0190\u0001\u0000\u0000\u0000\u0195\u0198\u0001\u0000\u0000\u0000"+
		"\u0196\u0194\u0001\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000\u0000"+
		"\u0197\'\u0001\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0199"+
		"\u019d\u0003*\u0015\u0000\u019a\u019c\u0003,\u0016\u0000\u019b\u019a\u0001"+
		"\u0000\u0000\u0000\u019c\u019f\u0001\u0000\u0000\u0000\u019d\u019b\u0001"+
		"\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u01a1\u0001"+
		"\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01a2\u0003"+
		".\u0017\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a2)\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005\u0002\u0000"+
		"\u0000\u01a4\u01a5\u00030\u0018\u0000\u01a5\u01a6\u0003 \u0010\u0000\u01a6"+
		"+\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005\u0003\u0000\u0000\u01a8\u01a9"+
		"\u0003*\u0015\u0000\u01a9-\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005\u0003"+
		"\u0000\u0000\u01ab\u01ac\u0003 \u0010\u0000\u01ac/\u0001\u0000\u0000\u0000"+
		"\u01ad\u01ae\u0005\u000b\u0000\u0000\u01ae\u01af\u00032\u0019\u0000\u01af"+
		"\u01b0\u0005\f\u0000\u0000\u01b01\u0001\u0000\u0000\u0000\u01b1\u01b2"+
		"\u0006\u0019\uffff\uffff\u0000\u01b2\u01c2\u0003\"\u0011\u0000\u01b3\u01c2"+
		"\u0003\u0014\n\u0000\u01b4\u01c2\u0003D\"\u0000\u01b5\u01c2\u0003:\u001d"+
		"\u0000\u01b6\u01b8\u0005\u0019\u0000\u0000\u01b7\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000"+
		"\u0000\u01b9\u01ba\u0005\u000b\u0000\u0000\u01ba\u01bb\u00032\u0019\u0000"+
		"\u01bb\u01bc\u0005\f\u0000\u0000\u01bc\u01c2\u0001\u0000\u0000\u0000\u01bd"+
		"\u01c2\u0005&\u0000\u0000\u01be\u01c2\u0005\'\u0000\u0000\u01bf\u01c2"+
		"\u0005+\u0000\u0000\u01c0\u01c2\u0005(\u0000\u0000\u01c1\u01b1\u0001\u0000"+
		"\u0000\u0000\u01c1\u01b3\u0001\u0000\u0000\u0000\u01c1\u01b4\u0001\u0000"+
		"\u0000\u0000\u01c1\u01b5\u0001\u0000\u0000\u0000\u01c1\u01b7\u0001\u0000"+
		"\u0000\u0000\u01c1\u01bd\u0001\u0000\u0000\u0000\u01c1\u01be\u0001\u0000"+
		"\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c2\u01cd\u0001\u0000\u0000\u0000\u01c3\u01c4\n\u0006\u0000"+
		"\u0000\u01c4\u01c5\u0003L&\u0000\u01c5\u01c6\u00032\u0019\u0007\u01c6"+
		"\u01cc\u0001\u0000\u0000\u0000\u01c7\u01c8\n\u0005\u0000\u0000\u01c8\u01c9"+
		"\u0003J%\u0000\u01c9\u01ca\u00032\u0019\u0006\u01ca\u01cc\u0001\u0000"+
		"\u0000\u0000\u01cb\u01c3\u0001\u0000\u0000\u0000\u01cb\u01c7\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000"+
		"\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce3\u0001\u0000\u0000"+
		"\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d1\u0005\u0004\u0000"+
		"\u0000\u01d1\u01d2\u00030\u0018\u0000\u01d2\u01d3\u0003 \u0010\u0000\u01d3"+
		"5\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005\u0005\u0000\u0000\u01d5\u01de"+
		"\u0005\r\u0000\u0000\u01d6\u01d9\u0003\u0004\u0002\u0000\u01d7\u01d9\u0003"+
		"\f\u0006\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d8\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01db\u0003T*\u0000"+
		"\u01db\u01dd\u0001\u0000\u0000\u0000\u01dc\u01d8\u0001\u0000\u0000\u0000"+
		"\u01dd\u01e0\u0001\u0000\u0000\u0000\u01de\u01dc\u0001\u0000\u0000\u0000"+
		"\u01de\u01df\u0001\u0000\u0000\u0000\u01df\u01e1\u0001\u0000\u0000\u0000"+
		"\u01e0\u01de\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005\u000e\u0000\u0000"+
		"\u01e2\u01e3\u0005\u0004\u0000\u0000\u01e3\u01e4\u00030\u0018\u0000\u01e4"+
		"7\u0001\u0000\u0000\u0000\u01e5\u01e6\u0005\u0006\u0000\u0000\u01e6\u01e7"+
		"\u0005\u000b\u0000\u0000\u01e7\u01e8\u0003D\"\u0000\u01e8\u01e9\u0003"+
		"T*\u0000\u01e9\u01ea\u00030\u0018\u0000\u01ea\u01eb\u0003T*\u0000\u01eb"+
		"\u01ec\u0003D\"\u0000\u01ec\u01ed\u0003\u0012\t\u0000\u01ed\u01ee\u0005"+
		"\f\u0000\u0000\u01ee\u01ef\u0003 \u0010\u0000\u01ef9\u0001\u0000\u0000"+
		"\u0000\u01f0\u01f1\u0005\t\u0000\u0000\u01f1\u01f2\u0005\u000b\u0000\u0000"+
		"\u01f2\u01f3\u0003<\u001e\u0000\u01f3\u01f4\u0005$\u0000\u0000\u01f4\u01f5"+
		"\u0003>\u001f\u0000\u01f5\u01f6\u0005\f\u0000\u0000\u01f6;\u0001\u0000"+
		"\u0000\u0000\u01f7\u01f8\u0006\u001e\uffff\uffff\u0000\u01f8\u01fd\u0005"+
		"+\u0000\u0000\u01f9\u01fd\u0005)\u0000\u0000\u01fa\u01fd\u0005&\u0000"+
		"\u0000\u01fb\u01fd\u0005\'\u0000\u0000\u01fc\u01f7\u0001\u0000\u0000\u0000"+
		"\u01fc\u01f9\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000"+
		"\u01fc\u01fb\u0001\u0000\u0000\u0000\u01fd\u020c\u0001\u0000\u0000\u0000"+
		"\u01fe\u01ff\n\u0007\u0000\u0000\u01ff\u0200\u0003H$\u0000\u0200\u0201"+
		"\u0003<\u001e\b\u0201\u020b\u0001\u0000\u0000\u0000\u0202\u0203\n\u0006"+
		"\u0000\u0000\u0203\u0204\u0003F#\u0000\u0204\u0205\u0003<\u001e\u0007"+
		"\u0205\u020b\u0001\u0000\u0000\u0000\u0206\u0207\n\u0005\u0000\u0000\u0207"+
		"\u0208\u0003R)\u0000\u0208\u0209\u0003<\u001e\u0006\u0209\u020b\u0001"+
		"\u0000\u0000\u0000\u020a\u01fe\u0001\u0000\u0000\u0000\u020a\u0202\u0001"+
		"\u0000\u0000\u0000\u020a\u0206\u0001\u0000\u0000\u0000\u020b\u020e\u0001"+
		"\u0000\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c\u020d\u0001"+
		"\u0000\u0000\u0000\u020d=\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000"+
		"\u0000\u0000\u020f\u0210\u0006\u001f\uffff\uffff\u0000\u0210\u0211\u0003"+
		"@ \u0000\u0211\u0212\u0005$\u0000\u0000\u0212\u0213\u0003@ \u0000\u0213"+
		"\u0219\u0001\u0000\u0000\u0000\u0214\u0215\n\u0001\u0000\u0000\u0215\u0216"+
		"\u0005$\u0000\u0000\u0216\u0218\u0003>\u001f\u0002\u0217\u0214\u0001\u0000"+
		"\u0000\u0000\u0218\u021b\u0001\u0000\u0000\u0000\u0219\u0217\u0001\u0000"+
		"\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000\u021a?\u0001\u0000\u0000"+
		"\u0000\u021b\u0219\u0001\u0000\u0000\u0000\u021c\u0222\u0005+\u0000\u0000"+
		"\u021d\u0222\u0003D\"\u0000\u021e\u0222\u0005&\u0000\u0000\u021f\u0222"+
		"\u0005\'\u0000\u0000\u0220\u0222\u0001\u0000\u0000\u0000\u0221\u021c\u0001"+
		"\u0000\u0000\u0000\u0221\u021d\u0001\u0000\u0000\u0000\u0221\u021e\u0001"+
		"\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0221\u0220\u0001"+
		"\u0000\u0000\u0000\u0222A\u0001\u0000\u0000\u0000\u0223\u0226\u0005+\u0000"+
		"\u0000\u0224\u0226\u0003D\"\u0000\u0225\u0223\u0001\u0000\u0000\u0000"+
		"\u0225\u0224\u0001\u0000\u0000\u0000\u0226\u0229\u0001\u0000\u0000\u0000"+
		"\u0227\u022a\u0003F#\u0000\u0228\u022a\u0003H$\u0000\u0229\u0227\u0001"+
		"\u0000\u0000\u0000\u0229\u0228\u0001\u0000\u0000\u0000\u022a\u022d\u0001"+
		"\u0000\u0000\u0000\u022b\u022e\u0005+\u0000\u0000\u022c\u022e\u0003D\""+
		"\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022d\u022c\u0001\u0000\u0000"+
		"\u0000\u022eC\u0001\u0000\u0000\u0000\u022f\u0230\u0005)\u0000\u0000\u0230"+
		"E\u0001\u0000\u0000\u0000\u0231\u0232\u0007\u0001\u0000\u0000\u0232G\u0001"+
		"\u0000\u0000\u0000\u0233\u0234\u0007\u0002\u0000\u0000\u0234I\u0001\u0000"+
		"\u0000\u0000\u0235\u0236\u0007\u0003\u0000\u0000\u0236K\u0001\u0000\u0000"+
		"\u0000\u0237\u0238\u0007\u0004\u0000\u0000\u0238M\u0001\u0000\u0000\u0000"+
		"\u0239\u023a\u0005\u0014\u0000\u0000\u023aO\u0001\u0000\u0000\u0000\u023b"+
		"\u023c\u0005\u0015\u0000\u0000\u023cQ\u0001\u0000\u0000\u0000\u023d\u023e"+
		"\u0005\u0013\u0000\u0000\u023eS\u0001\u0000\u0000\u0000\u023f\u0240\u0005"+
		"%\u0000\u0000\u0240U\u0001\u0000\u0000\u00008Y^bfh|\u008d\u0099\u009b"+
		"\u00a1\u00a5\u00a7\u00b1\u00bf\u00c1\u00c9\u00d6\u00db\u00de\u00e5\u00f7"+
		"\u00f9\u0102\u0107\u010a\u0110\u011a\u0122\u0138\u0140\u0146\u0150\u0158"+
		"\u0167\u016c\u016f\u0177\u0188\u0194\u0196\u019d\u01a1\u01b7\u01c1\u01cb"+
		"\u01cd\u01d8\u01de\u01fc\u020a\u020c\u0219\u0221\u0225\u0229\u022d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}