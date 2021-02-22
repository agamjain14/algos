
package hackerrank
import java.io._

import scala.io._

object Result {

  /*
   * Complete the 'gradingStudents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */




  def gradingStudents[T](grades: Array[T]): Array[Int] = {
    // Write your code here
    grades.map {
      case grade: Int =>
        if (grade > 37 && grade%5 >2)
          grade + (5 - grade%5)
        else
          grade

      case _ => throw new Exception("Only int Expected")
    }
  }

}

object GradingStudents {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val gradesCount = StdIn.readLine.trim.toInt

    val grades = Array.ofDim[Int](gradesCount)

    for (i <- 0 until gradesCount) {
      val gradesItem = StdIn.readLine.trim.toInt
      grades(i) = gradesItem
    }

    val result = Result.gradingStudents(grades)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
