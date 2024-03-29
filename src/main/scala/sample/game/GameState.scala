package sample.game

import scala.util.Random
import scala.collection.mutable.ListBuffer
import util.control.Breaks._

class GameState(var positions: List[Coord] = null, var play: Boolean = true) {
  def setup(): Unit = {
    var positionsTemp = ListBuffer[Coord]()
    positionsTemp += new Coord(0, 0)
    val request = new InputRequest()
    var count = request.itemNum
    for (i <- 1 to count) {
      breakable {
        while (true) {
          var randCoord = new Coord((-4 - count) + Random.nextInt(9 + count), (-4 - count) + Random.nextInt(9 + count))
          var equality = false
          for (pos <- positionsTemp) {
            if (pos.equals(randCoord)) {
              println("Boop")
              equality = true
            }
          }
          if (!equality) {
            positionsTemp += randCoord
            break
          }
        }
      }
    }
    positions = positionsTemp.toList
    println("You wake up in a foggy swamp \n" +
      "In your pocket you find a strange watch with a number on it")
    Compass.distanceText(positions)
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

  def unlucky(): Unit = {
    println("You found a rock, the number on the watch has changed")
    positions = positions.patch(positions.tail.indexOf(positions(0)), Nil, 1)
  }
}