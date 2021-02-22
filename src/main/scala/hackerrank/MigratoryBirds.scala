package hackerrank

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

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
import collection.JavaConverters._
import scala.List

object MigratoryBirds {

  // Complete the migratoryBirds function below.
  def migratoryBirds(arr: List[Int]): Int = {
    arr.groupBy(n => n).mapValues(l => l.size).maxBy(v=> v._2)._1

  }

  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arrCount: Int = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
    val result = migratoryBirds(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
