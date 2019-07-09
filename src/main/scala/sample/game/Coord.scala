package sample.game

class Coord(var xCoord: Int, var yCoord: Int) {
  def move(): Unit = {
    println("Input a direction to go")
    val direction = scala.io.StdIn.readLine()
    direction.toLowerCase() match {
      case "north" | "n" | "up" | "u" => yCoord += 1
      case "south" | "s" | "down" | "d" => yCoord -= 1
      case "east" | "e" | "right" | "r" => xCoord += 1
      case "west" | "w" | "left" | "l" => xCoord -= 1
      case _ => println("Please input a valid direction (north/south/east/west or up/down/right/left")
    }
  }
  def equals(second: Coord): Boolean = {
    if (this.xCoord == second.xCoord && this.yCoord == second.yCoord) {
      true
    }
    else {
      false
    }
  }
}

