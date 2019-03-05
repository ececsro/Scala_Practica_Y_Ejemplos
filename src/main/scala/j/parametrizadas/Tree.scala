package j.parametrizadas

abstract class Tree[A] {

  def item : Option[A]

  def left : Option[Tree[A]]

  def right : Option[Tree[A]]

  def inOrder : List[A]

}
