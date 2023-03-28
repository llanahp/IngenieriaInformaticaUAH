import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MyCallback implements MqttCallback {

    public String getFecha() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (sdf.format(dt));
    }

    public void JavaToBBDD(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://testinstance.cu852n4mo2tc.us-east-1.rds.amazonaws.com/placas?autoReconnect=true&useSSL=false";
            String userId = "root";
            String password = "rootroot";
            Connection conn = DriverManager.getConnection(connectionUrl, userId, password);
            //System.out.println("Connection to DB done!!!");
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            System.out.println(e);
        }

    }

    @Override
    public void connectionLost(Throwable cause) {


    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        if (topic.equals("cu2022G8/placa2s") == true) {
            //String ID=topic.substring(9);
            String ID = "1";
            String[] parts = message.toString().split("-");
            String sensor1 = parts[0];
            String sensor2 = parts[1];
            String sensor3 = parts[2];
            String sensor4 = parts[3];
            String sensor5 = parts[4];
            String fecha = getFecha();
            String query = "INSERT INTO placa VALUES (" + sensor1 + "," + sensor2 + "," + sensor3 + "," + sensor4 + "," + sensor5 + "," + ID + ",'" + fecha + "');";
            //System.out.println(query);
            JavaToBBDD(query);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {


    }

}
