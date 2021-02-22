package concepts.patternmatching

object Practice {

  def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] = {
    wordFrequencies.filter(t => t._2 > 2 && t._2 < 25).map(_._1)
  }



  /**
    * if we could destructure tha pair, we could make this code a little more pleasant and probably more readable
    * Scala provides a way of writing anonymous function : A PATTERN MATCHING ANONYMOUS FUNCTION
    *
    * A pattern matching anonymous function is an anonymous function that is defined as a block consisting of a
    * sequence of cases, surrounded as usual by curly braces, but WITHOUT A MATCH keyword before the block
    *
    * @param wordsFrequencies
    * @return
    */
  def wordsWithoutOutliersPatterMatchingAnonFunc(wordsFrequencies: Seq[(String, Int)]): Seq[String] = {
    wordsFrequencies filter {
      case (_, f) => f > 2 && f < 25
    } map {
      case (w, _) => w
    }
  }


  /**
    * Please Note that you have to specify the type of the value here, as the Scala compiler cannot infer it for
    * the pattern matching anonymous function
    */
  // Try assigning these anonymous function to values
  val predicate:(String, Int) => Boolean = {
    case (_, f) => f > 3 && f < 25
  }

  val transformFn: (String, Int) => String = {
    case (w, _) => w
  }

  /**
    * If you define an anonymous function this way and want to pass it to some other function, you have to make sure
    * that for all possible inputs, one of your cases matches so that tour anonymous function always return
    * a value --> OTHERWISE YOU WILL RISK A MATCHERROR AT RUNTIME
    */



  def main(args: Array[String]): Unit = {

  }
}
