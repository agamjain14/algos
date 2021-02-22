package segregate

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Segregate {

  case class Inbox(id: Int, name: String)
  case class Source(id: Int, name: String)
  case class InboxSource(id: Int, ibx: Inbox, src: Source)
  case class Response(ibxSrcs: Set[InboxSource])

  def main(args: Array[String]): Unit = {
    val ibx1 = Inbox(1,"Agam")

    val src1 = Source(1,"Src1")
    val src2 = Source(2,"Src2")
    val src3 = Source(3,"Src3")
    val src4 = Source(4,"Src4")

    val ibxSrc = Set(InboxSource(1,ibx1, src1), InboxSource(2,ibx1, src1), InboxSource(3,ibx1, src3), InboxSource(4,ibx1, src4))


    val response =  Response(ibxSrc)

    val p = response.ibxSrcs.groupBy(ibxsrc => ibxsrc.src).mapValues(_.size).toList
    println("#####" + p)




  }

}
