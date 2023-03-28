/* ========================================================== INCLUDES =========================================================== */

#include <Stepper.h>  //motor paso a paso
#include <ESP32Servo.h>  //servomotor

#include <WiFi.h>  //conexión Wi-Fi
#include <PubSubClient.h>  //conexión MQTT, de tipo PubSub

#include "string.h"

/* ========================================================== DEFINES =========================================================== */

#define IN1 19
#define IN2 18
#define IN3 5
#define IN4 17

#define pinServo 33
#define minServo 1000
#define maxServo 2000

#define pinBoton0 14
#define pinBoton1 27

#define pinFotoresistorCero 32 //superior izquierda
#define pinFotoresistorUno 35 //superior derecha
#define pinFotoresistorDos 34 //inferior izquierda
#define pinFotoresistorTres 36 //inferior derecha

#define pinPanelSolar 39

/* ========================================================== CONSTANTES GLOBALES =========================================================== */

const int diferenciaValoresSensoresDetectarGiro = 17; //valor de diferencia en cual se discrimina qué sensor detecta luz y su contrario no
const int stepsPerRevolution = 2048;  //número de pasos por paso del servomotor

/* ========================================================== VARIABLES GLOBALES =========================================================== */

int valores_fotoresistores[] = { 0, 0, 0, 0 }; //array de enteros para almacenar los valores de los fotoresistores
int gradosMotorPlaca = 0; //grados en los que está inclinados la placa
int estadoFuncionamiento = 0;

/* ========================================================== OBJETOS GLOBALES =========================================================== */

Stepper motorBase(stepsPerRevolution, IN1, IN3, IN2, IN4); //objeto motor paso a paso
Servo motorPlaca; //objeto servomotor

TaskHandle_t Task1; //manejador de la tarea 1 en paralelo
TaskHandle_t Task2; //manejador de la tarea 2 en paralelo

/* ========================================================== SETUP =========================================================== */

void setup(){

  //inicialización de los modos de ciertos pines en concreto
  pinMode(pinBoton0, INPUT_PULLDOWN);
  pinMode(pinBoton1, INPUT_PULLDOWN);
  pinMode(pinPanelSolar, INPUT);  //necesario, sino el pin provoca ciertos problemas con la placa

  //ajuste del motor paso a paso
  motorBase.setSpeed(5);

  //ajuste del servomotor
  motorPlaca.attach(pinServo, minServo, maxServo);
	motorPlaca.write(180-gradosMotorPlaca);

  //inicialización del puerto en serie
  Serial.begin(115200);

  //creación e inicialización de las tareas en paralelo
  crearTarea1();
  crearTarea2(); 
  
  //espera antes de comenzar el bucle
  delay(500);

}

/* ========================================================== LOOP =========================================================== */

void loop(){

  if( estadoFuncionamiento == 0 ){
    if( deboGirarHorario() ){ girarBase1GradoHorario(); }
    if( deboGirarAntihorario() ){ girarBase1GradoAntihorario(); }
  }

}

/* ============================= FUNCIONES UTILIZADAS PARA LOS SENSORES, ACTUADORES Y PULSADORES ============================= */

void actualizarValorFotoresistores(){
  //actualiza el valor de los fotoresistores en el array int valores_fotoresistores[], llamando a la función valSensor()
  for( int i = 0; i < 4; i++ ){ valores_fotoresistores[i] = valSensor(i); }
}

bool deboGirarArriba(){
  //devuelve true si se debe girar la placa hacia arriba, y false en caso contrario
	return ( valSensor(0) - valSensor(2) > diferenciaValoresSensoresDetectarGiro ) || ( valSensor(1) - valSensor(3) > diferenciaValoresSensoresDetectarGiro );
}

bool deboGirarAbajo(){
  //devuelve true si se debe girar la placa hacia abajo, y false en caso contrario
	return ( valSensor(2) - valSensor(0) > diferenciaValoresSensoresDetectarGiro ) || ( valSensor(3) - valSensor(1) > diferenciaValoresSensoresDetectarGiro );
}

bool deboGirarHorario(){
  //devuelve true si se debe girar la la base en sentido horario, y false en caso contrario
	return ( valSensor(0) - valSensor(1) > diferenciaValoresSensoresDetectarGiro ) || ( valSensor(2) - valSensor(3) > diferenciaValoresSensoresDetectarGiro );
}

bool deboGirarAntihorario(){
  //devuelve true si se debe girar la la base en sentido antihorario, y false en caso contrario
	return ( valSensor(1) - valSensor(0) > diferenciaValoresSensoresDetectarGiro ) || ( valSensor(3) - valSensor(2) > diferenciaValoresSensoresDetectarGiro );
}

long valSensor( int id ){
	/*
    mirando de frente la placa de fotoresistores:
	    id = 0 -> superior izquierda
	    id = 1 -> superior derecha
	    id = 2 -> inferior izquierda
	    id = 3 -> inferior derecha
  */
	switch(id){
		case 0: return map( analogRead( pinFotoresistorCero ), 0, 4095, 0, 100 );
		case 1: return map( analogRead( pinFotoresistorUno ), 0, 4095, 0, 100 );
		case 2: return map( analogRead( pinFotoresistorDos ), 0, 4095, 0, 100 );
		case 3: return map( analogRead( pinFotoresistorTres ), 0, 4095, 0, 100 );
	}
	return -1;
}

int valPanelSolar(){
  //devuelve el valor en voltios, con dos decimales, de la tensión generada por la placa solar
  return analogRead(pinPanelSolar);
}

void girarBase1GradoAntihorario(){
	//gira el motor de la base en sentido antihorario si no se pasa del tope
	if( digitalRead(pinBoton0) == LOW ){
		motorBase.step(6); //valores positivos en sentido antihorario; valores negativos en sentido horario
    delay(3);
	}
}

void girarBase1GradoHorario(){
	//gira el motor de la base en sentido horario si no se pasa del tope
	if( digitalRead(pinBoton1) == LOW ){
		motorBase.step(-6); //valores positivos en sentido antihorario; valores negativos en sentido horario
    delay(3);
	}
}

void girarPlaca1GradoArriba(int ret){
	//gira el motor de la placa hacia arriba si no sobrepasa la inclinación de 90º
	if( gradosMotorPlaca < 90 ){
		gradosMotorPlaca += 1;
		motorPlaca.write( 180-gradosMotorPlaca*2 );
    vTaskDelay(pdMS_TO_TICKS(ret));
	}
}

void girarPlaca1GradoAbajo(int ret){
	//gira el motor de la placa hacia abajo si no sobrepasa la inclinación de 0º
	if( gradosMotorPlaca > 0 ){
		gradosMotorPlaca -= 1;
		motorPlaca.write( 180-gradosMotorPlaca*2 );
    vTaskDelay(pdMS_TO_TICKS(ret));
	}
}

/* =============================================================================== TAREA ENCARGADA DEL MOVIMIENTO DEL SERVOMOTOR =================================================================== */

void crearTarea1(){
  /* Creación e inicialización de la tarea 1 */
  xTaskCreatePinnedToCore(
    tarea1,     //task function
    "tarea1",   //name of tast
    10000,      //stack size of task
    NULL,       //task parameters
    1,          //task priority
    &Task1,     //task handle to keep track of created task
    0           //pin task to core 0
  );
}

void tarea1( void *parametros ){
  /* Función llamada al crear la tarea 1 */
  vTaskDelay(pdMS_TO_TICKS(1000));
  while(1){

    if( estadoFuncionamiento == 0 ){
      if( deboGirarArriba() ){ girarPlaca1GradoArriba(30); }
      if( deboGirarAbajo() ){ girarPlaca1GradoAbajo(30); }
    } else if ( estadoFuncionamiento == 1 ){ 
      if( gradosMotorPlaca < 91 ){
        girarPlaca1GradoArriba(30);
      }
    }
    vTaskDelay(pdMS_TO_TICKS(10));
  }
}

/* =============================================================================== TAREA DE CONEXIÓN Y GESTIÓN DE COMUNICACIÓN CON BROKER =================================================================== */

void crearTarea2(){
  /* Creación e inicialización de la tarea 2 */
  xTaskCreatePinnedToCore(
    tarea2,     //task function
    "tarea2",   //name of tast
    10000,      //stack size of task
    NULL,       //task parameters
    1,          //task priority
    &Task2,     //task handle to keep track of created task
    1           //pin task to core 1
  );
}

void tarea2( void *parametros ){
  /* Función llamada al crear la tarea 2 */

  // WiFi
  const char *ssid = ""; // Enter your WiFi name
  const char *password = "";  // Enter WiFi password

  // MQTT Broker
  const char *mqtt_broker = "broker.emqx.io";
  const char *topic = "cu2022G8/placa1_recibir";
  const char *mqtt_username = "emqx";
  const char *mqtt_password = "public";
  const int mqtt_port = 1883;

  WiFiClient espClient;
  PubSubClient client(espClient);

  // connecting to a WiFi network
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
      vTaskDelay(pdMS_TO_TICKS(500));
      Serial.println("Connecting to WiFi..");
  }
  Serial.println("Connected to the WiFi network");

  //connecting to a mqtt broker
  client.setServer(mqtt_broker, mqtt_port);
  client.setCallback(callback);
  while (!client.connected()) {
      String client_id = "esp32-client-";
      client_id += String(WiFi.macAddress());
      Serial.printf("The client %s connects to the public mqtt broker\n", client_id.c_str());
      if (client.connect(client_id.c_str(), mqtt_username, mqtt_password)) {
          Serial.println("Public emqx mqtt broker connected");
      } else {
          Serial.print("failed with state ");
          Serial.print(client.state());
          vTaskDelay(pdMS_TO_TICKS(2000));
      }
  }

  // publish and subscribe
  client.publish(topic, "Hi EMQX I'm ESP32 ^^");
  client.subscribe(topic);

  int cnt = 0;
  char buff[5];

  while(1){
    actualizarValorFotoresistores();
    client.loop();
    vTaskDelay(pdMS_TO_TICKS(2000));
    
    //esto debe contener la info de los sensores
    String car = "";
    for(int i = 0; i < 4; i++){ car += String(valores_fotoresistores[i])+"-"; }
    float val_panel = (float) valPanelSolar() / (float) 1241;
    snprintf (buff, sizeof(buff), "%f", val_panel);
    car += String(buff)+"-";
    car += String(gradosMotorPlaca);
    char datos[car.length() + 1];
    car.toCharArray(datos, car.length() + 1);

    client.publish("cu2022G8/placa1_enviar",datos);
  }
}

void callback(char *topic, byte *payload, unsigned int length) {
  /* Función llamada al recibir un mensaje de un topic, donde se gestiona el control de la placa */
  char buff[length+1];
  for (int i = 0; i < length; i++) { buff[i] = (char) payload[i]; }
  buff[length] = '\0';
  
  if( strcmp( buff, "parar") == 0 ){
    estadoFuncionamiento = 1;
    Serial.println("Ahora la placa se situará en la posición de parado");
  }

  if( strcmp( buff, "seguir") == 0 ){
    estadoFuncionamiento = 0;
    Serial.println("Ahora la placa volverá a su funcionamiento normal");
  }
  
}
