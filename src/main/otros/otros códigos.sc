class X(a:Int){

  private val _a = a


}

val x = new X(4)
x.
List(List(1, 2, 3), true, List(1, 2, 3))

def m(value:Int):Any =
  if(value==0) true else List(3,3)

m(0)
m(33)

class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

var s = new Stack[Int]
s.push(4)
s.push(54)
println(s.pop())
println(s.pop())


class Stack2[A](val elements: List[A]) {

  def push(x: A): Stack2[A] =  new Stack2(x::elements)
  def peek: A = elements.head
  def pop():  Stack2[A] = new Stack2(elements.tail)
}

var s2 = new Stack[Int]
s2.push(4)
s2.push(54)
println(s2.pop())
println(s2.pop())


val result = 1 + 2 + 3 + 4 + 5 + 6 +
  7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 +
  15 + 16 + 17 + 18 + 19 + 20 +
  2