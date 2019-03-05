package g.clases.visibilidad.funcional.publicos.cambio

class Coordinate(val __row: Double = 0, val __column: Double = 0) {

  private val _distance = Math.sqrt(Math.pow(__row, 2) + Math.pow(__column, 2))
  private val _angle = __column / __row
  private val MAX = 3

  def row =
    this._distance * Math.cos(this._angle)

  def column =
    this._distance * Math.sin(this._angle)

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
