package h.herencia.coordinates

object Main {

  def main(args: Array[String]): Unit = {
    val listaPolimorfica = List(
      new PolarCoordinate(1,1),
      new CartesianCoordinate(2,3))

    listaPolimorfica match {
      case coordinate : PolarCoordinate =>
        new CartesianCoordinate(coordinate.row, coordinate.column)
      case coordinate =>
        coordinate
    }
  }
}
