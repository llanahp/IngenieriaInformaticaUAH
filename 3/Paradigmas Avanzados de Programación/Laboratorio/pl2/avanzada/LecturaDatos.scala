object LecturaDatos {

  //Esta función se utiliza para leer la posicion que quiere jugar el jugador, X
  def leerFila(filas: Int, columnas: Int): Int = {
    print("Introduce una fila: ")
    val fila = scala.io.StdIn.readLine().toInt
    if (fila > filas || filas < 0) { //en caso que se intreduzca una fila que no se permitida
      println("Posición Imposible")
      leerFila(filas, columnas)
    } else {
      leerColumna(filas, columnas, fila)
    }
  }

  //Esta función se utiliza para leer la posicion que quiere jugar el jugador, Y
  def leerColumna(filas: Int, columnas: Int, fila: Int): Int = {
    print("Introduce una columna: ")
    val columna = scala.io.StdIn.readLine().toInt
    if (columna > columnas || columna < 0) { //en caso que se intreduzca una columna que no se permitida
      println("Posición Imposible")
      leerColumna(filas, columnas, fila)
    } else {
      //posicion del trablero correcta
      return fila * (columnas) + columna + 1
    }
  }

  //lee de consola la dificultad que quiere jugar la persona
  def leerDificultad(): Int = {
    print("Introduce la dificultad(1,2,3): ")
    val dificultad = scala.io.StdIn.readLine()
    if (dificultad != "1" && dificultad != "2" && dificultad != "3") {
      leerDificultad()
    } else {
      return dificultad.toInt
    }
  }


  //pregunta si quiere jugar la persona o la máquina
  def leerJugador(): Int = {
    print("Deseas jugar tu (1) o prefieres que juegue la máquina (2): ")
    val jugador = scala.io.StdIn.readLine()
    if (jugador != "1" && jugador != "2")
      leerDificultad()
    else
      return jugador.toInt
  }

}
