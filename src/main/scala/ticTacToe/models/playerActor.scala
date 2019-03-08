package ticTacToe.models

import akka.actor.{Actor, ActorRef}
import ticTacToe.{PlayMessage, StartPlay}
import ticTacToe.views.{DemoOrManualView, GameView, GestorIO}

class playerActor(otherPlayer: ActorRef) extends Actor {

  def receive = {
    case StartPlay (game) =>
      otherPlayer ! PlayMessage (game)

    case PlayMessage(game) =>
      GameView.write(game)
      if (!game.isTicTacToe) {
        val turn = game.getTurn
        if (!game.isComplete) {
          sender ! PlayMessage(game.put(DemoOrManualView.getCoordinate(turn)))
        } else {
          sender ! PlayMessage(game.move(DemoOrManualView.getCoordinate(turn), DemoOrManualView.getCoordinate(turn)))
        }
      }  else {
        context.system.terminate()
        GestorIO.write("... pero ha perdido")
      }
  }
}


