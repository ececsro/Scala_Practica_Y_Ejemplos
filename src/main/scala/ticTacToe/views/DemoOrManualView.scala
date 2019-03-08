package ticTacToe.views

import ticTacToe.models.{Coordinate, DemoOrManual, Turn}

object DemoOrManualView {

  private var gameMode_ = new DemoOrManual("D")

  def askMode : String = {
    val gameMode = GestorIO.readString("Modo de juego? " +
      "['D'emo - 'M'anual - " +
      "'X|1':Jugador 1 Manual - " +
      "'O|2': Jugador 2 Manual]")
    gameMode match {
      case "D" | "d" | "Demo" | "demo"  => this.gameMode_ = new DemoOrManual("D")
      case "M" | "m" | "Manual" | "manual" => this.gameMode_ = new DemoOrManual("M")
      case "1" | "X" | "x" => this.gameMode_ = new DemoOrManual("X")
      case "2" | "O" | "o" => this.gameMode_ = new DemoOrManual("O")
      case _ => this.askMode
    }
    this.gameMode_.getGameMode
  }

  def getCoordinate(turn:Turn) : Coordinate = {
    def rndInt0_2: Int = {
      (new scala.util.Random).nextInt(3)
    }

    (gameMode_.getGameMode, turn.take) match {
      case ("D",_) => new Coordinate(rndInt0_2, rndInt0_2)
      case ("M",_) => CoordinateView.read
      case ("X",0) => CoordinateView.read
      case ("X",1) => new Coordinate(rndInt0_2, rndInt0_2)
      case ("O",0) => new Coordinate(rndInt0_2, rndInt0_2)
      case ("O",1) => CoordinateView.read
      case _ => new Coordinate(rndInt0_2, rndInt0_2)
    }
  }
}
