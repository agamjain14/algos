package hackerrank

import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

class CrossWordTest extends FunSuite with Matchers with BeforeAndAfterEach {

  var grid : Array[Array[Char]] = Array.empty[Array[Char]]

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
         |""".stripMargin.split("\n").map(_.toCharArray)
  }

  test("should get horizontal places") {

    val gd: Array[Array[Char]] = grid
    val horizontalPlaces = CrossWord.getHFields(gd)
    val expectedPlaces = List(((3,1),(3,5),5), ((7,2),(7,7),6))
    horizontalPlaces should contain theSameElementsAs expectedPlaces
  }

  test("should transpose") {

    val gd: Array[Array[Char]] = grid
    val actualGrid = CrossWord.transpose(gd)
    val expectedGrid =
          """|++++++++++
             |------++++
             |+++-+++-++
             |+++-+++-++
             |+++-+++-++
             |+++-------
             |+++++++-++
             |+++++++-++
             |++++++++++
             |++++++++++
             |""".stripMargin.split("\n").map(_.toCharArray)

    actualGrid shouldBe expectedGrid
  }

  test("should get vertical places") {

    val gd: Array[Array[Char]] = grid
    val horizontalPlaces = CrossWord.getVFields(gd)
    val expectedPlaces = List(((1,0),(1,5),6), ((5,3),(5,9),7))
    horizontalPlaces should contain theSameElementsAs expectedPlaces
  }

  test("should place the cities") {
    val cities = "LONDON;DELHI;ICELAND;ANKARA".split(";").map(_.toCharArray)
    cities foreach { row => row foreach print; println }
    cities.permutations foreach { p => p  foreach { row => row foreach print; }; println }
  }

//  test("should correctly set the grid for given cities") {
//
//    val cities = "LONDON;DELHI;ICELAND;ANKARA"
//
//    CrossWord.prepareInput(grid, cities)
//    //CrossWord.main(Array.empty[String])
//  }
//
//  test("should return the index of - in a given row") {
//    val row = "--+++-++-+"
//    val actualIndices = CrossWord.getIndices(row)
//
//    val expectedIndices = List(0, 1, 5, 8)
//
//    actualIndices should contain theSameElementsAs expectedIndices
//
//  }
//
//  test("should build horizontal indices map for given input") {
//
//    val rows = grid.split("\n").toList
//
//    val actualMap = CrossWord.buildMap(rows)
//
//    val expectedMap = Map(0 -> List(1), 5 -> List(1, 5), 1 -> List(1), 6 -> List(5), 9 -> List(5), 2 -> List(1), 7 -> List(2, 3, 4, 5, 6, 7), 3 -> List(1, 2, 3, 4, 5), 8 -> List(5), 4 -> List(1, 5))
//
//    actualMap should contain theSameElementsAs expectedMap
//  }
//
//  test("should transpose the board") {
//
//
//    val rows = grid.split("\n").toList
//
//    val actualGrid = CrossWord.transform(rows)
//    val expectedGrid =
//      """|++++++++++
//         |------++++
//         |+++-+++-++
//         |+++-+++-++
//         |+++-+++-++
//         |+++-------
//         |+++++++-++
//         |+++++++-++
//         |++++++++++
//         |++++++++++
//         |""".stripMargin.split("\n").toList
//
//    actualGrid shouldBe expectedGrid
//  }
//
//  test("should build vertical indices map for given input") {
//
//    val rows = grid.split("\n").toList
//
//    val l = CrossWord.transform(rows)
//    val actualMap = CrossWord.buildMap(l)
//
//    val expectedMap = Map(0 -> List(), 5 -> List(3, 4, 5, 6, 7, 8, 9), 1 -> List(0, 1, 2, 3, 4, 5), 6 -> List(7), 9 -> List(), 2 -> List(3, 7), 7 -> List(7), 3 -> List(3, 7), 8 -> List(), 4 -> List(3, 7))
//
//    actualMap should contain theSameElementsAs expectedMap
//  }
//
//  test("should group consecutive integers") {
//    val list = List(1,4,2,5,6,9,8,7,11,14,15).sortWith(_ < _)
//
//    val l = CrossWord.groupListIntoConsecutiveElementBucket(list)
//    l.foreach(println)
//  }

}
