import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.Token;


public class Simbolo {

    //Tipos de símbolo
    public enum TipoSimbolo {
        INT, FLOAT, POLYNOMIAL, TEXT, FUNCTION, VAR;

        public static TipoSimbolo fromString(String s) {
            switch (s) {
                case "int":
                    return (INT);
                case "float":
                    return (FLOAT);
                case "polynomial":
                    return (POLYNOMIAL);
                case "text":
                    return (TEXT);
                case "function":
                    return (FUNCTION);
                case "var":
                    return (VAR);
                default:
                    System.out.println("Error, tipo de símbolo inesperado.");
                    return (null);
            }
        }
    }

    //Atributos
    private String nombre;
    private TipoSimbolo tipoSimbolo;
    private Object valor;
    private int linea;

    //Constructores

    /**
     * Constructor con la asiganción de la variable
     *
     * @param nombre
     * @param tipoSimbolo
     * @param valor
     */
    public Simbolo(String nombre, TipoSimbolo tipoSimbolo, Object valor, int linea) {
        this.nombre = nombre;
        this.tipoSimbolo = tipoSimbolo;
        this.valor = valor;
        this.linea = linea;

    }

    /**
     * Cosntructor sin la asignación de la variable
     *
     * @param nombre
     */
    public Simbolo(String nombre) {
        this.nombre = nombre;
        this.tipoSimbolo = null;
        this.valor = null;
    }

    /**
     * Añade un valor a y el tipo a la variable
     *
     * @param tipoSimbolo
     * @param valor
     */
    public void addValor(TipoSimbolo tipoSimbolo, Object valor) {
        this.tipoSimbolo = tipoSimbolo;
        this.valor = valor;
    }

    /**
     * Métodos para obtener setear los diferentes tipos de valores
     *
     * @param valor
     */
    public void setValor(long valor) {
        this.tipoSimbolo = TipoSimbolo.INT;
        this.valor = valor;
    }

    public void setValor(String valor) {
        this.tipoSimbolo = TipoSimbolo.TEXT;
        this.valor = valor;
    }

    public void setValor(float valor) {
        this.tipoSimbolo = TipoSimbolo.FLOAT;
        this.valor = valor;
    }


    public void setValorPolinomio(String valor) {
        this.tipoSimbolo = TipoSimbolo.POLYNOMIAL;
        this.valor = valor;
    }


    public void setValor(Funcion valor) {
        this.tipoSimbolo = TipoSimbolo.FUNCTION;
    }

    /**
     * Obtiene el valor integer si el tipo es String lo es
     *
     * @return
     */
    public long getValorInteger() {
        if (this.tipoSimbolo == TipoSimbolo.INT) {
            return (long) this.valor;
        }//hola Leo :)
        else {
            //Throw exception
            return 0;
        }
    }

    /**
     * Obtiene el valor String
     *
     * @return
     */
    public String getValorString() {
        return this.valor.toString();
    }

    /**
     * Obtiene el valor polinomio
     *
     * @return
     */

    public String getValorPolinomio() {

        return this.valor.toString();
    }

    public Polinomio getValorPol() {
        Polinomio pol = ((Polinomio) this.valor);
        return pol;
    }

    public float getValorReal() {
        if (this.tipoSimbolo == TipoSimbolo.FLOAT) {
            float valor = Float.parseFloat(this.valor.toString());
            return valor;
        } else {
            //Throw exception
            return 0;
        }
    }

    /**
     * Obtiene el valor objeto
     *
     * @return
     */
    public Object getObjeto() {
        return this.valor;
    }

    /**
     * Obtiene el tipo de simbolo
     *
     * @return
     */
    public TipoSimbolo getTipoSimbolo() {
        return this.tipoSimbolo;
    }

    /**
     * Obtiene linea de ejecución
     *
     * @return
     */
    public int getLinea() {
        return this.linea;
    }
    //Añadir los métodos get que faltan
    //Se pueden añadir los métodos de linea donde se declara etc.

    /**
     * ToString del valor
     *
     * @return
     */
    public String imprimir() {
        return this.valor.toString();
    }

    /**
     * Método para obtener el valor del símbolo en formato texto
     *
     * @return String valor símbolo en texto
     */
    public String getValorSimbolo() {
        switch (this.getTipoSimbolo()) {
            case INT:
                return (String.valueOf(this.getValorInteger()));
            case FLOAT:
                return (String.valueOf(this.getValorReal()));
            case TEXT:
                return this.getValorString();
            case POLYNOMIAL:
                return this.getValorPolinomio().toString();
        };
        return null;
    }
}
