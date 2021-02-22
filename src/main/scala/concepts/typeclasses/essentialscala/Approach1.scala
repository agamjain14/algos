package concepts.typeclasses.essentialscala

import java.util.Date

import concepts.typeclasses.essentialscala.Approach3.{HTMLWriter, Person}

object Approach1 {
  /**
    * THe solution has number of drawbacks
    * 1) we are restricted to having just one way of rendering a Person.
    * 2) this pattern can only be applied to classes that we have written ourselves --> If we want to render a java.util.Date to HTML, for example,
    * we will have to write some other form of library func􀦞on. If we want to render a java.util.Date to HTML, for example, we will have to
    * write some other form of library func􀦞on.
    *
    *
    * So try Pattern Matching
    * */
  trait HTMLWritable {
    def toHTML: String
  }

  final case class Person(name: String, email: String) extends HTMLWritable {
    override def toHTML: String = s"<span>$name &lt;$email&gt;</span>"
  }

  // We cannot render date
  /**
    * sHIT
    *
    * case class Date(d: Int) extends HTMLWritable {
    *   override def toHTML: String = s"<span>$name &lt;$email&gt;</span>"
    * }
    */

  val p = Person("John", "john@example.com").toHTML
}

object Approach2 {

  final case class Person(name: String, email: String)
  // TRY pattern Matching
  /**
    * this implementation has its own issue
    * we lost type saftey because there is no useful supertype that covers just the elements we want to render and no more
    * We cannot have more than one implementaion of rendering for a given type -> we also have to modify this code whenver we want render a new type
    * So
    * we can overcome all these problems by moving out HTML rendering to adapter class
    */

  object HTMLWritable {
    def write(in : Any): String = {
      in match {
        case Person(name, email) => ???
        case d: Date => ???
        case _ => throw new Exception(s"fsahfdjk ")
      }
    }
  }

}


object Approach3 {

  /**
    * this is better we can now define HTMLwriter functionality for other types including types we have not written ourselves.
    *
    * you might recognize PersonWriter1, DateWriter, PersonWriter2 as following the type class instance pattern (though we havn't made them
    * implicit value at the point)
    *
    */
  final case class Person(name: String, email: String)

  /**
    * The HtmlWriter trait, which the instances
    * implement, is the type class itself.
    *
    */
  trait HTMLWriter[A] {
    def write(in: A): String
  }

  object PersonWriter1 extends HTMLWriter[Person] {
    def write(person: Person): String = s"<span>${person.name} &lt;${person.email}&gt;</span>"
  }

  object DateWriter extends HTMLWriter[Date] {
    def write(in: Date) = s"<span>${in.toString}</span>"
  }

  object PersonWriter2 extends HTMLWriter[Person] {
    def write(person: Person) = s"<span>${person.name} (${person.email.replaceAll("@", " at ")})</span>"
  }

  PersonWriter1.write(Person("John", "john@example.com"))
}

/**
  * trait HtmlWriter which allows us to implement HTML rendering for classes without requiring access to their source code, and allows us
  * to render the same class in different ways.
  *
  *
  * The issue with this code is that we need maanage a lot of HTMLWriter instances when we render any complex data -> manage this complexity
  * using implicit values and have implicit paramaterers
  */
object ImplicitsParameters {

  /**
    *
    * @param data - some data to convert to HTML
    * @param writer - writer to do conversion -> implicit parameter
    *               The implciit keyword applies to the whole parameter list, not just an indivdual parameter -> this makes the parameter list
    *               optional. When we call HtmlUtil.htmlify we can either specify the list as normal or we can omit the implicit parameters
    *               if we omit the implicit parametes, the compiler searches for implicit values for the correct type it can use to fill in the
    *               missing argument
    *
    * @tparam A
    */
  def htmlify[A](data: A)(implicit writer: HTMLWriter[A]) = {
    writer.write(data)
  }

  object PersonWriter1 extends HTMLWriter[Person] {
    def write(person: Person): String = s"<span>${person.name} &lt;${person.email}&gt;</span>"
  }
  htmlify(Person("John", "john@example.com"))(PersonWriter1)


  implicit object ApproximationWriter extends HTMLWriter[Int] {
    def write(in: Int): String = s"It's definitely less than ${((in / 10) + 1) * 10}"
  }

  /**
    * ambiguous implicit values - error
    */
  /*implicit object ApproximationWriter1 extends HTMLWriter[Int] {
    def write(in: Int): String = s"It's definitely less than ${((in / 10) + 1) * 10}"
  }*/

  implicit object ApproximationWriter2 extends HTMLWriter[Float] {
    def write(in: Float): String = s"It's definitely less than ${((in / 10) + 1) * 10}"
  }

}

/**
  * complete type class pattern (type class trait + implicit type class instances + interface using implicit parameters )
  */
object InterfacesUsingImplicitParameters {

}

object Main {
  import ImplicitsParameters._

  def main(args: Array[String]): Unit = {
    htmlify(2)
  }
}