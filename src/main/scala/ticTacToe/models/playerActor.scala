package ticTacToe.models

import akka.actor.Actor
import ticTacToe.PlayMessage
import ticTacToe.views.DemoOrManualView

class playerActor() extends Actor {

  def receive = {
    case PlayMessage(game) =>
      if (!game.isComplete){
        sender ! PlayMessage(game.put(DemoOrManualView.getCoordinate))
      } else {
        sender ! PlayMessage(game.move(DemoOrManualView.getCoordinate, DemoOrManualView.getCoordinate))
      }
  }
}


