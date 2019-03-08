package ticTacToe.models

import akka.actor.Actor
import ticTacToe.PlayMessage
import ticTacToe.views.DemoOrManualView

class playerActor() extends Actor {

  def receive = {
    case PlayMessage(game) =>
      val turn = game.getTurn
      if (!game.isComplete){
        sender ! PlayMessage(game.put(DemoOrManualView.getCoordinate(turn)))
      } else {
        sender ! PlayMessage(game.move(DemoOrManualView.getCoordinate(turn), DemoOrManualView.getCoordinate(turn)))
      }
  }
}


