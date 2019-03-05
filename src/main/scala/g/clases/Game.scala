package x

class Game(turn: Turn = new Turn, board: Board = new Board()) {

  private val turn_ = turn

  private val board_ = board

  def put(coordinate: Coordinate): Game = {
    val newTurn = this.turn_.changed
    val newBoard = this.board_.put(coordinate, this.turn_.take)
    new Game(newTurn, newBoard)
  }

  def move(from: Coordinate, to: Coordinate): Game = {
    val newTurn = this.turn_.changed
    val newBoard = this.board_.move(from, to)
    new Game(newTurn, newBoard)
  }

  def isTicTacToe: Boolean = board.isTicTacToe

  def isComplete: Boolean = board.isComplete

  def getBoard = this.board_

  def getTurn = this.turn_
}
