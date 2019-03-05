def isEven(value: Int): Boolean =
  value match {
    case 0 => true
    case 1 => false
    case _ => if (value > 0)
      isOdd(value - 1)
    else
      isOdd(value + 1)
  }

def isOdd(value: Int): Boolean =
  value match {
    case 0 => false
    case 1 => true
    case _ => if (value > 0)
      isEven(value - 1)
    else
      isEven(value + 1)
  }


isEven(0)
isOdd(0)
isEven(1)
isOdd(1)
isEven(5)
isOdd(5)
isEven(6)
isOdd(6)
isEven(-6)
isOdd(-6)