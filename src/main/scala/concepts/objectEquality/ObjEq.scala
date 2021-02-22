package concepts.objectEquality

import scala.collection.mutable

object ObjEq {

  class Point(val x: Int, val y: Int){
     def equals(obj: Point): Boolean = this.x == obj.x && this.y == obj.y
  }

  def main(args: Array[String]): Unit = {
    val p1, p2 = new Point(1, 2)
    val q = new Point(2, 3)
    println(p1)
    println(p2)
    println(p1 == p2) // false

    println(p1 equals  p2) // true -> compares value

    println(p1 == q) // false

    val coll = mutable.HashSet(p1)

    println(coll contains p2) // false -> precise type of one of the compared points is masked
    // that method operates
    //on generic sets, it calls the generic equals method in Object instead of the
    // overloaded variant in Point.


    val p2a: Any = p2
    println("p2a" + p2a)

    println( p2a == p2) // true

    println(p1 equals p2a) // false --> as the type is any, the equals method in "Any" is called instead
  }
}
