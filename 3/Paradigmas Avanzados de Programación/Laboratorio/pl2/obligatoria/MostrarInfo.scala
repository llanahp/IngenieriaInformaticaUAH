import scala.concurrent.duration._
import Acciones._
import LecturaDatos._

object MostrarInfo {
  //Cuando está jugando el ordenador, se llama a esta funcion para decir al jugador que posición se va a jugar
  def maquinajuegaPoscion(posicion: Int, nivel: Int): Unit = {
    val fila = posicion / maxColumnas(nivel)
    val columna = (posicion % maxColumnas(nivel))
    println()
    if (columna == 0)
      println("La maquina va a jugar la posicion: " + posicion + "(" + fila + "," + columna + ")")
    else
      println("La maquina va a jugar la posicion: " + posicion + "(" + fila + "," + (columna - 1) + ")")
    println("------------------------")
  }

  //Despues de cada jugada, mostrar por pantalla la puntuación
  def mostrarPuntuacion(puntuacion: Int, tiempoInicial: Long, partidasJugadas: Int): Unit = {
    println("El juego ha terminado")
    val segundos = getSegundos(Duration(System.nanoTime() - tiempoInicial, NANOSECONDS).toSeconds)
    println("tu puntuación es de: " + puntuacion + ", has consumido un tiempo de " + Duration(System.nanoTime() - tiempoInicial, NANOSECONDS).toMinutes + " " +
      "Minutos y " + segundos + " segundos, habiendo jugado " + partidasJugadas + " partidas")
  }

  //en función del nivel, mostrar el tablero
  def imprimir(l: List[Int], nivel: Int): Any = nivel match {
    case 1 => print("  "); imprimirColumnas(0, 11); imprimirPantalla(l, 9, 11)
    case 2 => print("  "); imprimirColumnas(0, 16); imprimirPantalla(l, 12, 16)
    case 3 => print("  "); imprimirColumnas(0, 15); imprimirPantalla(l, 25, 15)
  }

  //mostrar los indices de las columnas del tablero
  def imprimirColumnas(parcial: Int, total: Int): Any = {
    if (parcial < total) {
      if (parcial >= 10) {
        print("|" + (parcial));
        imprimirColumnas(parcial + 1, total)
      } else {
        print("| " + (parcial));
        imprimirColumnas(parcial + 1, total)
      }
    }
    else {
      println("|")
    }
  }

  //Cambio los numeros del trablero por su carácter
  def imprimirColor(numero: Int): String = numero match {
    case 0 => "  "
    case 1 => " A"
    case 2 => " R"
    case 3 => " N"
    case 4 => " V"
    case 5 => " P"
    case 6 => " M"
    case 7 => " G"
    case 8 => " B"
    case _ => "ERROR"
  }

  //escribir el tablero por consola
  def imprimirPantalla(l: List[Int], filas: Int, columnas: Int): Any = {
    //si es el final del tablero, hago una división
    if (l.isEmpty || longitud(l) == 0) {
      println("------------------------")
    } else {//muestro indice de la fila
      if (((longitud(l) - 1)) % columnas == columnas - 1) {
        val fila = ((filas * columnas) - longitud(l)) / columnas
        if (fila >= 10)
          print(fila)
        else
          print(" " + fila)
      }
      //muestro bloque
      if ((longitud(l) - 1) % columnas == 0) {//si no es fin de lineae
        println("|" + imprimirColor(l.head) + "|")
        imprimirPantalla(l.tail, filas, columnas)
      } else {//si es fin de linea
        print("|" + imprimirColor(l.head) + "")
        imprimirPantalla(l.tail, filas, columnas)
      }
    }
  }

  //comprueba dada una posicion si es poosible jugarla denrto del tablero
  def posicionCorrecta(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (getElemento(posicion, tablero) == 0) { //Si es un espacio en blanco
      println("Posición Imposible")
      posicionCorrecta(leerFila(maxFilas(nivel), maxColumnas(nivel)), tablero, nivel)
    } else {
      posicion
    }
  }
}
