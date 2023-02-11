
import java.io.Serializable;
import java.util.ArrayList;


public class Informacion implements Serializable {

    ArrayList<String> puestosVacunacion = new ArrayList<String>(10);
    ArrayList<Boolean> puestosVacunacionCerrados = new ArrayList<Boolean>(10);
    ArrayList<String> puestosObservacion = new ArrayList<String>(20);
    ArrayList<Boolean> puestoNecesitanSanitario = new ArrayList<Boolean>(20);
    String salaDescando,colaEntrada,vacunasDisponibles,puestoAuxiliarEntrada,puestoAuxiliarVacunas,pacienteEntrada;
    

}
