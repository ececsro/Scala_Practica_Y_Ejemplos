package j.parametrizadas

class EmptyTree[A]() extends Tree[A] {

  override def item: Option[A] =
    None

  override def left: Option[Tree[A]] =
    None

  override def right: Option[Tree[A]] =
    None

  override def inOrder: List[A] =
    Nil
}
