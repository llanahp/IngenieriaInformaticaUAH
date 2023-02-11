import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Logger {

    private static void crearLog(String Operacion) throws IOException {
        FileWriter archivo;

        //Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
        if (new File("evolucionHospital.txt").exists() == false)
            archivo = new FileWriter(new File("evolucionHospital.txt"), false);

        archivo = new FileWriter(new File("evolucionHospital.txt"), true);

        Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar

        archivo.write("[" + (String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                + "/" + String.valueOf(fechaActual.get(Calendar.MONTH) + 1)
                + "/" + String.valueOf(fechaActual.get(Calendar.YEAR))
                + "] [" + String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                + ":" + String.valueOf(fechaActual.get(Calendar.MINUTE))
                + ":" + String.valueOf(fechaActual.get(Calendar.SECOND))) + "] " + Operacion + "\r\n");

        archivo.close(); //Se cierra el archivo
    }


    public static void insertarEnLog(String cadena) {
        try {
            Logger.crearLog(cadena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
