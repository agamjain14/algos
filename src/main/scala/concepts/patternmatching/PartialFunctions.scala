package concepts.patternmatching

// COLLECT SIGNATURE FOR A SEQ -->  Seq[A]
// def collect[B](pf: PartialFunction[A, B])
// THIS METHOD RETURNS A NEW SEQUENCE BY APPLYING THE GIVEN PARTIAL FUNCTION TO ALL OF ITS ELEMENTS --> THE PARTIAL FUNCTIONS BOTH FILTERS AND MAPS THE SEQUENCE


// ******* SO WHAT IS PARTIAL FUNCTION
// IT'S A UNARY FUNCTION THAT IS KNOWN TO BE DEFINED ONLY FOR CERTAIN INPUT VALUES AND THAT ALLOWS
// CLIENTS TO CHECK WHETHER IT IS DEFINED FOR A SPECIFIC INPUT VALUE.

// PARTIALFUNCTION TRIAT PROVIDES AN isDefinedAt METHOD
// PARTIALFUNCTION[-A, +B] EXTENDS THE TYPE A => B / Function1[A, B]

// PATTERN MATCHING ANONYMOUS FUNCTION IS ALWAYS OF TYPE ALWAYS A TYPE PartialFunction

object PartialFunctions {


  val wordFrequencies = List(
    ("habitual", 6),
    ("and", 56),
    ("consuetudinary", 2),
    ("additionally", 27),
    ("homely", 5),
    ("society", 13))

  val pf: PartialFunction[(String, Int), String] = {
    case (word, freq) if freq > 3 && freq < 25 => word
  }

  // INSTEAD OF USING THE SYNTAX FOR PATTERN MATCHING ANONYMOUS FUNCTIONS, WE COULD
  // HAVE DEFINED THIS PARTIAL FUNCTION BY EXPLICITLY EXTENDING THE PartialFunction TRAIT

  val pf1 = new PartialFunction[(String, Int), String] {
    def apply(wordFrequency: (String, Int)) = wordFrequency match {
      case (word, freq) if freq > 3 && freq < 25 => word
    }

    def isDefinedAt(wordFrequency: (String, Int)): Boolean = wordFrequency match {
      case (word, freq) if freq > 3 && freq < 25 => true
      case _ => false
    }
  }

  // Now, if we passed our partial function to the map method, this would compile just fine, but result
  //in a MatchError at runtime, because our partial function is not defined for all possible input values,
  //thanks to the added guard clause:

  wordFrequencies.map(pf) // will throw a MatchError

  wordFrequencies.collect(pf) // List("habitual", "homely", "society")

}
