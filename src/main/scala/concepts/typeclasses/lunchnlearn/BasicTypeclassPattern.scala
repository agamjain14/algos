package concepts.typeclasses.lunchnlearn

import cats.SortExample.{Sort, Sorter}


/**
  * This allows us to implement the func􀦞onality for any type, and to provide
  * different implementa􀦞ons for the same operation.
  */
object Approach1a {
  case class Person(name: String, age: Int)

  case class Restaurant(name: String, address: String)

  /**
    * The trait which the instances implement, is the type class itself
    * A type class is a trait with at least one type variable
    * @tparam A
    */

  trait Serializable[A] {
    def ser(in : A): String
  }

  /**
    * These are type instances though we have not made it implicits
    */
  // moving all the logic to adapter-container


  object PersonSerialzer extends Serializable[Person] {
    override def ser(in: Person): String = ???

  }

  object PersonSerialzer1 extends Serializable[Person] {
    override def ser(in: Person): String = ???
  }



  object RestaurantSerialzer extends Serializable[Restaurant] {
    override def ser(in: Restaurant): String = ???
  }



  object SerializableInterface {
    def serialize[T](value: T, s: Serializable[T]) = s.ser(value)
  }

  SerializableInterface.serialize(Person("a", 1), PersonSerialzer)

  SerializableInterface.serialize(Person("b", 2), PersonSerialzer1)

}

/**
  * introducing implicits
  */
