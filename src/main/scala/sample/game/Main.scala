package sample.game

object Main {
  def main(args: Array[String]): Unit = {
    val game = new GameState()
    game.setup()
    while (game.play) {
      if (Compass.distance(game.positions) != 0.0) {
        game.positions(0).move()
        Compass.distanceText(game.positions)
      }
      else if (game.positions(0).xCoord == game.positions(1).xCoord && game.positions(0).yCoord == game.positions(1).yCoord){
        game.win()
      }
      else {
        game.unlucky()
        Compass.distanceText(game.positions)
      }
    }
    println("Bye!")
  }
}
