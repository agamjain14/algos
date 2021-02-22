package concepts.sequencingcomputaions.genericfoldforgenericdata

import scala.concurrent.Future


/*The sum type is called Either,
products are tuples,
and optional values are modelled with Option.*/


object TreeImpl {

  sealed trait Tree[A] {
    def fold[B](node: (B, B) => B, leaf: A => B): B
    def f :Future[Unit] = Future.successful()
  }
  case class Leaf[A](value: A) extends Tree[A] {
    def fold[B](node: (B, B) => B, leaf: A => B): B = leaf(value)
  }
  case class Node[A](left : Tree[A], right: Tree[A]) extends Tree[A] {
    def fold[B](node: (B, B) => B, leaf: A => B): B =
      node(left.fold(node, leaf), right.fold(node, leaf))
  }
}
