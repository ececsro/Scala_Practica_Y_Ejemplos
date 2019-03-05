package x

class Board(tokens2: List[List[Char]] = List(
  List(' ', ' ', ' '),
  List(' ', ' ', ' '),
  List(' ', ' ', ' '))) {

  private val tokens = tokens2

  private def getColor(row: List[Char], column: Int): Char =
    row.zipWithIndex match {
      case (color, position) :: tail if (position == column) => color
      case (_, position) :: tail => {
        val newRow = tail.map {
          case (color, _) => color
        }
        this.getColor(newRow, column - 1)
      }
    }

  private def quitar(list: List[(List[Char], Int)]): List[List[Char]] =
    list match {
      case Nil => Nil
      case (item, _) :: tail => item :: quitar(tail)
    }

  def getColor(coordinate: Coordinate): Char = {
    tokens.zipWithIndex match {
      case (row, position) :: tail if (position == coordinate.getRow) =>
        this.getColor(row, coordinate.getColumn)
      case (_, _) :: tail =>
        new Board(quitar(tail)).getColor(new Coordinate(coordinate.getRow-1, coordinate.getColumn))
    }
  }

  private def put(row: List[Char], column: Int, player: Char): List[Char] = {
    row.zipWithIndex.map {
      case (color, position) =>
        if (position == column)
          player
        else
          color
    }
  }

  def put(coordinate: Coordinate, player: Char): Board = {
    new Board(
      tokens.zipWithIndex.map {
        case (row, position) =>
          if (position == coordinate.getRow)
            this.put(row, coordinate.getColumn, player)
          else
            row
      })
  }

  def isComplete:Boolean = {
    def howMany(row:List[Char], color:Char):Int = {
      row match {
        case Nil => 0
        case head::tail if (head==color) => 1 + howMany(tail,color)
        case _::tail => howMany(tail,color)
      }
    }
    val times = tokens.map(row => howMany(row, ' '))
    val result = times.fold(0)((a,b)=> a+b)
    result == 3
  }

  def move(from: Coordinate, to: Coordinate): Board =
    this.put(from, ' ').put(to, this.getColor(from))

  override def equals(that: Any): Boolean =
    that match {
      case that: Board =>
        tokens == that.tokens
      case _ => false
    }

  def getCoordinates(player:Char, row:List[Char], fila:Int, columna:Int): List[Coordinate] = {
    row match {
      case Nil => Nil
      case head::tail => if (head== player)
        new Coordinate(fila, columna)::this.getCoordinates(player, tail, fila, columna+1)
      else
        this.getCoordinates(player, tail, fila, columna+1)
    }
  }

  def getCoordinates(player:Char, rows:List[List[Char]], fila:Int):List[Coordinate] = {
    rows match {
      case Nil => Nil
      case head::tail =>
        this.getCoordinates(player, head, fila, 0) ++ this.getCoordinates(player, tail, fila+1)
    }
  }

  def getCoordinates(player:Char):List[Coordinate] = this.getCoordinates(player, tokens, 0)

  def getDirections(coordinates:List[Coordinate]):List[String] = {
    coordinates match {
      case Nil => Nil
      case head::Nil => Nil
      case first::second::tail => first.getDirection(second)::this.getDirections(second::tail)
    }
  }

  def equals(strings:List[String]):Boolean =
    strings match {
      case Nil => true
      case _::Nil => true
      case first::second::tail if (first==second) => equals(second::tail)
      case _::_ => false
    }

  def isTicTacToe(player:Char):Boolean = {
    val coordinates = this.getCoordinates(player)
    if (coordinates.length < 3)
      false
    else {
      this.equals(this.getDirections(coordinates))
    }
  }
  def isTicTacToe:Boolean =
    this.isTicTacToe('x') || this.isTicTacToe('o')

  override def hashCode(): Int = {
    val state = Seq(tokens)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

}
