package g.clases.visibilidad.imperativa.publicos.cambio

class Coordinate(__row : Double = 0, __column : Double = 0){

  private var _distance = Math.sqrt(Math.pow(__row, 2) + Math.pow(__column, 2))
  private var _angle = __column / __row

  private val MAX = 3

  def row =
    this._distance * Math.cos(this._angle)

  def row_=(row: Double): Unit = {
    val newCoordinate = new Coordinate(row, this.column)
    this._distance = newCoordinate._distance
    this._angle = newCoordinate._angle
  }

  def column =
    this._distance * Math.sin(this._angle)

  def column_=(column: Double): Unit = {
    val newCoordinate = new Coordinate(this.row, column)
    this._distance = newCoordinate._distance
    this._angle = newCoordinate._angle
  }

  def direction(that: Coordinate): String =
    if (this.row == that.row)
      "Horizontal"
    else if (this.column == that.column)
      "Vertical"
    else if (this.inDiagonal && that.inDiagonal)
      "Diagonal"
    else if (this.inInverse && that.inInverse)
      "Inverse"
    else
      ""

  private def inDiagonal: Boolean =
    this.row - this.column == 0

  private def inInverse: Boolean =
    this.row + this.column == MAX - 1

  override def equals(that: Any): Boolean =
    that match {
      case that: Coordinate =>
        (this.row == that.row) &&
          (this.column == that.column)
      case _ => false
    }

  override def toString: String = s"($this.row_, $this.column_)"

}