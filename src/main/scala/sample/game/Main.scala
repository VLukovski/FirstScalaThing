package sample.game

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val game = new GameState()
    game.setup()
    while (game.play) {
      if (Compass.distance(game.positions) != 0.0) {
        game.positions(0).move()
        println(f"The number on the watch is ${Compass.distance(game.positions)}%2.2f metres")
      }
      else if (game.positions(0).xCoord == game.positions(1).xCoord && game.positions(0).yCoord == game.positions(1).yCoord){
        game.win()
      }
      else {
        game.unlucky()

      }
    }
    println("Bye!")
  }
}
