class Rational(numerator: Int, denominator: Int) {

  def this(numerator: Int) = this(numerator, 0)

  def this() = this(1, 0)

  private def simplification(numerator: Int, denominator: Int): (Int, Int) = {
    def gcd(x: Int, y: Int): Int =
      if (y == 0)
        x
      else
        gcd(y, x % y)

    val x = gcd(numerator, denominator)

    (numerator / x, denominator / x) match {
      case (a, b) if (b < 0) => (-a, -b)
      case (a, b) => (a, b)
    }
  }

  val (numerator_, denominator_) = this.simplification(numerator, denominator)

  def inverse: Rational =
    new Rational(this.denominator_, this.numerator_)

  def add(that: Rational): Rational =
    new Rational(
      this.numerator_ * that.denominator_ + that.numerator_ * this.denominator_,
      this.denominator_ * that.denominator_)

  def +(that: Rational): Rational =
    new Rational(
      this.numerator_ * that.denominator_ + that.numerator_ * this.denominator_,
      this.denominator_ * that.denominator_)

  def -(that: Rational): Rational =
    new Rational(this.numerator_ * that.denominator_ - that.numerator_ * this.denominator_,
      this.denominator_ * that.denominator_)

  def *(that: Rational): Rational =
    new Rational(this.numerator_ * that.numerator_, this.denominator_ * that.denominator_)

  def /(that: Rational): Rational =
    this * that.inverse

  def <(that: Rational): Boolean =
    this.numerator_ * that.denominator_ < that.numerator_ * this.denominator_

  def >(that: Rational): Boolean =
    this.numerator_ * this.denominator_ > that.numerator_ * that.denominator_

  def <=(that: Rational): Boolean =
    this.numerator_ * that.denominator_ <= that.numerator_ * this.denominator_

  def >=(that: Rational): Boolean =
    this.numerator_ * this.denominator_ >= that.numerator_ * that.denominator_

  def !=(that: Rational): Boolean =
    !(this == that)

  def ==(that: Rational): Boolean =
    this.equals(that)

  override def equals(that: Any): Boolean =
    that match {
      case that: Rational =>
        this.denominator_ == that.denominator_ &&
          this.numerator_ == that.numerator_
      case _ => false
    }

  override def hashCode(): Int = {
    val state = List(this.denominator_, this.numerator_)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Rational($this.numerator_ / $this.denominator_)"

}

