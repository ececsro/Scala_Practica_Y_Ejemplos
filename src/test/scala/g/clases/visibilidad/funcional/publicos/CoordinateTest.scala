package g.clases.visibilidad.funcional.publicos

import org.scalatest.FunSuite

class CoordinateTest extends FunSuite {

  test("constructor") {
    val coordinate = new Coordinate(3,4)
    assert(coordinate.row==3 && coordinate.column==4)
  }

  test("direction"){
    assert(
      new Coordinate(3,4).direction(
        new Coordinate(3,6)) =="Horizontal")

    assert(
      new Coordinate(1,6).direction(
        new Coordinate(3,6)) =="Vertical")

    assert(
      new Coordinate(2,2).direction(
        new Coordinate(0,0)) =="Diagonal")

    assert(
      new Coordinate(2,0).direction(
        new Coordinate(1,1)) =="Inverse")

    assert(
      new Coordinate(3,4).direction(
        new Coordinate(5,6)) =="")

  }
}
