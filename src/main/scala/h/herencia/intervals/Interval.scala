package h.herencia.intervals

abstract class Interval(__min: Double = 0, __max: Double = 0) {

  protected val _min = __min
  protected val _max = __max

  def min = _min

  def max = _max

  def includes(value: Double): Boolean

  override def toString = s"${this.min} - ${this.max}"

}
