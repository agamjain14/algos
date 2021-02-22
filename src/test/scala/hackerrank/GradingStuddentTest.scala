package hackerrank

import org.scalatest.FunSuite

class GradingStuddentTest extends FunSuite {

  test("An array should be blah blah"){
    assert(Result.gradingStudents(Array(45,56,57,33)) sameElements  Array(45,56,57,33))
  }

  test("for other types") {
    intercept[Exception] {
      Result.gradingStudents(Array("45",56.0,45,"33"))
    }
  }
}
