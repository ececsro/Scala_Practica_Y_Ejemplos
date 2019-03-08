package ticTacToe

import ticTacToe.models.{Game, playerActor, playersCoordinator}
import ticTacToe.views.{DemoOrManualView, GestorIO}
import akka.actor._

case class PlayMessage(game: Game)

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

    val gameMode = DemoOrManualView.askMode
    GestorIO.write(s"Modo de juego: ${gameMode}\n")
    
    val system = ActorSystem("PlayerCoordinator")
    val player1 = system.actorOf(Props[playerActor], name = "p1")
    val player2 = system.actorOf(Props[playerActor], name = "p2")
    val coordinator =
        system.actorOf(Props(new playersCoordinator(player1, player2)),
          name = "coordinator")

      coordinator ! PlayMessage(game)
  }
}