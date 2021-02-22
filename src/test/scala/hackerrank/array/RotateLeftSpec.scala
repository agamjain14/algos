package hackerrank.array

import org.scalatest.{FunSuite, Matchers}

class RotateLeftSpec extends FunSuite with Matchers {

  test("should rotate array left once") {
    val array = Array(1, 2, 3, 4, 5)

    val arrayUtils = new ArrayUtils(array)

    val actual = arrayUtils.rotateLeft(1)
    val expected = Array(2, 3, 4, 5, 1)

    actual should contain theSameElementsInOrderAs expected

  }

  test("should rotate array left twice") {
    val array = Array(1, 2, 3, 4, 5)

    val arrayUtils = new ArrayUtils(array)

    val actual = arrayUtils.rotateLeft(2)
    val expected = Array(3, 4, 5, 1, 2)

    actual should contain theSameElementsInOrderAs expected

  }

  test("should rotate array left five times") {
    val array = Array(1, 2, 3, 4, 5)

    val arrayUtils = new ArrayUtils(array)

    val actual = arrayUtils.rotateLeft(5)
    val expected = Array(1, 2, 3, 4, 5)

    actual should contain theSameElementsInOrderAs expected

  }

}
