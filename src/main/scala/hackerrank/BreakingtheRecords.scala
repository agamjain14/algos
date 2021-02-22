package hackerrank

import java.io.PrintWriter

object BreakingtheRecords {


  def breakingRecords(scores: List[Int]): (Int, Int) ={
    val record = scores.tail.foldLeft((scores.head, 0, scores.head, 0)) { (r, score) =>
      if (score > r._1) (score, r._2 + 1, r._3, r._4)
      else if (score < r._3) (r._1, r._2, score, r._4 + 1)
      else r
    }
    (record._2, record._4)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(System.out)

    val n = stdin.readLine.trim.toInt

    val scores: List[Int] = stdin.readLine.split(" ").map(i => i.trim.toInt).toList

    val result = breakingRecords(scores)

    printWriter.println(s"${result._1} ${result._2}")

    printWriter.close()

  }
}
