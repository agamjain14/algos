package hackerrank

object sparsearray {

  def mainWork[T](strings: List[T], queries: List[T]): List[Int] ={
    queries.map(s => strings.filter(_ == s).size)
  }

  def main(args: Array[String]): Unit = {
    val lines =  Iterator.continually(io.StdIn.readLine).takeWhile(_.nonEmpty).toList
    val n = lines(0).toInt
    val q = lines(n+1).toInt
    val string: List[String] = lines.slice(1, n + 1)
    val queries: List[String] = lines.slice(n + 2, lines.size)
    println(mainWork(string, queries).mkString("\n"))
  }
}
