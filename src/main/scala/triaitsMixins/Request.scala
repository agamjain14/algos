package triaitsMixins

sealed trait Request {

  def entitySetName: String
  def userId: String
  def resourceUri: Seq[String]
}

trait EntityFields extends Request {
  def select: List[String]
  abstract override def resourceUri: Seq[String] = super.resourceUri :+ "field statement"
}

trait EntityFilter extends Request {
  def expression: String
  abstract override def resourceUri: Seq[String] = super.resourceUri :+ "filter statement"
}

case class FeedRequest(entitySetName: String, userId: String) extends Request {
  def resourceUri: Seq[String] = Seq("base Uri")
}

object FeedRequest {
  def apply(entitySetName: String, userId: String, fields: List[String]): FeedRequest =
    new FeedRequest(entitySetName, userId) with EntityFields {
      val select: List[String] = fields
    }

  def apply(entitySetName: String, userId: String, filter: String): FeedRequest =
    new FeedRequest(entitySetName, userId) with EntityFilter {
      val expression: String = filter
    }

  def apply(entitySetName: String, userId: String, fields: List[String], filter: String): FeedRequest =
    new FeedRequest(entitySetName, userId) with EntityFields with EntityFilter {
      val select: List[String] = fields
      val expression: String = filter
    }
}

object Main {
  def main(args: Array[String]): Unit = {

    val fr = FeedRequest("esn","A674634", List("a", "b"))
    println(fr.resourceUri)
    val fr1 = FeedRequest("esn","A674634", "filter")
    println(fr1.resourceUri)
    val fr2 = FeedRequest("esn","A674634", List("a", "b"), "filter")
    println(fr2.resourceUri)
  }
}