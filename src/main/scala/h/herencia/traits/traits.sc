// trait: sin parámetros de construcción (no tipo), herencia múltiple y, sin implementación, compatibles con interfaz de java
// class: con parámetros de construccion (valor y tipo), herencia simple y compatibles con Java

trait BaseSoundPlayer {
  def play
  def close
  def pause
  def stop
  def resume
}

class Mp3SoundPlayer extends BaseSoundPlayer {
  def play { println("ñalsjdf")}
  def close {}
  def pause {}
  def stop {}
  def resume {}
}

trait BaseSoundFilePlayer
trait BasicPlayer
trait BasicController

trait Mp3BaseSoundFilePlayer extends BaseSoundFilePlayer {
  def getBasicPlayer: BasicPlayer
  def getBasicController: BasicController
  def setGain(volume: Double)
}

abstract class JavaSoundPlayer extends BaseSoundPlayer {
  def play {}
  def close {}
}

abstract class Animal {
  def speak
}

trait WaggingTail {
  def startTail
  def stopTail
}

trait FourLeggedAnimal {
  def walk
  def run
}

class Dog extends Animal with WaggingTail with FourLeggedAnimal {
  def speak {}
  def startTail {}
  def stopTail {}
  def walk {}
  def run {}
}

trait PizzaTrait {
  var numToppings: Int // abstract
  val maxNumToppings = 10 // concrete
}

class Pizza extends PizzaTrait {
  var numToppings = 0 // override not needed
}

{
  trait Pet {
    def speak {
      println("Yo")
    } // concrete implementation of a speak method
    def comeToMaster // abstract
  }

  class Dog extends Pet {
    // don't need to implement 'speak' if you don't want to
    def comeToMaster{
      println("I'm coming!")
    }
  }

  class Cat extends Pet {
    // override 'speak'
    override def speak {
      println("meow")
    }

    def comeToMaster {
      println("That's not gonna happen.")
    }
  }

  abstract class FlyingPet extends Pet {
    def fly = {
      println("I'm flying!")
    }
  }

}

{
  trait Tail {
    def wagTail {
      println("tail is wagging")
    }
  }

  abstract class Pet(var name: String) {
    def speak // abstract
    def ownerIsHome {
      println("excited")
    }
  }

  class Dog(name: String) extends Pet(name) with Tail {
    def speak {
      println("woof")
    }
  }

  object Test extends App {
    val zeus = new Dog("Zeus")
    zeus.ownerIsHome
    zeus.wagTail
    zeus.speak
  }
}

{
  trait Animal
  trait Wagging
  trait Running

  class Dog extends Animal with Wagging with Running {
    def speak {
      println("Woof")
    }

    def wag {
      println("Tail is wagging!")
    }

    def run {
      println("I'm running!")
    }
  }
}

// limitación de subclase
{
  trait WarpCore {
    this: Starship =>
  }

  class Starship
  class Enterprise extends Starship with WarpCore
//    class HandMade extends WarpCore
}

{
  class DavidBanner

  trait Angry {
    println("You won't like me ...")

    def f(ostias:Int):Unit = {
      print("ñalsjdf")
    }


  }

  object Test extends App {
    val hulk = new DavidBanner with Angry
  }
}

{
  trait A {
    println("trait A is constructed")
  }
  trait B {
    println("trait B is constructed")
  }
  trait C {
    println("trait C is constructed")
  }

  class D extends A with B with C {
    println("class D is constructed")
  }

  val d = new D
  //  trait A is constructed
  //  trait B is constructed
  //  trait C is constructed
  //  class D is constructed
}

{
  trait Hello {
    def hello { println("hello from Hello") }
  }

  trait A extends Hello {
    override def hello {
      println("hello from A")
      super.hello
  }
  }

  trait B extends Hello {
    override def hello {
      println("hello from B")
      super.hello
    }
  }

  trait C extends Hello {
    override def hello {
      println("hello from C")
      super.hello
    }
  }

  class D extends A with B with C
  val d = new D
  d.hello
  //  hello from Hello
//  hello from C
  //  hello from Hello
//  hello from B
  //  hello from Hello
//  hello from A

}