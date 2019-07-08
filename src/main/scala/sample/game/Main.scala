package sample.game

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val game = new GameState()
    game.setup()
    while (game.play) {
      if (Compass.distance(game.player, game.exit) != 0.0) {
        game.player.move()
        println("The number on the watch is " + Compass.distance(game.player, game.exit) + " metres")
      }
      else {
        game.win()
      }
    }
    println("Bye!")
  }
}
