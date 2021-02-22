package concepts.patternmatching


// a for comprehension can also contain value definitions
// and everything you learnt about the usage of patterns in the left side of value definitions holds true for value definitions
object PatternsinForComprehension {
  def gameResults(): Seq[(String, Int)] = ("A", 100) :: ("B", 200) :: ("C", 100) :: Nil


  def hallOfFame = for {
    result <- gameResults()
    (name, score) = result
    if score > 50
  } yield name

  // OR


  def hoF = for {
    (name, score) <- gameResults()
    if score > 50
  } yield name


  //IT is important to know that patterns in the left side of generators can already be used for
  // filtering purposes --- IF A PATTERN ON LEFT SIDE OF A GENERATOR DOES NOT MATCH, THE RESPECTIVE element
  // is filtered out

  val lists = List(1,2,3)::  List.empty :: List(5,3):: Nil

  // THIS WILL THROW A MATCHERROR, but result in an empty list being removed. Hence, we get back List(3,2)

  for {
    list @ head :: _ <- lists
  } yield list.size


}
