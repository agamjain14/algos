package concepts.typeclasses.lunchnlearn

object Approach1 {

  /**
    * Approach 1 - overloading
    */
  case class Person(name: String, age: Int)

  case class Restaurant(name: String, address: String)

  def serialize(p: Person): String = ???

  def serialize(r: Restaurant): String = ???
}

/**
  * Appraoch 2 - Inheritance
  */
object Approach2 {

  trait Serializable {
    def ser(): String
  }

  trait Serializable1 {
    def ser1(): String
  }

  case class Person(name: String, age: Int) extends Serializable with Serializable1 {
    override def ser(): String = ???

    override def ser1(): String = ???
  }

  case class Restaurant(name: String, address: String) extends Serializable {
    override def ser(): String = ???
  }
}


/**
  * Approach 3 - Pattern Matching
  */
object Approach3 {
  case class Person(name: String, age: Int)

  case class Restaurant(name: String, address: String)

  def serialize(t: Any): String = t match {
    case Person(name, age) => ???
    case Restaurant(name, address) => ???
    case _ => ???
  }
}