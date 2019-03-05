package x

import org.scalatest.FunSuite

class CoordinateTest extends FunSuite {

  test("inDiagonal"){
    val coordinate = new Coordinate(0,0)
    assert(coordinate.inDiagonal)
  }

  test("!inDiagonal"){
    val coordinate = new Coordinate(1,0)
    assert(!coordinate.inDiagonal)
  }

  test("inInverse"){
    val coordinate = new Coordinate(2,0)
    assert(coordinate.inInverse)
  }

  test("!inInverse"){
    val coordinate = new Coordinate(1,0)
    assert(!coordinate.inInverse)
  }

  test("direction horizontal") {
    val left = new Coordinate(2,0)
    val right = new Coordinate(2, 1)
    assert(left.getDirection(right)=="Horizontal")
  }

  test("direction vertical") {
    val left = new Coordinate(0,1)
    val right = new Coordinate(2, 1)
    assert(left.getDirection(right)=="Vertical")
  }

  test("direction diagonal") {
    val left = new Coordinate(0,0)
    val right = new Coordinate(2, 2)
    assert(left.getDirection(right)=="Diagonal")
  }

  test("direction inverse") {
    val left = new Coordinate(2,0)
    val right = new Coordinate(0, 2)
    assert(left.getDirection(right)=="Inverse")
  }

  test("direction without") {
    val left = new Coordinate(2,0)
    val right = new Coordinate(1, 2)
    assert(left.getDirection(right)=="")
  }

  test("shiftV"){
    val coordinate = new Coordinate(1,0)
    assert(coordinate.shiftV(5)==new Coordinate(6,0))
  }

}