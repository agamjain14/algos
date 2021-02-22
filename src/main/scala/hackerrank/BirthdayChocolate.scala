import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.List
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.collection.parallel.immutable._
import scala.collection.parallel.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object BirthdayChocolate {

  // Complete the birthday function below.
  def birthday(s: Array[Int], d: Int, m: Int): Int = {

    val total = s.sliding(m).toList.foldLeft(0) {
      case (r, ll) => if (ll.sum == d) {r + 1} else r
    }
    total
  }

  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val s = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val dm = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val d = dm(0).toInt

    val m = dm(1).toInt

    val result = birthday(s, d, m)
    printWriter.println(result)

    printWriter.close()
  }
}
