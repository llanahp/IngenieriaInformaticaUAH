import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.io.*;

/**
 * Clase Tabla de Simbolos
 * Estrucura:
 * Dentro de esta clase dos estructuras explicadas más adelante para poder almacenar las funciones de manera eficiente
 * Tendríamos un HashMap y una LinkedList.
 */
public class TablaSimbolos {

    /* Este HashMap<Nombre,Funcion> almacena todas las funciones y la clave es el nombre de la funcion
     se utiliza para poder ver de manera rápida si la función existe y acceder a sus datos.*/
    //private HashMap<String,Funcion> declaracionFunciones;

    private HashMap<String, ParseTree> funciones;
    private HashMap<String, Funcion> paramFunciones;

    private LinkedList<Ambito> ambitos = new LinkedList<>();

    private double resVal;

    /**
     * Constructor
     */
    public TablaSimbolos() {
        this.funciones = new HashMap<>();
        this.paramFunciones = new HashMap<>();
        this.ambitos = new LinkedList<>();
    }

    /**
     * Método para añadir una función a la lista completa de funciones (en principio función vacia)
     */
    public void addFuncionLista(String nombre, ParseTree nodo) {
        funciones.put(nombre, nodo);
    }

    /**
     * Comprobar si una función existe y devolverla en caso de que exista
     *
     * @param nombre
     */
    public ParseTree getFuncion(String nombre) {
        return funciones.get(nombre);
    }

    /**
     * Se añade la clase función cuando se crea con atributos nombre y parámetros
     *
     * @param nombre
     * @param funcion
     */
    public void addFuncion(String nombre, Funcion funcion) {
        paramFunciones.put(nombre, funcion);
    }

    /**
     * Devuelve la clase función
     *
     * @param nombre
     * @return
     */
    public Funcion getParamFuncion(String nombre) {
        return paramFunciones.get(nombre);
    }

    /**
     * Añade un nuevo ámbito a la pila de ámbitos del programa
     *
     * @param ambito
     */
    public void addAmbito(Ambito ambito) {
        this.ambitos.addFirst(ambito);
    }

    /**
     * Devuelve el ámbito de la cima de la pila, útil para asociar los ámbitos padre
     *
     * @return
     */
    public Ambito getAmbito() {
        return this.ambitos.getFirst();
    }

    /**
     * Quita el último ambito de la pila
     */
    public Ambito popAmbito() {
        return ambitos.removeFirst();
    }

    /**
     * Existe la funcion con nombre
     *
     * @param nombre String nombre funcion
     * @return boolean true si existe la funcion
     */
    public boolean existeFuncion(String nombre) {
        return this.funciones.get(nombre) != null;
    }

    public double getResVal() {
        return resVal;
    }

    public void setResVal(double resVal) {
        this.resVal = resVal;
    }

    public void mostrarVariables() {
        Ambito ambito = getAmbito();
        ambito.mostrarVariables();
    }

    public void getPilaFunciones() {
        int llamada = 0;
        for (int i = this.ambitos.size() -1; i >= 0; i--) {
            if (this.ambitos.get(i).getTipo() == Ambito.TipoAmbito.FUNCTION) {
                System.out.println("Llamada " + llamada + ": " + this.ambitos.get(i).getNombreFuncion());
                llamada++;
            }
        }
    }
}
