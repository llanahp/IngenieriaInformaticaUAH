
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SalaObservacion {

    ArrayList<CountDownLatch> esperaPorSanitario = new ArrayList<CountDownLatch>(20);
    ArrayList<String> listaPacientes = new ArrayList<String>();
    ArrayList<String> listaPacientesReaccion = new ArrayList<String>();
    ArrayList<String> listaSanitarios = new ArrayList<String>();
    int maxPuestos = 20;
    Lock cerrojoSanitarios = new ReentrantLock();
    Lock cerrojoPacientesReaccion = new ReentrantLock();
    Lock cerrojoPacientes = new ReentrantLock();

    public SalaObservacion() {
        for (int i = 0; i < maxPuestos; i++) {
            this.listaSanitarios.add(null);
            this.listaPacientes.add(null);
        }
    }

    private void inicilizarEsperaPorSanitario() {
        for (int i = 0; i < maxPuestos; i++) {
            esperaPorSanitario.add(new CountDownLatch(1));
        }
    }

    public void llegaSanitario(String id_sanitario) {
        int posicion = 0;
        cerrojoPacientesReaccion.lock();
        for (int i = 0; i < listaPacientesReaccion.size(); i++) {
            if (listaPacientesReaccion.get(i) != "") {
                posicion = i;
                listaPacientesReaccion.set(i, "");
                break;
            }
        }

        cerrojoPacientesReaccion.unlock();

        cerrojoSanitarios.lock();
        listaSanitarios.set(posicion, id_sanitario);
        cerrojoSanitarios.unlock();

        //Curo y despierto al paciente para que se pueda ir
        Aleatoriedad.EsperaAleatoria(2000, 5000);
        String id_paciente = listaPacientes.get(posicion);
        Logg.insertarEnLog("Paciente " + id_paciente + " sufre una reacción y es atendido por " + id_sanitario);
        System.out.println("Paciente " + id_paciente + " sufre una reacción y es atendido por " + id_sanitario);
        esperaPorSanitario.get(posicion).countDown();

        marchaSanitario(posicion, id_sanitario);
    }

    private void marchaSanitario(int posicion, String id_sanitario) {
        cerrojoSanitarios.lock();
        listaSanitarios.set(posicion, null);
        cerrojoSanitarios.unlock();
        //System.out.println("Sanitario " + id_sanitario + " se va de box " + (posicion + 1) );
    }

    public void llegadaPaciente(String id_paciente, Controlador controlador) {
        cerrojoPacientes.lock();
        int posicion = listaPacientes.indexOf(null);
        listaPacientes.set(posicion, id_paciente);
        cerrojoPacientes.unlock();

        //System.out.println("Paciente " + id_paciente + " ha entrado en la sala de Observación");
        Logg.insertarEnLog("Paciente " + id_paciente + " viene al box " + (posicion + 1));
        //System.out.println("Paciente " + id_paciente + " viene al box " + (posicion + 1) );
        try {
            controlador.SemaforoSalaVacunacion.release();
        } catch (Exception exc) {
            System.out.println(exc);
        }

        if (!SufreReaccion()) {
            marchaPaciente(id_paciente, posicion);
        } else {

            if (listaPacientesReaccion.size() == 0) {
                inicializarListaPacientesReaccion();
            }
            listaPacientesReaccion.set(posicion, id_paciente);
            if (esperaPorSanitario.size() == 0) {
                inicilizarEsperaPorSanitario();
            }
            esperaPorSanitario.set(posicion, new CountDownLatch(1));
            try {
                esperaPorSanitario.get(posicion).await();

            } catch (Exception exc) {
                System.out.println(exc);
            }

            marchaPaciente(id_paciente, posicion);
        }
    }

    private void marchaPaciente(String id_paciente, int posicion) {
        cerrojoPacientes.lock();
        listaPacientes.set(posicion, null);

        cerrojoPacientes.unlock();

        //System.out.println("Paciente " + id_paciente + " se va de box " + (posicion + 1) );
        Logg.insertarEnLog("Paciente " + id_paciente + " se va de box " + (posicion + 1));

    }

    public boolean IrSalaObservacion() {
        cerrojoPacientesReaccion.lock();
        boolean resultado = false;
        for (int i = 0; i < listaPacientesReaccion.size(); i++) {
            if (!listaPacientesReaccion.get(i).equals("")) {
                resultado = true;
                break;
            }
        }
        cerrojoPacientesReaccion.unlock();
        return resultado;
    }

    private boolean SufreReaccion() {
        Aleatoriedad.EsperaAleatoria(10000, 10000);
        return Aleatoriedad.Porcentaje(5) ? true : false;
    }

    private void inicializarListaPacientesReaccion() {
        for (int i = 0; i < 20; i++) {
            listaPacientesReaccion.add("");
        }
    }
}
