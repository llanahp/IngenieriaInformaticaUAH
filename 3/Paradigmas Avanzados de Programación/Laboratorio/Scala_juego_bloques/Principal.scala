import Acciones._
import Comprobaciones._
import LecturaDatos._
import MostrarInfo._

import scala.concurrent.duration.{Duration, NANOSECONDS}

object Principal {

  //dado el numero de filas,columnas y la cantidad de colores posibles, crea el tablero de forma aleatoria
  def crearTablero(filas: Int, columnas: Int, colores: Int, tablero: List[Int]): List[Int] = {
    if (filas * columnas != longitud(tablero)) {
      val a = numeroAleatorio(1, colores)
      return crearTablero(filas, columnas, colores, a :: tablero)
    } else
      return tablero
  }

  //en función del nivel, pone las bombas por encima del tablero creado
  def crearBombas(tablero: List[Int], nivel: Int): List[Int] = nivel match {
    case 1 => crearBombasAux(tablero, 3) //2 bombas
    case 2 => crearBombasAux(tablero, 3) //3 bombas
    case 3 => crearBombasAux(tablero, 5) //5 bombas
  }

  //Metodo auxiliar para colocar las bombas en el tablero
  def crearBombasAux(tablero: List[Int], bombas: Int): List[Int] = {
    if (bombas > 0) {
      val posicion = numeroAleatorio(1, longitud(tablero))
      if (getElemento(posicion, tablero) == 8) {
        crearBombasAux(tablero, bombas)
      }
      return crearBombasAux(setValor(8, posicion, tablero), bombas - 1)
    } //bomba es numero 8
    else
      return tablero
  }

  //dado la dificultad que desea jugar la persona, crea el tablero
  def crearTipoTablero(nivel: Int): List[Int] = nivel match {
    case 1 => crearTablero(9, 11, 3, Nil) //2 bombas
    case 2 => crearTablero(12, 16, 5, Nil) //3 bombas
    case 3 => crearTablero(25, 15, 7, Nil) //5 bombas
  }

  //dado el nivel, se le asigna el número de vidas
  def rellenarVidas(nivel: Int): Int = nivel match {
    case 1 => 8
    case 2 => 10
    case 3 => 15
  }


  //dada una posición, comprueba si se encuentra en una de las 4 esquinas
  def esEsquina(posicion: Int, filas: Int, columnas: Int): Boolean = {
    if (esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas) ||
      (esBordeDerehco(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) ||
      (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) ||
      (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)))
      true
    else
      false
  }

  //dada una posición, comprueba si existen 3 o más en linea a partir de ese bloque
  def tiene3EnLinea(posicion: Int, tablero: List[Int], nivel: Int): Boolean = {
    if (getElemento(posicion, tablero) != 0) {
      if (estaEnBordes(posicion, maxFilas(nivel), maxColumnas(nivel))) {
        val filas = maxFilas(nivel)
        val columnas = maxColumnas(nivel)
        //miro si es una esquina
        if (esEsquina(posicion, filas, columnas)) { //arriba izquierda
          if (esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) {
            if ((cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          } else if (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba Derecha
            if ((cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          } else if (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) { //abajo izquierda
            if ((cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          } else { //abajo Derecha
            if ((cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          }
        } else { //no es esquina

          if ((columnas >= posicion && posicion >= 0)) { //fila superior
            if (cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3 ||
              (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          } else if ((filas * columnas) >= posicion && posicion >= (filas * columnas) - columnas) { //fila inferior
            if (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3 ||
              (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          } else if ((posicion) % columnas == 0) { //columna derehca
            if (cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3 ||
              (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          } else { //columna izquieda
            if (cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3 ||
              (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
              return true
            else
              return false
          }
        }
      } else {
        if (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3 ||
          (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3)) {
          return true
        } else
          return false
      }
    }
    else
      return false
  }

  //dada una posición, dice cuantos puntos da al borrar ese bloques y los que tenga en su línea (3 o más)
  def puntos3EnLinea(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (estaEnBordes(posicion, maxFilas(nivel), maxColumnas(nivel))) { //esta en un borde
      val filas = maxFilas(nivel)
      val columnas = maxColumnas(nivel)
      if ((esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) ||
        (esBordeDerehco(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) ||
        (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) ||
        (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas))) { //Si es una esquina
        if (esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba izquierda
          if ((cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesDerehca(posicion, tablero, nivel) + 1, cuantosIgualesAbajo(posicion, tablero, nivel) + 1)
          else
            return 0
        } else if (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba Derecha
          if ((cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesIzquierda(posicion, tablero, nivel) + 1, cuantosIgualesAbajo(posicion, tablero, nivel) + 1)
          else
            return 0
        } else if (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) { //abajo izquierda
          if ((cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesDerehca(posicion, tablero, nivel) + 1, cuantosIgualesArriba(posicion, tablero, nivel) + 1)
          else
            return 0
        } else { //abajo Derecha
          if ((cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3) || (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesIzquierda(posicion, tablero, nivel) + 1, cuantosIgualesArriba(posicion, tablero, nivel) + 1)
          else
            return 0
        }
      } else {
        if ((columnas >= posicion && posicion >= 0)) { //fila superior
          if (cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3 || (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesAbajo(posicion, tablero, nivel) + 1, (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1))
          else
            return 0
        } else if ((filas * columnas) >= posicion && posicion >= (filas * columnas) - columnas) { //fila inferior
          if (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3 || (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesArriba(posicion, tablero, nivel) + 1, (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1))
          else
            return 0
        } else if ((posicion) % columnas == 0) { //columna derecha
          if (cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3 || (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesIzquierda(posicion, tablero, nivel) + 1, (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1))
          else
            return 0
        } else if ((posicion) % columnas == 1) { //columna izquieda
          if (cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3 || (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
            return max(cuantosIgualesDerehca(posicion, tablero, nivel) + 1, (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1))
          else
            return 0
        } else
          return 0
      }
    }
    else {
      if (cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3 || (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3)) {
        return max(cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1, (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1))
      } else
        return 0

    }
  }

  //Dado una bloque que se que tiene 3 o mas cerca, los borro
  // priorizaré borrar la fila o la columna que tenga más
  def eliminar3EnLinea(posicion: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (estaEnBordes(posicion, maxFilas(nivel), maxColumnas(nivel))) {
      val filas = maxFilas(nivel)
      val columnas = maxColumnas(nivel)
      //miro si es una esquina
      if ((esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) ||
        (esBordeDerehco(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) ||
        (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) ||
        (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas))) { //es una esquina
        val target = getElemento(posicion, tablero)
        if (esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba izquierda
          if ((cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3) && (cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= cuantosIgualesAbajo(posicion, tablero, nivel) + 1)) {
            val tab = setValor(0, posicion, tablero)
            return borrarDerecha(target, posicion + 1, tab, nivel)
          } else { //(cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3))
            val tab = setValor(0, posicion, tablero)
            return borrarAbajo(posicion + maxColumnas(nivel), target, tab, nivel)
          }
        } else if (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba Derecha
          if ((cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3) && (cuantosIgualesIzquierda(posicion, tablero, nivel) + 1) >= (cuantosIgualesAbajo(posicion, tablero, nivel) + 1)) {
            val tab = setValor(0, posicion, tablero)
            return borrarIzquieda(target, posicion - 1, tab, nivel)
          }
          else { //(cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3)
            val tab = setValor(0, posicion, tablero)
            return borrarAbajo(posicion + maxColumnas(nivel), target, tab, nivel)
          }
        } else if (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) { //abajo izquierda
          if ((cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3) && (cuantosIgualesDerehca(posicion, tablero, nivel) + 1) >= (cuantosIgualesArriba(posicion, tablero, nivel) + 1)) {
            val tab = setValor(0, posicion, tablero)
            return borrarDerecha(target, posicion + 1, tab, nivel)
          } else { // (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3)
            val tab = setValor(0, posicion, tablero)
            return borrarArriba(posicion - maxColumnas(nivel), target, tab, nivel)
          }
        } else { //abajo Derecha
          if ((cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3) && (cuantosIgualesIzquierda(posicion, tablero, nivel) + 1) >= (cuantosIgualesArriba(posicion, tablero, nivel) + 1)) {
            val tab = setValor(0, posicion, tablero)
            return borrarIzquieda(target, posicion - 1, tab, nivel)
          } else { //(cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3)
            val tab = setValor(0, posicion, tablero)
            return borrarArriba(posicion - maxColumnas(nivel), target, tab, nivel)
          }
        }
      } else { //No es una esquina pero si es un borde

        if ((columnas >= posicion && posicion >= 0)) { //fila superior
          val target = getElemento(posicion, tablero)
          if (cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= 3 && cuantosIgualesAbajo(posicion, tablero, nivel) + 1 >= (cuantosIgualesDerehca(posicion, tablero, nivel) + cuantosIgualesIzquierda(posicion, tablero, nivel) + 1)) { //3 seguidos hacia abajo
            val tab = setValor(0, posicion, tablero)
            return borrarAbajo(posicion + maxColumnas(nivel), target, tab, nivel)
          } else {
            val tab = setValor(0, posicion, tablero)
            return borrarIzquieda(posicion - 1, target, borrarDerecha(target, posicion + 1, tab, nivel), nivel)
          }

        } else if ((filas * columnas) >= posicion && posicion >= (filas * columnas) - columnas) { //fila inferior
          val target = getElemento(posicion, tablero)
          if (cuantosIgualesArriba(posicion, tablero, nivel) + 1 >= 3 && (cuantosIgualesArriba(posicion, tablero, nivel) + 1) >= (cuantosIgualesDerehca(posicion, tablero, nivel) + cuantosIgualesIzquierda(posicion, tablero, nivel) + 1)) {
            val tab = setValor(0, posicion, tablero)
            return borrarArriba(posicion - maxColumnas(nivel), target, tab, nivel)
          } else {
            val tab = setValor(0, posicion, tablero)
            return borrarIzquieda(posicion - 1, target, borrarDerecha(target, posicion + 1, tab, nivel), nivel)
          }

        } else if ((posicion) % columnas == 0) { //columna derecha
          val target = getElemento(posicion, tablero)
          if (cuantosIgualesIzquierda(posicion, tablero, nivel) + 1 >= 3 && (cuantosIgualesIzquierda(posicion, tablero, nivel) + 1) >= (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1)) {
            val tab = setValor(0, posicion, tablero)
            borrarIzquieda(posicion - 1, target, tab, nivel)
          } else { //Borro en hacia arriba y hacia abajo
            val tab = setValor(0, posicion, tablero)
            return borrarArriba(posicion - maxColumnas(nivel), target, borrarAbajo(posicion + maxColumnas(nivel), target, tab, nivel), nivel)
          }

        } else { //columna izquieda
          val target = getElemento(posicion, tablero)
          if (cuantosIgualesDerehca(posicion, tablero, nivel) + 1 >= 3 && (cuantosIgualesDerehca(posicion, tablero, nivel) + 1) >= (cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1)) {
            val tab = setValor(0, posicion, tablero)
            borrarDerecha(target, posicion + 1, tab, nivel)
          } else {
            val tab = setValor(0, posicion, tablero)
            return borrarArriba(posicion - maxColumnas(nivel), target, borrarAbajo(posicion + maxColumnas(nivel), target, tab, nivel), nivel)
          }
        }
      }
    } else { //no se encuentra en los bordes
      val target = getElemento(posicion, tablero)
      val borrariaLados = cuantosIgualesIzquierda(posicion, tablero, nivel) + cuantosIgualesDerehca(posicion, tablero, nivel) + 1
      if (borrariaLados >= 3 && borrariaLados >= cuantosIgualesArriba(posicion, tablero, nivel) + cuantosIgualesAbajo(posicion, tablero, nivel) + 1) {
        val tab = setValor(0, posicion, tablero)
        return borrarIzquieda(posicion - 1, target, borrarDerecha(target, posicion + 1, tab, nivel), nivel)
      } else {
        val tab = setValor(0, posicion, tablero)
        return borrarArriba(posicion - maxColumnas(nivel), target, borrarAbajo(posicion + maxColumnas(nivel), target, tab, nivel), nivel)
      }
    }
  }

  //la posicion que se ha seleccionado es una bomba y eliminaré sus bloques alrededor
  def eliminarBloquesBomba(posicion: Int, tablero: List[Int], nivel: Int): List[Int] = {
    val filas = maxFilas(nivel)
    val columnas = maxColumnas(nivel)
    if (estaEnBordes(posicion, filas, columnas)) { //Miro si es una esquina
      if (esBordeIzquierdo(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba izquierda
        val centr = setValor(0, posicion, setValor(0, posicion + 1, tablero))
        val inf = setValor(0, posicion + maxColumnas(nivel), setValor(0, posicion + maxColumnas(nivel) + 1, centr))
        return inf
      } else if (esBordeDerehco(posicion, filas, columnas) && esBordeSuperior(posicion, filas, columnas)) { //arriba Derecha
        val centr = setValor(0, posicion, setValor(0, posicion - 1, tablero))
        val inf = setValor(0, posicion + maxColumnas(nivel), setValor(0, posicion + maxColumnas(nivel) - 1, centr))
        return inf
      } else if (esBordeIzquierdo(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) { //abajo izquierda
        val centr = setValor(0, posicion, setValor(0, posicion + 1, tablero))
        val sup = setValor(0, posicion - maxColumnas(nivel), setValor(0, posicion - maxColumnas(nivel) + 1, centr))
        return sup
      } else if (esBordeDerehco(posicion, filas, columnas) && esBordeInferior(posicion, filas, columnas)) { //abajo Derecha
        val centr = setValor(0, posicion, setValor(0, posicion - 1, tablero))
        val sup = setValor(0, posicion - maxColumnas(nivel), setValor(0, posicion - maxColumnas(nivel) - 1, centr))
        return sup
      } else { //No es una esquina
        if (esBordeSuperior(posicion, filas, columnas)) { //Borde superior
          val centr = setValor(0, posicion, setValor(0, posicion - 1, setValor(0, posicion + 1, tablero)))
          val inf = setValor(0, posicion + maxColumnas(nivel), setValor(0, posicion + maxColumnas(nivel) - 1, setValor(0, posicion + maxColumnas(nivel) + 1, centr)))
          return inf
        } else if (esBordeInferior(posicion, filas, columnas)) { //Borde inferior
          val centr = setValor(0, posicion, setValor(0, posicion - 1, setValor(0, posicion + 1, tablero)))
          val sup = setValor(0, posicion - maxColumnas(nivel), setValor(0, posicion - maxColumnas(nivel) - 1, setValor(0, posicion - maxColumnas(nivel) + 1, centr)))
          return sup
        } else if (esBordeDerehco(posicion, filas, columnas)) { //Borde derecho
          val centr = setValor(0, posicion, setValor(0, posicion - maxColumnas(nivel), setValor(0, posicion + maxColumnas(nivel), tablero)))
          val sup = setValor(0, posicion - 1, setValor(0, posicion - maxColumnas(nivel) - 1, setValor(0, posicion + maxColumnas(nivel) - 1, centr)))
          return sup
        } else { //Borde Izquierdo
          val centr = setValor(0, posicion, setValor(0, posicion - maxColumnas(nivel), setValor(0, posicion + maxColumnas(nivel), tablero)))
          val sup = setValor(0, posicion + 1, setValor(0, posicion - maxColumnas(nivel) + 1, setValor(0, posicion + maxColumnas(nivel) + 1, centr)))
          return sup
        }
      }
    }
    else { //elimino centro y alrrededores
      val centr = setValor(0, posicion, setValor(0, posicion - 1, setValor(0, posicion + 1, tablero)))
      val sup = setValor(0, posicion - maxColumnas(nivel), setValor(0, posicion - maxColumnas(nivel) - 1, setValor(0, posicion - maxColumnas(nivel) + 1, centr)))
      val inf = setValor(0, posicion + maxColumnas(nivel), setValor(0, posicion + maxColumnas(nivel) - 1, setValor(0, posicion + maxColumnas(nivel) + 1, sup)))
      return inf
    }
  }

  //recorro el tablero mirando si puedo dejar caer bloques
  def recorrerTablero(posicion: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (!esBordeInferior(posicion, maxFilas(nivel), maxColumnas(nivel))) { //Mientras no esté en la última linea
      val valor = getElemento(posicion, tablero)
      val valorDebajo = getElemento(posicion + maxColumnas(nivel), tablero)
      if (valorDebajo == 0 && valor != 0) { //si tengo un 0 por debajo y yo no soy cero
        val table = setValor(0, posicion, tablero)
        val tab = setValor(valor, posicion + maxColumnas(nivel), table)
        return recorrerTablero(posicion + 1, tab, nivel)
      } else
        return recorrerTablero(posicion + 1, tablero, nivel)
    } else //Última línea
      return tablero
  }

  //Recorro el tablero mirando si puedo dejar caer los bloques y retorno el nuevo tablero
  def dejarCaer(tablero: List[Int], nivel: Int): List[Int] = {
    if (tablero != recorrerTablero(1, tablero, nivel)) { //Si despues de dejar caer el tablero ha cambiado
      return dejarCaer(recorrerTablero(1, tablero, nivel), nivel) //vuelvo a dejar caer
    } else { //el tablero ya no cambia y entonces no puedo dejar caer más
      return tablero
    }
  }

  //dada una columna, la muevo hacia la izquierda si esa está vacia
  def moverIzquierda(columna: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (tablero != existenColumnasVacias(columna, tablero, nivel)) {
      return moverIzquierda(columna, existenColumnasVacias(columna, tablero, nivel), nivel)
    } else {
      return tablero
    }
  }

  //despues de jugar una posicion, dejo caer bloques y luego los muevo a la izquierda
  def recolocarTabler(tablero: List[Int], nivel: Int): List[Int] = {
    //Dejar caer bloques si es posible
    val tab = dejarCaer(tablero, nivel)
    //mirar si puedo mover hacia la izquierda
    val table = moverIzquierda(maxColumnas(nivel), tab, nivel)
    return table
  }

  //dada una posicion, juega y realizar los cambios que necesarios
  def jugarPosicion(posicion: Int, tablero: List[Int], nivel: Int, bloquesEliminados: Int, vidas: Int, puntuacion: Int, tiempoInicial: Long, jugador: Int, partidasJugadas: Int): Unit = {
    if (seguirJugando(vidas, tiempoInicial) && quedanBloques(tablero)) { //El juegador puede seguir jugando
      if (jugador == 1) { //Juega la persona
        if (getElemento(posicion, tablero) == 8) { //Es Bomba
          val puntos = puntosBomba(posicion, tablero, nivel) //miro cuantos puntos me va a dar esta acción
          println("Mas " + puntos + " puntos, Total de puntos: " + (puntuacion + puntos))
          val table = eliminarBloquesBomba(posicion, tablero, nivel)
          val tab = recolocarTabler(table, nivel)
          imprimir(tab, nivel)
          jugarPosicion(posicionCorrecta(leerFila(maxFilas(nivel), maxColumnas(nivel)), tab, nivel), tab, nivel, bloquesEliminados, vidas, puntuacion + puntos, tiempoInicial, jugador, partidasJugadas)
        }
        else { //miro si hay 3 en linea o individual
          if (tiene3EnLinea(posicion, tablero, nivel)) {
            val puntos = puntos3EnLinea(posicion, tablero, nivel) * 10
            println("Mas " + puntos + " puntos, Total de puntos: " + (puntuacion + puntos))
            val table = eliminar3EnLinea(posicion, tablero, nivel)
            val tab = recolocarTabler(table, nivel)
            imprimir(tab, nivel)
            jugarPosicion(posicionCorrecta(leerFila(maxFilas(nivel), maxColumnas(nivel)), tab, nivel), tab, nivel, bloquesEliminados, vidas, puntuacion + puntos, tiempoInicial, jugador, partidasJugadas)
          } else {
            println("no tiene 3 o más en linea, pierdes 1 vida, te quedan: " + vidas + " vidas, Total de puntos: " + (puntuacion + 1))
            val table = setValor(0, posicion, tablero)
            val tab = recolocarTabler(table, nivel)
            imprimir(tab, nivel)
            jugarPosicion(posicionCorrecta(leerFila(maxFilas(nivel), maxColumnas(nivel)), tab, nivel), tab, nivel, bloquesEliminados, vidas - 1, puntuacion + 1, tiempoInicial, jugador, partidasJugadas)
          }
        }
      } else { //juega la máquina
        if (getElemento(posicion, tablero) == 8) { //Es Bomba
          val puntos = puntosBomba(posicion, tablero, nivel) //miro cuantos puntos me va a dar esta acción
          val table = eliminarBloquesBomba(posicion, tablero, nivel)
          val tab = recolocarTabler(table, nivel)
          imprimir(tab, nivel)
          val posi = getPosicionJugar(1, tab, nivel)
          maquinajuegaPoscion(posi, nivel)
          espera(2000)
          jugarPosicion(posi, tab, nivel, bloquesEliminados, vidas, puntuacion + puntos, tiempoInicial, jugador, partidasJugadas)
        }
        else { //miro si hay 3 en linea o individual
          if (tiene3EnLinea(posicion, tablero, nivel)) {
            val puntos = puntos3EnLinea(posicion, tablero, nivel) * 10
            val table = eliminar3EnLinea(posicion, tablero, nivel)
            val tab = recolocarTabler(table, nivel)
            imprimir(tab, nivel)
            val posi = getPosicionJugar(1,  tab, nivel)
            maquinajuegaPoscion(posi, nivel)
            espera(2000)
            jugarPosicion(posi, tab, nivel, bloquesEliminados, vidas, puntuacion + puntos, tiempoInicial, jugador, partidasJugadas)
          } else {
            println("no tiene 3 o más en linea, pierdes 1 vida, te quedan: " + vidas + " vidas")
            val table = setValor(0, posicion, tablero)
            val tab = recolocarTabler(table, nivel)
            imprimir(tab, nivel)
            val posi = getPosicionJugar(1,  tab, nivel)
            maquinajuegaPoscion(posi, nivel)
            espera(2000)
            jugarPosicion(posi, tab, nivel, bloquesEliminados, vidas - 1, puntuacion + 1, tiempoInicial, jugador, partidasJugadas)
          }
        }
      }
    } else { //El jugador NO puedo seguir jugando este tablero
      mostrarPuntuacion(puntuacion, tiempoInicial, partidasJugadas)
      if (Duration(System.nanoTime() - tiempoInicial, NANOSECONDS).toSeconds < 300) { //suficientes vidas y no han pasado 5 minutos que son 300 segundos
        //Pregunto el nivel del nuevo nivel y que vuelva a jugar
        val nivelSiguiente = leerDificultad()
        val jugadorSiguiente = leerJugador()
        val tableroSiguiente = crearBombas(crearTipoTablero(nivelSiguiente), nivelSiguiente)
        imprimir(tableroSiguiente, nivelSiguiente)
        if (jugador == 1) //Juega la persona
          jugarPosicion(posicionCorrecta(leerFila(maxFilas(nivelSiguiente), maxColumnas(nivelSiguiente)), tableroSiguiente, nivelSiguiente), tableroSiguiente, nivelSiguiente, 0, rellenarVidas(nivelSiguiente), puntuacion, tiempoInicial, jugadorSiguiente, partidasJugadas + 1)
        else { //juega la máquina
          val posicionsiguiente = getPosicionJugar(1, tableroSiguiente, nivelSiguiente)
          maquinajuegaPoscion(posicionsiguiente, nivelSiguiente)
          espera(2000)
          jugarPosicion(posicionsiguiente, tableroSiguiente, nivelSiguiente, 0, rellenarVidas(nivelSiguiente), puntuacion, tiempoInicial, jugadorSiguiente, partidasJugadas + 1)
        }
      }
    }
  }

  //Dada una posición, miro cuantos bloques borraria
  def cuantosBorraria(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (posicion > maxFilas(nivel) * maxColumnas(nivel)) { //si excedo los límites
      0
    } else {
      if (getElemento(posicion, tablero) == 8) { //Estamos ante una bomba
        return (puntosBomba(posicion, tablero, nivel) / 10)
      } else {
        if (tiene3EnLinea(posicion, tablero, nivel)) { //tiene mínimo 3 en linea
          return (puntos3EnLinea(posicion, tablero, nivel))
        } else { //solo puedo borrar el propio bloque
          if (getElemento(posicion, tablero) == 0) { //es una posicion con un espacio vacio
            0
          } else { //solo puedo borrar 1 bloques
            1
          }
        }
      }
    }
  }

  //retorna donde se encuentra el primer bloque que puedo borrar
  def getPosicionPrimerBloque(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (getElemento(posicion, tablero) != 0)
      return posicion
    else
      return getPosicionPrimerBloque(posicion + 1, tablero, nivel)
  }

  //este método buscará la mejor posicion que puede jugar la máquina (La que borre más bloques)
  def getPosicionJugar(posicion: Int, tablero: List[Int], nivel: Int): Int = {
    if (posicion > maxFilas(nivel) * maxColumnas(nivel)) { //he recorrido el tablerro y no encuentro bombas o 3 en línea
      //elimino el primer bloque que encuentre
      return getPosicionPrimerBloque(1, tablero, nivel)
    } else { //no he llegado al límite del tablero
      if (getElemento(posicion, tablero) == 8 || tiene3EnLinea(posicion, tablero, nivel)) {
        return posicion
      } else
        return getPosicionJugar(posicion + 1, tablero, nivel)
    }
  }

  //Método principal del juego
  def main(args: Array[String]) {
    println()
    //leemos por consola los datos necesarios para comenzar a jugar
    val nivel = leerDificultad()
    val jugador = leerJugador()
    val tiempoInicial = System.nanoTime() //empiezo a contar el tiempo de juego
    val tablero = crearBombas(crearTipoTablero(nivel), nivel)
    //muestro el tablero
    imprimir(tablero, nivel)
    if (jugador == 1) //Juega la persona
      jugarPosicion(posicionCorrecta(leerFila(maxFilas(nivel), maxColumnas(nivel)), tablero, nivel), tablero, nivel, 0, rellenarVidas(nivel), 0, tiempoInicial, jugador, 0)
    else { //juega la máquina
      //busco la mejor posicion para jugar
      val posi = getPosicionJugar(1, tablero, nivel)
      maquinajuegaPoscion(posi, nivel)
      espera(2000)
      jugarPosicion(posi, tablero, nivel, 0, rellenarVidas(nivel), 0, tiempoInicial, jugador, 0)
    }
  }
}
