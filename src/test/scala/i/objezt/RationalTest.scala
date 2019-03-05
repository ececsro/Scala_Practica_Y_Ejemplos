package i.objezt

import org.scalatest.FunSuite

class RationalTest extends FunSuite {

  test("") {
    assert(
      new Rational(1, 3) ==
        new Rational(1, 3))
    assert(
      new Rational(4, 6) ==
        new Rational(2, 3))
    assert(
      new Rational(-4, 6) ==
        new Rational(-2, 3))
    assert(
      new Rational(4, -6) ==
        new Rational(-2, 3))
  }

  test("+") {
    assert(
      new Rational(2, 6)
        + new Rational(1, 3)
        == new Rational(2, 3))
  }

  test("toString"){
    assert(
      new Rational(2, 6).toString
        == "1:3")
    assert(
      new Rational(20, -16).toString
        == "-5:4")
  }
}
