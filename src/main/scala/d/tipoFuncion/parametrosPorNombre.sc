// evaluación perezosa

def lazyAnd(left: Boolean, right: => Boolean): Boolean =
  if (left)
    right
  else
    false

lazyAnd(4>6,5/0>3)
//lazyAnd(4<6,5/0>3)

def strictAnd(left: Boolean, right: Boolean): Boolean =
  if (left)
    right
  else
    false

//strictAnd(4>6,5/0>3)
//strictAnd(4<6,5/0>3)

// imperativa
def whileLoop(condition: => Boolean)(body: => Unit): Unit =
  if (condition) {
    body
    whileLoop(condition)(body)
  }

var i = 2

whileLoop(i > 0) {
  println(i)
  i -= 1
} // prints 2 1