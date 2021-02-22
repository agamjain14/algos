package concepts.exception

object MainObject{

  type Sorter[T] = (T, T) => Boolean
  def sort[T](list: List[T], sorter: Sorter[T]): List[T] = {
    list.sortWith(sorter)
  }


  case class Country(name: String, id: Int)
  type CountrySorter = Sorter[Country]
  def byName : CountrySorter = (c1, c2) => c1.name < c2.name
  def byId : CountrySorter = (c1, c2) => c1.id < c2.id

  val countries = List(Country("Australia", 61), Country("USA", 1), Country("France", 33))

  sort(countries, byName)
}



object MainObject1 {
  case class Country(name: String, id: Int)
  def sort[T](list: List[T])(compare: (T, T) => Boolean): List[T] = {
    list.sortWith(compare)
  }

  def main(args: Array[String]): Unit = {
    val list = List(Country("C2", 1), Country("C1", 10))
    val rl = sort(list)((a, b) => a.name < b.name)
    list.foreach(print)
    println()
    rl.foreach(print)
    println

    val intList = List(1,2,3,4,5)
    val ril = sort(intList)((e1, e2) => e1 < e2)

    intList.foreach(print)
    println()
    ril.foreach(print)
    implicit val countryOrdering: Ordering[Country] = Ordering.by(_.name)
    val countries = List(Country("USA", 23), Country("Poland", 56), Country("Korea", 42))
    val sortedCountries = countries.sorted
  }

}
