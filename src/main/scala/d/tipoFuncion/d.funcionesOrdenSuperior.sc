// funciones anónimas
def double2(value: Int): Int = 2 * value

def double3 = (value: Int) => 2 * value

double3(5)
double3(-666)
((value: Int) => 2 * value) (5)
((value: Int) => 2 * value) (-666)

def isEven(value: Int): Boolean = (value % 2) == 0

def isEven2 = (value: Int) => (value % 2) == 0

isEven2(0)
isEven2(1)
isEven2(5)
isEven2(6)
((value: Int) => (value % 2) == 0) (0)
((value: Int) => (value % 2) == 0) (1)
((value: Int) => (value % 2) == 0) (5)
((value: Int) => (value % 2) == 0) (6)

def isOdd2 = (value: Int) => !isEven2(value)

isOdd2(0)
isOdd2(1)
isOdd2(5)
isOdd2(6)

def swap[A, B] = (x: A, y: B) => (y, x)

swap(3, 4)
swap(true, (3, 4))
swap((3, 4), ((6, 7), (8, 9)))
swap(((6, 7), (8, 9)), (3, 4))

def swap2[A, B] = (tuple: (A, B)) => (tuple._2, tuple._1)

swap2((2, true))
swap2(((3, 4), ((6, 7), (8, 9))))
swap2((((6, 7), (8, 9)), (3, 4)))

def isLowerCaseLetter = (char: Char) =>
  'a' <= char && char <= 'z' || char == 'ñ'

isLowerCaseLetter('a')
isLowerCaseLetter('ñ')
isLowerCaseLetter('z')
isLowerCaseLetter('A')
isLowerCaseLetter('*')

def toLowerCaseLetter = (upperCaseLetter: Char) =>
  if ('A' <= upperCaseLetter && upperCaseLetter <= 'Z')
    (upperCaseLetter + ('a' - 'A')).toChar
  else
    'ñ'

toLowerCaseLetter('A')
toLowerCaseLetter('Ñ')
toLowerCaseLetter('Z')

// funciones de orden superior! De primera clase!!!

def double(value: Int): Int = // Int => Int
  2 * value

def square(value: Int): Int =
  value * value

def sumDoubles(from: Int, to: Int): Int =
  if (from > to)
    0
  else
    double(from) + sumDoubles(from + 1, to)

sumDoubles(-5, 5)
sumDoubles(1, 10)

def sumSquares(from: Int, to: Int): Int =
  if (from > to)
    0
  else
    square(from) + sumSquares(from + 1, to)

sumSquares(-5, 5)
sumSquares(1, 10)

def sum(from: Int, to: Int, function: Int => Int): Int =
  if (from > to)
    0
  else
    function(from) + sum(from + 1, to, function)

sum(-5, 5, double)
sum(1, 10, double)

sum(-5, 5, square)
sum(1, 10, square)

sum(-5, 5, value => 2 * value)
sum(1, 10, value => 2 * value)
sum(-5, 5, value => value * value)
sum(1, 10, value => value * value)

def sumValues(from: Int, to: Int): Int =
  if (from > to)
    0
  else
    from + sumValues(from + 1, to)

sumValues(-5, 5)
sumValues(1, 10)

def identity[A](value: A): A = value

identity(4)
identity(5.5)

def identity2[A] = (value:A)=> value


sum(-5, 5, identity)
sum(1, 10, identity)
sum(-5, 5, x => x)

def sumDoubles2(from: Int, to: Int): Int =
  sum(from, to, double)

sumDoubles2(-5, 5)
sumDoubles2(1, 10)

def sumSquares2(from: Int, to: Int): Int =
  sum(from, to, square)

sumSquares2(-5, 5)
sumSquares2(1, 10)

def sumValues2(from: Int, to: Int): Int =
  sum(from, to, identity)

sumValues2(-5, 5)
sumValues2(1, 10)

// funcion de retorno: clousures!!!

(x:Int) => 2*x
((x:Int) => 2*x)(5)
(suffix: String) => "PREFIJO" + " " + suffix
((suffix: String) => "PREFIJO" + " " + suffix)("Pepe")

def concatenator(preffix: String): String => String =
  (suffix: String) => preffix + " " + suffix

def greeting = concatenator("Hi,")
greeting("Luis")
greeting("Paula")

concatenator("Hi,")("Luis")
concatenator("Hi,")("Paula")
def dismissal = concatenator("Bye,")
dismissal("Luis")
dismissal("Paula")

def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if (ssl) "https://" else "http://"
  (endpoint: String, query: String) => schema + domainName + "/" + endpoint + "?" + query

}

def getURL = urlBuilder(ssl = true,  "www.example.com")
val url = getURL("users", "id=1")

// aplicación parcial
def isInRange(left: Int, value: Int, right: Int): Boolean = {
  left < value && value < right
}

isInRange(3,7,9)
(isInRange(_: Int, 5, 10))(3)

def is5InRange = isInRange(_: Int, 5, _: Int)
is5InRange(0, 8)
is5InRange(-2, 2)

def between0and10 = isInRange(0, _: Int, 10)
between0and10(5)
between0and10(100)

// currificación

def concatenator8(preffix:String, suffix:String): String =
  preffix + " " + suffix

concatenator8("Hi,", _:String)
(concatenator8("Hi,", _:String))("Luis")

def concatenator2(preffix: String)(suffix: String) : String =
  preffix + " " + suffix

concatenator2("Hi,")_
concatenator2("Hi,")("Luis")

def add(a: Int, b: Int): Int =
  a + b

def addCurrifying =
  (add _).curried

def add5 = addCurrifying(5)
add5(10)
add5(100)
def add5and7 = add5(7)
add5and7

// funciones estandar
// map
// foldl
// find
// filter


def doubles2(list:List[Int]):List[Int] =
  list match {
    case Nil => Nil
    case head::tail => head*2 :: doubles2(tail)
  }

doubles2(List(1, 3, 4))

def evens2(list:List[Int]):List[Boolean] =
  list match {
    case Nil => Nil
    case head::tail => (head%2==0) :: evens2(tail)
  }
evens2(List(1, 2, 3, 4, 5, 6))


def map[A, B](list: List[A], transform: A => B): List[B] =
  list match {
    case Nil => Nil
    case head :: tail => transform(head) :: map(tail, transform)
  }

map(List(1, 3, 4), (x: Int) => 2 * x)
map(List(1, 2, 3, 4, 5, 6), (x: Int) => x % 2 == 0)
//map(List((1,2),(3,4),(4,5)),{ case (x:Int,y:Int) => x})

def filter[A](list:List[A], criterial: A => Boolean):List[A]=
  list match {
    case Nil => Nil
    case head::tail if criterial(head) => head::filter(tail, criterial)
    case _::tail => filter(tail, criterial)
  }

def reduce[A](list:List[A], fun: (A,A)=>A, emptyValue:A): A =
  list match {
    case Nil => emptyValue
    case head::Nil => head
    case first::second::tail => reduce(fun(first,second)::tail, fun, emptyValue)
  }

reduce(List(1,2,3,4), (x:Int, y:Int)=> x+y, 0)
reduce(Nil, (x:Int, y:Int)=> x+y, 0)
reduce(List(false,false,false,false), (x:Boolean, y:Boolean)=> x || y, false)
reduce(Nil, (x:Boolean, y:Boolean)=> x || y, false)






// estructuras de datos

8.abs
8 abs

7.compareTo(8)
7.compareTo {8}

List((1, 2), (3, 4), (4, 5)).map( (x: (Int, Int)) => x._2 )
List((1, 2), (3, 4), (4, 5)).map{ (x: (Int, Int)) => x._1 }
List((1, 2), (3, 4), (4, 5)).map { case (x:Int, y:Int) => x }
List((1, "a"), (3, "b"), (4, "c")).map { case (e1: Int, e2: String) => e1.toString + e2 }
List(1,3,4).map(x=>2*x)
//List(1,3,4).fold((x:Int,y:Int)=> x+y)


def putOnRow(row: List[Char], column: Int, player: Char): List[Char] =
  row match {
    case Nil => Nil
    case _ :: tail if column == 0 => player :: tail
    case head :: tail => head :: putOnRow(tail, column - 1, player)
  }

def putOnRow3(row: List[Char], column: Int, player: Char): List[Char] = {
  val head = row.head
  val tail = row.tail
  column match {
    case 0 => player :: tail
    case _ => head :: putOnRow3(tail, column - 1, player)
  }
}

val initialRow = List(' ', ' ', ' ')
val firstPutRow = putOnRow(initialRow, 2, 'x')
val secondPutRow = putOnRow(firstPutRow, 0, 'o')
val thirdPutRow = putOnRow(secondPutRow, 0, 'x')

def putsOnRow(row:List[Char], commands:List[(Int,Char)]):List[Char] =
  commands match {
    case Nil => row
    case (column,player)::tail =>
      putsOnRow(putOnRow(row, column, player), tail)
  }



def putsOnRow2(row:List[Char], commands:List[(Int,Char)]):List[Char] = {

  //  print(row)

  commands match {
    case Nil => row
    case (column, player) :: tail => {
      val actualState = putOnRow(row, column, player)

      //      print(actualState)

      putsOnRow2(actualState, tail)
    }
  }
}

putsOnRow(initialRow, List((2,'x'),(0,'o'), (0,'x')))


def putOnBoard(board: List[List[Char]], coordinate: (Int, Int), player: Char): List[List[Char]] =
  board match {
    case Nil => Nil
    case head :: tail if coordinate._1 == 0 => putOnRow(head, coordinate._2, player) :: tail
    case head :: tail => head :: putOnBoard(tail, (coordinate._1 - 1, coordinate._2), player)
  }

def putOnBoard2(board: List[List[Char]], coordinate: (Int, Int), player: Char): List[List[Char]] =
  (board, coordinate) match {
    case (head::tail, (0, column)) => putOnRow(head, column, player)::tail
    case (head::tail, (row, column)) => head:: putOnBoard2(tail, (row-1, column), player)
  }



val initialBoard = List(
  List(' ', ' ', ' '),
  List(' ', ' ', ' '),
  List(' ', ' ', ' '))
val firstPutBoard = putOnBoard(initialBoard, (1, 1), 'x')
val secondPutBoard = putOnBoard(firstPutBoard, (2, 0), 'o')
val thirdPutBoard = putOnBoard(secondPutBoard, (1, 0), 'x')

def putsOnBoard(board:List[List[Char]], comamnds: List[((Int, Int), Char)]): List[List[Char]] =
  comamnds match  {
    case Nil => board
    case (coordinate,player)::tail => {
      val actualState = putOnBoard(board, coordinate, player)

      //      print(actualState)

      putsOnBoard(actualState, tail)
    }
  }

putsOnBoard(initialBoard, List(((1, 1),'x'),((2, 0),'o'),((1, 0),'x')))

def withPosition[A](list: List[A]): List[(Int, A)] = {
  def withPosition[A](list: List[A], value: Int): List[(Int, A)] =
    list match {
      case Nil => Nil
      case head :: tail => (value, head) :: withPosition(tail, value + 1)
    }

  withPosition(list, 0)
}
withPosition(List(' ', ' ', ' '))

def putOnRow2(row: List[Char], column: Int, player: Char): List[Char] =
  row.zipWithIndex.map( {
    case (color, position) =>
      if (position == column)
        player
      else
        color })

val initialRow2 = List(' ', ' ', ' ')
val firstPutRow2 = putOnRow2(initialRow, 2, 'x')
val secondPutRow2 = putOnRow2(firstPutRow, 0, 'o')
val thirdPutRow2 = putOnRow2(secondPutRow, 0, 'x')


//zipWithIndex