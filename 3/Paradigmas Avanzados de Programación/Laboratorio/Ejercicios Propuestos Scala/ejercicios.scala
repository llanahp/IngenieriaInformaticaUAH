object ejercicios extends App {
  //1
  println("Ejercicio 1")

  def crearLista(n: Int): List[Int] = n match {
    case 0 => Nil
    case _ => n :: crearLista(n - 1)
  }

  val listaEnteros = crearLista(5)
  println(listaEnteros)

  //2
  println("Ejercicio 2")

  def sumaLista(l: List[Int]): Int = l match {
    case Nil => 0
    case _ => l.head + sumaLista(l.tail)
  }

  val suma = sumaLista(listaEnteros)
  println(suma)

  //3
  def sumaPares(n: Int): Int = n match {
    case 0 => 0
    case _ => if (n % 2 == 0) n + sumaPares(n - 1); else sumaPares(n - 1)
  }

  val sumaDePares = sumaPares(5)

  //4
  def sumaEntreNumeros(a: Int, b: Int): Int = {
    if (a + 1 < b) (a + 1) + sumaEntreNumeros(a + 1, b)
    else 0
  }

  val entre = sumaEntreNumeros(1, 4)
  //5
  println("Ejercicio 5")

  def opEntreNumeros(a: Int, b: Int, f: Int => Int): Int = {
    if (a + 1 < b) f(1 + a) + opEntreNumeros(a + 1, b, f)
    else 0
  }

  val entreCuadrado = opEntreNumeros(1, 4, (x: Int) => x * x) //2 y 3
  println(entreCuadrado)
  //6
  println("Ejercicio 6")

  def sumf1n(x: Int): Int = {
    x
  }
  def opEntreNumeros(a: Int, b: Int): Int = {
    if (a + 1 < b) sumf1n(1 + a) + opEntreNumeros(a + 1, b)
    else 0
  }

  val sumatorioOperacion = opEntreNumeros(1, 4)
  println(sumatorioOperacion)

  //7
  println("Ejercicio 7")

  def sumf1n2(x: Int): Int = {
    if (x % 10 == 2) x
    else if (x % 10 == 3) x
    else 0
  }

  def opEntreNumeros2(a: Int, b: Int): Int = {
    if (a <= b) sumf1n2(a) + opEntreNumeros2(a + 1, b)
    else 0
  }

  val sumatorioOperacion2 = opEntreNumeros2(0, 5)
  println(sumatorioOperacion2)
  //8
  println("Ejercicio 8")

  def numCifras(n: Int): Int = {
    if (n <= 9) 1
    else 1 + numCifras(n / 10)
  }

  val cifras = numCifras(1234)
  println(cifras)
  //9
  println("Ejercicio 9")

  def toma(n: Int, l: List[Int]): List[Int] = {
    if (l != Nil)
      if (n > 0) l.head :: toma(n - 1, l.tail)
      else Nil
    else Nil
  }

  val tomar = toma(4, List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  println(tomar)

  def deja(n: Int, l: List[Int]): List[Int] = {
    if (n > 0)
      l.head :: deja(n - 1, l.tail)
    else
      Nil
  }

  val dejar = deja(6, List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  println(dejar)

  //10
  def aplicaCua(f: Int => Int, l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case _ => f(l.head) :: aplicaCua(f, l.tail)
  }

  val aplicarListaCuadrado = aplicaCua((x: Int) => x * x, List(1, 2, 3, 4, 5, 6, 7, 8, 9))

  def aplicaCubo(f: Int => Int, l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case _ => f(l.head) :: aplicaCubo(f, l.tail)
  }

  val aplicarListaCubo = aplicaCubo((x: Int) => x * x * x, List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  //11
  println("Ejercicio 11") //matriz 4 * 4

  def longitud(l: List[Any]): Int = l match {
    case Nil => 0
    case _ => 1 + longitud(l.tail)

  }

  def imprimir(l: List[Int]): Any = {
    if (l.isEmpty || l.head == Nil || longitud(l) == 0) {
      print("")
    } else {
      if ((longitud(l) - 1) % 4 == 0) {
        println(l.head)
        imprimir(l.tail)
      } else {
        print(l.head + " ")
        imprimir(l.tail)
      }
    }
  }

  imprimir(List(9, 8, 7, 6, 1, 2, 3, 4, 9, 8, 7, 6, 4, 5, 6, 7))

  //12
  println("Ejercicio 12") //matriz 8 * 8

  def imprimir64(l: List[Int]): Any = {
    if (l.isEmpty || l.head == Nil || longitud(l) == 0) {
      print("")
    } else {
      if ((longitud(l) - 1) % 8 == 0) {
        println(l.head)
        imprimir64(l.tail)
      } else {
        print(l.head + " ")
        imprimir64(l.tail)
      }
    }
  }

  def leerElemento(n: Int, l: List[Int]): Int = n - 1 match {
    case 0 => l.head
    case _ => leerElemento(n - 1, l.tail)
  }

  def leerFilaAux(n: Int, l: List[Int]): List[Int] = n match {
    case 0 => l
    case _ => leerFilaAux(n - 1, l.tail)
  }

  def leerFilaSelecion(n: Int, l: List[Int]): List[Int] = n match {
    case 0 => Nil
    case _ => l.head :: leerFilaSelecion(n - 1, l.tail)
  }

  def leerFila(n: Int, l: List[Int]): List[Int] = {
    leerFilaSelecion(8, leerFilaAux(n * 8, l))
  }

  def leerColumna(n: Int, l: List[Int]): List[Int] = {
    if (l.isEmpty) {
      Nil
    } else {
      if (n == 0) {
        if (8 - (longitud(l) % 8) == 8) {
          l.head :: leerColumna(n, l.tail)
        } else {
          leerColumna(n, l.tail)
        }
      } else {
        if (8 - (longitud(l) % 8) == n) {
          l.head :: leerColumna(n, l.tail)
        } else {
          leerColumna(n, l.tail)
        }
      }
    }
  }

  def transpuestaAux(n: Int, l: List[Int]): List[Int] = {
    if (n < 8)
      leerColumna(n, l) ::: transpuestaAux(n + 1, l)
    else
      Nil
  }

  def transpuesta(l: List[Int]): List[Int] = {
    transpuestaAux(0, l)
  }

  val lista = List.range(0, 64)
  imprimir64(lista)
  leerElemento(4, lista)
  leerFila(2, lista)
  leerColumna(2, lista)
  transpuesta(lista)

  //13
  def seleccionar(l1: List[Boolean], l2: List[Any]): List[Any] = {
    if (longitud(l1) != longitud(l2)) {
      println("Error, listas de longitudes diferentes")
      Nil
    } else {
      if (!l1.isEmpty && !l2.isEmpty) {
        if (l1.head) {
          l2.head :: seleccionar(l1.tail, l2.tail)
        } else {
          Nil :: seleccionar(l1.tail, l2.tail)
        }
      } else {
        Nil
      }
    }
  }

  seleccionar(List(false, true, true, true, false), List(2, 3, 4, 7, 2))

  //14
  def mezclar(l1: List[Int], l2: List[Int]): List[Int] = {
    if (!l1.isEmpty) {
      if (!l2.isEmpty) {
        l1.head :: l2.head :: mezclar(l1.tail, l2.tail)
      } else {
        l1.head :: mezclar(l1.tail, l2)
      }
    } else {
      if (!l2.isEmpty) {
        l2.head :: mezclar(l1, l2.tail)
      } else {
        Nil
      }
    }
  }

  mezclar(List(1, 2, 3), List(4, 5, 6))

  //15
  def buscarAux(valor: Int, contador: Int, l: List[Int]): Int = {
    if (l.isEmpty)
      0
    else {
      if (valor == l.head) {
        contador
      } else {
        buscarAux(valor, contador + 1, l.tail)
      }
    }
  }

  def buscar(valor: Int, l: List[Int]): Int = {
    buscarAux(valor, 1, l)
  }

  buscar(1, List(4, 5, 6, 7, 8, 9))
}

