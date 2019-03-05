package j.parametrizadas

class NonEmptyTree[A](val _item: A,
                      val _left: Tree[A] = new EmptyTree[A](),
                      val _right: Tree[A] = new EmptyTree[A]()) extends Tree[A]() {

  override def item: Option[A] =
    Some(_item)

  override def left: Option[Tree[A]] =
    Some(_left)

  override def right: Option[Tree[A]] =
    Some(_right)

  override def inOrder(): List[A] =
    _left.inOrder ::: (_item :: _right.inOrder)
}
