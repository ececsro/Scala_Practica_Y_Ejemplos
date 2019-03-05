package h.herencia.coordinates

class CartesianCoordinate(__row: Double = 0, __column: Double = 0) extends Coordinate {

  private val _row = __row
  private val _column = __column

  override def row =
    _row

  override def column =
    _column

  override def distance =
    Math.sqrt(Math.pow(__row, 2) + Math.pow(__column, 2))

  override def angle =
    Math.atan(__column / __row)

  override def toString: String =
    s"(${this.row}, ${this.column})"

}


