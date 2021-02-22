package concepts.typeclasses.lunchnlearn



/**
  * the issue with the basic approach is that we need to manage a lot of Serializer instances - can be managed with implicits values and have mentioned
  * implicits parameters in passing
  */
object TypeclassWithImplicits {

  case class Person(name: String, age: Int)

  case class Restaurant(name: String, address: String)

  trait Serializable[A] {
    def ser(in : A): String
  }


  implicit object PersonSerialzer extends Serializable[Person] {
    override def ser(in: Person): String = ???

  }

 /* implicit object PersonSerialzer1 extends Serializable[Person] {
    override def ser(in: Person): String = ???
  }*/

  implicit object RestaurantSerialzer extends Serializable[Restaurant] {
    override def ser(in: Restaurant): String = ???
  }

  object SerializableInterface {
    def serialize[A](data: A)(implicit s: Serializable[A]): String = {
      s.ser(data)
    }
  }

  SerializableInterface.serialize(Person("a", 1))

}
