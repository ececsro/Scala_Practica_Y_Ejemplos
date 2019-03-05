class Interval(minimum:Double=0, maximum:Double=0) {

  private val minimum_ = minimum
  private val maximum_ = maximum

  def shifted(value:Double):Interval = {
    new Interval(minimum_ + value, maximum_ + value)
  }

  def include(value:Double):Boolean =
    minimum_ <= value && value <= maximum_

  def include(that:Interval):Boolean =
    this.include(that.minimum_) && this.include(that.maximum_)

  def intersect(that:Interval):Boolean =
    this.include(that.minimum_) || this.include(that.maximum_)

  def intersection(that:Interval):Interval =
    new Interval(this.minimum_.min(that.minimum_), this.maximum_.max(that.maximum_))

  def union(that:Interval):Interval =
    new Interval(this.minimum_.min(that.minimum_), this.maximum_.max(that.maximum_))



}