package triaitsMixins

trait Animal {

  def liveOneDay: Seq[String] = Seq("walk")
}

class Wolf extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack arm" :+ "eat animal"
}

class Fox extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack arm" :+ "eat animal" :+ "attack henhouse"
}

trait AttackingAnimal extends Animal{
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack farm"
}

trait CarnivoreAnimal extends Animal{
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "eat animal"
}


trait HenAttacker extends Animal{
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack henhouse"
}

class NewWolf extends Animal with AttackingAnimal with CarnivoreAnimal


trait Animal1{
  def liveOneDay: Seq[String]
}



class Crow extends Animal {
  override def liveOneDay: Seq[String] = Seq("fly") // CROW DOESN'T SEEM TO WALK
}

trait FlyingAnimal extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "fly"
}


class Raven extends Animal with FlyingAnimal

//SUPPOSE ANIMAL TRAIT HAVE NO DEFINITION

/**
  *

trait NewAnimal {
  def liveOneDay: Seq[String]
}

trait NewFlyingAnimal extends NewAnimal{
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "fly"
}

class MyTest extends NewAnimal with NewFlyingAnimal
*/

trait RightAnimal {
  def liveOneDay: Seq[String]
}

trait EmptyAnimal extends RightAnimal {
  override def liveOneDay: Seq[String] = Seq.empty
}

trait RightFlyingAnimal extends RightAnimal {
  abstract override def liveOneDay: Seq[String] = super.liveOneDay :+ "fly"
  // It let's define => we know at some point
  // there is a guaranteed person who is  gonna provide a super implementation of the liveOneDay
}

trait RightCarnivoreAnimal extends RightAnimal {
  abstract override def liveOneDay: Seq[String] = super.liveOneDay :+ "eat animal"
}

/**
  * THROWS ERROR

class NewRaven extends RightAnimal with RightFlyingAnimal with RightCarnivoreAnimal {
  override def liveOneDay: Seq[String] = super.liveOneDay
}
*/


case class UpdateRaven() extends RightAnimal {
  override def liveOneDay: Seq[String] = Seq("base impl")
}

/*case class NewRaven() extends RightAnimal with EmptyAnimal with RightFlyingAnimal with RightCarnivoreAnimal {
  override def liveOneDay: Seq[String] = super.liveOneDay
}*/
object Test {
  def main(args: Array[String]): Unit = {
    val animal = new Wolf
    println(animal.liveOneDay)

    val animal2= new Fox
    println(animal2.liveOneDay)


    val nw = new NewWolf
    println(nw.liveOneDay)


    val cr = new Crow
    println(cr.liveOneDay)


    val rv = new Raven
    println(rv.liveOneDay)

    // ERROR
    /*
    Error:(56, 48) method liveOneDay in trait NewAnimal is accessed from super. It may not be abstract unless it is overridden by a member declared `abstract' and `override'
    override def liveOneDay: Seq[String] = super.liveOneDay :+ "fly"
   */

    /**
      * the way it is structured I don't know that the  there will be someone implementing liveOneDay above the level
      * where NewFlyingAnimal is ==> all I know that liveOneDay exists => so I can't call super.liveOneDay
      * necessarily => because I don't know when someone is gonna put NewFlyingAnimal before this
      *
      * THE SOLUTION IS USING abstract override
      *
      */
    // val mt = new MyTest
   // println(mt.liveOneDay)


    /*val tA = new NewRaven
    println("qq " + tA.liveOneDay)*/

    val uR = new UpdateRaven() with RightFlyingAnimal with RightCarnivoreAnimal
    println("qq " + uR.liveOneDay)
  }
}
