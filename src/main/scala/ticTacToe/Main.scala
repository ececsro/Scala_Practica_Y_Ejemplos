package ticTacToe

import ticTacToe.models.Game
import ticTacToe.views.{CoordinateView, DemoOrManualView, GameView, GestorIO}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

    val gameMode = DemoOrManualView.askMode
    GestorIO.write(s"Modo de juego: $gameMode\n")

    GameView.write(game)

    do {
      if (!game.isComplete){
        game = game.put(DemoOrManualView.getCoordinate(gameMode))
      } else {
        game = game.move(DemoOrManualView.getCoordinate(gameMode), DemoOrManualView.getCoordinate(gameMode))
      }
      GameView.write(game)
    } while (!game.isTicTacToe)
    GestorIO.write("... pero has perdido")
  }
}
