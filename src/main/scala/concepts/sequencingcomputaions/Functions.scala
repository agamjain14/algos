package concepts.sequencingcomputaions


// FUNCTIONS allow abstract over methods , turing methods into values that we can pass around and
// manipulate within our programs
object Functions {

  sealed trait LinkedList {
    // we’ve used a generic type on the method to capture the changing return type.
    def fold[A](end: A)(f: (Int, A) => A): A = {
      this match {
        case End => end
        case Pair(hd, tl) => f(hd, tl.fold(end)(f))
      }
    }
    def length: Int = fold[Int](0)((_, tl) => 1 + tl)

    def product: Int = fold[Int](1)((hd, tl) => hd * tl)

    def double: LinkedList = fold[LinkedList](End)((hd, tl) => Pair(hd * 2, tl))

  }
  case object End extends LinkedList
  case class Pair(hd: Int, tl: LinkedList) extends LinkedList


}
