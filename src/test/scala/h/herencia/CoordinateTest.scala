package h.herencia

import h.herencia.coordinates.{CartesianCoordinate, Coordinate, PolarCoordinate}
import org.scalatest.FunSuite

class CoordinateTest extends FunSuite {

  private def precision(left:Double, right:Double):Boolean =
    (left-right).abs<0.1

  test("cartesian 3,4"){
    val cartesian : Coordinate = new CartesianCoordinate(3,4)
    assert(precision(cartesian.row, 3))
    assert(precision(cartesian.column, 4))
    assert(precision(cartesian.distance, 5))
    assert(precision(cartesian.angle, 0.93))
  }

  test("cartesian 5,12"){
    val cartesian = new CartesianCoordinate(5,12)
    assert(precision(cartesian.row, 5))
    assert(precision(cartesian.column, 12))
    assert(precision(cartesian.distance, 13))
    assert(precision(cartesian.angle, 1.18))
  }

  test("polar 5,0.93"){
    val cartesian = new PolarCoordinate(5,0.93)
    assert(precision(cartesian.row, 3))
    assert(precision(cartesian.column, 4))
    assert(precision(cartesian.distance, 5))
    assert(precision(cartesian.angle, 0.93))
  }

  test("polar 13,1.18 "){
    val cartesian = new PolarCoordinate(13,1.18)
    assert(precision(cartesian.row, 5))
    assert(precision(cartesian.column, 12))
    assert(precision(cartesian.distance, 13))
    assert(precision(cartesian.angle, 1.18))
  }

}
