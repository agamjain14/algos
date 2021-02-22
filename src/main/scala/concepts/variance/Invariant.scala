package concepts.variance

/*

The two classes Box[Fruit] and Box[Apple]
in the example above do not inherit from each other – that is the assumption the Scala compiler
makes when there is no variance annotation. Therefore, you cannot assign an object of type Box[Apple] to
a Box[Fruit]-typed variable:

 */

class Box[F <: Fruit](aFruit: F) {
  def fruit: F = aFruit

}

object Solution1 {
  var appleBox = new Box[Apple](new Apple {})

  var orangeBox = new Box[Orange](new Orange {})

  // Illegal
  // var box: Box[Fruit] = new Box[Apple](new Apple {})
}


