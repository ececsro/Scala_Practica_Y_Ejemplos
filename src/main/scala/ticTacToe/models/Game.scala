package ticTacToe.models

class Game(turn: Turn = new Turn, board: Board = new Board()) {

  private val turn_ = turn
  private val board_ = board

  def getBoard = {
    board_
  }

  def getTurn = {
    turn_
  }

  def put(coordinate: Coordinate): Game = {
    if (this.board_.getColor(coordinate) == -1) {
      val newTurn = this.turn_.changed
      val newBoard = this.board_.put(coordinate, this.turn_.take)
      new Game(newTurn, newBoard)
    }
    else
      this
  }

  def move(from: Coordinate, to: Coordinate): Game = {
    val player = turn.take
    if (this.board_.getColor(from) == player && this.board_.getColor(to) == -1 ) {
      val newTurn = this.turn_.changed
      val newBoard = this.board_.move(from, to)
      new Game(newTurn, newBoard)
    }
    else
      this
  }

  def isTicTacToe: Boolean = board_.isTicTacToe

  def isComplete: Boolean = board_.isComplete

  def getColor(coordinate:Coordinate):Int = board_.getColor(coordinate)

  def take : Int = turn_.take

  def canEqual(other: Any): Boolean = other.isInstanceOf[Game]

  override def equals(other: Any): Boolean = other match {
    case that: Game =>
      (that canEqual this) &&
        turn_ == that.turn_ &&
        board_ == that.board_
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(turn_, board_)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
