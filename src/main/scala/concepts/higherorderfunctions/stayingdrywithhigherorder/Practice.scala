package concepts.higherorderfunctions.stayingdrywithhigherorder

object Practice {

  case class Email(
                  subject: String,
                  text: String,
                  sender: String,
                  recipient: String)


  type EmailFilter = Email => Boolean

  def newMailForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)
  val sentByOneOf: Set[String] => EmailFilter = senders => email => senders.contains(email.sender)
  val minimumSize: Int => Email => Boolean = n => email => email.text.size <= n
  val maximumSize: Int => EmailFilter = n => email => email.text.size >= n
  /**
    * We can use the function `sentByOneOf` to create a new Email Filter that we can pass to the newMailForUser function
    */
  val emailFilter: EmailFilter = sentByOneOf(Set("abc@abc.com"))
  val sizeEmailFilter: EmailFilter = minimumSize(10)
  val emails = Email("a","b","c","abc@abc.com") :: Nil
  newMailForUser(emails, emailFilter)
  newMailForUser(emails, sizeEmailFilter)
  newMailForUser(emails, sentByOneOf(Set("abc@abc.com")))
  // Reusing existing functions
  type SizeChecker = Int => Boolean
  val sizeConstraint: SizeChecker => EmailFilter = f => email => f(email.text.size)
  val minimumSize1: Int => EmailFilter = n => sizeConstraint(x => x >= n)
  val maximumSize1: Int => EmailFilter = n => sizeConstraint(_ <= n)

  newMailForUser(emails, maximumSize1(10))

  case class Student(name: String, Id: Int)

  type Sorter[T] = (T, T) => Boolean

  def sort[T](list: List[T])(implicit f: Sorter[T]) = list.sortWith(f)

  implicit val sortById: Sorter[Student] = (s1, s2) => s1.Id < s2.Id

  import Practice._
   val list = List(Student("A", 5), Student("B", 2))

  sort(list)//(sortById)

  def main(args: Array[String]): Unit = {

  }
}
