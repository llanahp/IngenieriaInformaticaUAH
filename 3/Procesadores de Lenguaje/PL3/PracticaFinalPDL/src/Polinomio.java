import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinomio {

    private String expresion;
    private ArrayList<Monomio> monomios;

    private ArrayList<Variable> variables;


    public HashMap<String, Integer> obtenerLetras(String monomio) {

        // Anota cada término que no sea un número
        ArrayList<String> letras = new ArrayList<>();
        for (int caracter = 0; caracter < monomio.length(); caracter++) {
            if (Pattern.matches("[a-z]", String.valueOf(monomio.charAt(caracter)))) {
                letras.add(String.valueOf(monomio.charAt(caracter)));
            }
        }

        // Elimina el exponente de cada término y almacena el grado y el coeficiente en un mapa
        HashMap<String, Integer> mapaLetras = new HashMap<>();
        for (String letra : letras) {
            // Elimina el exponente
            letra = letra.replaceAll("\\^\\d+", "");

            // Obtiene el grado de la letra
            Pattern pattern = Pattern.compile("\\^(\\d+)");
            Matcher matcher = pattern.matcher(monomio);
            int grado = 1;
            if (matcher.find()) {
                grado = Integer.parseInt(matcher.group(1));
            }

            // Almacena la letra y su grado en el mapa
            mapaLetras.put(letra, grado);
        }

        return mapaLetras;
    }

    /**
     * Obtener el coeficiente de un monomio
     *
     * @param monomio
     * @return
     */
    public int obtenerCoeficiente(String monomio) {
        int index = 0;
        int coeficiente;
        // Asumiendo que todos los coeficientes del monomio están multiplicados
        if (String.valueOf(monomio.charAt(index)).matches("[-]") && !String.valueOf(monomio.charAt(index + 1)).matches("[0-9]")) {
            coeficiente = -1;
        } else if (String.valueOf(monomio.charAt(index)).matches("[-]") && String.valueOf(monomio.charAt(index + 1)).matches("[0-9]")) {
            index++;
            while (index < monomio.length() && String.valueOf(monomio.charAt(index)).matches("[0-9]")) {
                index++;
            }
            coeficiente = (Integer.parseInt(monomio.substring(0, index)));
        } else if (!String.valueOf(monomio.charAt(index)).matches("[0-9]")) {
            coeficiente = 1;
        } else {
            while (index < monomio.length() && String.valueOf(monomio.charAt(index)).matches("[0-9]")) {
                index++;
            }
            coeficiente = Integer.parseInt(monomio.substring(0, index));
        }


        return coeficiente;
    }

    public Polinomio(String expresion) {
        this.variables = new ArrayList<>();
        monomios = new ArrayList<>();
        String m;
        int index = 1;

        if (expresion.charAt(0) != '\'') {
            expresion = "\'" + expresion + "\'";
        }
        this.expresion = expresion;
        for (int i = 1; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '-' && i == 1) {
                index++;
                while (!String.valueOf(expresion.charAt(index)).matches("[-+]")) {
                    index++;
                }
                m = expresion.substring(i, index);
                i = index;
                index = i + 1;

                HashMap<String, Integer> vars = obtenerLetras(m);
                int coeficiente = obtenerCoeficiente(m);

                Monomio monomio = new Monomio(vars, coeficiente);
                monomios.add(monomio);
            } else if (expresion.charAt(i) == '-') {
                m = expresion.substring(index - 1, i);
                index = i + 1;

                HashMap<String, Integer> vars = obtenerLetras(m);
                int coeficiente = obtenerCoeficiente(m);

                Monomio monomio = new Monomio(vars, coeficiente);
                monomios.add(monomio);
            } else if (expresion.charAt(i) == '+') {
                m = expresion.substring(index, i);
                index = i + 1;

                HashMap<String, Integer> vars = obtenerLetras(m);
                int coeficiente = obtenerCoeficiente(m);

                Monomio monomio = new Monomio(vars, coeficiente);
                monomios.add(monomio);

            } else if (expresion.charAt(i) == '\'') {
                m = expresion.substring(index - 1, i);
                if (m.charAt(0) == '\'') {
                    m = m.substring(1);
                }
                if (obtenerLetras(m) == null) {
                    Monomio monomio = new Monomio(null, Integer.valueOf(m));
                    monomios.add(monomio);
                } else {
                    HashMap<String, Integer> vars = obtenerLetras(m);
                    if(m.startsWith("+")){
                        m = m.replaceAll("[+]","");
                    }
                    int coeficiente = obtenerCoeficiente(m);

                    Monomio monomio = new Monomio(vars, coeficiente);
                    monomios.add(monomio);
                }
            }
        }
    }

    public void addVariable(String nombre, Double valor) {
        variables.add(new Variable(nombre, valor));
    }

    public Variable getVariable(int i) {
        return this.variables.get(i);
    }

    public int numeroVariables() {
        return this.variables.size();
    }


    public ArrayList<Variable> toArray() {
        return variables;
    }


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


    public double evaluarPolinomio(String polinomio, ArrayList<Variable> vars) {
        // Creamos las pilas de operadores y números
        Stack<Character> operadores = new Stack<>();
        Stack<Double> numeros = new Stack<>();
        polinomio = polinomio.replaceAll("[']", "");
        // HashMap que recibe las variables y sus valores para poder buscarlo de forma eficiente
        // Ejemplo  (x,1)
        //          (y,7)
        HashMap<String, Double> valores = new HashMap<>();
        for (int i = 0; i < vars.size(); i++) {
            valores.put(vars.get(i).getNombre(), vars.get(i).getValor());
        }

        // Recorremos el polinomio
        for (int i = 0; i < polinomio.length(); i++) {
            char caracter = polinomio.charAt(i);

            // Si es un espacio, lo ignoramos
            if (caracter == ' ') continue;

            // Si es un número, lo metemos en la pila de números
            if (Character.isDigit(caracter)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(caracter)) {
                    sb.append(caracter);
                    i++;
                    if (i >= polinomio.length()) break;
                    caracter = polinomio.charAt(i);
                }
                i--;
                numeros.push(Double.parseDouble(sb.toString()));
            } else if (Character.isLetter(caracter)) {
                // Si es una letra, buscamos el valor de la variable en el HashMap
                StringBuilder sb = new StringBuilder();
                while (Character.isLetter(caracter)) {
                    sb.append(caracter);
                    i++;
                    if (i >= polinomio.length()) break;
                    caracter = polinomio.charAt(i);
                }
                i--;
                String variable = sb.toString();

                if (!valores.containsKey(variable)) {
                    throw new IllegalArgumentException("Variable no encontrada: " + variable);
                }
                numeros.push(valores.get(variable));

            } else if (caracter == '(') {
                // Si es un paréntesis izquierdo, lo metemos en la pila de operadores
                operadores.push(caracter);
            } else if (caracter == ')') {
                // Si es un paréntesis derecho, sacamos todos los operadores y números hasta encontrar el paréntesis izquierdo

                while (operadores.peek() != '(')
                    numeros.push(aplicaOperador(operadores.pop(), numeros.pop(), numeros.pop()));
                operadores.pop();
            } else {
                // Si es un operador, sacamos todos los operadores con mayor o igual prioridad y realizamos las operaciones
                while (!operadores.isEmpty() && prioridad(caracter) <= prioridad(operadores.peek()))
                    numeros.push(aplicaOperador(operadores.pop(), numeros.pop(), numeros.pop()));

                // Insertamos el nuevo operador en la pila
                operadores.push(caracter);
            }
        }

        // Sacamos todos los operadores y números y realizamos las operaciones
        while (!operadores.isEmpty()) numeros.push(aplicaOperador(operadores.pop(), numeros.pop(), numeros.pop()));

        // El resultado final estará en la cima de la pila
        return numeros.pop();
    }

    /**
     * Metodo para puntuar la prioridad de las operaciones cuando estamos evaluando el polinomio
     *
     * @param c
     * @return
     */
    private static int prioridad(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return 0;
    }

    /**
     * Método para transformar el string del operador a una operación real
     *
     * @param c
     * @param b
     * @param a
     * @return
     */
    private double aplicaOperador(char c, double b, double a) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return Math.pow(a, b);
        }
        return 0;
    }


    /**
     * Comprobar si una variable existe
     *
     * @param cadena
     * @return
     */
    public boolean contiene(String cadena) {
        for (int i = 0; i < this.variables.size(); i++) {
            if (variables.get(i).getNombre().equals(cadena))
                return true;
        }
        return false;
    }


    /**
     * Almacena el nombre de las variables y sus valores correspondientes
     *
     * @param variablesPolinomio
     * @param tree
     */
    public void getVarPolinomio(Polinomio variablesPolinomio, ParseTree tree, TablaSimbolos tablaSimbolos) {
        //En caso de tener una expresion parecida a  "x,8", llamfo recursivamente a los hijos de los lados
        if (tree.getChildCount() == 3 && tree.getChild(0).getText().contains(",")) {
            getVarPolinomio(variablesPolinomio, tree.getChild(0), tablaSimbolos);
            getVarPolinomio(variablesPolinomio, tree.getChild(2), tablaSimbolos);
        } else if (tree.getChildCount() == 3 && !tree.getChild(0).getText().contains(",")) {
            //Almaceno el valor del hijo
            String var = tree.getChild(0).getText().substring(1, tree.getChild(0).getText().length() - 1);
            String valor = tree.getChild(2).getText();

            switch (getTipo(tree.getChild(2).getText(), tablaSimbolos)) {
                case "ENTERO":

                case "REAL":
                    variablesPolinomio.addVariable(var, Double.parseDouble(valor));
                    break;
                case "VAR":
                    String res = "0";
                    variablesPolinomio.addVariable(var, Double.parseDouble(res));
                    break;
                default:
                    System.out.println("Tipo no esperado dentro del polinomio: " + var + " valor: " + valor);
                    System.exit(1);
                    break;
            }
        }
    }


    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public ArrayList<Monomio> getMonomios() {
        return monomios;
    }


    public String sumaPolinomios(Polinomio polinomio2) {
        ArrayList<Monomio> monomios1 = this.getMonomios();
        ArrayList<Boolean> monUsados1 = new ArrayList<>(monomios1.size());
        for (Monomio mon : monomios1) monUsados1.add(false);
        ArrayList<Monomio> monomios2 = polinomio2.getMonomios();
        ArrayList<Boolean> monUsados2 = new ArrayList<>(monomios2.size());
        for (Monomio mon : monomios2) monUsados2.add(false);
        ArrayList<Monomio> sumMonomios = new ArrayList<>();
        String independiente = "";

        int posM1 = 0;
        // Recorre cada monomio de ambos polinomios

        for (Monomio m1 : monomios1) {
            int posM2 = 0;
            for (Monomio m2 : monomios2) {
                // Si ambos monomios tienen las mismas incógnitas, suma sus coeficientes
                if (m1.comprobarSize() || m2.comprobarSize()) {
                    if (m1.comprobarSize()  && m2.comprobarSize()) {
                        int coeficiente = m1.getCoeficiente() + m2.getCoeficiente();
                        Monomio sumMonomio = new Monomio(null, coeficiente);
                        sumMonomios.add(sumMonomio);
                        monUsados1.set(posM1, true);
                        monUsados2.set(posM2, true);
                        independiente = sumMonomio.toString();
                    }
                } else if (m1.getVariables().equals(m2.getVariables())) {
                    int coeficiente = m1.getCoeficiente() + m2.getCoeficiente();
                    Monomio sumMonomio = new Monomio(m1.getVariables(), coeficiente);
                    sumMonomios.add(sumMonomio);
                    monUsados1.set(posM1, true);
                    monUsados2.set(posM2, true);
                }
                posM2++;
            }
            posM1++;
        }

        // Si el término independiente no ha sido sumado significa que uno de los polinomios no tiene término independiente
        if (independiente.equals("")) {
            if (!monUsados1.get(monUsados1.size() - 1)) {
                if (obtenerLetras(monomios1.get(monomios1.size() - 1).toString()) == null) {
                    independiente = monomios1.get(monomios1.size() - 1).toString();
                    monUsados1.set(monomios1.size() - 1, true);
                }
            } else if (!monUsados2.get(monUsados2.size() - 1)) {
                if (obtenerLetras(monomios2.get(monomios2.size() - 1).toString()) == null) {
                    independiente = monomios2.get(monomios2.size() - 1).toString();
                    monUsados2.set(monomios2.size() - 1, true);

                }
            }
        }

        String polResultado = "'";
        for (int i = 0; i < monomios1.size(); i++) {
            if (!monUsados1.get(i)) {
                if (monomios1.get(i).getCoeficiente() < 0) {
                    polResultado += monomios1.get(i).toString();
                } else {
                    polResultado += "+" + monomios1.get(i).toString();

                }
            }
        }
        for (int i = 0; i < monomios2.size(); i++) {
            if (!monUsados2.get(i)) {
                if (monomios2.get(i).getCoeficiente() < 0) {
                    polResultado += monomios2.get(i).toString();
                } else {
                    polResultado += "+" + monomios2.get(i).toString();

                }
            }
        }
        for (int i = 0; i < sumMonomios.size(); i++) {

            if (sumMonomios.get(i).getCoeficiente() < 0) {
                polResultado += sumMonomios.get(i).toString();
            } else {
                polResultado += "+" + sumMonomios.get(i).toString();

            }
        }

        if (String.valueOf(polResultado.charAt(1)).equals("+")) {
            polResultado = polResultado.replaceFirst("[+]", "");
        }
        return polResultado + "'";
    }


    public void cambiarSigno() {
        String tmp = this.expresion.substring(1, this.expresion.length() - 1);

        if (tmp.startsWith("-")) {
            tmp = tmp.substring(1);
        } else {
            tmp = "-" + tmp;
        }

        char[] resultado = tmp.toCharArray();

        for (int i = 1; i < tmp.length(); i++) {
            if (resultado[i] == '+') {
                resultado[i] = '-';
            } else if (tmp.charAt(i) == '-') {
                resultado[i] = '+';
            }
        }
        this.expresion = "'" + String.valueOf(resultado) + "'";
    }
}
