package ticTacToe.views

import ticTacToe.models.Coordinate
import ticTacToe.models.DemoOrManual

import scala.util.matching.Regex.Match

object DemoOrManualView {

  private var gameMode_ = new DemoOrManual("D")

  def askMode : String = {
    val gameMode = GestorIO.readString("Modo de juego? ['D'emo - 'M'anual]")
    gameMode match {
      case "D" | "d" | "Demo" | "demo"  => this.gameMode_ = new DemoOrManual("D")
      case "M" | "m" | "Manual" | "manual" => this.gameMode_ = new DemoOrManual("M")
      case _ => this.askMode
    }
    this.gameMode_.getGameMode
  }

  def getCoordinate : Coordinate = {
    def rndInt0_2: Int = {
      (new scala.util.Random).nextInt(3)
    }
     gameMode_.getGameMode match {
      case "D" => new Coordinate(rndInt0_2, rndInt0_2)
      case "M" => CoordinateView.read
      case _ => new Coordinate(rndInt0_2, rndInt0_2)
    }
  }
}
