def condensar(list: List[Int]): List[Int] =
  (list.head + list.tail.head) :: list.tail.tail

condensar(List(1, 2, 3, 4, 5)) == List(3, 3, 4, 5)

def condensar2(list: List[Int]): List[Int] =
  list match {
    case (first :: second :: tail) => first + second :: tail
  }

condensar2(List(1, 2, 3, 4, 5))

def length[T](list: List[T]): Int =
  if (list == Nil) 0 else 1 + length(list.tail)

length(List(1, 3, 4, 5))
length(List(List(1, 3, 4, 5), List(1, 3, 4, 5), List(1, 3, 4, 5)))

def length2[T](list: List[T]): Int =
  list match {
    case Nil => 0
    case head :: tail => 1 + length2(tail)
  }

length2(List(1, 3, 4, 5))
length2(List(List(1, 3, 4, 5), List(1, 3, 4, 5), List(1, 3, 4, 5)))

def member[A](value: A, list: List[A]): Boolean =
  list match {
    case Nil => false
    case head :: _ if head == value => true
    case _ :: tail => member(value, tail)
  }

member(1, List(1, 2, 3, 4))
member(4, List(1, 2, 3, 4))
member(5, List(1, 2, 3, 4))

def middlePoint(interval: (Double, Double)): Double =
  interval match {
    case (min, max) => (min + max) / 2
  }

def middlePoints(list: List[(Double, Double)]): List[Double] =
  list match {
    case Nil => Nil
    case head :: tail => middlePoint(head) :: middlePoints(tail)
  }

middlePoints(List((1.1, 2.2), (2.1, 3.2), (3.1, 4.2)))

def sumOdds(list: List[Int]): Int =
  if (list == Nil)
    0
  else if (list.head % 2 != 0)
    list.head + sumOdds(list.tail)
  else
    sumOdds(list.tail)

sumOdds(List(1, 3, 4, 5, 6))

def sumOdds2(list: List[Int]): Int =
  list match {
    case Nil => 0
    case head :: tail if (head % 2 != 0) => head + sumOdds2(tail)
    case _ :: tail => sumOdds2(tail)
  }

sumOdds2(List(1, 3, 4, 5, 6))

def sumOddPositions(list: List[Int]): Int =
  if (list == Nil)
    0
  else if (list.tail == Nil)
    list.head
  else
    list.head + sumOddPositions(list.tail.tail)

sumOddPositions(List(1, 2, 3, 4, 5, 6, 7))

def sumOddPositions2(list: List[Int]): Int =
  list match {
    case Nil => 0
    case head :: Nil => head
    case head :: tail => head + sumOddPositions2(tail.tail)
  }

sumOddPositions2(List(1, 2, 3, 4, 5, 6, 7))

def odds(list: List[Int]): List[Int] =
  if (list == Nil)
    Nil
  else if (list.head % 2 != 0)
    list.head :: odds(list.tail)
  else
    odds(list.tail)

odds(List(1, 2, 3, 4, 5, 6, 7))

def oddPositions(list: List[Int]): List[Int] =
  if (list == Nil)
    Nil
  else if (list.tail == Nil)
    list.head :: Nil
  else
    list.head :: odds(list.tail.tail)

oddPositions(List(1, 2, 3, 4, 5, 6, 7))

def and(list: List[Boolean]): Boolean =
  list match {
    case head :: Nil => head
    case head :: tail => head && and(tail)
  }

and(List(true, true, true, true))
and(List(true, true, false, true))

def conc[A](left: List[A], right: List[A]): List[A] =
  left match {
    case Nil => right
    case head :: tail => head :: conc(tail, right)
  }

conc(List(1, 2, 3), List(3, 2, 1))

def inverse[T](list: List[T]): List[T] =
  list match {
    case Nil => Nil
    case head :: Nil => head :: Nil
    case head :: tail => inverse(tail) ::: List(head)
  }

inverse(List(1, 2, 3, 4, 5, 6, 7))

def merge[T](operands: (List[T], List[T])): List[T] =
  operands match {
    case (left, Nil) => left
    case (Nil, right) => right
    case (headLeft :: tailLeft, headRight :: tailRight) =>
      headLeft :: headRight :: merge(tailLeft, tailRight)
  }

merge(List(1, 2, 3, 4, 5, 6, 7), List(1, 2, 3, 4, 5, 6, 7))

// Nil => Nil
//---
// List(1,2,3,4) => List(
//                    List(1,2,3,4)
//                    List(1,2,4,3)
//                    List(1,3,2,4)
//                    List(1,3,4,2)
//                    List(1,4,2,3)
//                    List(1,4,3,2)

//                    List(2,1,3,4)
//                    List(2,1,4,3)
//                    List(3,1,2,4)
//                    List(3,1,4,2)
//                    List(4,1,2,3)
//                    List(4,1,3,2)

//                    List(2,3,1,4)
//                    List(2,4,1,3)
//                    List(3,2,1,4)
//                    List(3,4,1,2)
//                    List(4,2,1,3)
//                    List(4,3,1,2)

//                    List(2,3,4,1)
//                    List(2,4,3,1)
//                    List(3,2,4,1)
//                    List(3,4,2,1)
//                    List(4,2,3,1)
//                    List(4,3,2,1)

// List(2,3,4) => List(
//                    List(2,3,4)
//                    List(2,4,3)
//                    List(3,2,4)
//                    List(3,4,2)
//                    List(4,2,3)
//                    List(4,3,2)

// Nil, n => List(List(n))
//---
// xyz,o => oxyz

//           xoyz
//           xyoz
//           xyzo

// yz, o => oyz
//          yoz
//          yzo


// head::tail,item => oxyz
//           xoyz
//           xyoz
//           xyzo

// tail, item => inter(tail,item)
def prefijo[A](list: List[List[A]], item: A): List[List[A]] =
  list match {
    case Nil => Nil
    case head :: tail => (item :: head) :: prefijo(tail, item)
  }

prefijo(List(List(1, 2, 3, 4), List(3, 4), List(1, 2)), 5)

def inter[A](list: List[A], item: A): List[List[A]] =
  list match {
    case Nil => List(List(item))
    case head :: tail => (item :: list) :: prefijo(inter(tail, item), head)
  }

inter(List(1, 2, 3), 4)

def inter2[A](list: List[List[A]], item: A): List[List[A]] =
  list match {
    case Nil => Nil
    case head :: tail => inter(head, item) ::: inter2(tail, item)
  }

inter2(List(List(1, 2, 3), List(1, 2)), 7)

def perm[A](list: List[A]): List[List[A]] =
  list match {
    case Nil => Nil
    case head :: Nil => List(List(head))
    case head :: tail => inter2(perm(tail), head)
  }

perm(List(1))
perm(List(1, 2))
perm(List(1, 2, 3))
perm(List(1, 2, 3, 4))

def nextDay3(day: Char): Char = {
  val days = List('L', 'M', 'X', 'J', 'V', 'S', 'D')

  def nextToFound(day: Char, days: List[Char]): Char =
    days match {
      case Nil => ' '
      case head :: tail =>
        if (day == head)
          if (tail == Nil)
            'L'
          else
            tail.head
        else
          nextToFound(day, tail)
    }

  nextToFound(day, days)
}

nextDay3('L')
nextDay3('D')