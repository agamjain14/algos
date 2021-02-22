package hackerrank

import java.io.PrintWriter

import sun.security.util.Length

object ClimbingtheLeaderboard {

//alice - 5 25 50 120
//score - 10 20 40 50 100
  def climbingLeaderBoard( alice: List[Int], scores: Seq[Int], length: Int): Unit = {
      alice match {
        case Nil => Unit
        case a :: as => scores match {
          case Nil => {println(1); climbingLeaderBoard(as, scores, length)}
          case s:: ss =>
            if (s < a) climbingLeaderBoard(alice, ss, length -1)
            else {
              println(if (s==a) length else length + 1)
              climbingLeaderBoard(as, scores, length)
            }
        }
      }
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter  = new PrintWriter(System.out)

    //val scoresCount = stdin.readLine.trim.toInt
    val scores = stdin.readLine.split(" ").map(_.trim.toInt).toList
    //val scores = List()
    val uniqueScores: (List[Int], Int) = scores match {
      case Nil => (List(), 0)
      case _ => scores.drop(1).foldLeft((List(scores.head), 1)) { (l, s) =>
        if (s == l._1.head) l else (s +: l._1, l._2 + 1)
      }
    }


    println(uniqueScores)

    //val aliceCount = stdin.readLine.split(" ").map(_.trim.toInt)
    //val alice = stdin.readLine.split(" ").map(_.trim.toInt).toList
    //val result = climbingLeaderBoard(alice, uniqueScores._1, uniqueScores._2)

    //printWriter.println(result.mkString("\n"))

    printWriter.close()

  }
}
