
public class Sanitario extends Thread {

    String id = "S";
    Controlador controlador;

    public Sanitario(int numeroId, Controlador controlador) {
        asignarID(numeroId);
        this.controlador = controlador;
    }

    private void asignarID(int numeroId) {
        if (numeroId < 10) {
            this.id = id + "0" + numeroId;
        } else {
            this.id = id + "" + numeroId;
        }
    }

    public String idSanitario() {
        return this.id;
    }

    public void run() {
        Aleatoriedad.EsperaAleatoria(1000, 3000);//cambiar de ropa
        
            controlador.EntraSanitario(id);
        
    }
    
}
