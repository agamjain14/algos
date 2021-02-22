package hackerrank

import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

class CrossWordSpec extends FunSuite with Matchers with BeforeAndAfterEach {

  var grid = ""

  override def beforeEach(): Unit = {
    grid =
      """|+-++++++++
         |+-++++++++
         |+-++++++++
         |+-----++++
         |+-+++-++++
         |+-+++-++++
         |+++++-++++
         |++------++
         |+++++-++++
         |+++++-++++
         |""".stripMargin
  }


  test("should correctly set the grid for given cities") {

    val cities = "LONDON;DELHI;ICELAND;ANKARA"

    //Cross.prepareInput(grid, cities)
    //CrossWord.main(Array.empty[String])
  }

}
