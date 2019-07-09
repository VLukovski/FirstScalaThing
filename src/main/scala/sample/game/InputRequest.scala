package sample.game

import scala.util.control.Breaks.{break, breakable}

class InputRequest(var ans: String = "1") {
  def itemNum: Int = {
    try {
      println("Please input the number of things you want to have in the world")
      ans = scala.io.StdIn.readLine()
      ans.toInt
    }
    catch {
      case _: Throwable => {
        println("Input is not a number")
        itemNum
      }
    }
    finally {
      if (ans.toInt < 1) {
        println("Number must be at least 1")
        itemNum
      }
    }
    ans.toInt
  }
}
