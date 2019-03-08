package ticTacToe.models

class DemoOrManual (gameMode : String = "D"){

  private val gameMode_ = gameMode

  def getGameMode: String = this.gameMode_
}
