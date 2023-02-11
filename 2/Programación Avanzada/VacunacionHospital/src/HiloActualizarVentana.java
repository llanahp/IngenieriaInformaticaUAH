
public class HiloActualizarVentana extends Thread {

    Ventana ventana;

    public HiloActualizarVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    public void run() {
        while (true) {
            Aleatoriedad.EsperaAleatoria(1000, 1000);
            ventana.ActualizarVentana();
        }
    }

}
