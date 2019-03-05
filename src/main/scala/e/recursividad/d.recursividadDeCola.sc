def rightDigit(value: Int, position: Int) : Int =
  position match {
    case 1 => value % 10
    case position => rightDigit(value / 10, position - 1)
  }

rightDigit(987654321, 1)
rightDigit(987654321, 5)
rightDigit(987654321, 9)

def lengthDigits(value: Int): Int =
  if (value < 10)
    1
  else
    1 + lengthDigits(value / 10)

lengthDigits(0)
lengthDigits(1)
lengthDigits(34)
lengthDigits(45763453)

def leftDigit(value: Int, position: Int): Int =
  rightDigit(value, lengthDigits(value) - (position - 1))

leftDigit(987654321, 9)
leftDigit(987654321, 5)
leftDigit(987654321, 1)

def power(base: Int, exponent: Int): Int =
  exponent match {
    case 0 => 1
    case _ =>
      if (exponent > 0)
        base * power(base, exponent - 1)
      else
        1 / power(base, -exponent)
  }

def inverse(value: Int): Int =
  if (value < 10)
    value
  else
    inverse(value / 10) + (value % 10 * power(10, lengthDigits(value / 10)))

inverse(0)
inverse(7)
inverse(75)
inverse(70)
inverse(704)
inverse(123456789)
inverse(1234567890)


def isPalindromic(value: Int): Boolean =
  value == inverse(value)

isPalindromic(123454321)
isPalindromic(12344321)
isPalindromic(13454321)
isPalindromic(12345432)







