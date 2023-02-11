import org.antlr.v4.runtime.CharStreams;

import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase Listener
 */
public class Listener extends sintacticoBaseListener {
    //Tabla de Símbolos
    private TablaSimbolos tablaSimbolos;
    //Lista de variables
    private HashMap<String, Object> variables;
    //Condicional
    private boolean shouldEnterBlock;
    //Walker
    private Walker walker;
    private boolean pasoApaso;

    /**
     * Constructor de Listener
     *
     * @param tablaSimbolos TablaSimbolos
     * @param walker        Walker
     */
    public Listener(TablaSimbolos tablaSimbolos, Walker walker) {
        this.tablaSimbolos = tablaSimbolos;
        this.walker = walker;
        this.pasoApaso = false;
    }

    /**
     * Método para establecer si se ejecuta en modo paso a paso (debug)
     *
     * @param pasoApaso boolean true si se desea ejecutar en paso a paso y false en caso contrario
     */
    public void setPasoApaso(boolean pasoApaso) {
        this.pasoApaso = pasoApaso;
    }

    /**
     * Devuelve si la ejecucion debe ser paso a poso
     *
     * @return boolean true si se ejecuta en paso a paso y false en caso contrario
     */
    public boolean isPasoApaso() {
        return pasoApaso;
    }

    /**
     * Método enterPrograma
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterPrograma(sintactico.ProgramaContext ctx) {
    }

    /**
     * Método enterCrearFuncion (cuando se crea una funcion)
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterCrearFuncion(sintactico.CrearFuncionContext ctx) {
        String nombre = ctx.variable().VAR().getText();
        if (ctx.getChildCount() == 6) {
            int numParm = ctx.parametrosCrear().getChildCount();
            ArrayList<String> parametros = new ArrayList<>();
            for (int i = 0; i < numParm; i += 2) {
                String param = ctx.parametrosCrear().getChild(i).getText();
                parametros.add(param);
            }
            Funcion func = new Funcion(nombre, parametros);
            tablaSimbolos.addFuncion(nombre, func);
        } else {
            Funcion func = new Funcion(nombre);
            tablaSimbolos.addFuncion(nombre, func);
        }

    }

    /**
     * Método enterContenidoFunc
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterContenidoFunc(sintactico.ContenidoFuncContext ctx) {
        variables = new HashMap<String, Object>();
    }

    /**
     * Método getValorCondicion
     *
     * @param hijo ParseTree
     * @return Valor
     */
    public Valor getValorCondicion(ParseTree hijo) {
        String cadena_valor = hijo.getChild(0).getText();
        String nombre_tipo = getTipo(cadena_valor);
        if (nombre_tipo.equals("TEXTO")) {
            return (new Valor(cadena_valor.substring(1, cadena_valor.length() - 1)));
        } else if (nombre_tipo.equals("ENTERO")) {
            return (new Valor(Long.parseLong(cadena_valor)));
        } else if (nombre_tipo.equals("REAL")) {
            return (new Valor(Float.parseFloat(cadena_valor)));
        } else if (nombre_tipo.equals("POLINOMIO")) {
            return new Valor(new Polinomio(cadena_valor));
        } else if (nombre_tipo.equals("VAR")) {
            Ambito ambito = tablaSimbolos.getAmbito();
            Simbolo simbolo = ambito.getSimbolo(cadena_valor);
            if (simbolo == null) {
                System.out.println("La variable " + cadena_valor + " no está declarada");
                System.exit(1);
            }
            switch (simbolo.getTipoSimbolo()) {
                case INT:
                    return (new Valor(simbolo.getValorInteger()));
                case FLOAT:
                    return (new Valor(simbolo.getValorReal()));
                case TEXT:
                    return (new Valor(simbolo.getValorString()));
                case POLYNOMIAL:
                    return new Valor(new Polinomio(simbolo.getValorPolinomio()));
                default:
                    System.out.println("tipo de variable no esperado");
                    System.exit(1);
                    return null;
            }
        }
        if (nombre_tipo.equals("FUNCTION")) {
            //cuando haga llamadas
            cadena_valor = cadena_valor.substring(0, cadena_valor.indexOf('('));
            return tablaSimbolos.getParamFuncion(cadena_valor).getValorReturn();
        } else {
            System.out.println("tipo de variable no esperado");
            System.exit(1);
            return (null);
        }
    }

    /**
     * Método enterLlamarFuncion (cuando se llama una funcion)
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterLlamarFuncion(sintactico.LlamarFuncionContext ctx) {
        ArrayList<Valor> argumentos = null;
        String nombreFuncion = ctx.variable().getText();

        if (!tablaSimbolos.existeFuncion(nombreFuncion)) {
            System.out.println("Se ha intentado llamar a una funcion que no existe");
            System.exit(1);
        }
        //Comprobación de número de parámetros
        int numParams = this.tablaSimbolos.getParamFuncion(nombreFuncion).getParam().size();
        if (ctx.getChildCount() == 4) { //Con parametros de entrada
            argumentos = Print.getArgumentos(ctx.getChild(2), tablaSimbolos);
            if (argumentos.size() != numParams) {
                System.out.println("El número de parámetros en la invocación de " + nombreFuncion + " no es válido");
                System.exit(1);
            }
        }
        Walker walker = new Walker();
        Listener listener = new Listener(tablaSimbolos, walker);
        listener.setPasoApaso(this.pasoApaso);
        //Walker y ambitos
        ArrayList<String> nombreParams = this.tablaSimbolos.getParamFuncion(nombreFuncion).getParam();
        Ambito ambitoNuevo = new Ambito(Ambito.TipoAmbito.FUNCTION, nombreFuncion);
        if (argumentos != null) {
            for (int i = 0; i < argumentos.size(); i++) {
                Simbolo s = new Simbolo(nombreParams.get(i));
                switch (argumentos.get(i).getTipo()) {
                    case INT:
                        s.setValor(argumentos.get(i).getInt());
                        break;
                    case FLOAT:
                        s.setValor(argumentos.get(i).getFloat());
                        break;
                    case TEXT:
                        s.setValor(argumentos.get(i).getString());
                        break;
                    case POLYNOMIAL:
                        s.setValorPolinomio((argumentos.get(i).getValorPolinomio().getExpresion()));
                        break;

                }
                ambitoNuevo.addSimbolo(nombreParams.get(i), s);
            }
        }
        this.tablaSimbolos.addAmbito(ambitoNuevo);
        walker.walk(listener, this.tablaSimbolos.getFuncion(nombreFuncion));
        //No guardamos aquí el resultado de la funcion (en caso de que sea necesario) ya que es tarea de "enterReturn"

    }


    /**
     * Método getReturn
     *
     * @param hijo ParseTree
     * @return Valor de return
     */
    public Valor getReturn(ParseTree hijo) {
        int numHijos = hijo.getChildCount();
        if (hijo.getChildCount() == 1) {
            return (getValorCondicion(hijo));
        } else if (hijo.getChildCount() == 3) {
            Valor valorIzq = getReturn(hijo.getChild(0));
            Valor valorDer = getReturn(hijo.getChild(numHijos - 1));
            String operacion = hijo.getChild(numHijos - 2).getText();
            return (Print.operar(valorIzq, operacion, valorDer));
        } else {
            System.out.println("Numero de hijos en return no esperado");
            System.exit(1);
            return null;
        }
    }

    /**
     * Método enterReturn
     *
     * @param ctx sintactico.ReturnContext
     */
    @Override
    public void enterReturn(sintactico.ReturnContext ctx) {
        Valor valor = new Valor("");
        if (ctx.getChildCount() == 4) {//return (a);
            valor = getReturn(ctx.getChild(2));
        } else if (ctx.getChildCount() == 2) {//return a;
            valor = getReturn(ctx.getChild(1));
        }
        ParseTree root = ctx;
        ParseTree fun = null;
        while (root.getParent() != null) {
            fun = root;
            root = root.getParent();
        }
        if (fun != null && fun.getChild(0).getText().equals("function")) {
            String nombreFun = fun.getChild(1).getText();
            Funcion funcion = this.tablaSimbolos.getParamFuncion(nombreFun);
            funcion.setHaceReturn(true);
            funcion.setValorReturn(valor);
        } else {
            System.out.println("Return fuera de funcion");
            System.exit(1);
        }
    }

    /**
     * Método calcularParametroCondicion
     *
     * @param hijo ParseTree
     * @return Valor
     */
    private Valor calcularParametroCondicion(ParseTree hijo) {
        int tieneNegacion = 0;
        int numHijos = hijo.getChildCount();
        if (numHijos == 1) {
            return (getValorCondicion(hijo));
        } else {
            //Mirar si tiene negacion
            if (hijo.getChild(0).getText().equals("!"))
                tieneNegacion++;
            if (numHijos == 3 && tieneNegacion == 0) {
                if (hijo.getChild(0).getText().equals("(")) {
                    return (calcularParametroCondicion(hijo.getChild(1)));
                } else {
                    Valor valorIzq = calcularParametroCondicion(hijo.getChild(0));
                    Valor valorDer = calcularParametroCondicion(hijo.getChild(numHijos - 1));
                    String operacion = hijo.getChild(numHijos - 2).getText();
                    return (Print.operar(valorIzq, operacion, valorDer));
                }
            } else if (numHijos == 4 && tieneNegacion == 1) {
                Valor res = calcularParametroCondicion(hijo.getChild(numHijos - 2));
                if (res.getTipo() == Simbolo.TipoSimbolo.INT) {
                    res.setValorInteger((res.getInt() == 1 ? 0 : 1));
                }
                return (res);
            }
        }
        return (null);
    }

    /**
     * Método enterIf
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterIf(sintactico.IfContext ctx) {
        // Evalúa la condición del if o
        ParseTree hijo = ctx.getChild(1).getChild(1);
        // Evalúa la condición del ifres.getInt() == 1
        // 0 false - 1 true
        Valor res = calcularParametroCondicion(hijo);

        if (res.getInt() == 1) {
            shouldEnterBlock = true;
        } else {
            shouldEnterBlock = false;
        }
    }

    /**
     * Método enterElif
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterElif(sintactico.ElifContext ctx) {
        if (!shouldEnterBlock) {
            walker.setSigue(false);
        }
    }

    /**
     * Método enterWhile
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterWhile(sintactico.WhileContext ctx) {
        // Evalúa la condición del while o
        ParseTree hijo = ctx.getChild(1).getChild(1);
        // Evalúa la condición del Whileres.getInt() == 1
        // 0 false - 1 true
        Valor res = calcularParametroCondicion(hijo);

        if (res.getInt() == 1) {
            shouldEnterBlock = true;
            Walker bucle = new Walker();
            while (res.getInt() == 1) {
                for (int i = 0; i < ctx.getChildCount(); i++) {
                    bucle.walk(this, ctx.getChild(i));
                }
                res = calcularParametroCondicion(hijo);
            }
        } else {
            shouldEnterBlock = false;
        }
    }

    /**
     * Método enterFor
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterFor(sintactico.ForContext ctx) {
        // Evalúa la condición del for
        ParseTree hijo = ctx.getChild(4).getChild(1);
        // Evalúa la condición del Whileres.getInt() == 1
        // 0 false - 1 true
        Valor res = calcularParametroCondicion(hijo);
        String cadena_valor = ctx.getChild(7).getText();
        String nombre_tipo = getTipo(cadena_valor);

        if (res.getInt() == 1) {
            shouldEnterBlock = true;
            Walker bucle = new Walker();
            while (res.getInt() == 1) {
                if (nombre_tipo.equals("INCREMENTO")) {
                    Simbolo s = tablaSimbolos.getAmbito().getSimbolo(ctx.getChild(2).getText());
                    if (s != null) {
                        if (s.getTipoSimbolo() == Simbolo.TipoSimbolo.INT) {
                            s.setValor(s.getValorInteger() + 1);
                        } else {
                            System.out.println("Tipo de variable " + cadena_valor + " no válido");
                        }
                    } else {
                        System.out.println("Contenido de Simbolo vacio en " + cadena_valor);
                    }
                } else {
                    Simbolo s = tablaSimbolos.getAmbito().getSimbolo(ctx.getChild(2).getText());
                    if (s != null) {
                        if (s.getTipoSimbolo() == Simbolo.TipoSimbolo.INT) {
                            s.setValor(s.getValorInteger() - 1);
                        } else {
                            System.out.println("Tipo de variable " + cadena_valor + " no válido");
                        }
                    } else {
                        System.out.println("Contenido de Simbolo vacio en " + cadena_valor);
                    }
                }
                for (int i = 0; i < ctx.getChildCount(); i++) {
                    bucle.walk(this, ctx.getChild(i));
                }
                res = calcularParametroCondicion(hijo);
            }
        } else {
            shouldEnterBlock = false;
        }
    }


    /**
     * Método enterContenidoBloque
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterContenidoBloque(sintactico.ContenidoBloqueContext ctx) {
        // ShouldEnterBlock viene dado a true o false según el análisis de la condición
        if (!shouldEnterBlock) {
            walker.setSigue(false);
        }
        //El ámbito padre son las variables inicializadas que pueden ser utilizadas dentro del condicional
        Ambito padre = tablaSimbolos.getAmbito();
        Ambito ambito = new Ambito(Ambito.TipoAmbito.IF, padre, "");
        tablaSimbolos.addAmbito(ambito);
    }

    @Override
    public void exitContenidoBloque(sintactico.ContenidoBloqueContext ctx) {
        shouldEnterBlock = !shouldEnterBlock;
        tablaSimbolos.popAmbito();
    }


    /**
     * Método exitIf
     *
     * @param ctx the parse tree
     */
    @Override
    public void exitIf(sintactico.IfContext ctx) {
        shouldEnterBlock = !shouldEnterBlock;
    }

    @Override
    public void exitCondicional(sintactico.CondicionalContext ctx) {
        shouldEnterBlock = true;
    }

    /**
     * Método enterElse
     *
     * @param ctx the parse tree
     */
    @Override
    public void enterElse(sintactico.ElseContext ctx) {
        if (!shouldEnterBlock) {
            walker.setSigue(false);
        }
    }


    @Override
    public void enterDeclaracion(sintactico.DeclaracionContext ctx) {
        String nombre = ctx.getChild(1).getChild(0).getText();
        Simbolo simbolo = new Simbolo(nombre);
        tablaSimbolos.getAmbito().addSimbolo(nombre, simbolo);
    }

    @Override
    public void exitAsignacion(sintactico.AsignacionContext ctx) {
        String nombre = ctx.variable().getText();
        if (tablaSimbolos.getAmbito().existeSimbolo(nombre)) {
            String tipoVariable = null;
            Object valor = null;
            if (ctx.getChildCount() == 3) {
                ParseTree nodo = ctx.getChild(2); // ParametroAsignacion
                if (nodo.getChildCount() == 1 && nodo.getChild(0).getChildCount() > 1) {
                    if (!nodo.getChild(0).getChild(0).getText().equals("val")) {
                        Valor valorFunc = getValorCondicion(nodo);

                        switch (valorFunc.getTipo()) {
                            case INT:
                                valor = valorFunc.getInt();
                                tipoVariable = "int";
                                break;
                            case FLOAT:
                                valor = valorFunc.getFloat();
                                tipoVariable = "float";
                                break;
                            case TEXT:
                                valor = valorFunc.getString();
                                tipoVariable = "text";
                                break;
                            case POLYNOMIAL:
                                valor = valorFunc.getValorPolinomio();
                                tipoVariable = "polynomial";
                                break;
                            default:
                                System.out.println("tipo de variable no esperado");
                                System.exit(1);
                                break;
                        }
                    } else { //Entra en la funcion val
                        valor = Float.parseFloat(String.valueOf(tablaSimbolos.getResVal()));
                        tipoVariable = "float";
                    }
                } else if (nodo.getChildCount() == 3) { //Se trata de una operacion
                    Valor valorIzq = calcularParametroCondicion(nodo.getChild(0));
                    Valor valorDer = calcularParametroCondicion(nodo.getChild(nodo.getChildCount() - 1));
                    String operacion = nodo.getChild(nodo.getChildCount() - 2).getText();
                    //posible error
                    Print.operar(valorIzq, operacion, valorDer);
                    switch (valorIzq.getTipo()) {
                        case INT:
                            valor = valorIzq.getInt();
                            tipoVariable = "int";
                            break;
                        case FLOAT:
                            valor = valorIzq.getFloat();
                            tipoVariable = "float";
                            break;
                        case TEXT:
                            if (valorIzq.getString().contains("\""))
                                valor = valorIzq.getString().substring(1, valorIzq.getString().length() - 1);
                            else
                                valor = valorIzq.getString();
                            tipoVariable = "text";
                            break;
                        case POLYNOMIAL:
                            valor = valorIzq.getValorPolinomio().getExpresion();
                            tipoVariable = "polynomial";
                            break;
                        case VAR:
                            Simbolo simbolo = tablaSimbolos.getAmbito().getSimbolo(valorIzq.getString());
                            if (simbolo != null) {
                                switch (simbolo.getTipoSimbolo()) {
                                    case INT:
                                        valor = simbolo.getValorInteger();
                                        tipoVariable = "int";
                                        break;
                                    case TEXT:
                                        valor = simbolo.getValorString();
                                        tipoVariable = "text";
                                        break;
                                    case FLOAT:
                                        valor = simbolo.getValorReal();
                                        tipoVariable = "float";
                                        break;
                                    case POLYNOMIAL:
                                        valor = simbolo.getValorPolinomio();
                                        tipoVariable = "polynomial";
                                        break;
                                    default:
                                        System.out.println(valorIzq.getString() + " tiene un tipo no esperado");
                                        System.exit(1);
                                        break;
                                }
                            } else {
                                System.out.println("La variable " + valorIzq.getString() + " no se encuentra declarada");
                                System.exit(1);
                            }
                        default:
                            System.out.println("tipo de variable no esperado");
                            System.exit(1);
                            break;
                    }
                    if (tipoVariable != null) {
                        int linea = ctx.start.getLine();
                        //Se añade el nuevo ámbito
                        Ambito tmp = this.tablaSimbolos.popAmbito();
                        Simbolo simb = new Simbolo(nombre, Simbolo.TipoSimbolo.fromString(tipoVariable), valor, linea);
                        tmp.modificarSimbolo(nombre, simb);
                        tablaSimbolos.addAmbito(tmp);
                    }
                }
                if (valor == null && tipoVariable == null) {
                    String tipo = getTipo(nodo.getText());
                    if (tipo.equals("ENTERO")) {
                        try {
                            valor = (long) Long.parseLong(ctx.getChild(2).getText());
                            tipoVariable = "int";
                        } catch (NumberFormatException ex) {
                            //Error lo que se ha pasado no es un integer
                        }
                    } else if (tipo.equals("REAL")) {
                        try {
                            valor = (double) Double.parseDouble(ctx.getChild(2).getText());
                            tipoVariable = "float";
                        } catch (NumberFormatException ex) {
                            //Error no se pasa un double
                        }
                    } else if (tipo.equals("POLINOMIO")) {
                        valor = ctx.getChild(2).getText();
                        tipoVariable = "polynomial";
                    } else if (tipo.equals("TEXTO")) {
                        valor = ctx.getChild(2).getText();
                        tipoVariable = "text";
                    } else if (tipo.equals("VAR")) {
                        Simbolo simbolo = tablaSimbolos.getAmbito().getSimbolo(nodo.getText());
                        if (simbolo != null) {
                            switch (simbolo.getTipoSimbolo()) {
                                case INT:
                                    valor = simbolo.getValorInteger();
                                    tipoVariable = "int";
                                    break;
                                case TEXT:
                                    valor = simbolo.getValorString();
                                    tipoVariable = "text";
                                    break;
                                case FLOAT:
                                    valor = simbolo.getValorReal();
                                    tipoVariable = "float";
                                    break;
                                case POLYNOMIAL:
                                    valor = simbolo.getValorPolinomio();
                                    tipoVariable = "polynomial";
                                    break;
                                default:
                                    System.out.println("Tipo no válido para " + nodo.getText());
                                    System.exit(1);
                                    break;
                            }
                        } else {
                            System.out.println("La variable " + nombre + " no se encuentra declarada");
                            System.exit(1);
                        }
                    } else if (tipo.equals("FUNCTION")) {
                        nombre = nodo.getText().substring(0, nodo.getText().indexOf('('));
                        Valor v = tablaSimbolos.getParamFuncion(nombre).getValorReturn();
                        //ArrayList<Object> array = ManejadorFunciones.llamadaFuncionReturn(ctx.getChild(2), this.tablaSimbolos);
                        switch (v.getTipo()) {
                            case INT:
                                valor = v.getInt();
                                break;
                            case FLOAT:
                                valor = v.getFloat();
                                break;
                            case POLYNOMIAL:
                                valor = v.getValorPolinomio().getExpresion();
                                break;
                            case TEXT:
                                valor = v.getString();
                                break;
                            default:
                                valor = null;
                                System.out.println("Error retorn funcion");
                        }
                        tipoVariable = String.valueOf(v.getTipo());
                    } else {
                        tipoVariable = null;
                        System.out.println("Error no se ha podido identificar el tipo declarado en la variable");
                        System.exit(1);
                    }
                }
            }
            if (tipoVariable != null) {
                int linea = ctx.start.getLine();
                //Se añade el nuevo ámbito
                Ambito tmp = tablaSimbolos.popAmbito();
                Simbolo simb = new Simbolo(nombre, Simbolo.TipoSimbolo.fromString(tipoVariable), valor, linea);
                tmp.modificarSimbolo(nombre, simb);
                tablaSimbolos.addAmbito(tmp);
            }
        } else {
            System.out.println("Error, la variable: " + nombre + ", no ha sido declarada.");
            System.exit(1);
        }
    }

    @Override
    public void exitLlamarFuncion(sintactico.LlamarFuncionContext ctx) {
        tablaSimbolos.popAmbito();
    }

    @Override
    public void exitPrint(sintactico.PrintContext ctx) {
        int numHijos = ctx.getChild(2).getChildCount();
        String cadena_valor = ctx.getChild(2).getText();
        String nombre_tipo = getTipo(cadena_valor);
        if (numHijos == 1) {
            if (nombre_tipo.equals("TEXTO") || nombre_tipo.equals("POLINOMIO")) {
                if (cadena_valor.contains("\""))
                    System.out.println(cadena_valor.substring(1, cadena_valor.length() - 1));
                else
                    System.out.println(cadena_valor);
            } else if (nombre_tipo.equals("ENTERO") || nombre_tipo.equals("REAL")) {
                if (ctx.getChild(2).getChild(0).getChildCount() > 1) {
                    System.out.println(cadena_valor.substring(0, cadena_valor.length() - 2));
                } else
                    System.out.println(cadena_valor);
            } else if (nombre_tipo.equals("VAR")) {
                Ambito ambito = tablaSimbolos.getAmbito();
                Simbolo var = ambito.getSimbolo(cadena_valor);

                if (var == null) { //la variable no está declarada en ningún ámbito (incluyendo los padres)
                    System.out.println("La variable " + cadena_valor + " no está declarada");
                } else {
                    switch (var.getTipoSimbolo()) {
                        case INT:
                            System.out.println(var.getValorInteger());
                            break;
                        case FLOAT:
                            System.out.println(Float.parseFloat(var.getObjeto().toString()));
                            break;
                        case TEXT:
                            if (cadena_valor.contains("\""))
                                System.out.println(var.getValorString().substring(1, var.getValorString().length() - 1));
                            else
                                System.out.println(var.getValorString());
                            break;
                        case POLYNOMIAL:
                            if (var.getValorPolinomio().contains("@")) {
                                System.out.println(var.getValorPol().getExpresion());
                            } else
                                System.out.println(var.getValorPolinomio());
                            break;
                        default:
                            System.out.println("tipo de variable no esperado para " + cadena_valor);
                            System.exit(1);
                            break;
                    }
                }
            } else if (nombre_tipo.equals("FUNCTION")) {
                cadena_valor = cadena_valor.substring(0, cadena_valor.indexOf('('));
                Valor valor = tablaSimbolos.getParamFuncion(cadena_valor).getValorReturn();
                System.out.println(valor.imprimir());
                //ArrayList<Object> array = ManejadorFunciones.llamadaFuncionReturn(ctx.getChild(2), this.tablaSimbolos);
                //System.out.println(String.valueOf(valor));
            } else if (ctx.getChild(2).getChild(0).getChild(0).getText().equals("val")) {
                System.out.println(String.valueOf(tablaSimbolos.getResVal()));
            }
        } else if (numHijos == 2) {
            //nombre_tipo.equals("VAR")
            if (nombre_tipo.equals("INCREMENTO") || nombre_tipo.equals("DECREMENTO") || nombre_tipo.equals("ENTERO") || nombre_tipo.equals("VAR") || nombre_tipo.equals("REAL")) {
                ParseTree nodo = ctx.getChild(2);
                String tipoAccion;
                int child;
                if (nodo.getChild(0).getText().equals("++") || nodo.getChild(1).getText().equals("++"))
                    tipoAccion = "INCREMENTO";
                else
                    tipoAccion = "DECREMENTO";
                //buscar donde no se encuentra el incremento o decremento y coger el valor a operar
                if (nodo.getChild(0).getText().equals("++") || nodo.getChild(0).getText().equals("--")) {
                    //El valor está en el nodo 1
                    child = 1;
                } else {
                    //El valor está en el nodo 0
                    child = 0;
                }
                String cadena = nodo.getChild(child).getText();
                cadena_valor = cadena;
                String numero = nodo.getChild(child).getText();
                String tipo_num = getTipo(numero);
                if (tipo_num.equals("ENTERO")) {
                    long n = Long.parseLong(numero);
                    if (tipoAccion.equals("INCREMENTO"))
                        n++;
                    else if (tipoAccion.equals("DECREMENTO"))
                        n--;
                    System.out.println(n);
                } else if (tipo_num.equals("REAL")) {
                    float n = Float.parseFloat(numero);
                    if (tipoAccion.equals("INCREMENTO"))
                        n++;
                    else if (tipoAccion.equals("DECREMENTO"))
                        n--;
                    System.out.println(n);
                } else if (tipo_num.equals("VAR")) {
                    Valor valor = null;
                    Ambito ambito = tablaSimbolos.getAmbito();
                    Simbolo var;
                    //Comprobar si existe en el ámbito actual e "ir" al padre para comprobarlo
                    var = ambito.getSimbolo(cadena_valor);
                    if (var == null) { //la variable no está declarada en ningún ámbito (incluyendo los padres)
                        System.out.println("La variable " + cadena_valor + " no está declarada");
                        System.exit(1);
                    } else {
                        switch (var.getTipoSimbolo()) {
                            case INT:
                                valor = new Valor(var.getValorInteger());
                                if (tipoAccion.equals("INCREMENTO")) {
                                    System.out.println(valor.getInt() + child); //Cuando esta el ++/-- a la izquierda child == 1 -> se debe mostrar el resultado de la operacion
                                    valor.setValorInteger(valor.getInt() + 1); //Siempre se incrementa el valor
                                } else if (tipoAccion.equals("DECREMENTO")) {  //En cambio cuando ++/-- esta a la derecha child == 0 -> se muestra el valor directamente (sin realizar la operacion)
                                    System.out.println(valor.getInt() - child);
                                    valor.setValorInteger(valor.getInt() - 1); //Siempre se decrementa el valor
                                }
                                break;
                            case FLOAT:
                                valor = new Valor(var.getValorReal());
                                if (tipoAccion.equals("INCREMENTO")) {
                                    System.out.println(valor.getFloat() + child);
                                    valor.setValorFloat(valor.getFloat() + 1);//Siempre se incrementa el valor
                                } else if (tipoAccion.equals("DECREMENTO")) {
                                    System.out.println(valor.getFloat() - child);
                                    valor.setValorFloat(valor.getFloat() - 1);//Siempre se decrementa el valor
                                }
                                break;
                        }
                        //Debemos actualizar el valor si es una variable
                        int linea = ctx.start.getLine();
                        //Se añade el nuevo ámbito
                        Ambito tmp = tablaSimbolos.popAmbito();
                        Object valorActualizado = null;
                        if (valor != null) {
                            switch (var.getTipoSimbolo()) {
                                case INT:
                                    valorActualizado = valor.getInt();
                                    break;
                                case FLOAT:
                                    valorActualizado = valor.getFloat();
                                    break;
                            }

                            Simbolo simb = new Simbolo(cadena_valor, Simbolo.TipoSimbolo.fromString(String.valueOf(var.getTipoSimbolo().toString().toLowerCase())), valorActualizado, linea);
                            tmp.modificarSimbolo(cadena_valor, simb);
                            tablaSimbolos.addAmbito(tmp);
                        } else {
                            System.out.println("Error a actualizar " + cadena_valor + " en incremento/decremento");
                            System.exit(1);
                        }
                    }
                } else if (nombre_tipo.equals("FUNCTION")) {
                    cadena_valor = cadena_valor.substring(0, cadena_valor.indexOf('('));
                    Valor valor = tablaSimbolos.getParamFuncion(cadena_valor).getValorReturn();

                    //ArrayList<Object> array = ManejadorFunciones.llamadaFuncionReturn(ctx.getChild(2), this.tablaSimbolos);
                    switch (valor.getTipo()) {
                        case INT:
                            if (tipoAccion.equals("INCREMENTO"))
                                System.out.println(valor.getInt() + child);
                            else if (tipoAccion.equals("DECREMENTO"))
                                System.out.println(valor.getInt() - child);
                            break;
                        case FLOAT:
                            if (tipoAccion.equals("INCREMENTO"))
                                System.out.println(valor.getFloat() + child);
                            else if (tipoAccion.equals("DECREMENTO"))
                                System.out.println(valor.getFloat() - child);
                            break;
                    }
                }
            }

        } else if (numHijos > 1) {
            ParseTree hijo = ctx.getChild(2);
            Valor valorIzq = Print.getValorOperando(hijo.getChild(0), tablaSimbolos);
            Valor valorDer = Print.getValorOperando(hijo.getChild(2), tablaSimbolos);
            String operacion = hijo.getChild(1).getText();
            valorIzq = Print.operar(valorIzq, operacion, valorDer);
            if (valorIzq != null) {
                switch (valorIzq.getTipo()) {
                    case INT:
                        System.out.println(valorIzq.getInt());
                        break;
                    case FLOAT:
                        System.out.println(valorIzq.getFloat());
                        break;
                    case TEXT:
                        System.out.println(valorIzq.getString());
                        break;
                    case POLYNOMIAL:
                        System.out.println(valorIzq.valorPolinomio.getExpresion());
                }
            }
        }
    }

    private String getTipo(String cadena_valor) {
        lexico lexer = new lexico(CharStreams.fromString(cadena_valor));
        lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);
        if (cadena_valor.contains("(")) {
            cadena_valor = cadena_valor.substring(0, cadena_valor.indexOf('('));
            if (tablaSimbolos.existeFuncion(cadena_valor))
                return ("FUNCTION");
        }
        return (lexer.getVocabulary().getSymbolicName(lexer.nextToken().getType()));
    }

    public static boolean isNumber(String numero) {
        try {
            for (int i = 0; i < numero.length(); i++) {
                if (!Character.isDigit(numero.charAt(i)) && numero.charAt(i) != '.' && numero.charAt(i) != ',')
                    return (false);
            }
            return (true);
        } catch (Exception exc) {
            return (false);
        }
    }

    public void enterVal(sintactico.ValContext ctx) {
        try {

            String polinomio = null;

            //Guardamos el polinomio a evaluar
            if (getTipo(ctx.getChild(2).getText()).equals("VAR")) {
                if (ctx.getChild(2).getChildCount() == 3) {
                    Polinomio poliIzq = null;
                    Polinomio poliDer = null;
                    if (getTipo(ctx.getChild(2).getChild(0).getText()).equals("VAR"))
                        poliIzq = new Polinomio(tablaSimbolos.getAmbito().getSimbolo(ctx.getChild(2).getChild(0).getText()).getValorPol().getExpresion());
                    else
                        poliIzq = new Polinomio(ctx.getChild(2).getChild(0).getText().substring(1, ctx.getChild(2).getChild(0).getText().length() - 1));
                    if (getTipo(ctx.getChild(2).getChild(2).getText()).equals("VAR"))
                        poliDer = new Polinomio(tablaSimbolos.getAmbito().getSimbolo(ctx.getChild(2).getChild(2).getText()).getValorPol().getExpresion());

                    else
                        poliDer = new Polinomio(ctx.getChild(2).getChild(2).getText().substring(1, ctx.getChild(2).getChild(2).getText().length() - 1));
                    // Obtengo el operador + ó -
                    String operacionPoli = ctx.getChild(2).getChild(1).getText();
                    //Calculo la operacion con los dos polinomios
                    if (operacionPoli.equals("+")) {
                        polinomio = poliIzq.sumaPolinomios(poliDer);
                    } else {
                        poliDer.cambiarSigno();
                        Polinomio poliDerCambiado = new Polinomio(poliDer.getExpresion());
                        polinomio = poliIzq.sumaPolinomios(poliDerCambiado);
                    }
                } else {
                    String evaluado = ctx.getChild(2).getText();
                    //Mirar si es una variable
                    Ambito ambito = this.tablaSimbolos.getAmbito();
                    if (ambito.existeSimbolo(evaluado)) {
                        //sacamos el valor de la variable
                        polinomio = ambito.getSimbolo(evaluado).getValorPol().getExpresion();
                    } else {
                        //"'2x^2'"
                        polinomio = tablaSimbolos.getAmbito().getSimbolo(ctx.getChild(2).getText()).getValorString();
                    }
                }
            } else {//'2x^2'
                polinomio = ctx.getChild(2).getText();
            }
            //Creamos variable que contendrá un ArrayList con las variables y sus valores
            Polinomio variablesPolinomio = new Polinomio(polinomio);
            //Almacenamos las distintas variables con sus valores mediante llamadas recursivas
            variablesPolinomio.getVarPolinomio(variablesPolinomio, ctx.getChild(4), tablaSimbolos);
            int i = 0;
            // Bucle que recorre el polinomio para añadir un operador multiplicación '*' siempre que haya un número o una variable seguidos:
            // Ejemplo: 1x + 3xy ---> 1*x + 3*x*y
            while (++i < polinomio.length()) {
                if (isNumber(Character.toString(polinomio.charAt(i - 1))) && variablesPolinomio.contiene(String.valueOf(polinomio.charAt(i)))) {
                    polinomio = polinomio.substring(0, i) + "*" + polinomio.substring(i);
                } else if (variablesPolinomio.contiene(String.valueOf(polinomio.charAt(i - 1))) && variablesPolinomio.contiene(String.valueOf(polinomio.charAt(i)))) {
                    polinomio = polinomio.substring(0, i) + "*" + polinomio.substring(i);
                }
            }
            tablaSimbolos.setResVal(variablesPolinomio.evaluarPolinomio(polinomio, variablesPolinomio.toArray()));
        } catch (Exception exc) {
            System.out.println("Error al evaluar el polinomio ");
            System.exit(1);
        }
    }

    @Override
    public void enterSim(sintactico.SimContext ctx) {
        String nombre = ctx.getChild(0).getText(); // car
        String operacion = ctx.getChild(1).getText(); // op
        Simbolo valor = tablaSimbolos.getAmbito().getSimbolo(nombre);
        if (valor == null) {
            System.out.println("La variable " + nombre + " no está declarada");
            System.exit(1);
        }
        if (valor.getTipoSimbolo() == Simbolo.TipoSimbolo.INT) {
            long nuevoValor = 0;
            if (operacion.equals("++")) {
                nuevoValor = valor.getValorInteger() + 1;
            } else {
                nuevoValor = valor.getValorInteger() - 1;
            }
            valor.setValor(nuevoValor);
            tablaSimbolos.getAmbito().modificarSimbolo(nombre, valor);
        } else if (valor.getTipoSimbolo() == Simbolo.TipoSimbolo.FLOAT) {
            float nuevoValor = 0;
            if (operacion.equals("++")) {
                nuevoValor = valor.getValorReal() + 1;
            } else {
                nuevoValor = valor.getValorReal() - 1;
            }
            valor.setValor(nuevoValor);
            tablaSimbolos.getAmbito().modificarSimbolo(nombre, valor);
        } else {
            System.out.println("Error, no se permite la opereción incremento/Decremento sobre este tipo de dato");
            System.exit(1);
        }
    }


    @Override
    public void enterLinea(sintactico.LineaContext ctx) {
        Scanner scan = new Scanner(System.in);
        if (this.pasoApaso) {
            String cadenaIn = null;
            boolean asignadoCorrectamente;
            do {
                System.out.println("c.- continuar el programa");
                System.out.println("var.- Mostrar el valor de las variables");
                System.out.println("l.- Consultar número de línea actual");
                System.out.println("f.- Terminar ejecucion funcion actual");
                System.out.println("mod.- Modificar el valor de una veriable");
                System.out.println("pila.- Obtener la pila de llamadas a funciones");
                System.out.print("->");
                cadenaIn = scan.nextLine();
                if (cadenaIn.equals("pila")) {
                    this.tablaSimbolos.getPilaFunciones();
                } else if (cadenaIn.equals("var")) {
                    this.tablaSimbolos.mostrarVariables();
                } else if (cadenaIn.equals("l")) {
                    System.out.println("Linea actual: " + ctx.getStart().getLine());
                } else if (cadenaIn.equals("f")) {
                    this.setPasoApaso(false);
                    cadenaIn = "c";
                } else if (cadenaIn.equals("mod")) {
                    String nombreVar = "";
                    String otraVez = "";
                    boolean variableValida = false;
                    do {
                        asignadoCorrectamente = true;
                        System.out.print("Introduce el nombre de la variable (pulse enter para salir)->");
                        nombreVar = scan.nextLine();
                        Ambito ambito = this.tablaSimbolos.getAmbito();
                        //Miro si existe la variable en la tabla de simbolos
                        if (ambito.existeSimbolo(nombreVar)) {
                            variableValida = true;
                            //Existe la variable introducida
                            //pedimos el nuevo valor
                            Simbolo s = ambito.getSimbolo(nombreVar);
                            if (s == null) {
                                System.out.println("No se pudo encontrar la variable " + nombreVar);
                                System.exit(1);
                            }
                            System.out.print("Que valor quieres poner a la variable " + nombreVar + " en vez de " + s.getValorSimbolo() + " ->");
                            String newValor = scan.nextLine();
                            //Actualizo el valor de la variable
                            long valorInt;
                            float valorFloat;
                            Polinomio valorPol;
                            Simbolo simb = null;
                            int linea = ctx.start.getLine();
                            try {
                                switch (s.getTipoSimbolo()) {
                                    case INT:
                                        valorInt = Integer.parseInt(newValor);
                                        simb = new Simbolo(nombreVar, Simbolo.TipoSimbolo.fromString("int"), valorInt, linea);
                                        break;
                                    case FLOAT:
                                        valorFloat = Float.parseFloat(newValor);
                                        simb = new Simbolo(nombreVar, Simbolo.TipoSimbolo.fromString("float"), valorFloat, linea);
                                        break;
                                    case TEXT:
                                        simb = new Simbolo(nombreVar, Simbolo.TipoSimbolo.fromString("text"), newValor, linea);
                                        break;
                                    case POLYNOMIAL:
                                        valorPol = new Polinomio(newValor);
                                        simb = new Simbolo(nombreVar, Simbolo.TipoSimbolo.fromString("polynomial"), valorPol, linea);
                                        break;
                                }
                                //Se añade el nuevo ámbito
                                Ambito tmp = this.tablaSimbolos.popAmbito();
                                tmp.modificarSimbolo(nombreVar, simb);
                                tablaSimbolos.addAmbito(tmp);
                                System.out.println("El valor de la variable " + nombreVar + " ha sido modificado a " + newValor);
                            } catch (Exception exc) {
                                System.out.println("No se ha podido cambiar el valor a la variable");
                                asignadoCorrectamente = false;
                            }
                        } else {
                            //No se ha encontrado la variable que ha introducido el usuario
                            System.out.println("Variable no encontrada");
                            variableValida = false;
                            System.out.println("Desea probar otra vez?(S/n)");
                            otraVez = scan.nextLine();
                            otraVez = otraVez.toUpperCase();
                        }
                    } while ((!variableValida && otraVez.equals("S")) || !asignadoCorrectamente);
                }
            } while (!cadenaIn.equals("c"));
        }
    }
}