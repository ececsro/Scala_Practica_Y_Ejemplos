def rightDigit(value: Int, position: Int): Int =
  position match {
    case 1 => value % 10
    case position => rightDigit(value / 10, position - 1)
  }

rightDigit(987654321, 1)
rightDigit(987654321, 5)
rightDigit(987654321, 9)

def rightDigit2(value: Int, position: Int): Int = {
  def rightDigit2Acum(value: Int, position: Int, acum: Int) : Int =
    if (position == 1)
      value % 10
    else
      rightDigit2Acum(value/10, position-1, acum*10 + value%10)

  rightDigit2Acum(value, position, 0)
}

rightDigit2(987654321, 1)
rightDigit2(987654321, 5)
rightDigit2(987654321, 9)