package concepts.basicforcomprhension

object Main {
  sealed abstract class Perhaps[A]() {
    def foreach(f: A => Unit): Unit
  }
  case class YesItIs[A](value: A) extends Perhaps[A] {
    override def foreach(f: A => Unit): Unit = f(value)
  }

  case object Nope extends Perhaps[Nothing] {
    override def foreach(f: Nothing => Unit): Unit = ()
  }

  def main(args: Array[String]): Unit = {
    val a = YesItIs(4)
    a.foreach(x => println("x " + x))

    val y3 = YesItIs(3)
    /*for {
      a <- y3
    } yield a * a*/ // value map is not a member of YesItIs[Int]
  }
}


object Main1 {
  sealed abstract class Perhaps[+A]() {
    def foreach(f: A => Unit): Unit
    def map[B](f: A => B): Perhaps[B]
  }
  case class YesItIs[A](value: A) extends Perhaps[A] {
    override def foreach(f: A => Unit): Unit = f(value)

    override def map[B](f: A => B): Perhaps[B] = YesItIs(f(value))
  }

  case object Nope extends Perhaps[Nothing] {
    override def foreach(f: Nothing => Unit): Unit = ()

    override def map[B](f: Nothing => B): Perhaps[B] = this
  }

  def main(args: Array[String]): Unit = {
    val a = YesItIs(4)
    a.foreach(x => println("x " + x))

    val y3 = YesItIs(3)
    val y4 = YesItIs(4)

    for {
      a <- y3
    } yield a * a

    /*for {
      a <- y3  // value flatMap is not a member of YesItIs[A]
      b <- y4
    } yield a * b*/
  }
}