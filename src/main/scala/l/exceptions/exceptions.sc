import scala.util.Random

def f: Int = {
  val r = Random
  val value = r.nextInt(100)
  if (value < 50)
    throw new Exception()
  else
    value
}

try {
  println(f)
} catch {
  case e: Exception => println("Capturada")
}

def f2: Int = {
  try {
    f
  } catch {
    case e: Exception => throw e
  }
}

def f3: Int = f

try {
  f3
} catch {
  case e: Exception => print("alsdn")
}


try {
  println(f2)
} catch {
  case e: Exception => println("Capturada 2")
}


def toInt(s: String): Option[Int] = {
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case _: Exception => None
  }
}

toInt("6bb66") match {
  case Some(i) => println(i)
  case None => println("That didn't work.")
}

val y = for {
  a <- toInt("123")
  b <- toInt("1234")
  c <- toInt("12345")
} yield a + b + c

import scala.util.{Failure, Success, Try}

def toInt2(s: String): Try[Int] = Try {
  Integer.parseInt(s.trim)
}

toInt2("66a6") match {
  case Success(i) => println(i)
  case Failure(s) => println(s"Failed. Reason: $s")
}

val y2 = for {
  a <- toInt2("123")
  b <- toInt2("12h34")
  c <- toInt2("12345")
} yield a + b + c






