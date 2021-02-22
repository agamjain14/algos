package workshop.trains

case class Train(kind: String, number: Int, schedule: Seq[()])

case class Time(hours: Int = 0, minutes: Int = 0) {
  require(hours >= 0 && hours < 24, "Hours should be between 0 and 23")
}