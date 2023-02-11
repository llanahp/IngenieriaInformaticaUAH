import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Monomio {
    /*
        4x^2 -> 4 = coeficiente
                x = literal y z u
                2 = grado
     */

    /*
    <literal, grado>
    */
    private HashMap<String, Integer> variables;
    private int coeficiente;

    public Monomio(HashMap<String, Integer> variables, int coeficiente) {
        this.variables = variables;
        this.coeficiente = coeficiente;
    }

    public HashMap<String, Integer> getVariables() {

        return variables;
    }

    public boolean comprobarSize(){
        boolean result = false;
        if(variables.size() == 0){
            result = true;
        }
        return result;
    }

    public void setVariables(HashMap<String, Integer> variables) {
        this.variables = variables;
    }



    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    @Override
    public String toString() {
        String m; // Monomio

        if(variables == null){
            return String.valueOf(coeficiente);
        }

        if(coeficiente != 1){
            m = String.valueOf(coeficiente);
        }
        else{
            m = "";
        }

        Set<String> vars = variables.keySet() ;
        for(String letra : vars){
            m += letra;
            if(variables.get(letra)>1){
                m+= "^"+variables.get(letra);
            }
        }

        return m;
    }


}
