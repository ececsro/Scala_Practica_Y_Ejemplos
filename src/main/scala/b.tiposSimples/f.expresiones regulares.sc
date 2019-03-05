// operadores: https://www.tutorialspoint.com/scala/scala_regular_expressions.htm

"A|E|I|O|U".r()
"A|E|I|O|U".r
"A|E|I|O|U"r

val vowel = "A|E|I|O|U".r

// alternativas
import scala.util.matching.Regex
val vowel2 = new Regex("A|E|I|O|U")
val vowel3 : Regex = "A|E|I|O|U"r

// correspondencias
// localizar primera
vowel.findFirstIn("A")
vowel.findFirstIn("abcdef")
vowel.findFirstIn("ABCDEF")

vowel.findFirstIn("""SI TU AMAS ALGO, DÉJALO LIBRE.
                    |SI RETORNA ES TUYO
                    |SI NO NUNCA LO FUE""")

vowel.findFirstIn("""Si tú amas algo, déjalo libre.
  |Si retorna es tuyo
  |Si no nunca lo fue""")

// localizar todas

val results = vowel.findAllIn("""SI TU AMAS ALGO, DÉJALO LIBRE.
                    |SI RETORNA ES TUYO
                    |SI NO NUNCA LO FUE""")
results.toList

// replaceFirstIn

val pattern = """(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2})""".r("year", "month", "day", "hour", "min", "sec")
val result = pattern.findFirstMatchIn("20170224134523")
result match {
  case Some(_) => {
    val hour = result.get.group("hour")
    val min = result.get.group("min")
    val sec = result.get.group("sec")
    val day = result.get.group("day")
    val month = result.get.group("month")
    val year = result.get.group("year")
    s"$hour:$min:$sec del $day de $month del $year"
  }
  case None => {
    "--:--:-- del -- de -- del ---"
  }
}





//replaceFirstIn( )
//replaceAllIn( )
//
//mkString(",")

case class DateTimeStr(year: Int, month: Int, day: Int, hour: Int, min: Int, sec: Int)

def parseDateTime (dateTimeStr: String = "20170224134523"): Option[DateTimeStr] = {
  val pattern = """(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2})""".r("year", "month", "day", "hour", "min", "sec")
  pattern.findFirstMatchIn(dateTimeStr).fold[Option[DateTimeStr]](None)(result =>
    Some(
      DateTimeStr(
        result.group("year").toInt,
        result.group("month").toInt,
        result.group("day").toInt,
        result.group("hour").toInt,
        result.group("min").toInt,
        result.group("sec").toInt,
      )
    )
  )
}

parseDateTime("20170224134523")
parseDateTime()
parseDateTime("boo!")