package j.parametrizadas

import org.scalatest.FunSuite

class OperacionesTest extends FunSuite {

  test("contiene") {
    val lista = ListaNoVacia(1,ListaNoVacia(2,ListaNoVacia(3,ListaVacia())))
//    val x = 1::2::3::Nil
    assert(Operaciones.contiene(2, lista))
  }

  test("filtrada") {
    val lista = ListaNoVacia(1,ListaNoVacia(2,ListaNoVacia(3,ListaVacia())))
    val condicion : (Int)=>Boolean = (valor:Int)=>valor%2==0
    assert(Operaciones.filtrada(lista,condicion)==ListaNoVacia(2,ListaVacia()))
  }

}
