package concepts.patternmatching

object PatternMatchingAnonymousFunc {
  val songTitle = List("A", "B", "C")
  songTitle.map(s => s.toLowerCase)


  val wordFrequencies = List(
    ("habitual", 6),
    ("and", 56),
    ("consuetudinary", 2),
    ("additionally", 27),
    ("homely", 5),
    ("society", 13))

  def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] =
    wordFrequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(t => t._1)

  wordsWithoutOutliers(wordFrequencies)


  // THIS SOLUTION HAS MANY PROBLEM
  // 1) accessing the field of the tuple looks pretty ugly ---> Solution pattern matching anonymous function
  // A PATTERN MATCHING ANONYMOUS FUNCTION IS AN ANONYMOUS FUNCTION THAT IS DEFINED AS
  // A BLOCK CONSISTING OF A SEQUENCE OF CASES
  // BUT WITHOUT MATCH KEYWORD

  def modifiedWordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] =
    wordFrequencies.filter { case (_, f) => f > 3 && f < 25 } map { case (w, _) => w }


  val predicate: (String, Int) => Boolean = { case (_, f) =>
    f > 3 && f < 25 }

  val transformFn: (String, Int) => String = { case (w, _) => w }
  // PLEASE NOTE THAT WEW HAVE TO SPECIFY THE TYPE OF THE VALUE HERE, AS THE SCALA COMPILER CANNOT INFER
  // IT FOR PATTERN MATCHING ANONYMOUS FUNCTION

  // ******* IMPORTANT*********//
  // IF YOU DEFINE AN ANONYMOUS FUNCTION THIS WAY AND WANT TO PASS IT TO SOME OTHER FUNCTION,
  // SUCH AS THE ONES IN OUR EXAMPLE, YOU HAVE TO MAKE SURE THAT FOR ALL POSSIBLE INPUTS, ONE
  // OF YOUR CASES MATCHES SO THAT YOUR ANONYMOUS FUNCTION ALWAYS RETURN A VALUE. OTHERWISE
  // YOU WILL RISK A MATCHERROR AT RUNTIME.

}
