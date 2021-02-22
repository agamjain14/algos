



package concepts.sequencingcomputaions

object BadStyle {



  sealed trait IntList {
    def length: Int =
      this match {
        case End => 0
        case Pair(hd, tl) => 1 + tl.length
      }

    def double: IntList =
      this match {
        case End => End
        case Pair(hd, tl) => Pair(hd * 2, tl.double)
      }

    def product: Int =
      this match {
        case End => 1
        case Pair(hd, tl) => hd * tl.product
      }

    def sum: Int =
      this match {
        case End => 0
        case Pair(hd, tl) => hd + tl.sum
      }
  }
  case object End extends IntList
  final case class Pair(head: Int , tail: IntList) extends IntList

//

}

//Pair(1, Pair(2, Pair(3, End)))
// First problem - our list is restricted to storing int => Generics to abstract over types
// Second problem - there's a lot of repetition => Functions to abstract over methods