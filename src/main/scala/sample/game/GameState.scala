package sample.game

import scala.util.Random

class GameState(var player: Coord = null, var exit: Coord = null, var play: Boolean = true) {
  def setup(): Unit = {
    player = new Coord(0, 0)
    exit = new Coord(-5 + Random.nextInt(10), -5 + Random.nextInt(10))
    println("You wake up on a foggy swamp \n" +
      "In your pocket you find a strange watch with a number on it")
    println("The number on the watch is " + Compass.distance(player, exit) + " metres")
    println("You need to find an exit")
  }
  def win(): Unit = {
    println("You have reached the exit \n" +
      "Would you like to play again yes/no?")
    val ans = scala.io.StdIn.readLine()
    ans.toLowerCase() match {
      case "yes" | "y" => setup()
      case "no" | "n" => play = false
      case _ => println("Please input a valid answer")
    }
  }
}