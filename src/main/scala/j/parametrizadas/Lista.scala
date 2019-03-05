package j.parametrizadas

abstract class Lista[A]() {

  def cabeza : Option[A]

  def cola : Option[Lista[A]]

  def length : Int

}
