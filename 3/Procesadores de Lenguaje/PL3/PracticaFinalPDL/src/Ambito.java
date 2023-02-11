import java.util.*;
import java.io.*;

public class Ambito {
    //Tipo de ambito
    public enum TipoAmbito {
        FUNCTION, IF, FOR, WHILE, DOWHILE, ELSE, ELSEIF;

        public static TipoAmbito fromString(String s) {
            switch (s) {
                case "function":
                    return (FUNCTION);
                case "if":
                    return (IF);
                case "for":
                    return (FOR);
                case "while":
                    return (WHILE);
                case "dowhile":
                    return (DOWHILE);
                case "else":
                    return (ELSE);
                case "elseif":
                    return (ELSEIF);
                default:
                    System.out.println("Error, tipo de ambito inesperado.");
                    return (null);
            }
        }
    }

    //Atributos
    private HashMap<String, Simbolo> variables; //key=nombre
    private TipoAmbito tipoAmbito;
    private Ambito padre;
    private String nombreFuncion;

    /**
     * Constructor de la clase ambito
     * @param tipoAmbito TipoAmbito del ambito
     * @param padre Ambito padre
     * @param nombreFuncion String nombre
     */
    public Ambito(TipoAmbito tipoAmbito, Ambito padre, String nombreFuncion) {
        this.tipoAmbito = tipoAmbito;
        this.padre = padre;
        variables = new HashMap<String, Simbolo>();
        this.nombreFuncion = nombreFuncion;
    }

    /**
     * Estructura para el primer ámbito (ámbito padre/principal)
     *
     * @param tipoAmbito
     */
    public Ambito(TipoAmbito tipoAmbito, String nombreFuncion) {
        this.tipoAmbito = tipoAmbito;
        this.padre = null;
        variables = new HashMap<String, Simbolo>();
        this.nombreFuncion = nombreFuncion;
    }

    /**
     * Devuelve si existe el símbolo en la tabla de símbolos
     *
     * @param nombre
     * @return
     */
    public boolean existeSimbolo(String nombre) {
        if (variables != null && variables.containsKey(nombre)) {
            return true;
        } else if (padre != null && padre.existeSimbolo(nombre)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Añade un simbolo a la tabla de símbolos del ámbito
     *
     * @param nombre
     * @param variable
     */
    public void addSimbolo(String nombre, Simbolo variable) {
        if (variables.containsKey(nombre)) {
            modificarSimbolo(nombre, variable); //Si exite se añade el nuevo valor
        } else {
            variables.put(nombre, variable); //Si no existe se añade a la tabla de símbolos del ámbito
        }

    }

    /**
     * Se asigana otro valor a una variable ya inicializada, en caso de no estar en la tabla
     * salta una excepción
     *
     * @param nombre
     * @param variable
     */
    public void modificarSimbolo(String nombre, Simbolo variable) {
        try {

            if (variables.containsKey(nombre)) {
                variables.replace(nombre, variable);
            } else {
                padre.modificarSimbolo(nombre, variable);
            }
        } catch (Exception ex) {
            System.out.println("Error, la variable no está declarada.");
            System.exit(1);
        }
    }

    /**
     * Elimina una variable de la tabla de símbolos
     *
     * @param nombre
     */
    public void removeSimbolo(String nombre) {
        try {
            if (variables.containsKey(nombre)) {
                variables.remove(nombre);
            } else {
                System.out.println("Error, la variable no está inicializada.");
                System.exit(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Añade un ámbito padre si no es una función
     *
     * @param padre
     */
    public void addAmbitoPadre(Ambito padre) {
        try {
            if (this.tipoAmbito != TipoAmbito.FUNCTION) {
                this.padre = padre;
            } else {
                System.out.println("Error, hemos sufrido un error inesperado."); //Un ámbito de una función no tiene un ámbito padre
                System.exit(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Devuelve una variable asociada al parámetro de entrada nombre
     *
     * @param nombre
     * @return
     */
    public Simbolo getSimbolo(String nombre) {

        if (this.padre == null && !variables.containsKey(nombre)) {
            return null;
        }
        if (variables.containsKey(nombre)) {
            return variables.get(nombre);
        } else {
            return this.padre.getSimbolo(nombre);
        }
    }

    /**
     * Devuelve el ámbito padre
     *
     * @return Ambito padre
     */
    public Ambito getPadre() {
        return this.padre;
    }

    public void mostrarVariables() {
        System.out.println("Variables: ");
        System.out.println("--------------");
        for (String key : this.variables.keySet()) {
            System.out.println(key + ":\t");
            System.out.println(this.variables.get(key).getValorSimbolo());
        }
    }

    public TipoAmbito getTipo(){
        return (this.tipoAmbito);
    }

    public String getNombreFuncion(){
        return this.nombreFuncion;
    }
}
