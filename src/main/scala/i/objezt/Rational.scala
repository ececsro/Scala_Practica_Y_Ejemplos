package i.objezt

object Rational {

  def simplification(left: Int, right: Int): (Int, Int) = {
    def gcd(left: Int, right: Int): Int =
      if (right == 0)
        left
      else
        gcd(right, left % right)

    val denominator = gcd(left, right)

    (left / denominator, right / denominator) match {
      case (left, right) if (right < 0) => (-left, -right)
      case (left, right) => (left, right)
    }
  }
}

class Rational(__numerator: Int = 1, __denominator: Int = 0) {

  private val (_numerator, _denominator) =
    Rational.simplification(__numerator, __denominator)

  def inverse: Rational =
    new Rational(this._denominator, this._numerator)

  def add(that: Rational): Rational =
    new Rational(
      this._numerator * that._denominator + that._numerator * this._denominator,
      this._denominator * that._denominator)

  def +(that: Rational): Rational =
    new Rational(
      this._numerator * that._denominator + that._numerator * this._denominator,
      this._denominator * that._denominator)

  def -(that: Rational): Rational =
    new Rational(this._numerator * that._denominator - that._numerator * this._denominator,
      this._denominator * that._denominator)

  def *(that: Rational): Rational =
    new Rational(this._numerator * that._numerator, this._denominator * that._denominator)

  def /(that: Rational): Rational =
    this * that.inverse

  def <(that: Rational): Boolean =
    this._numerator * that._denominator < that._numerator * this._denominator

  def >(that: Rational): Boolean =
    this._numerator * this._denominator > that._numerator * that._denominator

  def <=(that: Rational): Boolean =
    this._numerator * that._denominator <= that._numerator * this._denominator

  def >=(that: Rational): Boolean =
    this._numerator * this._denominator >= that._numerator * that._denominator

  def !=(that: Rational): Boolean =
    !(this == that)

  def ==(that: Rational): Boolean =
    this.equals(that)

  override def equals(that: Any): Boolean =
    that match {
      case that: Rational =>
        this._denominator == that._denominator &&
          this._numerator == that._numerator
      case _ => false
    }

  override def hashCode(): Int = {
    val state = List(this._denominator, this._numerator)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = {
    s"${this._numerator}:${this._denominator}"
  }

}


