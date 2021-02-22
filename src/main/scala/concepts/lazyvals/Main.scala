package concepts.lazyvals

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._


object COmpute {

  def fib(n: Int): Int = n match {
    case x if x < 0 =>
      throw new IllegalArgumentException(
        "Only positive numbers allowed")
    case 0 | 1 => 1
    case _ => fib(n-2) + fib(n-1)
  }
}

object ValStore {
  import COmpute._
  lazy val fortyFive = fib(5)                   // (1)
  val fortySix  = fib(6)                   // (2)
}

object Scenario1 {
  def main(args: Array[String]): Unit = {
    val result = Future.sequence(Seq(            // (3)
      Future {
        ValStore.fortyFive
        println("done (45)")
      },
      Future {
        ValStore.fortySix
        println("done (46)")
      }
    ))
    Await.result(result, 5.seconds)
  }
}