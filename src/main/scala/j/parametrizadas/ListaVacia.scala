package j.parametrizadas

case class ListaVacia[A]() extends  Lista[A] {

  override def cabeza : Option[A] =
    None

  override def cola : Option[Lista[A]] =
    None

  override def length : Int =
    0
}
