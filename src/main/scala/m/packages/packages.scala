package xxxx

package a {
  class xxx
  trait ttt

  package b {
    case class X(value:Int)
    case class Y(value:Int)
  }
}

//import a.b.X
//import a.b.Y
//
//import a.b._



class Z {
//  import
  import a.b.{X, Y}
  val x = X(4)
  val y = Y(4)
}

package XX {

  import a.b.{X => XX}

  class Otra {
    val xx = XX(5)
  }
}
