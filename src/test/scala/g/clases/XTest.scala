import org.scalatest.FunSuite

class XTest extends FunSuite {

  test("simplification 1/2") {
    val rational = new Rational(1, 2)
    assert(rational.toString == "Rational(1/2)")
  }

  test("simplification 2/4") {
    val rational = new Rational(2, 4)
    assert(rational.toString == "Rational(1/2)")
  }

  test("simplification -2/4") {
    val rational = new Rational(-2, 4)
    assert(rational.toString == "Rational(-1/2)")
  }

  test("simplification 2/-4") {
    val rational = new Rational(2, -4)
    assert(rational.toString == "Rational(-1/2)")
  }

  test("inverse"){
    val rational = new Rational(4,5)
    assert(rational.inverse == new Rational(5,4))
  }

  test("sum"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,4)
    assert(rationalX+rationalY== new Rational(3,1))
  }

  test("sum negative"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,-4)
    assert(rationalX+rationalY== new Rational(-3,2))
  }

  test("subtract"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,4)
    assert(rationalX - rationalY == new Rational(-3,2))
  }

  test("subtract negative"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,-4)
    assert(rationalX - rationalY == new Rational(3,1))
  }

  test("product"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,4)
    assert(rationalX * rationalY == new Rational(27,16))
  }

  test("product negative"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,-4)
    assert(rationalX * rationalY == new Rational(-27,16))
  }

  test("division"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,4)
    assert(rationalX / rationalY == new Rational(1,3))
  }

  test("division negative"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,-4)
    assert(rationalX / rationalY == new Rational(-1,3))
  }

  test("greater"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,-4)
    assert((rationalX > rationalY) == true)
  }

  test("less"){
    val rationalX = new Rational(3,4)
    val rationalY = new Rational(9,-4)
    assert((rationalX < rationalY) == false)
  }

}
