// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link sintactico}.
 */
public interface sintacticoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link sintactico#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(sintactico.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(sintactico.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#linea}.
	 * @param ctx the parse tree
	 */
	void enterLinea(sintactico.LineaContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#linea}.
	 * @param ctx the parse tree
	 */
	void exitLinea(sintactico.LineaContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(sintactico.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(sintactico.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(sintactico.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(sintactico.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametroReturn}.
	 * @param ctx the parse tree
	 */
	void enterParametroReturn(sintactico.ParametroReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametroReturn}.
	 * @param ctx the parse tree
	 */
	void exitParametroReturn(sintactico.ParametroReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#igual}.
	 * @param ctx the parse tree
	 */
	void enterIgual(sintactico.IgualContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#igual}.
	 * @param ctx the parse tree
	 */
	void exitIgual(sintactico.IgualContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(sintactico.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(sintactico.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(sintactico.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(sintactico.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametroAsignacion}.
	 * @param ctx the parse tree
	 */
	void enterParametroAsignacion(sintactico.ParametroAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametroAsignacion}.
	 * @param ctx the parse tree
	 */
	void exitParametroAsignacion(sintactico.ParametroAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#incdec}.
	 * @param ctx the parse tree
	 */
	void enterIncdec(sintactico.IncdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#incdec}.
	 * @param ctx the parse tree
	 */
	void exitIncdec(sintactico.IncdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#sim}.
	 * @param ctx the parse tree
	 */
	void enterSim(sintactico.SimContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#sim}.
	 * @param ctx the parse tree
	 */
	void exitSim(sintactico.SimContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#crearFuncion}.
	 * @param ctx the parse tree
	 */
	void enterCrearFuncion(sintactico.CrearFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#crearFuncion}.
	 * @param ctx the parse tree
	 */
	void exitCrearFuncion(sintactico.CrearFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametrosCrear}.
	 * @param ctx the parse tree
	 */
	void enterParametrosCrear(sintactico.ParametrosCrearContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametrosCrear}.
	 * @param ctx the parse tree
	 */
	void exitParametrosCrear(sintactico.ParametrosCrearContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(sintactico.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(sintactico.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(sintactico.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(sintactico.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#contenidoFunc}.
	 * @param ctx the parse tree
	 */
	void enterContenidoFunc(sintactico.ContenidoFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#contenidoFunc}.
	 * @param ctx the parse tree
	 */
	void exitContenidoFunc(sintactico.ContenidoFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#contenidoBloque}.
	 * @param ctx the parse tree
	 */
	void enterContenidoBloque(sintactico.ContenidoBloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#contenidoBloque}.
	 * @param ctx the parse tree
	 */
	void exitContenidoBloque(sintactico.ContenidoBloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#llamarFuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamarFuncion(sintactico.LlamarFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#llamarFuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamarFuncion(sintactico.LlamarFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(sintactico.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(sintactico.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametroPrint}.
	 * @param ctx the parse tree
	 */
	void enterParametroPrint(sintactico.ParametroPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametroPrint}.
	 * @param ctx the parse tree
	 */
	void exitParametroPrint(sintactico.ParametroPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(sintactico.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(sintactico.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(sintactico.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(sintactico.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#elif}.
	 * @param ctx the parse tree
	 */
	void enterElif(sintactico.ElifContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#elif}.
	 * @param ctx the parse tree
	 */
	void exitElif(sintactico.ElifContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(sintactico.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(sintactico.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#condiciones}.
	 * @param ctx the parse tree
	 */
	void enterCondiciones(sintactico.CondicionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#condiciones}.
	 * @param ctx the parse tree
	 */
	void exitCondiciones(sintactico.CondicionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametroCondicion}.
	 * @param ctx the parse tree
	 */
	void enterParametroCondicion(sintactico.ParametroCondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametroCondicion}.
	 * @param ctx the parse tree
	 */
	void exitParametroCondicion(sintactico.ParametroCondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(sintactico.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(sintactico.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#doWhile}.
	 * @param ctx the parse tree
	 */
	void enterDoWhile(sintactico.DoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#doWhile}.
	 * @param ctx the parse tree
	 */
	void exitDoWhile(sintactico.DoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(sintactico.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(sintactico.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(sintactico.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(sintactico.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#polinomioEvaluar}.
	 * @param ctx the parse tree
	 */
	void enterPolinomioEvaluar(sintactico.PolinomioEvaluarContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#polinomioEvaluar}.
	 * @param ctx the parse tree
	 */
	void exitPolinomioEvaluar(sintactico.PolinomioEvaluarContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#parametroPolinomio}.
	 * @param ctx the parse tree
	 */
	void enterParametroPolinomio(sintactico.ParametroPolinomioContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#parametroPolinomio}.
	 * @param ctx the parse tree
	 */
	void exitParametroPolinomio(sintactico.ParametroPolinomioContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#operandoVal}.
	 * @param ctx the parse tree
	 */
	void enterOperandoVal(sintactico.OperandoValContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#operandoVal}.
	 * @param ctx the parse tree
	 */
	void exitOperandoVal(sintactico.OperandoValContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#operacionConPolinom}.
	 * @param ctx the parse tree
	 */
	void enterOperacionConPolinom(sintactico.OperacionConPolinomContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#operacionConPolinom}.
	 * @param ctx the parse tree
	 */
	void exitOperacionConPolinom(sintactico.OperacionConPolinomContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(sintactico.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(sintactico.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#operadicion}.
	 * @param ctx the parse tree
	 */
	void enterOperadicion(sintactico.OperadicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#operadicion}.
	 * @param ctx the parse tree
	 */
	void exitOperadicion(sintactico.OperadicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#opermultipl}.
	 * @param ctx the parse tree
	 */
	void enterOpermultipl(sintactico.OpermultiplContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#opermultipl}.
	 * @param ctx the parse tree
	 */
	void exitOpermultipl(sintactico.OpermultiplContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#operlogicos}.
	 * @param ctx the parse tree
	 */
	void enterOperlogicos(sintactico.OperlogicosContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#operlogicos}.
	 * @param ctx the parse tree
	 */
	void exitOperlogicos(sintactico.OperlogicosContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#opercomparac}.
	 * @param ctx the parse tree
	 */
	void enterOpercomparac(sintactico.OpercomparacContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#opercomparac}.
	 * @param ctx the parse tree
	 */
	void exitOpercomparac(sintactico.OpercomparacContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#resto}.
	 * @param ctx the parse tree
	 */
	void enterResto(sintactico.RestoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#resto}.
	 * @param ctx the parse tree
	 */
	void exitResto(sintactico.RestoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#modulo}.
	 * @param ctx the parse tree
	 */
	void enterModulo(sintactico.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#modulo}.
	 * @param ctx the parse tree
	 */
	void exitModulo(sintactico.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#elevado}.
	 * @param ctx the parse tree
	 */
	void enterElevado(sintactico.ElevadoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#elevado}.
	 * @param ctx the parse tree
	 */
	void exitElevado(sintactico.ElevadoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sintactico#finlinea}.
	 * @param ctx the parse tree
	 */
	void enterFinlinea(sintactico.FinlineaContext ctx);
	/**
	 * Exit a parse tree produced by {@link sintactico#finlinea}.
	 * @param ctx the parse tree
	 */
	void exitFinlinea(sintactico.FinlineaContext ctx);
}