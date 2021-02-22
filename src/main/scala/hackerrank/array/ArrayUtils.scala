package hackerrank.array

class ArrayUtils(array: Array[Int]) {

  def rotateLeft(numberOfRotation: Int): Array[Int] = {
    val lengthOfArray = array.length
    val relocationFactor = lengthOfArray - numberOfRotation
    array.zipWithIndex.foldLeft(new Array[Int](lengthOfArray))((res, zippedElement) => {
      val updatedIndex = (zippedElement._2 + relocationFactor) % lengthOfArray
      res(updatedIndex) = array(zippedElement._2 )
      res
    })
  }


  /*
    r = 1 => [0 -> 4], [1->0], [2->1], [3->2], [4->3]
  * [1,2,3,4,5] -> [2,3,4,5,1]  ---> [0,1,2,3,4] -> [1,2,3,4,0]
  *
    r = 2 => [0->3], [1->4], [2->0], [3-> 1], [4->2]
    [1,2,3,4,5] -> [3,4,5,1,2]

    (current_index + (len_of_array - r)) % len_of_array

    (x + 3) % 5

   * */
}
