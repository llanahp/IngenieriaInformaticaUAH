// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link sintactico}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface sintacticoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link sintactico#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(sintactico.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#linea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinea(sintactico.LineaContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(sintactico.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(sintactico.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametroReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametroReturn(sintactico.ParametroReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#igual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgual(sintactico.IgualContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(sintactico.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(sintactico.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametroAsignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametroAsignacion(sintactico.ParametroAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#incdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncdec(sintactico.IncdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#sim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSim(sintactico.SimContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#crearFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrearFuncion(sintactico.CrearFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametrosCrear}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametrosCrear(sintactico.ParametrosCrearContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(sintactico.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(sintactico.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#contenidoFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContenidoFunc(sintactico.ContenidoFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#contenidoBloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContenidoBloque(sintactico.ContenidoBloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#llamarFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamarFuncion(sintactico.LlamarFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(sintactico.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametroPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametroPrint(sintactico.ParametroPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(sintactico.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(sintactico.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#elif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif(sintactico.ElifContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(sintactico.ElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#condiciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondiciones(sintactico.CondicionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametroCondicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametroCondicion(sintactico.ParametroCondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(sintactico.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#doWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(sintactico.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(sintactico.ForContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(sintactico.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#polinomioEvaluar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolinomioEvaluar(sintactico.PolinomioEvaluarContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#parametroPolinomio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametroPolinomio(sintactico.ParametroPolinomioContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#operandoVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperandoVal(sintactico.OperandoValContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#operacionConPolinom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacionConPolinom(sintactico.OperacionConPolinomContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(sintactico.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#operadicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperadicion(sintactico.OperadicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#opermultipl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpermultipl(sintactico.OpermultiplContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#operlogicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperlogicos(sintactico.OperlogicosContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#opercomparac}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpercomparac(sintactico.OpercomparacContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#resto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResto(sintactico.RestoContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#modulo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(sintactico.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#elevado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElevado(sintactico.ElevadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link sintactico#finlinea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinlinea(sintactico.FinlineaContext ctx);
}