package week4

object rational {
  val x = new Rational(1, 3)                      //> x  : week4.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week4.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week4.Rational = 3/2
  x.sub(y).sub(z)                                 //> res0: week4.Rational = -79/42
  x.less(y)                                       //> res1: Boolean = true
  x.max(y)                                        //> res2: week4.Rational = 5/7

  //val strange = new Rational(1, 0)
  //strange.add(strange)
}

class Rational(x: Int, y: Int) {

  require(y != 0, "denomenator must be non zero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numerator = x
  val denominator = y

  def this(x: Int) = this(x, 1)

  def add(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator)
  }

  def neg: Rational =
    new Rational(-numerator, denominator)

  def sub(that: Rational): Rational = add(that.neg)

  def mul(that: Rational): Rational = {
    new Rational(
      numerator * that.numerator,
      denominator * that.denominator)
  }

  def less(that: Rational) =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: Rational) =
    if (this.less(that)) that else this

  override def toString = {
    val g = gcd(x, y)
    numerator / g + "/" + denominator / g
  }
}