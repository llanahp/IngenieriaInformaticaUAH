import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class Print {

    public static String getTipo(String cadena_valor, TablaSimbolos tablaSimbolos) {
        lexico lexer = new lexico(CharStreams.fromString(cadena_valor));
        lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);
        if (cadena_valor.contains("(")) {
            cadena_valor = cadena_valor.substring(0, cadena_valor.indexOf('('));
            if (tablaSimbolos.existeFuncion(cadena_valor))
                return ("FUNCTION");
        }
        return (lexer.getVocabulary().getSymbolicName(lexer.nextToken().getType()));
    }

    public static Valor getValorOperando(ParseTree tree, TablaSimbolos tablaSimbolos) {
        if (tree.getChildCount() == 1) {
            String valor = tree.getChild(0).getText();
            if (getTipo(valor, tablaSimbolos).equals("TEXTO")) {
                return (new Valor(valor.substring(1, valor.length() - 1)));
            } else if (getTipo(valor, tablaSimbolos).equals("POLINOMIO")) {
                return (new Valor(new Polinomio(valor)));
            } else if (getTipo(valor, tablaSimbolos).equals("ENTERO")) {
                return (new Valor(Long.parseLong(valor)));
            } else if (getTipo(valor, tablaSimbolos).equals("REAL")) {
                return (new Valor(Float.parseFloat(valor)));
            } else if (getTipo(valor, tablaSimbolos).equals("VAR")) {
                Ambito ambito = tablaSimbolos.getAmbito();
                Simbolo var = ambito.getSimbolo(valor);
                return (new Valor(var.getObjeto(), var.getTipoSimbolo()));
            } else if (getTipo(valor, tablaSimbolos).equals("FUNCTION")) {
                valor = valor.substring(0, valor.indexOf('('));
                Valor valorReturn = tablaSimbolos.getParamFuncion(valor).getValorReturn();
                //ArrayList<Object> array = ManejadorFunciones.llamadaFuncionReturn(tree, tablaSimbolos);
                return valorReturn;
            } else {
                System.out.println("Tipo no esperado para " + valor);
                System.exit(1);
                return (null);
            }
        } else if (tree.getChildCount() == 3) {
            Valor valorIzq = getValorOperando(tree.getChild(0), tablaSimbolos);
            Valor valorDer = getValorOperando(tree.getChild(2), tablaSimbolos);
            String operacion = tree.getChild(1).getText();
            return (operar(valorIzq, operacion, valorDer));
        } else {
            System.out.println("Numero de ramas en print no esperado");
            System.exit(1);
            return (null);
        }
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

    public static boolean isBoolean(String texto) {
        try {
            if (texto.equals("true") || texto.equals("false")) return (true);
        } catch (Exception exc) {
            return (false);
        }
        return (false);
    }


    public static Valor operar(Valor valorIzq, String op, Valor valorDer) {
        boolean esPolinomioDer = valorDer.getTipo() == Simbolo.TipoSimbolo.POLYNOMIAL;
        boolean esPolinomioIzq = valorIzq.getTipo() == Simbolo.TipoSimbolo.POLYNOMIAL;
        if (!(valorIzq.getTipo() == valorDer.getTipo() || esPolinomioDer || esPolinomioIzq)) {
            System.out.println("Operacion con tipos distintos, no valida");
            System.exit(1);
            return null;
        }
        switch (op) {
            case "+":
                if (esPolinomioIzq && esPolinomioDer) {
                    Polinomio izq = valorIzq.getValorPolinomio();
                    Polinomio der = valorDer.getValorPolinomio();
                    Polinomio res = new Polinomio(izq.sumaPolinomios(der));
                    valorIzq.setValorPolinomio(res);
                    return (valorIzq);
                } else if (esPolinomioDer) {
                    Polinomio der = valorDer.getValorPolinomio();
                    Polinomio izq = new Polinomio(Long.toString(valorIzq.valorInteger));
                    Polinomio res = new Polinomio(izq.sumaPolinomios(der));
                    valorIzq.setValorPolinomio(res);
                    return (valorIzq);
                }
                else if (esPolinomioIzq)
                {
                    Polinomio der = new Polinomio(Long.toString(valorIzq.valorInteger));
                    Polinomio izq = valorDer.getValorPolinomio();
                    Polinomio res = new Polinomio(izq.sumaPolinomios(der));
                    valorIzq.setValorPolinomio(res);
                    return (valorIzq);
                }else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() + valorDer.getInt());
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorFloat(valorIzq.getFloat() + valorDer.getFloat());
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.TEXT) {
                    valorIzq.setValorString(valorIzq.getString() + valorDer.getString());
                    return (valorIzq);
                }
                break;
            case "-":
                if (esPolinomioIzq && esPolinomioDer) {
                    Polinomio izq = valorIzq.getValorPolinomio();
                    Polinomio der = valorDer.getValorPolinomio();
                    der.cambiarSigno();
                    Polinomio cambiadoSigno = new Polinomio(der.getExpresion());
                    Polinomio res = new Polinomio(izq.sumaPolinomios(cambiadoSigno));
                    valorIzq.setValorPolinomio(res);
                    return (valorIzq);
                } else if (esPolinomioDer) {
                    Polinomio der = valorDer.getValorPolinomio();
                    Polinomio izq = new Polinomio(Long.toString(valorIzq.valorInteger));
                    der.cambiarSigno();
                    Polinomio cambiadoSigno = new Polinomio(der.getExpresion());
                    Polinomio res = new Polinomio(izq.sumaPolinomios(cambiadoSigno));
                    valorIzq.setValorPolinomio(res);
                    return (valorIzq);
                }
                else if (esPolinomioIzq)
                {
                    Polinomio der = new Polinomio(Long.toString(valorIzq.valorInteger));
                    Polinomio izq = valorDer.getValorPolinomio();
                    der.cambiarSigno();
                    Polinomio cambiadoSigno = new Polinomio(der.getExpresion());
                    Polinomio res = new Polinomio(izq.sumaPolinomios(cambiadoSigno));
                    valorIzq.setValorPolinomio(res);
                    return (valorIzq);
                }else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() - valorDer.getInt());
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorFloat(valorIzq.getFloat() - valorDer.getFloat());
                    return (valorIzq);
                }
                break;
            case "^":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger((long) Math.pow(valorIzq.getInt(), valorDer.getInt()));
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorFloat((float) Math.pow(valorIzq.getFloat(), valorDer.getFloat()));
                    return (valorIzq);
                }
                break;
            case "*":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() * valorDer.getInt());
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorFloat(valorIzq.getFloat() * valorDer.getFloat());
                    return (valorIzq);
                }
                break;
            case "/":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() / valorDer.getInt());
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorFloat(valorIzq.getFloat() / valorDer.getFloat());
                    return (valorIzq);
                }
                break;
            case "%":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() % valorDer.getInt());
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorFloat(valorIzq.getFloat() % valorDer.getFloat());
                    return (valorIzq);
                }
                break;
            case "//":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(Math.floorMod(valorIzq.getInt(), valorDer.getInt()));
                    return (valorIzq);
                }
                break;
            case "&&":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() & valorDer.getInt());
                    return (valorIzq);
                }
                break;
            case "||":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() | valorDer.getInt());
                    return (valorIzq);
                }
                break;
            case "##":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger(valorIzq.getInt() ^ valorDer.getInt());
                    return (valorIzq);
                }
                break;
            case "!":
                break;
            case ">":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger((valorIzq.getInt() > valorDer.getInt()) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorInteger((valorIzq.getFloat() > valorDer.getFloat()) ? 1 : 0);
                    return (valorIzq);
                }
                break;
            case "<":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger((valorIzq.getInt() < valorDer.getInt()) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorInteger((valorIzq.getFloat() < valorDer.getFloat()) ? 1 : 0);
                    return (valorIzq);
                }

                break;
            case ">=":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger((valorIzq.getInt() >= valorDer.getInt()) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorInteger((valorIzq.getFloat() >= valorDer.getFloat()) ? 1 : 0);
                    return (valorIzq);
                }
                break;
            case "==":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger((valorIzq.getInt() == valorDer.getInt()) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.TEXT) {
                    valorIzq.setValorInteger((valorIzq.getString().equals(valorDer.getString())) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorInteger((valorIzq.getFloat() == valorDer.getFloat()) ? 1 : 0);
                    return (valorIzq);
                }
                break;
            case "<=":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger((valorIzq.getInt() <= valorDer.getInt()) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorInteger((valorIzq.getFloat() <= valorDer.getFloat()) ? 1 : 0);
                    return (valorIzq);
                }
                break;
            case "!=":
                if (valorIzq.getTipo() == Simbolo.TipoSimbolo.INT) {
                    valorIzq.setValorInteger((valorIzq.getInt() != valorDer.getInt()) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.FLOAT) {
                    valorIzq.setValorInteger((valorIzq.getFloat() != valorDer.getFloat()) ? 1 : 0);
                    return (valorIzq);
                } else if (valorIzq.getTipo() == Simbolo.TipoSimbolo.TEXT) {
                    valorIzq.setValorInteger((!valorIzq.getString().equals(valorDer.getString())) ? 1 : 0);
                    return (valorIzq);
                }
                break;
            default:
                System.out.println("Tipo Operacion no esperada");
                System.exit(1);
        }
        return (null);
    }


    public static ArrayList<Valor> getArgumentos(ParseTree tree, TablaSimbolos tablaSimbolos) {
        ArrayList<Valor> argumentos = new ArrayList<>();
        for (int i = 0; i < tree.getChildCount(); i = i + 2) {
            String cadena_valor = tree.getChild(i).getText();
            String nombre_tipo = getTipo(cadena_valor, tablaSimbolos);
            if (tree.getChild(i).getChildCount() == 1) {
                if (nombre_tipo.equals("VAR")) {
                    Ambito ambito = tablaSimbolos.getAmbito();
                    Simbolo var = ambito.getSimbolo(cadena_valor);
                    if (var == null) {
                        System.out.println("La variable " + cadena_valor + " no está declarada");
                        System.exit(1);
                    } else {
                        switch (var.getTipoSimbolo()) {
                            case INT:
                                argumentos.add(new Valor(var.getValorInteger()));
                                break;
                            case FLOAT:
                                argumentos.add(new Valor(Float.parseFloat(var.getObjeto().toString())));
                                break;
                            case TEXT:
                                argumentos.add(new Valor(var.getValorString().substring(1, var.getValorString().length() - 1)));
                                break;
                            case POLYNOMIAL:
                                argumentos.add(new Valor(var.getObjeto().toString().substring(1, var.getObjeto().toString().length() - 1)));
                                break;
                            default:
                                System.out.println("tipo de variable no esperado para " + cadena_valor);
                                System.exit(1);
                                break;
                        }
                    }
                } else if (nombre_tipo.equals("ENTERO")) {
                    argumentos.add(new Valor(Long.parseLong(cadena_valor)));
                } else if (nombre_tipo.equals("REAL")) {
                    argumentos.add(new Valor(Float.parseFloat(cadena_valor)));
                } else if (nombre_tipo.equals("TEXTO")) {
                    argumentos.add(new Valor(cadena_valor));
                } else if (nombre_tipo.equals("POLINOMIO")) {
                    argumentos.add(new Valor(new Polinomio(cadena_valor)));
                } else {
                    System.out.println("tipo de dato no esperado para " + cadena_valor);
                    System.exit(1);
                }
            } else if (tree.getChild(i).getChildCount() == 3) { //Se trata de una operación
                Valor valorIzq = getValorOperando(tree.getChild(i).getChild(0), tablaSimbolos);
                Valor valorDer = getValorOperando(tree.getChild(i).getChild(2), tablaSimbolos);
                String operacion = tree.getChild(i).getChild(1).getText();
                Valor res = operar(valorIzq, operacion, valorDer);
                argumentos.add(res);
            }
        }
        return argumentos;
    }
}
