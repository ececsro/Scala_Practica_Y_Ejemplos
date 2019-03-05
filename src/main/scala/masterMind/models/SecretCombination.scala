package masterMind.models

object SecretCombination {

  def generateRandom = List('R','V','N','N')
}
class SecretCombination() {

  val _colors = SecretCombination.generateRandom

  def deaths = {}
}
