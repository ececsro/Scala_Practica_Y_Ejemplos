def fibonacci(position:Int):Int =
 position match {
   case 1 => 1
   case 2 => 1
   case position => fibonacci(position-1) + fibonacci(position-2)
 }

fibonacci(1)
fibonacci(2)
fibonacci(3)
fibonacci(4)
fibonacci(5)
fibonacci(6)
fibonacci(17)

def ackerman(values:(Int,Int)):Int =
  values match {
    case (0, n) => n+1
      case(m,0) => ackerman(m-1, 1)
    case (m,n)=> ackerman(m-1, ackerman(m, n-1))
  }

//ackerman(3,4)
//ackerman(3,2)
//ackerman(3,3)

def coins(value: Int): Int = {
  def min2(left:Int, right:Int):Int =
    if (left<right) left else right

  if (value < 5)
    value
  else if (value < 11)
    1 + coins(value - 5)
  else if (value == 11)
    1
  else
    1 + min2(coins(value - 1), min2(coins(value - 5), coins(value - 11)))
}
coins(4)
coins(5)
coins(6)
coins(10)
coins(11)
coins(12)
coins(99)
coins(100)
coins(101)

def typeCoins(value: Int): (Int, Int, Int) = {
  def sumCoins(one: (Int, Int, Int), two: (Int, Int, Int)): (Int, Int, Int) =
    (one._1 + two._1, one._2 + two._2, one._3 + two._3)

  def minCoins(a: (Int, Int, Int), b: (Int, Int, Int), c: (Int, Int, Int)): (Int, Int, Int) = {
    def minCoins(left: (Int, Int, Int), right: (Int, Int, Int)): (Int, Int, Int) = {
      def lengthCoins(coins: (Int, Int, Int)): Int =
        coins._1 + coins._2 + coins._3

      if (lengthCoins(left) > lengthCoins(right))
        right
      else
        left
    }

    minCoins(a, minCoins(b, c))
  }

  if (value < 5)
    (value, 0, 0)
  else if (value < 11)
    sumCoins((0, 1, 0), typeCoins(value - 5))
  else if (value == 11)
    (0, 0, 1)
  else
    sumCoins((0, 0, 1), minCoins(typeCoins(value - 1), typeCoins(value - 5), typeCoins(value - 11)))

}

typeCoins(4)
typeCoins(5)
typeCoins(6)
typeCoins(10)
typeCoins(11)
typeCoins(12)
typeCoins(99)
typeCoins(100)
typeCoins(101)

