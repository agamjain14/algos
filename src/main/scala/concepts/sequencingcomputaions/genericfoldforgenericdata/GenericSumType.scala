package concepts.sequencingcomputaions.genericfoldforgenericdata

// Scala’s standard library has the generic sum type Either for two cases, but it
//does not have types for more cases.
object GenericSumType {
  sealed trait Sum[A, B]
  final case class Left[A, B](value: A) extends Sum[A, B]
  final case class Right[A, B](value: B) extends Sum[A, B]
}
