package j.parametrizadas

case class ListaNoVacia[A](val __cabeza:A, val __cola:Lista[A]) extends  Lista[A] {

  override def cabeza : Option[A] =
    Some(__cabeza)

  override def cola : Option[Lista[A]] =
    Some(__cola)

  override def length : Int =
    1 + __cola.length

}
