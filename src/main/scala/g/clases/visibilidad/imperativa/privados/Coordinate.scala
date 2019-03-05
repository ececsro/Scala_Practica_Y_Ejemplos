package g.clases.visibilidad.imperativa.privados

class Coordinate(__row: Double = 0, __column: Double = 0) {

  private var _row = __row
  private var _column = __column
  private val MAX = 3

  def row = _row

  def row_=(row: Double): Unit = {
    this._row = row
  }

  def column = _column

  def column_=(column: Double): Unit = {
    this._column = column
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