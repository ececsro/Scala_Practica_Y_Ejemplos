package h.herencia.intervals

class ClosedInterval(__min:Double, __max:Double) extends Interval(__min, __max){

  override def includes(value: Double): Boolean =
    this.min <= value && value <= this.max

  override def toString = "[" + super.toString + "]"
}
