package ticTacToe.models

class DemoOrManual (gameMode : String = "D"){

  private val gameMode_ = gameMode

  def getGameMode: String = this.gameMode_

  def canEqual(other: Any): Boolean = other.isInstanceOf[DemoOrManual]

  override def equals(other: Any): Boolean = other match {
    case that: DemoOrManual =>
      (that canEqual this) &&
        gameMode_ == that.gameMode_
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(gameMode_)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"DemoOrManual($gameMode_)"
}
