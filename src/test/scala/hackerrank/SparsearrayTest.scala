package hackerrank

import org.scalatest.{FunSpec, Matchers}

class SparsearrayTest extends FunSpec with Matchers{

  describe("SAT List method") {
    it("should matching elements") {
      val ele = sparsearray.mainWork(List("aba"," baba", "aba", "xzxb"), List(1, 2, 3))
      ele should be(List(2,1,0))
    }
  }
}
