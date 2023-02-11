// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class lexico extends Lexer {
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
		VAR=41, MONOMIO=42, POLINOMIO=43, COMENTLINC=44, COMENTARIO=45, WS=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LET", "IF", "ELSE", "WHILE", "DO", "FOR", "FUNC", "RETURN", "VAL", "PRINT", 
			"PARIZ", "PARDE", "LLAVEI", "LLAVED", "OPR", "OPS", "OPM", "OPD", "OPE", 
			"OPRESTO", "OPMOD", "OPAND", "OPOR", "OPEXC", "OPNEG", "OPMAYOR", "OPMENOR", 
			"OPMAYIG", "OPMENIG", "OPIGUAL", "OPDIST", "IGUAL", "INCREMENTO", "DECREMENTO", 
			"PUNTO", "COMA", "FINLINEA", "ENTERO", "REAL", "NUM", "TEXTO", "VAR", 
			"MONOMIO", "POLINOMIO", "COMENTLINC", "COMENTARIO", "COM", "WS"
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
			"VAR", "MONOMIO", "POLINOMIO", "COMENTLINC", "COMENTARIO", "WS"
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


	public lexico(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lexico.g4"; }

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
		"\u0004\u0000.\u013b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\""+
		"\u0001#\u0001#\u0001$\u0001$\u0001%\u0004%\u00d6\b%\u000b%\f%\u00d7\u0001"+
		"&\u0001&\u0003&\u00dc\b&\u0001&\u0005&\u00df\b&\n&\f&\u00e2\t&\u0001&"+
		"\u0001&\u0004&\u00e6\b&\u000b&\f&\u00e7\u0001\'\u0001\'\u0001(\u0001("+
		"\u0005(\u00ee\b(\n(\f(\u00f1\t(\u0001(\u0001(\u0001)\u0001)\u0005)\u00f7"+
		"\b)\n)\f)\u00fa\t)\u0001*\u0001*\u0003*\u00fe\b*\u0001*\u0001*\u0001*"+
		"\u0003*\u0103\b*\u0003*\u0105\b*\u0001+\u0001+\u0001+\u0003+\u010a\b+"+
		"\u0001+\u0001+\u0001+\u0003+\u010f\b+\u0003+\u0111\b+\u0001+\u0005+\u0114"+
		"\b+\n+\f+\u0117\t+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0005"+
		",\u0120\b,\n,\f,\u0123\t,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0005"+
		"-\u012b\b-\n-\f-\u012e\t-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001"+
		".\u0001.\u0001/\u0001/\u0001/\u0001/\u0003\u00ef\u0121\u012c\u00000\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K"+
		"&M\'O\u0000Q(S)U*W+Y,[-]\u0000_.\u0001\u0000\u0004\u0001\u000009\u0001"+
		"\u0000az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0149\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000"+
		"\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C"+
		"\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000"+
		"\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000"+
		"\u0000M\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S"+
		"\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000"+
		"\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000"+
		"\u0000_\u0001\u0000\u0000\u0000\u0001a\u0001\u0000\u0000\u0000\u0003e"+
		"\u0001\u0000\u0000\u0000\u0005h\u0001\u0000\u0000\u0000\u0007m\u0001\u0000"+
		"\u0000\u0000\ts\u0001\u0000\u0000\u0000\u000bv\u0001\u0000\u0000\u0000"+
		"\rz\u0001\u0000\u0000\u0000\u000f\u0083\u0001\u0000\u0000\u0000\u0011"+
		"\u008a\u0001\u0000\u0000\u0000\u0013\u008e\u0001\u0000\u0000\u0000\u0015"+
		"\u0094\u0001\u0000\u0000\u0000\u0017\u0096\u0001\u0000\u0000\u0000\u0019"+
		"\u0098\u0001\u0000\u0000\u0000\u001b\u009a\u0001\u0000\u0000\u0000\u001d"+
		"\u009c\u0001\u0000\u0000\u0000\u001f\u009e\u0001\u0000\u0000\u0000!\u00a0"+
		"\u0001\u0000\u0000\u0000#\u00a2\u0001\u0000\u0000\u0000%\u00a4\u0001\u0000"+
		"\u0000\u0000\'\u00a6\u0001\u0000\u0000\u0000)\u00a8\u0001\u0000\u0000"+
		"\u0000+\u00ab\u0001\u0000\u0000\u0000-\u00ae\u0001\u0000\u0000\u0000/"+
		"\u00b1\u0001\u0000\u0000\u00001\u00b4\u0001\u0000\u0000\u00003\u00b6\u0001"+
		"\u0000\u0000\u00005\u00b8\u0001\u0000\u0000\u00007\u00ba\u0001\u0000\u0000"+
		"\u00009\u00bd\u0001\u0000\u0000\u0000;\u00c0\u0001\u0000\u0000\u0000="+
		"\u00c3\u0001\u0000\u0000\u0000?\u00c6\u0001\u0000\u0000\u0000A\u00c8\u0001"+
		"\u0000\u0000\u0000C\u00cb\u0001\u0000\u0000\u0000E\u00ce\u0001\u0000\u0000"+
		"\u0000G\u00d0\u0001\u0000\u0000\u0000I\u00d2\u0001\u0000\u0000\u0000K"+
		"\u00d5\u0001\u0000\u0000\u0000M\u00e0\u0001\u0000\u0000\u0000O\u00e9\u0001"+
		"\u0000\u0000\u0000Q\u00eb\u0001\u0000\u0000\u0000S\u00f4\u0001\u0000\u0000"+
		"\u0000U\u00fd\u0001\u0000\u0000\u0000W\u0106\u0001\u0000\u0000\u0000Y"+
		"\u011a\u0001\u0000\u0000\u0000[\u0128\u0001\u0000\u0000\u0000]\u0133\u0001"+
		"\u0000\u0000\u0000_\u0137\u0001\u0000\u0000\u0000ab\u0005l\u0000\u0000"+
		"bc\u0005e\u0000\u0000cd\u0005t\u0000\u0000d\u0002\u0001\u0000\u0000\u0000"+
		"ef\u0005i\u0000\u0000fg\u0005f\u0000\u0000g\u0004\u0001\u0000\u0000\u0000"+
		"hi\u0005e\u0000\u0000ij\u0005l\u0000\u0000jk\u0005s\u0000\u0000kl\u0005"+
		"e\u0000\u0000l\u0006\u0001\u0000\u0000\u0000mn\u0005w\u0000\u0000no\u0005"+
		"h\u0000\u0000op\u0005i\u0000\u0000pq\u0005l\u0000\u0000qr\u0005e\u0000"+
		"\u0000r\b\u0001\u0000\u0000\u0000st\u0005d\u0000\u0000tu\u0005o\u0000"+
		"\u0000u\n\u0001\u0000\u0000\u0000vw\u0005f\u0000\u0000wx\u0005o\u0000"+
		"\u0000xy\u0005r\u0000\u0000y\f\u0001\u0000\u0000\u0000z{\u0005f\u0000"+
		"\u0000{|\u0005u\u0000\u0000|}\u0005n\u0000\u0000}~\u0005c\u0000\u0000"+
		"~\u007f\u0005t\u0000\u0000\u007f\u0080\u0005i\u0000\u0000\u0080\u0081"+
		"\u0005o\u0000\u0000\u0081\u0082\u0005n\u0000\u0000\u0082\u000e\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005r\u0000\u0000\u0084\u0085\u0005e\u0000\u0000"+
		"\u0085\u0086\u0005t\u0000\u0000\u0086\u0087\u0005u\u0000\u0000\u0087\u0088"+
		"\u0005r\u0000\u0000\u0088\u0089\u0005n\u0000\u0000\u0089\u0010\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0005v\u0000\u0000\u008b\u008c\u0005a\u0000\u0000"+
		"\u008c\u008d\u0005l\u0000\u0000\u008d\u0012\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0005p\u0000\u0000\u008f\u0090\u0005r\u0000\u0000\u0090\u0091\u0005"+
		"i\u0000\u0000\u0091\u0092\u0005n\u0000\u0000\u0092\u0093\u0005t\u0000"+
		"\u0000\u0093\u0014\u0001\u0000\u0000\u0000\u0094\u0095\u0005(\u0000\u0000"+
		"\u0095\u0016\u0001\u0000\u0000\u0000\u0096\u0097\u0005)\u0000\u0000\u0097"+
		"\u0018\u0001\u0000\u0000\u0000\u0098\u0099\u0005{\u0000\u0000\u0099\u001a"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005}\u0000\u0000\u009b\u001c\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005-\u0000\u0000\u009d\u001e\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0005+\u0000\u0000\u009f \u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005*\u0000\u0000\u00a1\"\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0005/\u0000\u0000\u00a3$\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"^\u0000\u0000\u00a5&\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005%\u0000"+
		"\u0000\u00a7(\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005/\u0000\u0000\u00a9"+
		"\u00aa\u0005/\u0000\u0000\u00aa*\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"&\u0000\u0000\u00ac\u00ad\u0005&\u0000\u0000\u00ad,\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0005|\u0000\u0000\u00af\u00b0\u0005|\u0000\u0000\u00b0"+
		".\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005#\u0000\u0000\u00b2\u00b3\u0005"+
		"#\u0000\u0000\u00b30\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005!\u0000"+
		"\u0000\u00b52\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005>\u0000\u0000\u00b7"+
		"4\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005<\u0000\u0000\u00b96\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0005>\u0000\u0000\u00bb\u00bc\u0005=\u0000"+
		"\u0000\u00bc8\u0001\u0000\u0000\u0000\u00bd\u00be\u0005<\u0000\u0000\u00be"+
		"\u00bf\u0005=\u0000\u0000\u00bf:\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"=\u0000\u0000\u00c1\u00c2\u0005=\u0000\u0000\u00c2<\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0005!\u0000\u0000\u00c4\u00c5\u0005=\u0000\u0000\u00c5"+
		">\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005=\u0000\u0000\u00c7@\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0005+\u0000\u0000\u00c9\u00ca\u0005+\u0000"+
		"\u0000\u00caB\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005-\u0000\u0000\u00cc"+
		"\u00cd\u0005-\u0000\u0000\u00cdD\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005"+
		".\u0000\u0000\u00cfF\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005,\u0000"+
		"\u0000\u00d1H\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005;\u0000\u0000\u00d3"+
		"J\u0001\u0000\u0000\u0000\u00d4\u00d6\u0003O\'\u0000\u00d5\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8L\u0001\u0000"+
		"\u0000\u0000\u00d9\u00dc\u0003\u001f\u000f\u0000\u00da\u00dc\u0003\u001d"+
		"\u000e\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00da\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000"+
		"\u0000\u0000\u00dd\u00df\u0003O\'\u0000\u00de\u00db\u0001\u0000\u0000"+
		"\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e5\u0003E\"\u0000"+
		"\u00e4\u00e6\u0003O\'\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e8N\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0007\u0000\u0000\u0000\u00eaP\u0001\u0000\u0000\u0000\u00eb\u00ef\u0005"+
		"\"\u0000\u0000\u00ec\u00ee\t\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\"\u0000"+
		"\u0000\u00f3R\u0001\u0000\u0000\u0000\u00f4\u00f8\u0007\u0001\u0000\u0000"+
		"\u00f5\u00f7\u0007\u0002\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9T\u0001\u0000\u0000\u0000\u00fa"+
		"\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fe\u0003O\'\u0000\u00fc\u00fe"+
		"\u0003S)\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fe\u0104\u0001\u0000\u0000\u0000\u00ff\u0102\u0003%\u0012"+
		"\u0000\u0100\u0103\u0003O\'\u0000\u0101\u0103\u0003S)\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103\u0105"+
		"\u0001\u0000\u0000\u0000\u0104\u00ff\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0001\u0000\u0000\u0000\u0105V\u0001\u0000\u0000\u0000\u0106\u0109\u0005"+
		"\'\u0000\u0000\u0107\u010a\u0003\u001f\u000f\u0000\u0108\u010a\u0003\u001d"+
		"\u000e\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u0108\u0001\u0000"+
		"\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b\u0115\u0003U*\u0000\u010c\u010f\u0003\u001f\u000f\u0000"+
		"\u010d\u010f\u0003\u001d\u000e\u0000\u010e\u010c\u0001\u0000\u0000\u0000"+
		"\u010e\u010d\u0001\u0000\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000"+
		"\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000"+
		"\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0114\u0003U*\u0000\u0113\u0110"+
		"\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118"+
		"\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u0119"+
		"\u0005\'\u0000\u0000\u0119X\u0001\u0000\u0000\u0000\u011a\u011b\u0005"+
		"%\u0000\u0000\u011b\u011c\u0005%\u0000\u0000\u011c\u011d\u0005%\u0000"+
		"\u0000\u011d\u0121\u0001\u0000\u0000\u0000\u011e\u0120\t\u0000\u0000\u0000"+
		"\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000\u0000"+
		"\u0121\u0122\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000"+
		"\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0005\n\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0006,\u0000\u0000\u0127Z\u0001\u0000\u0000\u0000\u0128\u012c\u0003"+
		"].\u0000\u0129\u012b\t\u0000\u0000\u0000\u012a\u0129\u0001\u0000\u0000"+
		"\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000"+
		"\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012d\u012f\u0001\u0000\u0000"+
		"\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0130\u0003].\u0000\u0130"+
		"\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0006-\u0000\u0000\u0132\\"+
		"\u0001\u0000\u0000\u0000\u0133\u0134\u0005*\u0000\u0000\u0134\u0135\u0005"+
		"*\u0000\u0000\u0135\u0136\u0005*\u0000\u0000\u0136^\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0007\u0003\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\u0006/\u0000\u0000\u013a`\u0001\u0000\u0000\u0000\u0010"+
		"\u0000\u00d7\u00db\u00e0\u00e7\u00ef\u00f8\u00fd\u0102\u0104\u0109\u010e"+
		"\u0110\u0115\u0121\u012c\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}