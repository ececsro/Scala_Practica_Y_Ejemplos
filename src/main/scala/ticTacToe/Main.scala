package ticTacToe

import ticTacToe.models.{Game, playerActor}
import ticTacToe.views.{DemoOrManualView, GestorIO, MainView}
import akka.actor._

case class PlayMessage(game: Game)
case class StartPlay(game: Game)

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

//    MainView.startGame

    val gameMode = DemoOrManualView.askMode
    GestorIO.write(s"Modo de juego: ${gameMode}\n")
    
    val system = ActorSystem("PlayerCoordinator")
    val player1 = system.actorOf(Props (new playerActor(null)), name = "p1")
    val player2 = system.actorOf(Props (new playerActor(player1)), name = "p2")

    player2 ! StartPlay(game)
  }
}