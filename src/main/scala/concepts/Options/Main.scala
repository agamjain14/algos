package concepts.Options




object Main {


  case class User(
                   id: Int,
                   firstName: String,
                   lastName: String,
                   age: Int,
                   gender: Option[String])

  object UserRepository {
    private val users = Map(
      1 -> User(1, "A", "A", 32, Some("male")),
      2 -> User(2, "B", "B", 30, None)
    )

    def findById(id: Int) = users.get(id)

    def findAll = users.values
  }


  val user1 = UserRepository.findById(1)

  if (user1.isDefined) {
    println(user1.get.firstName)
  }


  val user = User(3, "C", "C", 30, None)

  println("Gender: " + user.gender.getOrElse("not specified"))



  case class Resource(content: String)
  val resourceFromConfigDir: Option[Resource] = None
  val resourceFromClasspath: Option[Resource] = Some(Resource("I was found on the class path"))

  val resource = resourceFromConfigDir orElse resourceFromClasspath
}
