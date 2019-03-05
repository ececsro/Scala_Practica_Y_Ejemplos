package  Fractional

object Auxiliar{

  def mcm (uno: Int, dos: Int): Int = {
    ProdFPCyNCME(uno, dos, 2)
  }

  def ProdFPCyNCME (x: Int, y: Int, z: Int): Int = (x, y, z) match {
    case (1, 1, _) => 1
    case _ => if (x % z == 0) {
      if (y % z == 0) z * ProdFPCyNCME(x / z, y / z, z) else z * ProdFPCyNCME(x / z, y, z)
    } else if (y % z == 0) z * ProdFPCyNCME(x, y / z, z) else ProdFPCyNCME(x, y, SiguPrim(z))
  }

  def SiguPrim (x: Int): Int = if (Prim(x + 1)) x + 1 else SiguPrim(x + 1)

  def AlguDivi (x: Int, y: Int): Boolean = y match {
    case 1 => false
    case _ => x % y == 0 || AlguDivi(x, y - 1)
  }

  def Prim (x: Int): Boolean = x match {
    case 1 => true
    case _ => !AlguDivi(x, x - 1)
  }

  def gcd(number1: Int,number2: Int): Int ={
    if(number2 ==0) number1 else gcd(number2, number1%number2)
  }

}

