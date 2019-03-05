def mcd(left: Int, right: Int): Int =
  if (left < right)
    mcd(right, left)
  else
    right match {
      case 0 => left
      case _ => mcd(right, left % right)
    }

mcd(9, 15)
mcd(15, 9)
mcd(222, 44)
mcd(222, 333)

def mcm(left: Int, right: Int): Int =
  if (left == 0 || right == 0)
    0
  else
    left * right / mcd(left, right)

mcm(0, 20)
mcm(26, 0)
mcm(26, 20)
mcm(20, 26)
mcm(100, 42)

def factorial(value: Int): Int =
  value match {
    case 0 => 1
    case _ => value * factorial(value - 1)
  }

factorial(1)
factorial(2)
factorial(3)
factorial(4)
factorial(5)
factorial(6)
factorial(7)

def power(base: Double, exponent: Int): Double =
  exponent match {
    case 0 => 1
    case _ =>
      if (exponent > 0)
        base * power(base, exponent - 1)
      else
        1 / power(base, -exponent)
  }

power(5, 2)
power(2, 10)
power(2, -2)

def power2(base:Double, exponent:Int):Double = {

  def power3(base:Double, exponent:Int, acu:Double):Double =
    exponent match {
      case 0 => acu
      case _ => power3(base, exponent-1, base*acu)
    }
  power3(base, exponent, 1)
}

power2(3,4)

//power3(3,4,1)
//power3(3,3,3)
//power3(3,2,9)
//power3(3,1,27)
//power3(3,0,81)
//81





def addition(left: Int, right: Int): Int =
  left match {
    case 0 => right
    case _ => if (left > 0)
      addition(left - 1, right + 1)
    else
      addition(left + 1, right - 1)
  }

addition(19, 24)
addition(-19, 24)
addition(19, -24)
addition(-19, -24)

def subtraction(left: Int, right: Int): Int =
  right match {
    case 0 => left
    case _ => if (right > 0)
      subtraction(left - 1, right - 1)
    else
      subtraction(left + 1, right + 1)
  }

subtraction(19, 24)
subtraction(-19, 24)
subtraction(19, -24)
subtraction(-19, -24)


def multiplication(left: Int, right: Int): Int =
  if (right == 0)
    0
  else if (right == 1)
    left
  else if (right > 1)
    left + multiplication(left, right - 1)
  else
    -multiplication(left, -right)

multiplication(9, 4)
multiplication(-9, 4)
multiplication(9, -4)
multiplication(-9, -4)

def division(left: Int, right: Int): Int =
  if (left < 0 && right < 0)
    division(-left, -right)
  else if (left < 0)
    -division(-left, right)
  else if (right < 0)
    -division(left, -right)
  else if (left < right)
    0
  else if (left == right)
    1
  else
    1 + division(left - right, right)

division(9, 21)
division(9, 9)
division(9, 7)
division(9, 2)
division(-9, 2)
division(9, -2)
division(-9, -2)


def remainder(left: Int, right: Int): Int =
  if (left < 0 && right < 0)
    -remainder(-left, -right)
  else if (left < 0)
    -remainder(-left, right)
  else if (right < 0)
    remainder(left, -right)
  else if (left < right)
    left
  else if (left == right)
    0
  else
    remainder(left - right, right)


remainder(9, 21)
remainder(9, 9)
remainder(9, 7)
remainder(9, 5)
remainder(-9, 5)
remainder(9, -5)
remainder(-9, -5)

def isPrime(value: Int): Boolean = {
  def existSomeDivisorUntilOne(value: Int, divisor: Int): Boolean =
    divisor match {
      case 1 => false
      case _ => value % divisor == 0 || existSomeDivisorUntilOne(value, divisor - 1)
    }
  //optimizar: hasta raiz de 2, solo impares
  value match {
    case 1 => true
    case 2 => true
    case _ => !existSomeDivisorUntilOne(value, value - 1)
  }
}

isPrime(1)
isPrime(2)
isPrime(3)
isPrime(4)
isPrime(5)
isPrime(6)
isPrime(7)

def nextPrime(value: Int): Int =
  if (isPrime(value + 1))
    value + 1
  else nextPrime(value + 1)

nextPrime(1)
nextPrime(2)
nextPrime(3)
nextPrime(4)
nextPrime(5)
nextPrime(6)
nextPrime(100)

def sumProperDivisors(value: Int): Int = {
  def sumProperDivisors(value: Int, from: Int, to: Int): Int =
    if (value % from == 0)
      if (from == to)
        from
      else
        from + sumProperDivisors(value, from - 1, to)
    else if (from == to)
      0
    else
      sumProperDivisors(value, from - 1, to)

  sumProperDivisors(value, value - 1, 1)
}

sumProperDivisors(27)
sumProperDivisors(28)
sumProperDivisors(29)
sumProperDivisors(495)
sumProperDivisors(496)
sumProperDivisors(497)
sumProperDivisors(8128)

def isPerfect(value: Int): Boolean =
  sumProperDivisors(value) == value

isPerfect(27)
isPerfect(28)
isPerfect(29)
isPerfect(495)
isPerfect(496)
isPerfect(497)
isPerfect(8128)

def areFriends(left: Int, right: Int): Boolean =
  sumProperDivisors(left) == right && left == sumProperDivisors(right)

areFriends(219, 284)
areFriends(220, 284)
areFriends(220, 285)
areFriends(1184, 1210)
areFriends(6232, 6368)
areFriends(17296, 18416)
areFriends(9363584, 9437056)

def isEven(value:Int):Boolean =
  value match {
    case 0 => true
    case 1 => false
    case _ => isEven(value-2)
  }

isEven(0)
isEven(1)
isEven(2)
isEven(3)
isEven(4)
isEven(5)
isEven(6)


def isOdd(value:Int):Boolean =
  value match {
    case 0 => false
    case 1 => true
    case _ => isOdd(value-2)
  }

isOdd(0)
isOdd(1)
isOdd(2)
isOdd(3)
isOdd(4)
isOdd(5)
isOdd(6)









