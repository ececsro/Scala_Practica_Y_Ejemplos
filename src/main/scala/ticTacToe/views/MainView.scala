package ticTacToe.views

import akka.actor.{ActorSystem, Props}
import ticTacToe.Main.game
import ticTacToe.StartPlay
import ticTacToe.models.{Game, playerActor}

object MainView {

  var game = new Game

  def startGame {
    val gameMode = DemoOrManualView.askMode
    GestorIO.write(s"Modo de juego: ${gameMode}\n")

    val system = ActorSystem("PlayerCoordinator")
    val player1 = system.actorOf(Props(new playerActor(null)), name = "p1")
    val player2 = system.actorOf(Props(new playerActor(player1)), name = "p2")

    player2 ! StartPlay(game)
  }
}
