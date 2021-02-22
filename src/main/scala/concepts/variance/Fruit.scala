package concepts.variance


// https://blog.codecentric.de/en/2015/03/scala-type-system-parameterized-types-variances-part-1/
trait Fruit {
  def name : String
}

trait Orange extends Fruit {
  def name = "Orange"
}

trait Apple extends Fruit {
  def name = "Apple"
}