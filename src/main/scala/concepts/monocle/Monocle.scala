package concepts.monocle


/**
  * Scala already provides getters and setters for case classes but modifying nested objects is verbose
  * which makes code difficult to understand and reason about.
  */
object Monocle {

  case class Street(number: Int, name: String)

  case class Address(city: String, street: Street)

  case class Company(name: String, address: Address)

  case class Employee(name: String, company: Company)


  /**
    * Let's say we have an employee and we need to upper case the first character of his company street name
    * here is how we could write it in vanilla scala
    */

  val employee = Employee("john", Company("awesome inc", Address("london", Street(23, "high street"))))
  employee.copy(
    company = employee.company.copy(
      address = employee.company.address.copy(
        street = employee.company.address.street.copy(
          name = employee.company.address.street.name.capitalize
        )
      )
    )
  )

  /**
    * As we can see copy is not convenient to update nested objects because we need to repeat ourselves
    */

  import monocle.Lens
  import monocle.macros.GenLens

  val company: Lens[Employee, Company] = GenLens[Employee](_.company)
  val address: Lens[Company, Address] = GenLens[Company](_.address)
  val street: Lens[Address, Street] = GenLens[Address](_.street)
  val streetName: Lens[Street, String] = GenLens[Street](_.name)

  company composeLens address composeLens street composeLens streetName

  /**
    * ComposeLens takes two lenses, one from A to B and other from B to C and create a third Lens from A to C
    * therefore, after composing company, address, street and name, we obtain a Lens from Employee to String(the street
    * name). Now we can use this Lens issued from the composition to modify the street name using the function
    * capitalize
    */

  (company composeLens address composeLens street composeLens streetName).modify(_.capitalize)(employee)

  /**
    * Here modify lift a function String => String to a function Employee => Employee
    */
}
