package week1

object ex1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  factorial(100)                                  //> res0: Int = 0
}