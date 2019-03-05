package j.parametrizadas

object Operaciones {

  def contiene[A](item:A, lista:Lista[A]):Boolean =
    lista match {
      case ListaVacia() =>
        false
      case ListaNoVacia(cabeza, cola) =>
        cabeza == item || contiene(item, cola)
    }

  def filtrada[A](lista:Lista[A], condicion: A => Boolean):Lista[A] =
    lista match {
      case ListaVacia() =>
        ListaVacia()
      case ListaNoVacia(cabeza, cola) if condicion(cabeza) =>
        ListaNoVacia(cabeza, filtrada(cola, condicion))
      case ListaNoVacia(_, cola) =>
        filtrada(cola, condicion)
    }

}
