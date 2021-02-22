package concepts.foldleft

object Practice {

  def sum(l: List[Int]): Int = {
    l.foldLeft(0) {
      (b, a) => (b + a)
    }
  }


  def count(l: List[Int]): Int = {
    l.foldLeft(0) {
      (r, c) => r + 1
    }
  }



  //Get the last element from the list
  def last[A](l: List[A]): A = {
    l.foldLeft(l.head) {
      case (_, c) => c
    }
  }

  def penultimate[A](list: List[A]): A =
    list.foldLeft( (list.head, list.tail.head) )( (r:(A, A), c: A) => (r._2, c) )._1

  def main(args: Array[String]): Unit = {

    //println(count(List(1,2,3,4,5, 5)))

    println(last(List(1,2,3,4,5, 5)))
  }

}
