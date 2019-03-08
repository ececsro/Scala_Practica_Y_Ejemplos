package ticTacToe.models

import akka.actor.{Actor, ActorRef}
import ticTacToe.views.{GameView, GestorIO}
import ticTacToe.PlayMessage

class playersCoordinator(player1: ActorRef, player2: ActorRef) extends Actor {

  def receive = {
    case PlayMessage(game) =>
      GameView.write(game)
      if (!game.isTicTacToe) {
        game.getTurn.take match {
          case 0 => player1 ! PlayMessage(game)
          case 1 => player2 ! PlayMessage(game)
        }
      } else {
        context.system.terminate()
        GestorIO.write("... pero ha perdido")
      }
  }
}


