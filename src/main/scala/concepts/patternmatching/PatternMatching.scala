package concepts.patternmatching



case class Player(name: String, score: Int)

object PatternMatching {

  /**
    * return type is lowest common ancestors in scala type hierarchy
    *
    * USING PATTERN MATCHING ON LEFT SIDE
    * You can do this with any pattern, but generally, it is a good idea to make sure that your pattern
    * always matches. Otherwise, you will be the witness of an exception at runtime.
    *
    * @param player
    * @return
    */
  def printMessage(player: Player) = player match {
    case Player(_, score) if (score > 1000) => println("get the job")
    case Player(name, score) => name
  }
  def main(args: Array[String]): Unit = {

  }
}
