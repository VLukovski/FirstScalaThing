package sample.game

object Compass {
  def distance(player: Coord, exit: Coord): Double = {
    math.sqrt(math.pow(player.xCoord - exit.xCoord, 2) + math.pow(player.yCoord - exit.yCoord, 2))
  }
}
