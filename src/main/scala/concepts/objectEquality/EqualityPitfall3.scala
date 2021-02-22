package concepts.objectEquality


/**
  * Defining equals in terms of mutable fields
  */
object EqualityPitfall3 {


  /**
    * it is a problem
    * @param x is mutable
    * @param y is mutable
    */
  class Point(val x: Int, val y: Int) {

    override def hashCode = x * 41 + y

    override def equals(other: Any) = other match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }
  }
}
