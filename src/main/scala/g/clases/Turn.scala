package x

class Turn(value: Int = 0) {

  private val colors_ = List('x', 'o')

  private val value_ = value

  private def item(colors: List[Char], position: Int): Char =
    position match {
      case 0 => colors.head
      case 1 => colors.tail.head
    }

  private def other = (this.value_ + 1) % 2

  def take: Char = this.item(this.colors_, value_)

  def notTake: Char = this.item(this.colors_, this.other)

  def changed: Turn = new Turn(this.other)

  override def equals(that: Any): Boolean =
    that match {
      case that: Turn =>
        this.value_ == that.value_
      case _ => false
    }
}
