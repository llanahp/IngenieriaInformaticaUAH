Placa solar orientable PEC1
Alejandro Fuentetaja Simón, Raúl López Llana, Álvaro Radajczyk Sánchez, David Romero Oñoro
Computación Ubicua 2022-2023
Grado en Ingeniería Informática
alvaro.radajczyk@edu.uah.es,  raul.lopez@edu.uah.es, alejandro.fuentetaja@edu.uah.es, d.romeroo@edu.uah.es
Resumen. Este proyecto tiene como objetivo dar a conocer una nueva forma de instalar placas solares para poder exprimir al máximo su rendimiento y poder así obtener la mayor cantidad de energía posible durante el día. Para esto, las placas son orientadas de forma automática hacia la posición donde pueden obtener más energía. Junto a este avance se le suma la solución a un problema común que es la limpieza de las placas. Por ello hemos incorporado una función en la que se facilita al usuario la limpieza de estas para que puedan seguir aportando la mayor cantidad de energía posible.
Palabras clave: Placas solares, Orientable, Sol, Energía, Automatización, Limpieza, Sostenible, Arduino, Servidor, Sensores.
1.	Introducción

El desarrollo de las células solares (nombre correcto de los paneles solares) comenzó en 1839 con el físico francés Antoine-Cesar Becquerel, quien descubrió el efecto fotovoltaico, proceso por el cual se puede transformar la luz en corriente eléctrica. No fue hasta 1883 que se construiría el primer panel solar, por Charles Fritz. Tras muchos años de avances tecnológicos, se llegó a la idea de aumentar la eficacia de los paneles solares mediante un seguimiento de la luz solar mediante un sistema de tracking del sol que intenta que los rayos solares impacten en las células solares perpendicularmente. Existen dos tipos de sistemas de seguimiento, pasivos y activos: los pasivos emplean la expansión de un gas contenido en una cámara bajo los paneles solares que ajustan la posición sin apenas necesidad de ningún actuador, mientras que los sistemas activos poseen una serie de sensores fotovoltaicos que detectan la luz solar y mediante actuadores, ajustan la posición de la placa solar.
En la actualidad, la población está cada vez más concienciada de que el uso de energías limpias es el futuro. Por eso mismo debemos buscar la forma de que sean lo más eficientes posibles y puedan dotarnos de toda la energía que necesitamos a diario. Con esta premisa hemos querido aportar nuestro grano de arena creando un proyecto de placas solares orientables para poder optimizar al máximo la energía que recibimos del sol.
2.	Análisis del problema
Como ya es sabido por todos el uso de energías limpias se encuentra en pleno auge debido a sus grandes beneficios. Por esto mismo en la actualidad existen varias propuestas de mejora relacionadas con las placas solares como la creación de placas con distintos componentes[1]. De la mano de este tipo de avances se encuentra la creación de plantas solares que aumentan la cantidad de energía obtenida y permiten suministrar de energía a grandes empresas [2]. 
Todo esto es una gran mejora respecto a décadas anteriores pero nosotros queremos ir un paso más allá e intentar que estas plantas sean más eficientes de lo que ya son y que a nivel particular se pueda obtener un mayor rendimiento. Con este objetivo en la cabeza decidimos buscar diferentes prototipos [3] y aportar una mejora que destaque sobre el resto. En la actualidad existen 2 tipos de implementación de placas solares. Las fijas y las que se mueven 180 grados. 
Rápidamente nos dimos cuenta que en determinados casos este tipo de implementación podía llegar a no ser tan beneficiosa como puede parecer por lo que pensamos en la siguiente idea. Crear una placa solar que se pudiesen mover 360 grados y junto a esto, que den la posibilidad de poder limpiarlas de una manera fácil y sencilla. 
3.	Objetivos y alcance del proyecto
En nuestro estudio del mercado hemos hallado un espacio comercial reducido, lo cual es bueno para nuestro proyecto, esto se traduce en un alto potencial para este proyecto y una reducida competencia, las condiciones idóneas para una fuerte apuesta mercantil. La mayor parte de compañías que consideramos como competencia están principalmente orientadas a la venta de paneles solares estáticos, siendo estas las que abarcan la mayoría de las ventas. Estas empresas participan en un comercio ligado al nuestro, es decir, el campo en el que practican su actividad comercial es muy parecido al nuestro, planteando cierta competencia, y abriendo la posibilidad de colaboraciones, compras o simplemente convenios comerciales.
Los únicos puntos de compra de placas solares con sistemas de seguimiento solar son páginas como Amazon, AliExpress o AliBaba, lo que quiere decir que por el momento no existen apenas empresas de tamaño medio cuyo servicio sea la venta de este tipo de paneles solares. Es por esto que el espacio disponible para asentar un nuevo mercado es considerable.
Nuestro plan de negocio incluye presentar al público las considerables ventajas y diferencias entre los productos del mercado ya asentado (paneles solares estáticos) y los sistemas solares dinámicos. Las más relevantes siendo la mayor efectividad energética (entre un 20% y 30%) y por tanto una mayor rentabilidad de inversión a largo plazo, debido a que la inversión inicial requerida para esta clase de sistemas es mayor.

Nuestro proyecto consiste en la creación de un sistema que permita mover las placas y orientarlas en la dirección que permita tener una mayor cantidad de energía. Para ello será necesario el diseño de un soporte que permite moverlas en todas las direcciones posibles. Junto a esto es necesario integrar una serie de sensores que sean capaces de observar en qué dirección se encuentra la fuente principal de luz y mover el soporte accionado por dos motores en la dirección óptima.
Con la implementación de este soporte también permitirá al usuario el uso de una aplicación móvil para poder obtener información acerca de la placa e informes acerca de su comportamiento a lo largo del tiempo. En esta aplicación se le dará la opción de poder colocar la placa solar de una forma muy fácil para poder limpiarla dado que tienden a ensuciarse y a perder eficiencia.




4.	Ideas descartadas
Tras analizar distintas implementaciones llegamos a la conclusión de que si queríamos crear un proyecto fácilmente escalable debía de tener incorporado por cada placa un sensor que mida en qué dirección se encuentra la mayor cantidad de luz. Ya que si implementamos uno para todas las placas de un recinto podría llegar a ser contraproducente. No todas las placas tienen porque compartir la misma orientación para obtener la mayor cantidad de energía posible.
Por otra parte, el grupo descartó la idea de desarrollar un localizador GPS en la estructura de la placa solar debido a la poca utilidad que este prestaría en el prototipo, ya que la localización (suponiendo que las placas reales basadas en el prototipo tienen un gran tamaño) no variaría apenas debido a las grandes maniobras que supondría mover una de las placas mientras esta esté funcionando.
Otra de las propuestas que fue desechada es un sistema simple de limpiado de la placa que iría montado en la propia placa, de forma que cuando se seleccione la opción de “Limpiar” en la app, una barra con una almohadilla empapada en jabón de manos cotidiano pasase por la superficie de la placa. Esta idea fue descartada debido a la complejidad del montaje de este sistema y a la poca utilidad que realmente aporta, ya que la placa (o placas) serían fácilmente limpiadas de forma manual por cualquier persona al cargo de ella(s).
Por último, la idea de diseñar una serie de controles manuales de la placa a través de la app de Android no llegó a convencer al equipo de desarrollo porque el objetivo de este proyecto es construir una placa solar de forma que su rendimiento sea el máximo posible (siguiendo el recorrido de la luz solar) y por tanto alterar la posición más óptima calculada por la placa sería alejarnos del punto de más eficiencia energética.
5.	Desarrollo
5.1.	Arquitectura del sistema
La arquitectura de nuestro sistema consistirá en una arquitectura de 4 capas.

La arquitectura de nuestro proyecto consta de 4 capas: la primera de ellas es la capa de percepción, en la que se encuentran los sensores necesarios que toman las medidas imprescindibles para el desarrollo de nuestro proyecto, la cantidad y tipo de sensores que vamos a emplear están descritos en el siguiente apartado.
La siguiente capa, la capa de red, consistirá en una conexión wifi bidireccional entre la estructura de la placa solar (placa esp32, sensores, etc) y nuestra capa de procesado, que recibirá datos de esa conexión suscribiéndose (método del sistema MQTT empleado) al publicador situado en la placa esp32. También situaremos un publicador en nuestra capa de procesado, al que la placa esp32 se suscribirá para establecer ese doble sentido en la conexión.
En la capa de procesado, nuestra lógica de negocio estará situada en un programa Java conectado a un motor de base de datos de MySQL en la que cargaremos nuestros datos recopilados y a un servidor de Apache Tomcat, lo que nos permitirá conectarnos con las vistas (representación de los datos) de la página web en la siguiente capa.
Por último, la capa de aplicación, en la que vamos a encontrar una serie de interfaces que son las que van a mostrar los datos e interactuar con los usuarios. Consta de dos partes distintas: una app de android, en la que vamos a poder visualizar datos obtenidos de la placa solar y mandar ciertas órdenes simples a la placa solar, y por otra parte la página web, que va a ser útil para visualizar gráficas, datos procesados o descargar informes sobre la placa solar.

El diseño que hemos pensado implementar para el apartado hardware es el siguiente.
-	Los botones servirán para calibrar inicialmente al motor paso a paso
-	El motor paso a paso se encargará de rotar la placa y la estructura que la sujeta
-	El servomotor se encargará de rotar solamente la placa
-	Los fotoresistores servirán para orientar a la placa y para obtener información útil
 
 
5.2.	Tecnología a utilizar

Elementos hardware:
-	Placa ESP32
-	1 servomotor SG90
-	1 motor paso a paso 28BYJ
-	4 fotoresistores sensibles a la luz
-	Base, soporte y placa hechos a medida (en un futuro se facilitará un modelo para poder imprimir de manera personal)
-	4 Resistencias 10K Ohm
-	2 Resistencias 220 Ohm
-	2 Interruptores que cierran el circuito al ser presionados
-	Cables

Elementos software:
-	IDE programación placa: Arduino IDE
-	Broker: Emqx
-	Base de datos: MySQL
-	Simulador servidor página web: Apache
-	IDE programación aplicación Android: Android Studio
 

5.3.	Mockup aplicaciones

El diseño de nuestra página web será algo como el siguiente boceto:




En la página web de este proyecto se va a poder visualizar gráficas que muestren datos determinados de la placa solar recogidos a lo largo del tiempo, además de la posibilidad de descargar informes sobre estos datos en formato pdf.

















El diseño de la aplicación Android seguirá este boceto:



 



Se podrá consultar y descargar un informe diario con los datos recabados (.pdf) y resetear la placa cuando sea necesario.








5.4.	Plan de desarrollo
El plan de desarrollo que hemos decidido llevar a cabo es el siguiente. En él se puede observar las tareas que vamos a realizar y cuánto tiempo tenemos previsto dedicarle a cada una de ellas. 
El número de personas que requiere nuestro plan de desarrollo va a ser de una por cada actividad. 



1.	6.   Conclusiones
Como conclusión del desarrollo del proyecto sacamos un gran conocimiento acerca de las nuevas fuentes de energía renovables de la actualidad. También sacamos en claro la complejidad que conlleva un proyecto de esta magnitud y el gran beneficio de trabajar en equipo para poder sacar algo así adelante. Nos ha servido para conocer nuevas tecnologías que desconocíamos en un principio y ahora podemos afirmar que son una gran ayuda para proyectos de IOT como este.



2.	7.   Bibliografía
[1] https://www.cambioenergetico.com/blog/tipos-de-paneles-solares-fotovoltaicos/
[2] https://www.youtube.com/watch?v=74FFTL3Vljw
[3] https://www.youtube.com/watch?v=k-Hw4TpdApY
[4] https://www.diva-portal.org/smash/get/diva2:1674078/FULLTEXT02

