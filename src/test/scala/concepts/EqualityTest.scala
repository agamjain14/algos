package concepts

import concepts.objectEquality.Equality.Person
import org.scalatest.FunSuite

class EqualityTest extends FunSuite {
  val nimoy = new Person("Leonard Nimoy", 82)
  val nimoy2 = new Person("Leonard Nimoy", 82)
  val shatner = new Person("William Shatner", 82)
  val stewart = new Person("Patrick Stewart", 47)

  // all tests pass
  test("nimoy   != null")    { assert(nimoy != null) }

  // these should be equal
  test("nimoy   == nimoy")   { assert(nimoy != nimoy) } // it will fail
  test("nimoy   == nimoy2")  { assert(nimoy == nimoy2) }
  test("nimoy2  == nimoy")   { assert(nimoy2 == nimoy) }
}
