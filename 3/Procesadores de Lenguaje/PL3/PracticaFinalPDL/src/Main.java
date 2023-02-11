import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Main (ejecutable)
 */
public class Main {

    /**
     * Método para mostrar el menú de opciones
     */
    public static void mostrarMenu() {

        System.out.println("Introduzca el numero de la ópcion que desee");
        System.out.println("1.- Correr el programa de un fichero");
        System.out.println("2.- Ejecutar paso a paso el programa de un fichero");
        System.out.println("----------------------");
        System.out.print("-> ");
    }

    /**
     * Método main
     *
     * @param args String[] argumentos de entrada por terminal
     */
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int respuesta = -1;
            do {
                mostrarMenu();
                try {
                    respuesta = Integer.parseInt(scan.nextLine());
                } catch (Exception e) {
                    System.out.println("La respuesta debe de ser un número");
                    respuesta = -1;
                }
            } while (respuesta < 1 || respuesta > 2);

            String entrada = null;

            InputStream inputStream = System.in;
            boolean lecturaFichero = true;
            do {
                lecturaFichero = true;

                System.out.println("Introduce la ruta del fichero que desea ejecutar: ");
                entrada = scan.nextLine();

                try {
                    //Leer el fichero de la ruta introducida
                    if (entrada != null) {
                        inputStream = new FileInputStream(entrada);
                    }
                } catch (Exception exc) {
                    System.out.println("No se puede abrir el fichero situado en la ruta: " + entrada);
                    lecturaFichero = false;
                }
            } while (!lecturaFichero);

            //Ejecutamos el programa en función de la opcion seleccionada
            try {
                TablaSimbolos tablaSimbolos = new TablaSimbolos();
                Walker walker = new Walker();
                int puntuacion = 0;
                Listener listener = new Listener(tablaSimbolos, walker);
                listener.setPasoApaso(respuesta != 1); //Establecemos si se ejecuta paso a paso o no

                CharStream input = CharStreams.fromStream(inputStream);
                lexico lexer = new lexico(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                sintactico parser = new sintactico(tokens);
                parser.setBuildParseTree(true);
                ParseTree tree = parser.programa();

                //Creamos el elemento walker

                // ArrayList que contiene los nodos de las funciones que hay creadas en el programa
                ArrayList<ParseTree> nodos = new ArrayList<>();
                String nombreFuncion = null;
                if (tree.getChild(0).getChild(0).getText().equals("function")) {
                    // Añadimos los nodos correspondientes a las funciones y lo cargamos en la tabla de símbolos
                    for (int nodo = 0; nodo < tree.getChildCount(); nodo++) {
                        ParseTree n = tree.getChild(nodo);
                        nodos.add(n);
                        tablaSimbolos.addFuncionLista(n.getChild(1).getText(), n);
                        ArrayList<String> parametros = new ArrayList<>();
                        for (int i = 0; i < n.getChild(3).getChildCount(); i += 2) {
                            parametros.add(n.getChild(3).getChild(i).getText());
                        }
                        nombreFuncion = n.getChild(1).getText();
                        tablaSimbolos.addFuncion(n.getChild(1).getText(), new Funcion(n.getChild(1).getText(), parametros));
                    }
                    tablaSimbolos.addAmbito(new Ambito(Ambito.TipoAmbito.FUNCTION, nombreFuncion));
                    // Obtenemos el nodo main
                    ParseTree nodoMain = nodos.get(nodos.size() - 1);

                    //Miro si el main tiene argumentos
                    if (args.length > 0) {
                        if (nodoMain.getChild(3).getChildCount() > 0) {
                            ParseTree nodoArgumentos = nodoMain.getChild(3);
                            int contador = 0;
                            for (int i = 0; i < nodoArgumentos.getChildCount(); i = i + 2) {
                                String valorArgumento = args[contador];
                                Object valor = new Object();
                                String tipoVariable = "";
                                try {
                                    valor = Long.valueOf(valorArgumento);
                                    tipoVariable = "int";
                                } catch (Exception e) {
                                    try {
                                        valor = Float.parseFloat(valorArgumento);
                                        tipoVariable = "float";
                                    } catch (Exception ex) {
                                        try {
                                            if (valorArgumento.charAt(0) == '\'' && valorArgumento.charAt(valorArgumento.length() - 1) == '\'') { //Comprobar si es un polinomio
                                                tipoVariable = "polynomial";
                                            } else {
                                                tipoVariable = "text";
                                            }
                                            valor = valorArgumento;
                                        } catch (Exception exception) {
                                            System.out.println("Error al castear los argumentos introducidos");
                                            System.exit(1);
                                        }
                                    }
                                }
                                String nombre = nodoArgumentos.getChild(i).getText(); //Nombre de la variable
                                int linea = -1; //Para identificar que es un parámetro de entrada por el terminal
                                Ambito tmp = tablaSimbolos.popAmbito();
                                //si es un polinomio, meter como string
                                Simbolo simb = new Simbolo(nombre, Simbolo.TipoSimbolo.fromString(tipoVariable), valor, linea);
                                tmp.addSimbolo(nombre, simb);
                                //tmp.modificarSimbolo(nombre, simb);
                                tablaSimbolos.addAmbito(tmp);
                                contador++;
                            }
                        }
                    }
                    //Recorremos la función main
                    walker.walk(listener, nodoMain);
                } else { //Si no hay funciones
                    for (int nodo = 0; nodo < tree.getChildCount() - 1; nodo++) {
                        ParseTree n = tree.getChild(nodo);
                        nodos.add(n);
                        tablaSimbolos.addFuncionLista(n.getChild(0).getText(), n);
                        tablaSimbolos.addAmbito(new Ambito(Ambito.TipoAmbito.FUNCTION, "main")); //Ponemos main ya que son funciones "falsas"
                    }
                    for (ParseTree p : nodos) {
                        walker.walk(listener, p);
                    }
                }
            } catch (Exception e) {
                System.out.println("La ejecucion del programa al completo no ha sido exitosa");
                e.printStackTrace();
            }
        } catch (Exception exc) {
            //System.out.println(exc);
            exc.printStackTrace();
        }
    }
}
