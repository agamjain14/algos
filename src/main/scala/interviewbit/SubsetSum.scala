import java.io._
import scala.io._

object SubsetSum {
  case class Memo[I <% K, K, O](f: I => O) extends (I => O) {
    import scala.collection.mutable.{Map => Dict}
    val cache = Dict.empty[K, O]
    override def apply(x: I) = cache getOrElseUpdate (x, f(x))
  }
  def o(s: List[Int], c: Int): Boolean = {
    type DP = Memo[(List[Int], Int), (Int, Int), Boolean]
    implicit def encode(key: (List[Int], Int)) = (key._1.length, key._2)
    lazy val f: DP = Memo {
      case (_, 0) => true
      case (Nil, _) => false
      case (a :: as, x) => f(as, x - a) || f(as, x)
    }
    f(s, c)
  }
  def main(args: Array[String]) {
    val t = readInt()
    for (_ <- 0 until t) {
      val s = StdIn.readLine.split(' ').toList.map(_.toInt);val s1: List[Int] = s.drop(1);val c = readInt();val b = o(s1, c);val r = if(b) "YES" else "NO";println(r)
    }

  }
}
