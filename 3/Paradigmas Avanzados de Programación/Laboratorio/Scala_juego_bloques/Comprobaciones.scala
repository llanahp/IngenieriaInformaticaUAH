import Acciones._
import Principal._

import scala.concurrent.duration.{Duration, NANOSECONDS}

object Comprobaciones {

  //Dada una columna, comprueba si está vacia o no
  def esColumnaVacia(columna: List[Int]): Boolean = {
    if (!columna.isEmpty) {
      if (columna.head != 0) { //si encuentro una posicion que no está vacia
        return false //la columna no está vacia
      } else {
        return esColumnaVacia(columna.tail)
      }
    } else { //he recorrido toda la columna y es vacia
      return true
    }
  }

  //Recorre el tablero mirando si existen columnas vacias
  def existenColumnasVacias(columna: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (columna > 1) { //Mientras no esté en la columna de la izquierda
      val miColumnaContineBloqques = !esColumnaVacia(getColumna(columna, tablero, nivel))
      val siguienteColumnaContineBloqques = !esColumnaVacia(getColumna(columna - 1, tablero, nivel))
      if (!siguienteColumnaContineBloqques && miColumnaContineBloqques) {
        //tengo que mover la columna
        return existenColumnasVacias(columna - 1, reemplazarColumna(columna, tablero, nivel), nivel)
      } else {
        return existenColumnasVacias(columna - 1, tablero, nivel)
      }
      Nil
    } else
      return tablero
  }

  //Despues de jugar una posicion, miro si quedan bloques por borrar
  def quedanBloques(tablero: List[Int]): Boolean = {
    if (tablero.isEmpty) { //si es vacio
      return false
    } else {
      if (tablero.head == 0) {
        return quedanBloques(tablero.tail)
      } else {
        return true
      }
    }
  }

  //Dada una posición, comrpueba cuantos bloques iguales se encuentran  hacia la izquierda
  def cuantosIgualesIzquierda(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (esBordeIzquierdo(posicion - 1, maxFilas(nivel), maxColumnas(nivel))) { //si la siguiente posicion no está en otra linea
      //recolecto los elementos
      val izquierda = getElemento(posicion - 1, tablero)
      val centro = getElemento(posicion, tablero)
      //miro si son iguales
      if (izquierda == centro) {
        return 1
      } else {
        return 0
      }
    } else { //La siguiente hacia la izquieda NO está en el borde
      //recolecto los elementos
      val izquierda = getElemento(posicion - 1, tablero)
      val centro = getElemento(posicion, tablero)
      //miro si son iguales

      if (izquierda == centro) {
        return 1 + cuantosIgualesIzquierda(posicion - 1, tablero, nivel)
      } else {
        return 0
      }
    }
  }

  //Dada una posición, comrpueba cuantos bloques iguales se encuentran  hacia la derecha
  def cuantosIgualesDerehca(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (esBordeDerehco(posicion + 1, maxFilas(nivel), maxColumnas(nivel))) { //si la siguiente posicion no está en otra linea
      //recolecto los elementos
      val derecha = getElemento(posicion + 1, tablero)
      val centro = getElemento(posicion, tablero)
      //miro si son iguales

      if (derecha == centro) {
        return 1
      } else {
        return 0
      }
    } else { //La siguiente hacia la izquieda NO está en el borde
      //recolecto los elementos
      val derecha = getElemento(posicion + 1, tablero)
      val centro = getElemento(posicion, tablero)
      //miro si son iguales

      if (derecha == centro) {
        return 1 + cuantosIgualesDerehca(posicion + 1, tablero, nivel)
      } else {
        return 0
      }
    }
  }

  //Dada una posición, comrpueba cuantos bloques iguales se encuentran  hacia abajo
  def cuantosIgualesAbajo(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (esBordeInferior(posicion + maxColumnas(nivel), maxFilas(nivel), maxColumnas(nivel))) { //si la siguiente posicion no está en otra linea
      //recolecto los elementos
      val centro = getElemento(posicion, tablero)
      val abajo = getElemento(posicion + maxColumnas(nivel), tablero)
      //miro si son iguales

      if (abajo == centro) {
        return 1
      } else {
        return 0
      }
    } else { //La siguiente hacia la izquieda NO está en el borde
      //recolecto los elementos
      val abajo = getElemento(posicion + maxColumnas(nivel), tablero)
      val centro = getElemento(posicion, tablero)
      //miro si son iguales

      if (abajo == centro) {
        return 1 + cuantosIgualesAbajo(posicion + maxColumnas(nivel), tablero, nivel)
      } else {
        return 0
      }
    }
  }

  //Dada una posición, comrpueba cuantos bloques iguales se encuentran  hacia arriba
  def cuantosIgualesArriba(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (esBordeSuperior(posicion - maxColumnas(nivel), maxFilas(nivel), maxColumnas(nivel))) { //si la siguiente posicion no está en otra linea
      //recolecto los elementos
      val arriba = getElemento(posicion - maxColumnas(nivel), tablero)
      val centro = getElemento(posicion, tablero)
      //miro si son iguales

      if (arriba == centro) {
        return 1
      } else {
        return 0
      }
    } else { //La siguiente hacia la izquieda NO está en el borde
      //recolecto los elementos
      val arriba = getElemento(posicion - maxColumnas(nivel), tablero)
      val centro = getElemento(posicion, tablero)
      //miro si son iguales

      if (arriba == centro) {
        return 1 + cuantosIgualesArriba(posicion - maxColumnas(nivel), tablero, nivel)
      } else {
        return 0
      }
    }
  }

  //dada una posicion, compruebo si se encuentra en la fila de arriba
  def esBordeSuperior(posicion: Int, filas: Int, columnas: Int): Boolean = {
    if (columnas >= posicion && posicion >= 0) { //se encuentra dentro de la primera fila
      return true
    } else {
      return false
    }
  }

  //dada una posicion, compruebo si se encuentra en la última fila
  def esBordeInferior(posicion: Int, filas: Int, columnas: Int): Boolean = {
    if ((filas * columnas) >= posicion && posicion >= (filas * columnas) - columnas + 1) { //si se encuentra en la últiuma fila
      return true
    } else {
      return false
    }
  }

  //dada una posicion, compruebo si se encuentra en la columna de la derecha
  def esBordeDerehco(posicion: Int, filas: Int, columnas: Int): Boolean = {
    if (posicion % columnas == 0)
      return true
    else
      return false
  }

  //dada una posicion, compruebo si se encuentraen la columna de la izquierda
  def esBordeIzquierdo(posicion: Int, filas: Int, columnas: Int): Boolean = {
    if (posicion % columnas == 1)
      return true
    else
      return false
  }

  //comprueba en base al tiempo transcurrido y el numero de vidas restantes, si puede seguir jugando
  def seguirJugando(vidas: Int, tiempoInicial: Long): Boolean = {
    if (vidas > 0 && Duration(System.nanoTime() - tiempoInicial, NANOSECONDS).toSeconds < 300) //suficientes vidas y no han pasado 5 minutos que son 300 segundos
      return true
    else
      return false
  }


  //dada una posición, comprueba si se encutra en los bordes del tablero
  def estaEnBordes(posicion: Int, filas: Int, columnas: Int): Boolean = {
    if (esBordeSuperior(posicion, filas, columnas) || esBordeInferior(posicion, filas, columnas) ||
      esBordeIzquierdo(posicion, filas, columnas) || esBordeDerehco(posicion, filas, columnas))
      return true
    else
      return false
  }


  //retorna cuantos puntos va a borrar la bomba
  def puntosBomba(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    val filas = maxFilas(nivel)
    val columnas = maxColumnas(nivel)
    if (estaEnBordes(posicion, filas, columnas)) {
      //se encuentra en los bordes y tengo que mirar más detenidamente
      if (esEsquina(posicion, filas, columnas)) { //miro si es una esquina
        if (esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba izquierda
          val b1 = if (getElemento(posicion + 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion + columnas, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion + 1 + columnas, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3) * 10)
        } else if (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba Derecha
          val b1 = if (getElemento(posicion - 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion + columnas, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion - 1 + columnas, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3) * 10)
        } else if (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) { //abajo izquierda
          val b1 = if (getElemento(posicion + 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion - columnas, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion + 1 - columnas, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3) * 10)
        } else { //abajo Derecha
          val b1 = if (getElemento(posicion - 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion - columnas, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion - 1 - columnas, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3) * 10)
        }

      } else { //es solo un borde
        if (esBordeIzquierdo(posicion, filas, columnas)) { //borde izquierdo
          val b1 = if (getElemento(posicion + 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion - columnas, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion - columnas + 1, tablero) != 0) 1 else 0
          val b4 = if (getElemento(posicion + columnas, tablero) != 0) 1 else 0
          val b5 = if (getElemento(posicion + columnas + 1, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3 + b4 + b5) * 10)

        } else if (esBordeDerehco(posicion, filas, columnas)) { //borde derecho
          val b1 = if (getElemento(posicion - 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion - columnas, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion - columnas - 1, tablero) != 0) 1 else 0
          val b4 = if (getElemento(posicion + columnas, tablero) != 0) 1 else 0
          val b5 = if (getElemento(posicion + columnas - 1, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3 + b4 + b5) * 10)

        } else if (esBordeSuperior(posicion, filas, columnas)) { //borde superior
          val b1 = if (getElemento(posicion + 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion - 1, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion + columnas - 1, tablero) != 0) 1 else 0
          val b5 = if (getElemento(posicion + columnas + 1, tablero) != 0) 1 else 0
          val b4 = if (getElemento(posicion + columnas, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3 + b4 + b5) * 10)

        } else { //borde inferior
          val b1 = if (getElemento(posicion + 1, tablero) != 0) 1 else 0
          val b2 = if (getElemento(posicion - 1, tablero) != 0) 1 else 0
          val b3 = if (getElemento(posicion - columnas - 1, tablero) != 0) 1 else 0
          val b5 = if (getElemento(posicion - columnas + 1, tablero) != 0) 1 else 0
          val b4 = if (getElemento(posicion - columnas, tablero) != 0) 1 else 0
          return 10 + ((b1 + b2 + b3 + b4 + b5) * 10)

        }
      }
    } else {
      return (10 + (10 * cuantosBloquesAlrededor(posicion, tablero, nivel, 0)))
    }
  }


  def cuantosBloquesAlrededor(posicion: Int, tablero: List[Int], nivel: Int, recorrido: Int): Int = recorrido match {
    case 0 => {
      if (posicion - 1 - maxColumnas(nivel) > 0 && posicion - 1 - maxColumnas(nivel) <= maxColumnas(nivel) * maxFilas(nivel)) {
        if (getElemento(posicion - 1 - maxColumnas(nivel), tablero) != 0) {
          return (1 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
        } else
          return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
      } else
        return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
    }
    case 1 => {
      if (posicion - maxColumnas(nivel) > 0 && posicion - maxColumnas(nivel) <= maxColumnas(nivel) * maxFilas(nivel)) {
        if (getElemento(posicion - maxColumnas(nivel), tablero) != 0) {
          return (1 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
        } else
          return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
      } else
        return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
    }
    case 2 => {
      if (posicion + 1 - maxColumnas(nivel) > 0 && posicion + 1 - maxColumnas(nivel) <= maxColumnas(nivel) * maxFilas(nivel)) {
        if (getElemento(posicion + 1 - maxColumnas(nivel), tablero) != 0) {
          return (1 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
        } else
          return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
      } else
        return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
    }
    case 3 => {
      if (posicion - 1 > 0 && posicion - 1 <= maxColumnas(nivel) * maxFilas(nivel)) {
        if (getElemento(posicion - 1, tablero) != 0) {
          return (1 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
        } else
          return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
      } else
        return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
    }
    case 4 => {
      if (posicion + 1 > 0 && posicion + 1 <= maxColumnas(nivel) * maxFilas(nivel)) {
        if (getElemento(posicion + 1, tablero) != 0) {
          return (1 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
        } else
          return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
      } else
        return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
    }
    case 5 => {
      if (posicion - 1 + maxColumnas(nivel) > 0 && posicion - 1 + maxColumnas(nivel) <= maxColumnas(nivel) * maxFilas(nivel)) {
        if (getElemento(posicion - 1 + maxColumnas(nivel), tablero) != 0) {
          return (1 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
        } else
          return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
      } else
        return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
    }
    case 6 => {
      if (posicion + maxColumnas(nivel) > 0 && posicion + maxColumnas(nivel) <= maxColumnas(nivel) * maxFilas(nivel)) {

        if (getElemento(posicion + maxColumnas(nivel), tablero) != 0) {
          return (1 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
        } else
          return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
      } else
        return (0 + cuantosBloquesAlrededor(posicion, tablero, nivel, recorrido + 1))
    }
    case 7 => {
      if (posicion + 1 + maxColumnas(nivel) > 0 && posicion + 1 + maxColumnas(nivel) <= maxColumnas(nivel) * maxFilas(nivel)) {
        if (getElemento(posicion + 1 + maxColumnas(nivel), tablero) != 0) {
          return 1
        } else
          return 0
      } else
        return 0
    }
  }
}
