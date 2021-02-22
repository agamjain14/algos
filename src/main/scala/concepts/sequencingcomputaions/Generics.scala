package concepts.sequencingcomputaions

// WE want to make sure that we preserve the type when we get the value out of the box
// syntax [A] is called type parameter, ca also be added to methods -> which limits the scope of the parameters to the method declaration and body

/*
We described type parameters as analogous to method parameters, and this
analogy continues when extending a trait that has type parameters. Extending
a trait, as we do in a sum type, is the type level equivalent of calling a
method and we must supply values for any type parameters of the trait we’re
extending.
 */

// types define the availabe operation
// and with generic types there isn't a concrete type to define
// generic type are made concrete when  a class is instantiated --- WHICH IS TOO LATE TO MAKE USE OF THE INFORMATION
// in the definition of class


// Throwing exception isn't cool. Whenever we throw an exception we lose type safety as there is nothing in the
// type system that will remind us to deal with the error
object Generics {

  final case class Box[A](value: A)
  Box(2)
  Box("h1")

  sealed trait Result[A]
  case class Success[A](result: A) extends Result[A]
  case class Failure[A](reason: String) extends Result[A]


  sealed trait LinkedList[A] {
    def contains(vl: A): Boolean = {
      this match {
        case End() => false
        case Pair(hd, tl) => if (hd == vl) true else tl.contains(vl)
      }
    }

    def apply(n: Int): A = {
      this match {
        case End() => throw new Exception("Bad things happened") // THROWING EXCEPTION is not a good approach
        case Pair(hd, tl) => if (n == 0) hd else tl.apply(n - 1)
      }
    }

    def modifiedApply(n: Int): Result[A] = {
      this match {
        case End() => Failure("bad things happens")
        case Pair(hd, tl) => if (n == 0) Success(hd) else tl.modifiedApply(n - 1)
      }
    }
  }
  case class End[A]() extends LinkedList[A]
  case class Pair[A](hd: A, tl: LinkedList[A]) extends LinkedList[A]


  def main(args: Array[String]): Unit = {
    val example = Pair(1, Pair(2, Pair(3, End())))
    //assert(example.contains(5))
    //assert(example(0) == 1)

    /*assert(try {
      example(3)
      false
    }
    catch {
      case e: Exception => true
    })*/


    assert(example.modifiedApply(0) == Success(1))
    assert(example.modifiedApply(3) == Failure("index out of bounds"))


  }




}
