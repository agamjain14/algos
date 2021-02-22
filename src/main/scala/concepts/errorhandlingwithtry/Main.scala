package concepts.errorhandlingwithtry

import scala.util.Try
import java.net.URL

object Main {

  case class Customer(age: Int)
  class Cigarettes
  case class UnderAgeException(message: String) extends Exception(message)

  def buyCigarattes(customer: Customer): Cigarettes =
    if (customer.age < 16) throw UnderAgeException(
      s"Customer must be older than 16 but was ${customer.age}")
    else new Cigarettes


  // Thrown exceptions can be caught and dealt with very similarly to Java, albeit using a partial function
  //to specify the exceptions we want to deal with. Also, Scala’s try/catch is an expression, so the
  //following code returns the message of the exception:

  val youngCustomer = Customer(15)
  try {
    buyCigarattes(youngCustomer)
    "Yo, here are your cancer sticks! Happy smokin'!"
  } catch {
    case UnderAgeException(msg) => msg
  }

  //************** IMPORTANT **************
  // ERROR HANDLING THE FUNCTIONAL WAY

  // IT'S USUALLY PREFERRED TO SIGNIFY THAT AN ERROR HAS OCCURRED BY RETURNING AN APPROPRIATE VALUE FROM YOUR FUNCTION


  // TRY CAN BE COMPARED WITH OPTION
  // Option[A] IS A CONTAINER FOR A VALUE OF TYPE A THAT MAY BE PRESENT OR NOT,
  // Try[A] represents a computation that may result in a value of type A --> IF IT'S SUCCESSFUL, OR IN SOME Throwable
  // IF SOMETHING HAS GONE WRONG
  // THERE ARE TWO DIFFERENT TYPES OF TRY: IF AN INSTANCE OF Try[A] REPRESENTS A SUCCESSFUL COMPUTATION, IT IS AN INSTANCE
  // OF Success[A], SIMPLY WRAPPING A VALUE OF TYPE A. IF, ON THE OTHER HAND, IT REPRESENTS A COMPUTATION IN WHICH
  // AN ERROR HAS OCCURRED, IT IS AN INSTANCE OF Failure[A], WRAPPING A Throwable I.E. AN EXCEPTION OR OTHER KIND OF ERROR

  def parseURL(url: String): Try[URL] = Try(new URL(url))

}
