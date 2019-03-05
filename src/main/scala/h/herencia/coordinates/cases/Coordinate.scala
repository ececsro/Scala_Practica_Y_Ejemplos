package h.herencia.coordinates.cases

abstract class Coordinate {

  private val MAX = 3

  def row: Double

  def column: Double

  def distance: Double

  def angle: Double

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

  protected def inDiagonal: Boolean =
    this.row - this.column == 0

  protected def inInverse: Boolean =
    this.row + this.column == MAX - 1

  override def equals(that: Any): Boolean =
    that match {
      case that: Coordinate =>
        this.row == that.row &&
          this.column == that.column
      case _:Any => false
    }

  protected def round(value:Double):Double =
    Math.round(value*100)/100

}
