package concepts.forcomprehension

import scala.reflect.runtime.universe._
import scala.util.Try

object Main {
  def main(args: Array[String]): Unit = {

    val c1: Try[Int] = Try(1)

    val c2: Try[Unit] = Try(Unit)

    /*desugar{
      for {
        input <- c1
        flatIp = input.toString
        _ = c2
      } yield Unit
    }*/

    val numList = List(1,2,3)
    val strList = List("a", "b", "c")
    val doubleList = List(0.1, 0.2, 0.3)

    println(show {
      reify {
        /*for {
          input <- c1
          flatIp = input.toString
          temp = c2
        } yield Unit*/

        //println("######")

        for {
          num <- numList
          //temp1 = num
          str <- strList
          temp2 = str
          dbl <- doubleList
          temp3 = dbl
        } yield (num, str, dbl)

      }
    })

    println("######")

    val l =
      """
        |aaa
        |bbb
        |ccc
        |""".stripMargin

    val list = l.split("\n").toList

    println(show {
      reify {
        val s = for {
          str <- list
        } str
        println(s)
      }
    })
  }
}
