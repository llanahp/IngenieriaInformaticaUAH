public class Aleatoriedad {

    public static void EsperaAleatoria(int minimo, int maximo) {//incluidos los numeros pasados
        try {
            Thread.sleep(NumeroAleatorio(minimo, maximo));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int NumeroAleatorio(int minimo, int maximo) {//incluidos los numeros pasados por referencia

        return (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
    }

    public static boolean Porcentaje(int porcentaje) {//1000 = 1segundo
        return NumeroAleatorio(1, 100) <= porcentaje ? true : false;
    }
}
