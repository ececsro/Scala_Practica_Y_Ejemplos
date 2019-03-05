def division(left:Int, right:Int): Option[Int] =
  right match {
    case 0 => None
    case _ => Some(left/right)
  }

def tittle(value:Option[Int]):String =
  value match {
    case None => "Resultado indefinido!!!"
    case Some(_) => "Resultado: " + value.get
  }

tittle(division(5,0))
tittle(division(5,1))
