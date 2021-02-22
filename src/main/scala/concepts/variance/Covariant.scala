package concepts.variance

class Box1[+F <: Fruit](a: F) {}

object Covariant {

  var box: Box1[Fruit] = new Box1[Apple](new Apple {})


}
