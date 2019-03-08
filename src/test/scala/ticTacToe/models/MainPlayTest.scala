package ticTacToe.models

import ticTacToe.views.{GestorIO, MainView}

import collection.mutable.Stack
import org.scalatest._
import org.scalatest.FlatSpec
import org.scalamock.scalatest.MockFactory
import ticTacToe.Main

class MainPlayTest extends FlatSpec with MockFactory {
  "TicTacToe" should "play in Demo mode" in {
    val GestorIOMock = mock[GestorIO]
//    GestorIOMock expects 'readString  returning "D"
//    (GestorIOMock.readString _).
//      expects("Modo de juego").
//      returning("D")

//    MainView.startGame

  }
}



