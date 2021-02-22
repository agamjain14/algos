package concepts.objectEquality


/**
  * Changing equals without also changing hashCode
  */
object EqualityPitfall2 {

  class Point(val x: Int, val y: Int) {

    override def hashCode = x * 41 + y

    override def equals(other: Any) = other match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }
  }
}
