
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        try {
            Controlador controlador = new Controlador();

            Registry registry = LocateRegistry.createRegistry(1099); //Arranca rmiregistry local en el puerto 1099
            Naming.rebind("//127.0.0.1/ObjetoSaluda", controlador); //Hace visible el objeto para clientes

            Ventana ventana = new Ventana();
            ventana.setVisible(true);

            //Auxiliares
            Auxiliar auxiliar1 = new Auxiliar(1, controlador);
            auxiliar1.start();
            Auxiliar auxiliar2 = new Auxiliar(2, controlador);
            auxiliar2.start();

            //Sanitarios
            Sanitario sanitario;
            for (int i = 1; i < 11; i++) {
                sanitario = new Sanitario(i, controlador);
                sanitario.start();
            }

            //Pacientes
            Paciente paciente;
            for (int i = 1; i < 2001; i++) {
                Aleatoriedad.EsperaAleatoria(1000, 3000);
                paciente = new Paciente(i, controlador);
                paciente.start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
