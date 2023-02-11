import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clase Funcion encargada del almacenamientos de los datos dentro del ámbito de una función
 * Estrucura:
 * Hay dos HashMaps uno de parámetros y otro de variables que nos facilitarán la busqueda de los mismos por su nombre.
 * Y luego habría dos pilas, creadas como LinkedList una para los ámbitos de las distintas variables y dentro de esa pila tendríamos
 * una pila por ámbito con las diferentes variables que se van almacenando.
 */
public class Funcion {
    private String nombre;
    // HashMap<Nombre,ArrayList<Valor,Tipo>> almacena los parámetros por su nombre como clave, el valor y tipo del mismo.
    private ArrayList<String> nombresParam;
    //Este boolean será true si en la llamada a una funcion realiza un return
    private  Boolean haceReturn = false;
    private Valor valorReturn;

    public Funcion(String nombre,ArrayList<String> nombresParam)
    {
        this.nombre = nombre;
        this.haceReturn = false;
        this.nombresParam = nombresParam;
        this.valorReturn = null;

    }
    public Funcion(String nombre)
    {
        this.nombre = nombre;
        this.haceReturn = false;
        this.nombresParam = new ArrayList<>();
        this.valorReturn = null;
    }

    public void setHaceReturn(boolean haceReturn){
        this.haceReturn = haceReturn;
    }

    public boolean getHaceReturn(){
        return this.haceReturn;
    }

    public void setValorReturn(Valor valor){
        this.valorReturn = valor;
    }

    public Valor getValorReturn(){
        return this.valorReturn;
    }

    /**
     * Obtener el nombre de la función
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los nombres de los parámetros
     * @return
     */
    public ArrayList getParam()
    {
        return this.nombresParam;
    }

    /**
     * Setea los nombres de parámetros
     * @param param
     */
    public void setParam(ArrayList param)
    {
        this.nombresParam = param;
    }

}
