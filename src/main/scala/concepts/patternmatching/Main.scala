package concepts.patternmatching



// Their return value is what is returned by the block belonging to the first matched pattern
object Main {

  case class Player(name: String, score: Int)
  def printMessage(player: Player) = player match {
    case Player(_, score) if score > 10000 => println("get a life")
    case Player(name, _) => println(s"hey $name, nice to see you again")
  }

  // message() is a pure function
  def message(player: Player) = player match {
    case Player(_, score) if score > 100000 => "get a job"
    case Player(name, _) => s"hey $name"
  }

  def printMessage1(player: Player) = println(message(player))


  def currentPlayer: Player = Player("Daniel", 350)
  val player = currentPlayer

  val Player(name, _) = currentPlayer

  //it is a good idea to make sure that your pattern
  //always matches. Otherwise, you will be the witness of an exception at runtime.

  def scores: List[Int] = List()

  val best :: rest = scores /// MATCH ERROR



  def gameResult(): (String, Int) = ("Daniel", 500)

  val result = gameResult()
  println(s"${result._1}: ${result._2}")


  // it's safe to destructure our tuple in the value definition, as we know we are dealing with Tuple2

  val (name1, score) = gameResult()

}
