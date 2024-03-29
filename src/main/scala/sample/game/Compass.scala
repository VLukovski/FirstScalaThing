package sample.game

import scala.collection.mutable.ListBuffer

object Compass {
  def distance(positions: List[Coord]): Double = {
    var distances = ListBuffer[Double]()
    for (position <- positions.tail) {
      distances += math.sqrt(math.pow(positions(0).xCoord - position.xCoord, 2) + math.pow(positions(0).yCoord - position.yCoord, 2))
    }
    distances.toList.min
  }
  def distanceText(positions: List[Coord]): Unit ={
    println(f"The number on the watch is ${distance(positions)}%2.2f metres")
  }
}
