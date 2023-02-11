
import java.util.PrimitiveIterator;

public class Auxiliar extends Thread {

    private String id = "A";
    private final String auxiliar1 = "A1";
    private Controlador controlador;

    public Auxiliar(int NumeroId, Controlador controlador) {
        this.id = id + "" + NumeroId;
        this.controlador = controlador;
    }

    public String GetIdAuxiliar() {
        return this.id;
    }

    public void run() {
        if (id.equals(auxiliar1)) {
            while (true) {
                controlador.puestoAuxiliarEntrada = id;
                for (int i = 0; i < 10; i++) {
                    controlador.AuxiliarEntrada();
                    //TODO debe mostrar por consola cuantos pacientes van en total....
                }
                controlador.puestoAuxiliarEntrada = "";
                EntraDescansar(controlador);
                Aleatoriedad.EsperaAleatoria(3000, 5000);
                SaleDescansar(controlador);
            }
        } else {
            while (true) {
                controlador.puestoAuxiliarVacunas = id;
                for (int i = 0; i < 20; i++) {
                    controlador.AuxiliarVacunas();
                    Aleatoriedad.EsperaAleatoria(500, 1000);
                }
                controlador.puestoAuxiliarVacunas = "";
                EntraDescansar(controlador);
                Aleatoriedad.EsperaAleatoria(1000, 4000);
                SaleDescansar(controlador);
            }
        }
    }

    public void EntraDescansar(Controlador controlador) {
        if (controlador.salaDescando.equals("")) {
            controlador.salaDescando = id;
        } else {
            controlador.salaDescando = controlador.salaDescando + ", " + id;
        }
        Logg.insertarEnLog("Auxiliar " + id + " comienza su descanso");

    }

    public void SaleDescansar(Controlador controlador) {
        if (controlador.salaDescando.startsWith(id)) {
            controlador.salaDescando = controlador.salaDescando.replace(id, "");
        } else {
            controlador.salaDescando = controlador.salaDescando.replace(", " + id, "");
        }
        Logg.insertarEnLog("Auxiliar " + id + " termina su descanso");

    }

}
