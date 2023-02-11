import scala.collection.parallel.immutable.ParVector

object paralelizacion extends App {


  def max(a: Int, b: Int): Int = {
    if (a >= b)
      return a
    else
      return b
  }

  def maximo(tablero: ParVector[Int]): Int = {
    if (!tablero.isEmpty) {
      val primero = tablero.head
      if (!tablero.tail.isEmpty) {
        val otro = maximo(tablero.tail)
        println("\t" + tablero.tail)
        println("\t" + otro)
        return max(tablero.head, otro)
      } else {
        primero
      }
    } else {
      println("a")
      0 //nunca entra aquí
    }
  }


  def mostrar(valor: Int) = println(valor)
  //println(maximo(tablero))

  val tablero = List(9, 8, 7, 6, 5, 4, 3, 2, 1).toVector.par

  def prueba(tablero: ParVector[Int]): Unit = {
    if (!tablero.isEmpty) {
      mostrar(tablero.head)
      prueba(tablero.tail)
    }
  }

  prueba(tablero)

}
