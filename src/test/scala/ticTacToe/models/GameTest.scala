package ticTacToe.models
import org.scalatest.FunSuite

class GameTest extends FunSuite {

    test("put on 1,1 with x") {
      val player = 0
      val turn = new Turn(player)

      val board = new Board()
      val game = new Game(turn,board)

      val coordinate = new Coordinate(1, 1)

      val returnedGame = game.put(coordinate)

      assert(returnedGame.getTurn.take == 1)
      assert(returnedGame.getBoard ==
        new Board(List(
          List(-1, -1, -1),
          List(-1, 0, -1),
          List(-1, -1, -1))))

      assert(game.put(coordinate) ==
        new Game(
          new Turn(1), new Board(List(
          List(-1, -1, -1),
          List(-1, 0, -1),
          List(-1, -1, -1))))
        )
    }

    test("put on 0,2 with o") {
      val board = new Board(List(
        List(-1, -1, -1),
        List(-1, 0, -1),
        List(-1, -1, -1)))
      val coordinate = new Coordinate(0, 2)
      val player = 1
      val turn = new Turn(player)

      val game = new Game(turn,board)

      assert(game.put(coordinate) ==
        new Game(new Turn(0), new Board(List(
          List(-1, -1, 1),
          List(-1, 0, -1),
          List(-1, -1, -1)))))
    }

    test("put on 2,0 with x") {
      val board = new Board(List(
        List(-1, -1, -1),
        List(-1, 0, -1),
        List(-1, -1, 1)))
      val coordinate = new Coordinate(2, 0)
      val player = 0
      val turn = new Turn(player)
      val game = new Game(turn,board)

      assert(game.put(coordinate) ==
        new Game(new Turn(1), new Board(List(
          List(-1, -1, -1),
          List(-1, 0, -1),
          List(0, -1, 1)))))
    }

    test("put on 2,0 with o when 2,0 was x") {
      val board = new Board(List(
        List(-1, -1, -1),
        List(-1, 0, -1),
        List(0, -1, 1)))
      val coordinate = new Coordinate(2, 0)
      val player = 1
      val turn = new Turn(player)
      val game = new Game(turn,board)
      assert(game.put(coordinate) ==
        new Game(turn, board))

//          new Board(List(
//          List(-1, -1, -1),
//          List(-1, 0, -1),
//          List(0, -1, 1)))))
    }

  test("move from 1,1 to 2,0 with x") {
    val board = new Board(List(
      List(-1, -1, -1),
      List(-1, 0, -1),
      List(-1, -1, 1)))
    val player = 0
    val turn = new Turn(player)
    val game = new Game(turn,board)

    val from = new Coordinate(1, 1)
    val to = new Coordinate(2, 0)

    assert(game.move(from, to) ==
      new Game(turn.changed,
      new Board(List(
        List(-1, -1, -1),
        List(-1, -1, -1),
        List(0, -1, 1)))))
  }

  test("when 1,1 is empty, move from 1,1 to 2,0 with x, then no change") {
    val board = new Board(List(
      List(-1, -1, -1),
      List(-1, -1, -1),
      List(-1, -1, 1)))
    val player = 0
    val turn = new Turn(player)
    val game = new Game(turn,board)

    val from = new Coordinate(1, 1)
    val to = new Coordinate(2, 0)

    assert(game.move(from, to) == new Game( turn, board))
  }

  test("when 2,1 is o, move from 1,1 to 2,1 with x, then no change") {
    val board = new Board(List(
      List(-1, -1, -1),
      List(-1, -1, -1),
      List(-1, 1, 1)))
    val player = 0
    val turn = new Turn(player)
    val game = new Game(turn,board)

    val from = new Coordinate(1, 1)
    val to = new Coordinate(2, 1)

    assert(game.move(from, to) == new Game( turn, board))
  }

  test("when 1,1 is o, move from 1,1 with x to 2,1, then no change") {
    val board = new Board(List(
      List(-1, -1, -1),
      List(-1, 0, -1),
      List(-1, 1, 1)))
    val player = 0
    val turn = new Turn(player)
    val game = new Game(turn,board)

    val from = new Coordinate(1, 1)
    val to = new Coordinate(2, 1)

    assert(game.move(from, to) == new Game( turn, board))
  }



}
