package j.parametrizadas

import org.scalatest.FunSuite

class ListaTest extends FunSuite {

  test("length") {
    val listaVacia = new ListaVacia[Int]
    assert(listaVacia.length == 0)

    val lista1 = new ListaNoVacia(1, listaVacia)
    assert(lista1.length == 1)

    val lista2 = new ListaNoVacia(2, lista1)
    assert(lista2.length == 2)

    val lista3 = new ListaNoVacia(3, lista2)
    assert(lista3.length == 3)
  }

}
