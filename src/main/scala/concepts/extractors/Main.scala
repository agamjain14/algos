package concepts.extractors


// In Scala, patterns can be defined independently of case classes.
// To this end, a method named unapply is defined to yield a so-called extractor.

// extractors are opposite of constructors

// https://www.scala-lang.org/old/node/112
object Main {
  /*case class User(firstName: String, lastName: String, score: Int)

  def advance(xs: List[User]) = xs match {
    case User(_, _, score1) :: User(_, _, score2) => score1 - score2
    case _ => 0
  }*/


  trait User{
    def name: String
  }

  class FreeUser(val name: String) extends User
  class PremiumUser(val name: String) extends User


  object FreeUser {
    def unapply(user: FreeUser): Option[String] = Some(user.name)
  }
  
  object PremiumUser {
    def unapply(user: PremiumUser): Option[String] = Some(user.name)
  }

  def main(args: Array[String]): Unit = {
    FreeUser.unapply(new FreeUser("Daniel"))
  }
}
