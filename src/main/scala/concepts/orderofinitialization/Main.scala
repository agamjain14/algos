package concepts.orderofinitialization

object Main {

  class A() {
    val a: Int = 1

    def print(): Unit = {
      println("in A " + a)
    }
  }

  class B() extends A {
    override val a: Int = 2

    override def print: Unit = {
      println("in B " + a)
    }
  }

  def main(args: Array[String]): Unit = {
    val b = new A()
    println("val " + b.a)
    b.print
  }
}

object Main1 {
  /*abstract class A {
    val x1: String
    lazy val x2: String = "mom"

    println("A: " + x1 + ", " + x2)
  }
  class B extends A {
    lazy val x1: String = "hello"

    println("B: " + x1 + ", " + x2)
  }
  class C extends B {
    override lazy val x2: String = "dad"

    println("C: " + x1 + ", " + x2)
  }*/



  class Root { def x = "Root" }
  class A extends Root { override def x = "A" ; def superA = super.x }
  trait B extends Root { override def x = "B" ; def superB = super.x }
  class C extends Root with B {
    override def x = "C" ; def superC = super.x
  }
  class D extends A with B {
    override def x = "D" ; def superD = super.x
  }


  def main(args: Array[String]): Unit = {

  }
}
