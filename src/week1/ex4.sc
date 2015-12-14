package week1
import math.abs

object ex4 {
  println("Welcome to the Scala worksheet")

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) = {
    abs((x - y) / x) / x < tolerance
  }

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {

    def iterate(guess: Double): Double = {
    println(guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)

  }
  fixedPoint(x => 1 + x / 2)(1)
  
  def avgDamp(f:Double =>Double)(x:Double) = (x+f(x))/2
  def sqrt(x: Double) =
  
  	fixedPoint(avgDamp(y => x / y))(1)
  	sqrt(2)

}