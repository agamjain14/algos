package cats

object SortExample extends App {

  type Sorter[T] = (T, T) => Boolean

  trait Sort[T] {
    def sort(seq: Seq[T])(implicit sorter: Sorter[T]): Seq[T]
  }

  object SortableInstances {
    implicit val intInstance = new Sort[Int] {
      override def sort(seq: Seq[Int])(implicit sorter: Sorter[Int]): Seq[Int] = seq.sortWith(sorter)
    }
    implicit val intInstance1 = new Sort[Int] {
      override def sort(seq: Seq[Int])(implicit sorter: Sorter[Int]): Seq[Int] = seq.sortWith(sorter)
    }

    implicit val floatInstance = new Sort[Float] {
      override def sort(seq: Seq[Float])(implicit sorter: Sorter[Float]): Seq[Float] = seq.sortWith(sorter)
    }

    implicit val doubleInstance = new Sort[Double] {
      override def sort(seq: Seq[Double])(implicit sorter: Sorter[Double]): Seq[Double] = seq.sortWith(sorter)
    }

    implicit val cRInstance = new Sort[ClassRoom] {
      override def sort(seq: Seq[ClassRoom])(implicit sorter: Sorter[ClassRoom]): Seq[ClassRoom] = seq.sortWith(sorter)
    }
  }

  object SortableInterface {
    def sortArray[T](value: Seq[T])(implicit sorter: Sorter[T], sortable: Sort[T]) = println(sortable.sort(value))
  }

  import SortableInstances._
  implicit val byId : Sorter[Int] = (c1, c2) => c1 < c2
  val intSeq: Seq[Int] = Seq(1,2,6,2,8,0)
  SortableInterface.sortArray(intSeq)(byId, SortableInstances.intInstance1)

  implicit val byDouble : Sorter[Double] = (c1, c2) => c1 < c2
  val floatSeq: Seq[Double] = Seq(1.0,2.4,6,2.7,8.1,63.1)
  SortableInterface.sortArray(floatSeq)

  case class ClassRoom(roll: Int, name: String)

  implicit val byName: Sorter[ClassRoom] = (c1, c2) => c1.name < c2.name
  val cRSeq: Seq[ClassRoom] = Seq(ClassRoom(2, "G"), ClassRoom(1,"B"), ClassRoom(6,"A"))
  SortableInterface.sortArray(cRSeq)

  /*implicit val byRoll: Sorter[ClassRoom] = (c1, c2) => c1.roll < c2.roll
  val cRSeq1: Seq[ClassRoom] = Seq(ClassRoom(7, "G"), ClassRoom(2,"B"), ClassRoom(5,"A"))
  SortableInterface.sortArray(cRSeq1)*/
}
