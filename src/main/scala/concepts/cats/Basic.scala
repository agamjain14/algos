package concepts.cats
/**
  * In cats a type class is represented by a trait with at least one type parameter
  *
  */
object Basic {

  sealed trait Json
  final case class JsObject(get: Map[String, Json]) extends Json
  final case class JsString(get: String) extends Json
  final case class JsNumber(get: Double) extends Json
  case object JsNull extends Json

  final case class Person(name: String, email: String)

  trait JsonWriter[A] {
    def write(value: A): Json
  }

  object JsonWriterInstances {
    //implementation of each instance
    implicit val stringWriter: JsonWriter[String] =
      new JsonWriter[String] {
        def write(value: String): Json =
          JsString(value)
      }

    implicit val personWriter: JsonWriter[Person] =
      new JsonWriter[Person] {
        def write(value: Person): Json =
          JsObject(Map(
            "name" -> JsString(value.name),
            "email" -> JsString(value.email)
          ))
      }
  }


  // Interface Object
  object Json {
    implicit def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
      w.write(value)
  }

  import JsonWriterInstances._

  Json.toJson(Person("Dave", "dave@example.com"))

  //Interface Syntax
  object JsonSyntax {
    implicit class JsonWriterOps[A](value: A){
      def toJson(implicit w: JsonWriter[A]): Json =
        w.write(value)
    }
  }

  import JsonWriterInstances._
  import JsonSyntax._

  Person("Dave", "dave@example.com").toJson
  "a".toJson
}