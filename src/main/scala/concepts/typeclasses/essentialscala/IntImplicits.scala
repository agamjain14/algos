package concepts.typeclasses.essentialscala

object IntImplicits {

  implicit class IntToYeah(num: Int) {

    def convert = for (_ <- 0 until num) println("Oh yeah!")

    def times(a: Int => Unit) = {
      for (_ <- 0 until num) a
    }

  }

  implicit class StringImp(str: String) {

    def ===(s: String) = {
      str.toLowerCase() == s.toLowerCase
    }
  }

}
