package hackerrank

import java.io.PrintWriter
import scala.math.min


trait Add[A] {
  def apply(a: A, b: A): A
}

object Add {

  implicit def numericAdd[A: Numeric]: Add[A] = new Add[A] {
    def apply(a: A, b: A): A = implicitly[Numeric[A]].plus(a, b)
  }
}



trait Summable[A] {
  def +(a: A): A
}

object Summable {

  implicit object SummableInt extends Summable[Int] {
    override def +(a: Int) = a + 1
  }

}

trait Divide[A] {
  def /(a: A): A
}

object Divide {
  implicit object DivideInt extends Divide[Int] {
    def /(a: Int) = a / 2
  }
}


trait Mod[A] {
  def %(a: A): A
}

object Mod {
  implicit object ModInt extends Mod[Int] {
    def %(a: Int) = a % 2
  }
}

object DrawingBook {
    /*
    |failure case 1) p > n
    |failure case 2) type mismatch
    |failure case 3) string input
    |
    */


  def compute[A: Integral](n: A, p: A)(implicit s: Summable[A], d: Divide[A], m: Mod[A]) = {
    val x: A = if (m.%(n) == 0) s.+(n) else n

  }

  def pageCount(n: Int, p: Int): Int = {
    /*
     * Write your code here.
     */
    val m = if (n%2==0) n + 1  else n
    min(p/2, (m-p)/2)

  }

  def fun[A](a: A, b: A)(implicit ev: Summable[A]) =
    ev.+(a)

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(System.out)

    val n = stdin.readLine.trim.toInt

    val p = stdin.readLine.trim.toInt

    val result = pageCount(n, p)

    printWriter.println(result)

    printWriter.close()
  }
}
