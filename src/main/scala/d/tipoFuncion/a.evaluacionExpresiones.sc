// valor
5
'a'
true
5.5
(false, 5.55)
// ?
(4,('o','0'),true)
-4
// aplicacion de funcion/operador sobre un valor
// enteros
- 4
+ 4

//-.(4)
//+.(4)

4+5
4-5
4*5
4/5
4%5

4.+(5)
4.-(5)
4.*(5)
4./(5)
4.%(5)

4==5
4!=5
4>5
4>=5
4<5
4<=5

4.==(5)
4.!=(5)
4.<=(5)
4.<(5)
4.>=(5)
4.>(5)

4<<5
4>>5
4&5

4.<<(5)
4.>>(5)
4.&(5)


4.isWhole()
444.byteValue()

4.isWhole
444.byteValue

4 isWhole
//444 byteValue

//4.self()
//444.isValidByte()
//4.abs()
//-4.signum()
//4.unary_+()
//4.unary_-()

4.self
444.isValidByte
4.abs
-4.signum
4.unary_+
4.unary_-

4 self
//444 isValidByte
//4 abs
//-4 signum
//4 unary_+
//4 unary_-

4.compare(5)
4.max(5)
4.min(5)
4.equals(true)

4 compare 5
4 max 4
4 min 5
4 equals true

//?
4+5+6
4 max 5 max 6

// aplicacion de funcion/operador sobre un valor
// reales, similar

// aplicacion de funcion/operador sobre un valor
// lógicos

true && true
false || false
!true

true.&&(true)
false.||(false)
//!.(true)

true==true
true!=true
true>true
true>=true
true<true
true<=true

true.==(true)
true.!=(true)
true.>(true)
true.>=(true)
true.<(true)
true.<=(true)

// aplicacion de funcion/operador sobre un valor
// caracteres

'a'.toUpper

'a' toUpper

// secuencia de dos o más expresiones separadas por comas encerradas entre paréntesis
(1,2+3)
//?
(1,(2,3))

(1.signum,(2 % 10,true),4+5)
//?
(4+5)
('a',4.compare(5+5),true)

// aplicacion de función/operador sobre un valor
4+5+6+6+6+7
100*100/2
4+5 * 6+7
//?
100/100/2
4-2-1

100-100/2

// conversión de tipos

100*2.2
4 + 'a'
4L - 1
5.5 * 2
4.compare(2.toByte)

// precedencia y asociatividad
//(all letters)
// |
// ^
// &
// = !
// < >
// :
// + -
// * / %
//(all other special characters)
4+5*2
100/100/2
4-2-1
4.-(2).-(1)
4.-(2.-(1))

100-100/2

7 + -4.abs.max(2)
7 + -4.abs.max(9)

7 + -4.abs max 2
7 + -4.abs max 9

7 + - 4 . abs max 2
7 + - 4 . abs max 9

//7 + -4 abs max 2
//7 + -4 abs max 9

// Paréntesis
(7 + -4 abs) max 2
(7 + -4 abs) max 9

// Evaluación perezosa
true || 5/0>1
//false || 5/0>1

false && 5/0>1
//true && 5/0>1

true || 5/0>1 && false

false && 5/0>1 || true || 5/0>1

//true || lkajs asldkfj asdf ñaksdjfñlakjdf

// Funciones parametrizadas

(3,true)._2
(3,5.5)._2

(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22)._22
//(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23)._23


def  first[A,B](tuple2:(A,B)):A = tuple2._1
def  second[A,B](tuple2:(A,B)):B = tuple2._2

first(5, true)
first((5, true), 66.66)

if (5>4) "greater" else "not greater"
if ((3,true)._2) (5.5-1, false) else (0.0, true)

def opIf[A](condition:Boolean, thenBranch:A, elseBranch:A):A =
  if (condition)
    thenBranch
  else elseBranch

opIf(5>4, "greater", "not greater")
opIf((3,true)._2, (5.5-1, false), (0.0, true))


// correspondencia de patrones

666 match {
    case 0 => true;
    case 100 => false
    case _ => true
}

5*2 match {
    case p if (p%2==0) => true
    case _ => false
}

0 match {
    case p if (p<0) => p-1
    case p if (p>0) => p+1
    case 0 => 0
}

(3,false) match {
    case tuple if (tuple._1>2) => false
    case tuple => tuple._2
}


('a', 5.2) match {
    case ('a', distance) => distance * 2
    case ('b', distance)  => distance * 3
    case (_, distance) => distance
}

('a', 5) match {
    case ('a', distance) => distance * 2
    case ('b', distance)  => distance * 3
//    case tuple => tuple._2
    case (_, x) => x
}


9 match {
    case 122 => (1,2,2)
    case 232 => (2,3,2)
    case _ => (0,0,0)
}

//8 match {
//  case 0 => true
//}


(-7 match {
    case n if (n>0) => n*2
    case _ => 100
}) + 1

(232 match {
    case 122 => (1,2,2)
    case 232 => (2,3,2)
    case _ => (0,0,0)
})._2










