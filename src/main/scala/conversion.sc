class BetterString(val s: String) {
  def increment = s.map(c => (c + 1).toChar)
}

implicit def stringToString(s: String) = new BetterString(s)

"ana".increment