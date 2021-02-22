package hackerrank

object Cross {

}
object Solution {

  def solveCrossword(grid: Array[Array[Char]], cities: Array[Array[Char]]): Array[Array[Char]] = {

    type Field = ((Int, Int), (Int, Int), Int)

    def getHFields(cw: Array[Array[Char]]): List[Field] = {
      def loop(rowN: Int, rowWithCols: Array[(Char, Int)], acc: List[Field]): List[Field] = {
        val (field: Array[(Char, Int)], rest) = rowWithCols.dropWhile(_._1 == '+').span(_._1 == '-')
        if(field.isEmpty) {
          acc
        } else if(field.length > 1) {
          loop(rowN, rest, ((rowN, field(0)._2), (rowN, field.last._2), field.length) :: acc)
        } else {
          loop(rowN, rest, acc)
        }
      }
      (for(row <- 0 until 10) yield loop(row, cw(row).zipWithIndex, Nil)).toList.flatten
    }

    def getVFields(cw: Array[Array[Char]]): List[Field] = {
      val trans = Array.tabulate(10, 10)((x, y) => cw(y)(x))
      getHFields(trans).map{case ((x1, y1), (x2, y2), len) => ((y1, x1), (y2, x2), len)}
    }

    val fields = getHFields(grid) ++ getVFields(grid)

    def suite(word: Array[Char], field: Field, cw: Array[Array[Char]]): Boolean = {
      if(word.length == field._3) {
        val (r1, c1) = field._1
        val (r2, c2) = field._2
        if(r1 == r2) {
          (c1 to c2).forall(col => cw(r1)(col) == '-' || cw(r1)(col) == word(col - c1))
        } else {
          (r1 to r2).forall(row => cw(row)(c1) == '-' || cw(row)(c1) == word(row - r1))
        }
      } else {
        false
      }
    }

    def fill(word: Array[Char], field: Field, cw: Array[Array[Char]]): Array[Array[Char]] = {
      val filled = cw.map(_.clone)
      val (r1, c1) = field._1
      val (r2, c2) = field._2
      if(r1 == r2) {
        (c1 to c2).foreach(col => filled(r1)(col) = word(col - c1))
      } else {
        (r1 to r2).foreach(row => filled(row)(c1) = word(row - r1))
      }
      filled
    }

    def placeWords(ws: Array[Array[Char]], fields: List[Field]): List[Array[Array[Char]]] = ws.length match {
      case 0 => List(grid)
      case _ =>
        for {
          cws <- placeWords(ws.tail, fields.tail)
          if suite(ws.head, fields.head, cws)
        } yield fill(ws.head, fields.head,  cws)
    }

    cities.permutations.toList.flatMap(p => placeWords(p, fields)).head
  }

  def main(args: Array[String]) {
    val cw = for(i <- Array.range(0, 10)) yield io.StdIn.readLine.toCharArray
    val ws = io.StdIn.readLine.split(";").map(_.toCharArray)
    println(solveCrossword(cw, ws).map(_.mkString("")).mkString("\n"))
  }
}