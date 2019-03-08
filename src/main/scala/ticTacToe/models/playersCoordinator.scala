package ticTacToe.models

import akka.actor.{Actor, ActorRef}
import ticTacToe.Main.game
import ticTacToe.views.{DemoOrManualView, GameView, GestorIO}
import ticTacToe.{PlayMessage, StartMessage}

class playersCoordinator(game: Game, player1: ActorRef, player2: ActorRef) extends Actor {

  def receive = {
    case PlayMessage(game) =>
      GameView.write(game)
      if (!this.game.isTicTacToe) {
        this.game.getTurn.take match {
          case 0 => player1 ! PlayMessage(game)
          case 1 => player2 ! PlayMessage(game)
        }
      } else {
        context.system.terminate()
        GestorIO.write("... pero has perdido")
      }
  }
}


