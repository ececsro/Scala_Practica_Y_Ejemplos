var x = 5
x = 4

val y = 5
//y = 4

var z: Int = 5

// precedencia y asociatividad

x = 5 & 3
x = (5 % 3)

var a = 10
var b = 20
var c = 0

c = a + b
c += a
c -= a
c *= a
c /= a
c %= a
c <<= 2
c >>= 2
c &= a
c ^= a
c |= a


// sentencias

x = 5
x
if (x > 0)
  x = 10
else if (x < 0)
  x = -10
x
while (x>0){
  x = x-1
}
x
do {
  x = x + 1
} while(x<10)
x


val xList = List(1,2,3)
val yList = List(4,5,6)

for (e <- List(1, 3, 5, 7)) {
   println(e)
 } 

println(for (e <- List(1, 2, 3, 4, 5)) yield e)

for (i <- 1 to 5) yield i

for (i <- 1 to 5) yield i * 2



for (x <- xList; y <- yList) yield(x, y)

for (x <- xList; y <- yList) yield(x + y)

for {
  x <- yList
  y <- yList
} yield (x, y)

for {
  x <- yList
  y <- yList
} yield (x + y)

// unit
var cont = 0
cont
def avanzar(): Unit = {
  for(x <- 1 to 10) {
    cont += 1
  }
}
cont
avanzar()
cont

// print

print(5)
print("bla bla bla")
println(5)
println("bla bla bla")

// leer

//scala.io.StdIn.readLine()
// desde main, aplicación!

// orientado a objetos

//todas las anteriores son Case Classes pq no cambian
// sin new, no hace falta
// se comparar por valor, no hace falta equals

class Point(var x: Int, var y: Int) {

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String =
    s"($x, $y)"
}

val point1 = new Point(2, 3)
point1.x // 2
println(point1)