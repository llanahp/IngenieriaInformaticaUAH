object Acciones {
  //Dada un indice  de una columna, retorna todos los elementos que se encuentren en esa columna
  def getColumna(columna: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (columna <= (maxColumnas(nivel) * maxFilas(nivel))) { //si no he llegado al final del tablero
      return getElemento(columna, tablero) :: getColumna((columna + maxColumnas(nivel)), tablero, nivel)
    } else { //llego al final del tablero
      return Nil
    }
  }

  //
  def reemplazarColumna(columna: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (columna <= (maxColumnas(nivel) * maxFilas(nivel))) {
      val actual = getElemento(columna, tablero)
      val anterior = getElemento(columna - 1, tablero)
      val tabl = setValor(actual, columna - 1, setValor(anterior, columna, tablero))
      return reemplazarColumna(columna + maxColumnas(nivel), tabl, nivel)
    } else {
      return tablero
    }
  }

  //Espera de tiempo que se le pase por referencia
  def espera(tiempo: Int): Unit = {
    Thread.sleep(tiempo)
  }

  //dado dos numeros, retorna el más grande
  def max(a: Int, b: Int): Int = {
    if (a >= b)
      return a
    else
      return b
  }

  //dado el nivel del juego, retorna el numero de elementos por fila
  def maxFilas(nivel: Int): Int = nivel match {
    case 1 => 9
    case 2 => 12
    case 3 => 25
  }

  //dado el nivel del juego, retorna el numero de elementos por columna
  def maxColumnas(nivel: Int): Int = nivel match {
    case 1 => 11
    case 2 => 16
    case 3 => 15
  }

  //Dada una lista, me dice su longitud
  def longitud(l: List[Int]): Int = l match {
    case Nil => 0
    case _ => 1 + longitud(l.tail)
  }

  //Genera un número aleatorio dado sus límites (incluidos)
  def numeroAleatorio(min: Int, Max: Int): Int = {
    val r = new scala.util.Random
    return min + r.nextInt((Max - min) + 1)
  }

  //Sustituye un valor en una posicion dada dentro del tablero
  def setValor(valor: Int, pos: Int, l: List[Int]): List[Int] = {
    if (l.isEmpty) Nil
    else if (pos == 1) valor :: l.tail
    else l.head :: setValor(valor, (pos - 1), l.tail)
  }

  //Me retorna el elmento que se encuentre en la posición indicada del tablero
  def getElemento(n: Int, l: List[Int]): Int = n - 1 match {
    case 0 => l.head
    case _ => getElemento(n - 1, l.tail)
  }

  //Dado el tiempo transcurrido, retorna solo los segundos
  def getSegundos(tiempo: Long): Long = {
    if (tiempo >= 60)
      return getSegundos(tiempo - 60)
    else
      return tiempo
  }

  //Dada una posición, borrará los elementos que se encuentren por encima de él
  def borrarArriba(posicionArriba: Int, target: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (posicionArriba > maxColumnas(nivel)) { //llamada recursiva
      if (posicionArriba < 0) { //Excede el límite del tablero
        return tablero
      } else {
        val arriba = getElemento(posicionArriba, tablero)
        if (arriba == target) { //Borro el centro y llamo reculsivamente
          val tab = setValor(0, posicionArriba, tablero)
          return borrarArriba(posicionArriba - maxColumnas(nivel), target, tab, nivel)
        } else
          return tablero
      }
    } else { //posicion arriba es el tope
      if (posicionArriba < 0) { //Excede el límite del tablero
        return tablero
      } else {
        val arriba = getElemento(posicionArriba, tablero)
        if (arriba == target) {
          return setValor(0, posicionArriba, tablero)
        } else
          return tablero
      }
    }
  }

  //Dada una posición, borrará los elementos que se encuentren por debajo de él
  def borrarAbajo(posicionAbajo: Int, target: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (posicionAbajo < (maxColumnas(nivel) * maxColumnas(nivel)) - maxColumnas(nivel)) { //llamada recursiva
      if (posicionAbajo > (maxFilas(nivel) * maxColumnas(nivel))) { //Excede el límite del tablero
        return tablero
      } else {
        val abajo = getElemento(posicionAbajo, tablero)
        if (abajo == target) {
          val tab = setValor(0, posicionAbajo, tablero)
          return borrarAbajo(posicionAbajo + maxColumnas(nivel), target, tab, nivel)
        } else
          return tablero
      }
    } else { //posicion abajo es el tope
      if (posicionAbajo > (maxFilas(nivel) * maxColumnas(nivel))) { //Excede el límite del tablero
        return tablero
      } else {
        val abajo = getElemento(posicionAbajo, tablero)
        if (abajo == target) {
          return setValor(0, posicionAbajo, tablero)
        } else
          return tablero
      }
    }
  }

  //Dada una posición, borrará los elementos que se encuentren a la derecha de él
  def borrarDerecha(target: Int, posicionDerecha: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (posicionDerecha > (maxFilas(nivel) * maxColumnas(nivel))) { //excede los límites
      return tablero
    } else {
      if (posicionDerecha != maxColumnas(nivel) && posicionDerecha / maxColumnas(nivel) != maxColumnas(nivel)) {
        val derecha = getElemento(posicionDerecha, tablero)
        if (derecha == target) {
          return borrarDerecha(target, posicionDerecha + 1, setValor(0, posicionDerecha, tablero), nivel)
        } else
          return tablero
      } else {
        if (posicionDerecha > (maxFilas(nivel) * maxColumnas(nivel))) { //Excede el límite del tablero
          return tablero
        } else {
          val derecha = getElemento(posicionDerecha, tablero)
          if (derecha == target) {
            return setValor(0, posicionDerecha, tablero)
          } else
            return tablero
        }
      }
    }
  }

  //Dada una posición, borrará los elementos que se encuentren a la izquierda de él
  def borrarIzquieda(posicionIzquiedo: Int, target: Int, tablero: List[Int], nivel: Int): List[Int] = {
    if (posicionIzquiedo % maxColumnas(nivel) != 1) {
      if (posicionIzquiedo < 0) { //Excede el límite del tablero
        return tablero
      } else {

        val izquierda = getElemento(posicionIzquiedo, tablero)
        if (izquierda == target) {
          val tab = setValor(0, posicionIzquiedo, tablero)
          return borrarIzquieda(posicionIzquiedo - 1, target, tab, nivel)
        } else
          return tablero
      }
    } else {
      if (posicionIzquiedo < 0) { //Excede el límite del tablero
        return tablero
      } else {
        val izquierda = getElemento(posicionIzquiedo, tablero)
        if (izquierda == target) {
          return setValor(0, posicionIzquiedo, tablero)
        } else
          return tablero
      }
    }
  }
}
