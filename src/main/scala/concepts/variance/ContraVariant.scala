package concepts.variance

class Box2[-F <: Fruit](a: F) {}

object ContraVariant {
  val fruit: Box2[Apple] = new Box2[Fruit](new Fruit {
    override def name: String = ???
  })
}
