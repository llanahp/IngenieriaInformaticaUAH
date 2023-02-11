
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Controlador extends UnicastRemoteObject implements InterfacInformacion {

    String puestoAuxiliarEntrada = "", puestoAuxiliarVacunas = "", salaDescando = "", pacienteEntrada = "", colaEntrada = "";
    Semaphore SemaforoColaEspera = new Semaphore(1, true);
    Semaphore SemaforoSalaVacunacion = new Semaphore(10, true);
    Semaphore SemaforoSalaObservación = new Semaphore(20, true);
    Semaphore vacunasDisponibles = new Semaphore(0);
    SalaVacunacion salaVacunacion = new SalaVacunacion();
    SalaObservacion salaObservacion = new SalaObservacion();
    Exchanger<Boolean> EsperaSalaEntrada = new Exchanger();
    ArrayList<Boolean> PuestoNecesitanSanitario = new ArrayList<Boolean>(20);
    Lock cerrojoSalaDescanso = new ReentrantLock();

    Controlador() throws RemoteException {

    }

    public Informacion getInformacion(ArrayList<String> cierreDePuestos) {
        ArrayList<Boolean> puestosVacunacionCerrados = new ArrayList<Boolean>(10);
        for (int i = 0; i < cierreDePuestos.size(); i++) {
            if (!cierreDePuestos.get(i).equals("")) {
                System.out.println("Tengo que cerrar el puesto " + (i + 1));
                salaVacunacion.boxInterrupido.set(i, ".");
                salaVacunacion.listaPacientesRestantes.get(i).release(15 - salaVacunacion.listaPacientesRestantes.get(i).availablePermits());
                salaVacunacion.listaPacientes.set(i, null);
                salaVacunacion.listaSanitarios.set(i, null);
                salaVacunacion.listaPacientes.set(i, "Inoperativo");
                puestosVacunacionCerrados.add(false);
            } else {
                puestosVacunacionCerrados.add(true);
            }
        }
        Informacion info = new Informacion();
        info.puestosVacunacionCerrados = puestosVacunacionCerrados;
        info.salaDescando = salaDescando;
        info.colaEntrada = colaEntrada;
        info.vacunasDisponibles = vacunasDisponibles.availablePermits() + "";
        info.puestoAuxiliarEntrada = puestoAuxiliarEntrada;
        info.puestoAuxiliarVacunas = puestoAuxiliarVacunas;
        info.pacienteEntrada = pacienteEntrada;
        info.puestoNecesitanSanitario = getPuestosNecesitanVacunacion();
        inicializarArrayListInformacion(info);
        insertarPuestosVacunacion(info);
        insertarPuestosObservacion(info);

        return info;

    }

    private void insertarPuestosObservacion(Informacion info) {
        if (salaObservacion.listaPacientes.size() != 0 && salaObservacion.listaSanitarios.size() != 0) {
            for (int i = 0; i < salaObservacion.listaSanitarios.size(); i++) {
                if (salaObservacion != null && salaObservacion.listaSanitarios != null && salaObservacion.listaPacientes != null) {
                    if (salaObservacion.listaPacientes.get(i) != null) {
                        if (salaObservacion.listaSanitarios.get(i) != null) {
                            String puesto = salaObservacion.listaSanitarios.get(i) + ", " + salaObservacion.listaPacientes.get(i);
                            info.puestosObservacion.set(i, puesto);
                        } else {
                            info.puestosObservacion.set(i, salaObservacion.listaPacientes.get(i));
                        }
                    }
                } else {
                    info.puestosObservacion.set(i, "");

                }
            }
        }
    }

    private void insertarPuestosVacunacion(Informacion info) {
        if (salaVacunacion.listaPacientes.size() != 0 && salaVacunacion.listaSanitarios.size() != 0) {
            for (int i = 0; i < salaVacunacion.listaSanitarios.size(); i++) {
                if (salaVacunacion != null && salaVacunacion.listaSanitarios != null && salaVacunacion.listaPacientes != null) {
                    if (salaVacunacion.listaSanitarios.get(i) != null) {
                        if (salaVacunacion.listaPacientes.get(i) != "Inoperativo") {
                            if (salaVacunacion.listaPacientes.get(i) != null) {
                                String puesto = salaVacunacion.listaSanitarios.get(i) + ", " + salaVacunacion.listaPacientes.get(i);
                                info.puestosVacunacion.set(i, puesto);
                            } else {
                                info.puestosVacunacion.set(i, salaVacunacion.listaSanitarios.get(i));
                            }
                        } else {
                            info.puestosVacunacion.set(i, salaVacunacion.listaSanitarios.get(i));
                        }
                    }
                } else {
                    info.puestosVacunacion.set(i, "");

                }
            }
        }
    }

    private void inicializarArrayListInformacion(Informacion info) {
        if (info.puestosVacunacion == null) {
            info.puestosVacunacion = new ArrayList<>();
        }
        if (info.puestosVacunacion.size() == 0) {
            for (int i = 0; i < 10; i++) {
                info.puestosVacunacion.add("");
            }
        }
        if (info.puestosObservacion == null) {
            info.puestosObservacion = new ArrayList<>();
        }
        if (info.puestosObservacion.size() == 0) {
            for (int i = 0; i < 20; i++) {
                info.puestosObservacion.add("");
            }
        }
    }

    private void actulizarSalidaSalaEspera(String idPaciente) {
        if (colaEntrada.startsWith(idPaciente)) {
            if (colaEntrada.startsWith(idPaciente + ", ")) {
                colaEntrada = colaEntrada.replace(idPaciente + ", ", "");
            } else {
                colaEntrada = colaEntrada.replace(idPaciente, "");
            }
        } else {
            colaEntrada = colaEntrada.replace(", " + idPaciente, "");
        }
    }

    public void EntraPaciente(String idPaciente) {

        try {
            if (colaEntrada.equals("")) {
                colaEntrada = idPaciente;
            } else {
                colaEntrada = colaEntrada + ", " + idPaciente;
            }

            SemaforoColaEspera.acquire();

            actulizarSalidaSalaEspera(idPaciente);
            pacienteEntrada = idPaciente;
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        if (DebeEntradaHospital(idPaciente)) {
            //Espero hasta que haya hueco en la sala de vacunación
            ExisteEspacioSalaVacunacion(idPaciente);

            //El paciente ya está vacunado y espra a tener hueco en la sala de observacion
            ExisteEspacioSalaObservacion(idPaciente);

        } else {
            //La persona no tiene que entrar al hospital
            Logg.insertarEnLog("Paciente " + idPaciente + " ha acudido sin cita");

            SemaforoColaEspera.release();
            pacienteEntrada = "";

        }

    }

    public void EntraSanitario(String idSanitario) {
        while (true) {
            //mirar si necesita ir a observacion o vacunacion
            if (salaObservacion.IrSalaObservacion()) {
                salaObservacion.llegaSanitario(idSanitario);
                EntraDescansar(idSanitario, "Sanitario");
                SaleDescansar(idSanitario, "Sanitario");

            } else {
                salaVacunacion.llegaSanitario(idSanitario);
                EntraDescansar(idSanitario, "Sanitario");
                Aleatoriedad.EsperaAleatoria(5000, 8000);
                SaleDescansar(idSanitario, "Sanitario");
            }
        }

    }

    public void EntraDescansar(String id, String tipo) {
        cerrojoSalaDescanso.lock();
        if (salaDescando.equals("")) {
            salaDescando = id;
        } else {
            salaDescando = salaDescando + ", " + id;
        }
        Logg.insertarEnLog(tipo + " " + id + " comienza su descanso");
        cerrojoSalaDescanso.unlock();

    }

    public void SaleDescansar(String id, String tipo) {
        cerrojoSalaDescanso.lock();
        if (salaDescando.startsWith(id)) {
            if (salaDescando.startsWith(id + ", ")) {
                salaDescando = salaDescando.replace(id + ", ", "");
            } else {
                salaDescando = salaDescando.replace(id, "");
            }
        } else {
            salaDescando = salaDescando.replace(", " + id, "");
        }
        Logg.insertarEnLog(tipo + " " + id + " termina su descanso");
        cerrojoSalaDescanso.unlock();
    }

    public void AuxiliarVacunas() {
        vacunasDisponibles.release();
    }

    public void AuxiliarEntrada() {
        if (SemaforoSalaVacunacion.tryAcquire()) {
            Aleatoriedad.EsperaAleatoria(500, 1000);
            try {
                EsperaSalaEntrada.exchange(Aleatoriedad.Porcentaje(1) ? false : true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void ExisteEspacioSalaVacunacion(String idPaciente) {
        try {
            SemaforoSalaVacunacion.acquire();

        } catch (Exception exc) {
            System.out.println(exc);
        }
        salaVacunacion.llegadaPaciente(idPaciente, this);

    }

    private void ExisteEspacioSalaObservacion(String idPaciente) {
        try {
            SemaforoSalaObservación.acquire();
            SemaforoSalaVacunacion.release();
        } catch (Exception exc) {
            System.out.println(exc);
        }
        //¿release de salavacunacion?
        salaObservacion.llegadaPaciente(idPaciente, this);
        SemaforoSalaObservación.release();

    }

    private boolean DebeEntradaHospital(String idPaciente) {
        boolean resultado = false;
        try {
            resultado = EsperaSalaEntrada.exchange(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!resultado) {
            Logg.insertarEnLog("Paciente " + idPaciente + " ha acudido sin cita");
        }
        return resultado;
    }

    private ArrayList<Boolean> getPuestosNecesitanVacunacion() {
        ArrayList<Boolean> arrayVolver = new ArrayList<>(20);
        for (int i = 0; i < salaObservacion.listaPacientesReaccion.size(); i++) {
            if (salaObservacion.listaPacientesReaccion.get(i) != "") {
                arrayVolver.add(true);
            } else {
                arrayVolver.add(false);

            }

        }
        return arrayVolver;
    }

}
