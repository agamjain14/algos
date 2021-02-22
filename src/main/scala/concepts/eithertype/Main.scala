package concepts.eithertype

object Main {
  sealed abstract class Perhaps[A]
  case class YesItIs[A](value: A) extends Perhaps[A]
  case object Nope extends Perhaps[Nothing]

  val y3 = YesItIs(3)
  val y4 = YesItIs(4)
  val n = Nope

  // NOPE IS A SINGLETON INSTANCE(OBJECT) OF TYPE Perhaps[Nothing], AND Nothing IS A SPECIAL TYPE IN SCALA(BOTTOM OF THE
  // TYPE SYSTEM

  /*for {
    a <- y3 // VALUE FOR EACH IS NOT A MEMBER OF YesItIs[Int]
  } println(a)*/
}

object Solution {
  sealed abstract class Perhaps[A] {
    def foreach(f: A => Unit): Unit
  }

  case class YesItIs[A](value: A) extends Perhaps[A] {
    override def foreach(f: A => Unit): Unit = f(value)
  }

  case object Nope extends Perhaps[Nothing] {
    override def foreach(f: Nothing => Unit): Unit = ()
  }

  val y3 = YesItIs(3)

  for {
    a <- y3
  } println(a)
}