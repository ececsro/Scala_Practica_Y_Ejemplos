package x

import org.scalatest.FunSuite

class BoardTest extends FunSuite {

  test("put on 1,1 with x") {
    val board = new Board()
    val coordinate = new Coordinate(1, 1)
    val player = 'x'
    assert(board.put(coordinate, player) ==
      new Board(List(
        List(' ', ' ', ' '),
        List(' ', 'x', ' '),
        List(' ', ' ', ' '))))
  }

  test("put on 0,2 with o") {
    val board = new Board(List(
      List(' ', ' ', ' '),
      List(' ', 'x', ' '),
      List(' ', ' ', ' ')))
    val coordinate = new Coordinate(0, 2)
    val player = 'o'
    assert(board.put(coordinate, player) ==
      new Board(List(
        List(' ', ' ', 'o'),
        List(' ', 'x', ' '),
        List(' ', ' ', ' '))))
  }

  test("put on 2,0 with x") {
    val board = new Board(List(
      List(' ', ' ', ' '),
      List(' ', 'x', ' '),
      List(' ', ' ', 'o')))
    val coordinate = new Coordinate(2, 0)
    val player = 'x'
    assert(board.put(coordinate, player) ==
      new Board(List(
        List(' ', ' ', ' '),
        List(' ', 'x', ' '),
        List('x', ' ', 'o'))))
  }

  test("move from 1,1 to 2,0 with x") {
    val board = new Board(List(
      List(' ', ' ', ' '),
      List(' ', 'x', ' '),
      List(' ', ' ', 'o')))
    val from = new Coordinate(1, 1)
    val to = new Coordinate(2, 0)
    val player = 'x'
    assert(board.move(from, to) ==
      new Board(List(
        List(' ', ' ', ' '),
        List(' ', ' ', ' '),
        List('x', ' ', 'o'))))
  }

  test("getColor") {
    val board = new Board(List(
      List(' ', ' ', ' '),
      List(' ', 'x', ' '),
      List(' ', ' ', 'o')))
    assert(board.getColor(new Coordinate(0, 0)) == ' ')
    assert(board.getColor(new Coordinate(1, 1)) == 'x')
    assert(board.getColor(new Coordinate(2, 2)) == 'o')
  }

  test("complete") {
    val board = new Board(List(
      List('x', 'o', ' '),
      List(' ', 'x', ' '),
      List('o', 'x', 'o')))
    assert(board.isComplete)
  }

  test("not complete") {
    val board = new Board(List(
      List('x', 'o', ' '),
      List(' ', ' ', ' '),
      List('o', 'x', 'o')))
    assert(!board.isComplete)
  }

  test("getCoordinates") {
    val board = new Board(List(
      List('x', 'o', ' '),
      List(' ', 'x', ' '),
      List('o', 'x', 'o')))
    assert(
      board.getCoordinates('x')
        ==
        List(
          new Coordinate(0, 0),
          new Coordinate(1, 1),
          new Coordinate(2, 1)))
    assert(
      board.getCoordinates('o')
        ==
        List(
          new Coordinate(0, 1),
          new Coordinate(2, 0),
          new Coordinate(2, 2)))
    assert(
      board.getCoordinates(' ')
        ==
        List(
          new Coordinate(0, 2),
          new Coordinate(1, 0),
          new Coordinate(1, 2)))
  }

  test("directions") {
    val board = new Board()
    assert(board.getDirections(List(
      new Coordinate(0, 2),
      new Coordinate(1, 0),
      new Coordinate(1, 2)
    )) == List("", "Horizontal"))
    assert(board.getDirections(List(
      new Coordinate(0, 0),
      new Coordinate(2, 2),
      new Coordinate(1, 1)
    )) == List("Diagonal", "Diagonal"))
    assert(board.getDirections(List(
      new Coordinate(0, 2),
      new Coordinate(0, 0),
      new Coordinate(2, 0)
    )) == List("Horizontal", "Vertical"))
  }

  test("equals strings") {
    val board = new Board()
    assert(board.equals(List("a", "a", "a")))
    assert(!board.equals(List("a", "b", "a")))
  }

  test("isTicTacToe") {
    assert(new Board(List(
      List('x', 'o', ' '),
      List(' ', 'x', ' '),
      List('o', ' ', 'x'))).isTicTacToe('x'))
    assert(new Board(List(
      List('x', 'o', ' '),
      List(' ', 'o', ' '),
      List('x', 'o', 'x'))).isTicTacToe('o'))
    assert(!new Board(List(
      List('x', 'o', ' '),
      List(' ', ' ', ' '),
      List('o', ' ', 'x'))).isTicTacToe('x'))
  }


}
