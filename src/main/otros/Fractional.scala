package g.clases

//import Fractional.Auxiliar
//
//class Rational (n: Int, d: Int) {
//  require(d != 0, "denominator must be nonzero")
//
//  private val numerator = this.simplification(n, d)._1
//  private val denominator = this.simplification(n, d)._2
//
//  private def simplification(numerator:Int, denominator:Int):(Int, Int) =
//    if (denominator < 0){
//      simplification(-numerator, -denominator)
//    } else {
//      val gcd = Auxiliar.gcd(numerator, denominator)
//      (numerator /gcd, denominator/gcd)
//    }
//
//  def + (that: Rational): Rational = {
//    new Rational((this.numerator) * (that.denominator) + that.numerator * this.denominator, this.denominator * that.denominator)
//  }
//
//  def - : Rational =
//    new Rational(-numerator, denominator)
//
//  def - (that: Rational): Rational =
//    new Rational(this.numerator * that.denominator - that.numerator * this.denominator.toInt, this.denominator * that.denominator)
//
//  def * (that: Rational): Rational =
//    new Rational(this.numerator * that.numerator.toInt, this.denominator * that.denominator)
//
//  def / (that: Rational): Rational =
//    this * that.inverse
//
//  def inverse: Rational =
//    new Rational(this.denominator, this.numerator)
//
//  def <= (that: Rational): Boolean = this.numerator / this.denominator <= that.numerator / that.denominator
//
//  def >= (that: Rational): Boolean = this.numerator / this.denominator >= that.numerator / that.denominator
//
//  def != (that: Rational): Boolean = !(this == that)
//
//  def == (that: Rational): Boolean = this.equals(that)
//
//  def canEqual (other: Any): Boolean = other.isInstanceOf[Rational]
//
//  override def equals (other: Any): Boolean = other match {
//    case that: Rational =>
//      (that canEqual this) &&
//        denominator == that.denominator &&
//        numerator == that.numerator
//    case _ => false
//  }
//
//  override def hashCode (): Int = {
//    val state = Seq(denominator, numerator)
//    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
//  }
//
//  override def toString = s"Rational($denominator, $numerator)"
//}
