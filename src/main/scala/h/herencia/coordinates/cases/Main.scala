package h.herencia.coordinates.cases

object Main {

  def main(args: Array[String]): Unit = {
    val listaPolimorfica = List(
      PolarCoordinate(1,1),
      CartesianCoordinate(2,3))

    listaPolimorfica match {
      case coordinate : PolarCoordinate =>
        CartesianCoordinate(coordinate.row, coordinate.column)
      case coordinate =>
        coordinate
    }


  }
}
