"Cadena de caracteres"

"""Este es
  una cadena de caracteres
  multilinea"""

"""Este es
  |una cadena de caracteres
  |multilinea""".stripMargin

"""Este es
  una cadena de caracteres
  multilinea""".stripMargin

"""Este es
  #una cadena de caracteres
  #multilinea""".stripMargin('#')

val name = "Luis"
"Hola, " + name
s"Hola, $name"

def doble(value:Int):Int =
  2*value

val value = 5
//s"El doble de $value es $doble(value)"
s"El doble de $value es ${doble(value)}"

val valor = 555.5555
f"Precio: $valor%2.2f."

"Cadena de caracteres con\nsalto de línea"

raw"Cadena de caracteres con\nsalto de línea"

raw"a\nb"

"a\nb"

"""Multili
      ñlaks\njd
      ñlaskjd"""

raw"""Multili
      ñlaksjd
      ñlaskjd"""

"""Este es
  una cadena de caracteres
  multilinea""".replaceAll("a", "A")























