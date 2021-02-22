package hackerrank

import scala.annotation.tailrec

object CrossWord {


  type Field = ((Int, Int), (Int, Int), Int)

  def getHFields(grid: Array[Array[Char]]): List[Field] = {

    def loop(row: Int, rowN: Array[(Char, Int)], acc: List[Field]): List[Field] = {
      val (places: Array[(Char, Int)], rest: Array[(Char, Int)]) = rowN.dropWhile(_._1 == '+').span(_._1 == '-')
      if (places.isEmpty)
        acc
      else if (places.length > 1) {
        loop(row, rest, ((row, places(0)._2), (row, places.last._2), places.length) :: acc)
      } else {
        loop(row, rest, acc)
      }
    }

    (0 until 10).map(row => loop(row, grid(row).zipWithIndex, List.empty[Field])).toList.flatten
  }

  def transpose(grid: Array[Array[Char]]): Array[Array[Char]] = {
    Array.tabulate(10, 10)((x, y) => grid(y)(x))
  }

  def getVFields(grid: Array[Array[Char]]): List[Field] = {
    val transposedGrid = transpose(grid)
    getHFields(transposedGrid)
  }

  def prepareInput(grid: String, cityString: String): Unit = {

    val rows: List[String] = grid.split("\n").toList
    val cities: List[String] = cityString.split(";").toList

    val placesMap = buildMap(rows)// ++ buildMap(transform(rows))
    val verticalMap = buildMap(transform(rows))



  }

  def buildMap(rows: List[String]) = {
    @tailrec
    def func(r: List[String], map: Map[Int, List[Int]], index: Int): Map[Int, List[Int]] = {
      r match {
        case h :: t =>
          func(t, map + (index -> getIndices(h)), index + 1)
        case Nil => map
      }
    }

    func(rows, Map.empty[Int, List[Int]], 0)
  }

  def getIndices(row: String): List[Int] = {
    val list = row.foldLeft((List.empty[Int], 0))((r, c) => {
      if (c == '-') {
        (r._1 :+ r._2, r._2 + 1)
      } else (r._1, r._2 + 1)
    })
    list._1
  }

  def transform(board: List[String]) : List[String] = {
    (1 to 10).map(i => board.map(element => element.substring(i-1,i)).mkString).toList
  }

}
