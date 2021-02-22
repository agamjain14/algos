package concepts.typeclasses.equality

// basic type class Pattern
object EqualityDemo {

  case class Person(name: String, email: String)

  // type Sorter[A] = (A, A) => Boolean

  trait Equal[A] {
    def equal(v1: A, v2: A): Boolean
  }

  object EmailEquality extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email
  }

  object NameEmailEqual extends Equal[Person] {
    def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email && v1.name == v2.name
  }

  object Eq {
    def apply[A](p1: A, p2: A)(implicit instance: Equal[A]): Boolean = {
      instance.equal(p1, p2)
    }
  }

  /**
    * Package up the different Equal impmentation as implicit values in their own object -> control the implicit selection by changing which object is imported
    */
  object NameAndEmailImplicit {
    implicit object NameEmailEqual extends Equal[Person] {
      def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email && v1.name == v2.name
    }
  }

  object EmailImplicit {
    implicit object EmailEqual extends Equal[Person] {
      def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email
    }
  }

  object Example {
    def byNameAndEmail: Unit = {
      import NameAndEmailImplicit._
      //Eq(Person("a", "a"), Person("w", "r"))
    }
  }

  /**
    * implement an interface on a companion object of Equal
    *
    */
  object Equal {
    def apply[A](implicit instance: Equal[A]): Equal[A] = instance
  }

}

// implicit Parameter and Interfaces -> make it easir to use
