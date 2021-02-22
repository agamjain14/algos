package concepts.objectEquality


/**
  * Failing to define equals as an equivalence relation
  */
object EqualityPitfall4 {


  object Color extends Enumeration{
    val red, green, blue = Value
  }


  class Point(val x: Int, val y: Int) {

    override def hashCode = x * 41 + y

    override def equals(other: Any) = other match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }
  }

  class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends Point(x, y) {
    override def equals(other: Any): Boolean = other match {
      case that: ColoredPoint =>
        this.color == that.color && super.equals(that)
      case _ => false
    }
  }


}
