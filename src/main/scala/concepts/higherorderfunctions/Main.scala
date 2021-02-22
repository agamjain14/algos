package concepts.higherorderfunctions

object Main {

  case class Email(
    subject: String,
    text: String,
    sender: String,
    recipient: String)


  // we have filtering function that makes use of predicate, a function  of type Email => Boolean


  type EmailFilter = Email => Boolean // type alias
  def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)


  // factory functions that produce EmailFilter functions configured to the user's liking:


  val sentByOneOf: Set[String] => EmailFilter = {
    senders => email => senders.contains(email.sender) // list of sender => Email => Boolean
  }

  val notSentByAnyOf: Set[String] => EmailFilter = {
    senders => email => !senders.contains(email.sender)
  }

  val minimumSize: Int => EmailFilter = {
    n => email => email.text.size >= n
  }

  val maximumSize: Int => EmailFilter = {
    n => email => email.text.size <= n
  }

  // EACH OF THESE FOUR VALS IS A FUNCTION THAT RETURNS AN EmailFilter,
  // WE CAN USE ANY OF THESE FUNCTION TO CREATE A NEW EmailFilter THAT WE CAN PASS TO THE newMailsForUser function

  val emailFilter: EmailFilter = notSentByAnyOf(Set("a@a.com"))

  val mails = Email(
    subject = "blah blah",
    text = "blah blah",
    sender = "a@a.com",
    recipient = "b@b.com"
  ) :: Nil

  newMailsForUser(mails, emailFilter)

  // WE INTRODUCE A FUNCTION sizeConstraint THAT TAKES A PREDICATE THAT CHECKS IF THE SIZE OF THE EMAIL BODY IS OKAY.
  // THAT SIZE WILL BE PASSED TO THE PREDICATE BY THE sizeConstraint FUNCTION
  type SizeChecker = Int => Boolean
  val sizeConstraint: SizeChecker => EmailFilter =
    f => email => f(email.text.size)

  val minimumSize1: Int => EmailFilter = n => sizeConstraint(_ >= n)

  def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)





}
