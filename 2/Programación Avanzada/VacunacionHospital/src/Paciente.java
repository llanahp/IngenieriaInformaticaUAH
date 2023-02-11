
public class Paciente extends Thread {
    private String id = "P";
    private Controlador controlador;

    public Paciente(int numeroId, Controlador controlador) {
        asignarID(numeroId);
        this.controlador = controlador;
    }

    private void asignarID(int numeroId) {
        String numeroCifras = Integer.toString(numeroId);
        switch (numeroCifras.length()) {
            case 1:
                this.id = id + "000" + numeroId;
                break;
            case 2:
                this.id = id + "00" + numeroId;
                break;
            case 3:
                this.id = id + "0" + numeroId;
                break;
            case 4:
                this.id = id + numeroId;
                break;
        }

    }


    public String GetIdPaciente() {
        return this.id;
    }

    public void run() {
        Logg.insertarEnLog("Llega paciente " + GetIdPaciente());
        System.out.println("Llega paciente " + GetIdPaciente());
        controlador.EntraPaciente(GetIdPaciente());
        Logg.insertarEnLog("Paciente " + GetIdPaciente() + " sale del hospital");
        System.out.println("Paciente " + GetIdPaciente() + " sale del hospital");
    }
}
