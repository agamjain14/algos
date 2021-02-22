package hackerrank

object CommonSubstring extends App {

  val s1 = "Hello".toLowerCase

  val s2 = "orl".toLowerCase

  val m1 = s1.groupBy(identity).keySet
  val m2 = s2.groupBy(identity).keySet

  val r = m1.foldLeft(("No", false))((r, c) => {
    if(!r._2 && m2.contains(c)) {
       ("Yes", true)
    } else {
      r
    }
  })

  print(r._1)
}
