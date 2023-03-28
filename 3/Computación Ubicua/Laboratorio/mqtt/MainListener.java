import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public class MainListener {
    static MqttAsyncClient myClient;

    public static void mqtt() {
        try {
            String ruta = "tcp://broker.emqx.io:1883";
            myClient = new MqttAsyncClient(ruta, UUID.randomUUID().toString());

            MyCallback mycallback = new MyCallback();

            myClient.setCallback(mycallback);

            //establecer conexion con mosquito
            IMqttToken token = myClient.connect();
            //Esperar a que se conecte mosquito
            token.waitForCompletion();
            //me suscribo al topic
            myClient.subscribe("cu2022G8/#", 0);
        } catch (Exception exc) {
            System.out.println("error mqtt");
        }
    }


    public static void main(String[] args) {

        mqtt();
    }
}
