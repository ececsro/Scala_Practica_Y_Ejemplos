package j.parametrizadas

import org.scalatest.FunSuite

class TreeTest extends FunSuite {

  test("inOrder") {
    val tree =
      new NonEmptyTree('a',
        new NonEmptyTree('b',
          new NonEmptyTree('d'),
          new NonEmptyTree('e')),
        new NonEmptyTree('c',
          new EmptyTree(),
          new NonEmptyTree('f',
            _right = new EmptyTree())))
    assert(tree.inOrder() == List('d', 'b', 'e', 'a', 'c', 'f'))
  }


}
