package h.herencia.coordinates

class PolarCoordinate(__distance: Double = 0, __angle: Double = 0) extends Coordinate {

  private val _distance = __distance
  private val _angle = __angle

  override def row =
    this._distance * Math.cos(this._angle)

  override def column =
    this._distance * Math.sin(this._angle)

  override def distance =
    _distance

  override def angle =
    _angle

  override def toString: String =
    s"(${this.distance}, ${this.angle})"

}

