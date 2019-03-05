package ticTacToe.views

import ticTacToe.models.Coordinate

import scala.util.matching.Regex.Match

object DemoOrManualView {

  def askMode: String = {
    val gameMode = GestorIO.readString("Modo de juego? ['D'emo - 'M'anual]")
    gameMode match {
      case "D" | "d" | "Demo" | "demo"  => "D"
      case "M" | "m" | "Manual" | "manual" => "M"
      case _ => this.askMode
    }
  }

  def getCoordinate (gameMode: String): Coordinate = {
    def rndInt0_2: Int = {
      (new scala.util.Random).nextInt(3)
    }
    gameMode match {
      case "D" => new Coordinate(rndInt0_2, rndInt0_2)
      case "M" => CoordinateView.read
      case _ => new Coordinate(rndInt0_2, rndInt0_2)
    }
  }
}
