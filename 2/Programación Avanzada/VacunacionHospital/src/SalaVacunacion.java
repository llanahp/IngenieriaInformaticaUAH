
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalaVacunacion {
    
    ArrayList<String> boxInterrupido = new ArrayList<String>();
    ArrayList<String> listaPacientes = new ArrayList<String>();
    ArrayList<String> listaSanitarios = new ArrayList<String>();
    Lock cerrojoSanitario = new ReentrantLock();
    Lock cerrojoPacientes = new ReentrantLock();
    ArrayList<Semaphore> listaPacientesRestantes = new ArrayList<>(10);
    
    public boolean EspacioDisponible() {
        boolean resultado = false;
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (listaPacientes.get(i) == null) {
                resultado = true;
            }
        }
        return resultado;
    }
    
    public SalaVacunacion() {
        inicializarListaPacientes();
    }
    
    public void inicializarArraylist() {
        for (int i = 0; i < 10; i++) {
            listaPacientesRestantes.add(new Semaphore(15));
        }
    }
    
    public void inicializarListaPacientes() {
        for (int i = 0; i < 10; i++) {
            this.boxInterrupido.add(null);
            this.listaSanitarios.add(null);
            this.listaPacientes.add("Inoperativo");
        }
    }
    
    public void llegaSanitario(String id_Sanitario) {
        cerrojoSanitario.lock();
        int posicion = listaSanitarios.indexOf(null);
        listaSanitarios.set(posicion, id_Sanitario);
        listaPacientes.set(posicion, null);
        cerrojoSanitario.unlock();
        Logg.insertarEnLog("Sanitario " + id_Sanitario + " acude al  box " + (posicion + 1));
        //System.out.println("Sanitario " + id_Sanitario + " acude al  box " + (posicion + 1));
        try {
            if (listaPacientesRestantes.size() == 0) {
                inicializarArraylist();
            }
            listaPacientesRestantes.set(posicion, new Semaphore(0));
            
            listaPacientesRestantes.get(posicion).acquire(15);
            if (boxInterrupido.get(posicion) != null) {
                boxInterrupido.set(posicion, null);
                marchaSanitarioForzosa(id_Sanitario, posicion);
            } else {
                marchaSanitario(posicion, id_Sanitario);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
    }
    
    public void marchaSanitario(int posicion, String id_sanitario) {
        cerrojoSanitario.lock();
        listaSanitarios.set(posicion, null);
        listaPacientes.set(posicion, "Inoperativo");
        cerrojoSanitario.unlock();
        //System.out.println("Sanitario " + id_sanitario + " se va de box " + (posicion + 1));
    }
    
    public void marchaSanitarioForzosa(String id_Sanitario, int posicion) {
        cerrojoSanitario.lock();
        listaSanitarios.set(posicion, null);
        listaPacientes.set(posicion, "Inoperativo");
        cerrojoSanitario.unlock();
        //System.out.println("Sanitario " + id_Sanitario + " se va de box " + (posicion + 1));
    }
    
    public void llegadaPaciente(String id_paciente, Controlador controlador) {
        cerrojoPacientes.lock();
        int posicion;
        do {
            if (listaPacientes.size() == 0) {
                inicializarListaPacientes();
            }
            posicion = listaPacientes.indexOf(null);
            if (posicion == -1) {
                Aleatoriedad.EsperaAleatoria(1000, 1000);
            } else {
                listaPacientes.set(posicion, id_paciente);
            }
        } while (posicion == -1);
        cerrojoPacientes.unlock();
        
        Logg.insertarEnLog("Paciente " + id_paciente + " acude al box " + (posicion + 1));
        //System.out.println("Paciente " + id_paciente + " acude al box " + (posicion + 1));
        try {
            controlador.SemaforoColaEspera.release();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        try {
            controlador.vacunasDisponibles.acquire();
            Aleatoriedad.EsperaAleatoria(3000, 5000);
            String idSanitario = listaSanitarios.get(posicion);
            Logg.insertarEnLog("Paciente " + id_paciente + " vacunado en el puesto " + (posicion + 1) + " por " + idSanitario);
            System.out.println("Paciente " + id_paciente + " vacunado en el puesto " + (posicion + 1) + " por " + idSanitario);
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaVacunacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrojoPacientes.lock();
        listaPacientes.set(posicion, null);
        cerrojoPacientes.unlock();
        //System.out.println("Paciente " + id_paciente + " se va de box " + (posicion + 1));
        listaPacientesRestantes.get(posicion).release();
        
    }
    
}
