package concepts.objectEquality

import scala.collection.mutable

object EqualityPitfall1 {

 /**
 The constructor parameters x and y can only be used within the body
  of the class. We must declare a field or method using val or def to access data from outside the object.
 Fortunately, Scala provides us a useful short-hand way of declaring both in one go. We can prefix
  constructor parameters with the val keyword to have Scala define fields for them automatically:

 */
  class Point(val x: Int, val y: Int){

   // PITFALL 1 - Defining equals with the wrong signature.
    def equals(other: Point): Boolean =
      this.x == other.x && this.y == other.y
  }


  def main(args: Array[String]): Unit = {
    val p1, p2 = new Point(1, 2)
    val q = new Point(2, 3)
    println(p1)
    println(p2)

    println(p1 equals p2)

    println(p1 equals q)

    // TROUBLES STARTS HERE
    val coll = mutable.HashSet(p1)
    println("TROUBLES STARTS HERE")
    println(coll contains p2)


    /**
    In fact, the version of equals given above does not
    override the standard method equals, because its type is different. Here is
    the type of the equals method as it is defined in the root class Any1:
      def equals(other: Any): Boolean
    */
    val p2a: Any = p2
    println(s"p1 equals p2a   ${p1 equals p2a}")


    /** A better definition, but still not perfect */
    /*override def equals(other: Any) = other match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }*/

  }
}
