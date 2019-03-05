// definicion de funciones: números

def double (value: Int) : Int =
  2 * value

double(5)
double(-666)

def isEven(value: Int): Boolean =
  (value % 2) == 0

isEven(0)
isEven(1)
isEven(5)
isEven(6)

def isOdd(value: Int): Boolean =
  !isEven(value)

isOdd(0)
isOdd(1)
isOdd(5)
isOdd(6)

def adjust(value: Double, min: Double, max: Double): Double =
  if (value > max)
    max
  else if (value < min)
    min
  else
    value

adjust(2, -10, 10)
adjust(-100.0, -10, 10)
adjust(-0.0123, -.001, .001)
adjust(-0.00123, -.001, .001)

def adjust2(value:(Int, Int, Int)) : Int =
  if (value._1 <= value._3) value._3 else if (value._1 >= value._2) value._2 else value._1

adjust2((2, -10, 10))
adjust2(-100.0, -10, 10)
adjust2(-0.0123, -.001, .001)
adjust2(-0.00123, -.001, .001)


def adjust10absolute(value: Double): Double =
  adjust(value, -10, 10)

adjust10absolute(-100.0)
adjust10absolute(-1.0)
adjust10absolute(1.0)
adjust10absolute(100.0)

// definicion de funciones: letras

def isLowerCaseLetter(char: Char): Boolean =
  'a' <= char && char <= 'z' || char == 'ñ'

isLowerCaseLetter('a')
isLowerCaseLetter('ñ')
isLowerCaseLetter('z')
isLowerCaseLetter('A')
isLowerCaseLetter('*')

def isUpperCaseLetter(char: Char): Boolean =
  'A' <= char && char <= 'Z' || char == 'Ñ'

isUpperCaseLetter('A')
isUpperCaseLetter('Ñ')
isUpperCaseLetter('Z')
isUpperCaseLetter('a')
isUpperCaseLetter('*')

def toLowerCaseLetter(upperCaseLetter: Char): Char =
  if ('A' <= upperCaseLetter && upperCaseLetter <= 'Z')
    (upperCaseLetter + ('a' - 'A')).toChar
  else
    'ñ'

toLowerCaseLetter('A')
toLowerCaseLetter('Ñ')
toLowerCaseLetter('Z')

def toUpperCaseLetter(lowerCaseLetter: Char): Char =
  if ('a' <= lowerCaseLetter && lowerCaseLetter <= 'z')
    (lowerCaseLetter - ('a' - 'A')).toChar
  else
    'Ñ'

toUpperCaseLetter('a')
toUpperCaseLetter('ñ')
toUpperCaseLetter('z')

def isVowel(character: Char): Boolean =
  character == 'a' || character == 'b' || character == 'i' || character == 'o' || character == 'u' ||
    character == 'A' || character == 'B' || character == 'I' || character == 'O' || character == 'U'

isVowel('a')
isVowel('*')
isVowel('4')

def isVowel7(character: Char): Boolean =
  character == 'a' || character == 'b' || character == 'i' || character == 'o' || character == 'u' ||
    character == 'A' || character == 'B' || character == 'I' || character == 'O' || character == 'U'

isVowel7('a')
isVowel7('*')
isVowel7('4')

// definicion de funciones: intervalos

def middlePoint(interval: (Double, Double)): Double =
  (interval._1 + interval._2) / 2

middlePoint(3, 6)
middlePoint(-3, 6)

def middlePoint2(min: Double, max: Double): Double =
  (min + max) / 2

middlePoint2(3, 6)
middlePoint2(-3, 6)

def length(min: Double, max: Double): Double =
  max - min

length(3, 6)
length(-3, 6)

def length2(interval: (Double, Double)): Double =
  interval._2 - interval._1

length2(3, 6)
length2(-3, 6)

def centeredMiddleInterval(interval: (Double, Double)): (Double, Double) =
  (middlePoint(interval) - length2(interval) / 2 / 2, middlePoint(interval) + length2(interval) / 2 / 2)

centeredMiddleInterval(3, 6)
centeredMiddleInterval(-3, 6)

def centeredMiddleInterval2(min: Double, max: Double): (Double, Double) =
  (middlePoint(min, max) - length(min, max) / 2 / 2, middlePoint(min, max) + length(min, max) / 2 / 2)

centeredMiddleInterval2(3, 6)
centeredMiddleInterval2(-3, 6)

// definicion de funciones: fechas

def nextDay(day: Char): Char =
  if (day == 'L')
    'M'
  else if (day == 'M')
    'X'
  else if (day == 'X')
    'J'
  else if (day == 'J')
    'V'
  else if (day == 'V')
    'S'
  else if (day == 'S')
    'D'
  else
    'L'

nextDay('L')
nextDay('D')

def isChristmas(date: (Int, Int, Int)): Boolean =
  date._1 == 25 && date._2 == 12

isChristmas(12, 6, 1968)
isChristmas(25, 12, 1968)

// definición de funciones: jugador

def color2(player: (Char, ((Int, Int), (Int, Int), (Int, Int)))): Char =
  player._1

color2('x', ((0, 0), (1, 1), (2, 2)))

def secondToken(player: (Char, ((Int, Int), (Int, Int), (Int, Int)))): (Int,Int) =
  player._2._2

secondToken('x', ((0, 0), (1, 1), (2, 2)))

// correspondencia de patrones: números

def isEven2(value: Int): Boolean =
  value match {
    case _ if (value % 2) == 0 => true
    case _ => false
  }

isEven2(0)
isEven2(1)
isEven2(5)
isEven2(6)

def adjust2(value: Double, min: Double, max: Double): Double =
  value match {
    case _ if value > max => max
    case _ if value < min => min
    case _ => value
  }

adjust2(-100.0, -10, 10)
adjust2(-0.0123, -.001, .001)
adjust2(-0.00123, -.001, .001)

// correspondencia de patrones: letras

def isLowerCaseLetter2(char: Char): Boolean =
  char match {
    case _ if 'a' <= char && char <= 'z' => true
    case 'ñ' => true
    case _ => false
  }

isLowerCaseLetter2('a')
isLowerCaseLetter2('ñ')
isLowerCaseLetter2('z')
isLowerCaseLetter2('A')
isLowerCaseLetter2('*')

def toLowerCaseLetter2(upperCaseLetter: Char): Char =
  upperCaseLetter match {
    case _ if 'A' <= upperCaseLetter && upperCaseLetter <= 'Z' => (upperCaseLetter + ('a' - 'A')).toChar
    case 'Ñ' => 'ñ'
  }

toLowerCaseLetter2('A')
toLowerCaseLetter2('Ñ')
toLowerCaseLetter2('Z')

def isVowel2(char: Char): Boolean =
  char match {
    case 'a' => true
    case 'e' => true
    case 'i' => true
    case 'o' => true
    case 'u' => true
    case _ => false
  }

isVowel2('a')
isVowel2('*')
isVowel2('4')

// correspondencia de patrones: intervalos

def middlePoint2(interval: (Double, Double)): Double =
  interval match {
    case (min, max) => (min + max) / 2
  }

middlePoint2(3, 6)
middlePoint2(-3, 6)

def length3(interval: (Double, Double)): Double =
  interval match {
    case (min, max) => max - min
  }

length3(3, 6)
length3(-3, 6)

// correspondencia de patrones: jugador

def color(player: (Char, ((Int, Int), (Int, Int), (Int, Int)))): Char =
  player match {
    case (color, _) => color
  }

// correspondencia de patrones: fechas

def nextDay2(day: Char): Char =
  day match {
    case 'L' => 'M'
    case 'M' => 'X'
    case 'X' => 'J'
    case 'J' => 'V'
    case 'V' => 'S'
    case 'S' => 'D'
    case 'D' => 'L'
  }

nextDay2('L')
nextDay2('D')

def isHolyday(day: Char): Boolean =
  day match {
    case 'S' => true
    case 'D' => true
    case _ => false
  }


isHolyday('L')
isHolyday('V')
isHolyday('S')
isHolyday('D')

def isChristmas2(date: (Int, Int, Int)): Boolean =
  date match {
    case (25, 12, _) => true
    case _ => false
  }

isChristmas2(12, 6, 1968)
isChristmas2(25, 12, 1968)

// definiciones locales: letras

def nextLetter(char: Char): Char = {

  def nextLowerCaseLetter(char: Char): Char =
    if ('a' <= char && char < 'z')
      (char + 1).toChar
    else if (char == 'z')
      'a'
    else
      'o'

  if (isUpperCaseLetter(char))
    toUpperCaseLetter(nextLowerCaseLetter(toLowerCaseLetter(char)))
  else
    nextLowerCaseLetter(char)
}

nextLetter('a')
nextLetter('ñ')
nextLetter('z')

// definiciones locales: intervalos

def centeredMiddleInterval3(interval: (Double, Double)): (Double, Double) = {
  val newLong: Double = length2(interval) / 2
  val newMiddlePoint: Double = middlePoint(interval)
  (newMiddlePoint - newLong / 2, newMiddlePoint + newLong / 2)
}

centeredMiddleInterval3(3, 6)
centeredMiddleInterval3(-3, 6)

// funciones parametrizadas

def swap[A, B](tuple:(A,B)) : (B,A) =
  (tuple._2, tuple._1)

swap(3,4)
swap(true, (3,4))
swap((3,4),((6,7),(8,9)))
swap(swap((3,4),((6,7),(8,9))))

















