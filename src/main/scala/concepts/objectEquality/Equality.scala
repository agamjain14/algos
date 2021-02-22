package concepts.objectEquality

//IN scala object instance are compared with ==
// In java == is for primitive types and "equals" for object comparison

// https://alvinalexander.com/scala/how-to-define-equals-hashcode-methods-in-scala-object-equality
// Implementing equals method is a seven step process
// 1) create a canEqual method
// 2) canEqual should return true if the argument passed into it is an instance of the current class, false otherwise
// 3) implementing the "equals" method
// 4) writing body of equal as a single match expression
// 5) the match expression must have 2 case statements, first case => typed pattern for the current class
// 6) use series of logical "and" . If this class extends anything other than AnyRef, you'll want to invoke your supreclass equals method
// 7) for other case specify a wildcard pattern that yields false
// 8) Any time you implement an equals method you should also implement a hashCode method, so you might say that’s Step 8 in this process.
object Equality {

  class Person(var name: String, var age: Int) {

    def canEqual(a: Any) = a.isInstanceOf[Person]

    override def equals(obj: Any): Boolean =
      obj match {
        case p: Person => {
          p.canEqual(this) &&
          this.name == p.name &&
          this.age == p.age
        }
        case _ => false
      }

    override def hashCode(): Int = {
      var prime = 31
      var result = 1
      result = prime * result + age
      result = prime * result + (if(name == null) 0 else name.hashCode)
      result
    }
  }
}
