object Filter {
  def main(args: Array[String]): Unit = {

    // Übung 1
    val zahlen = List(1, 2, 3, 4, 5)
    val geradeZahlen = zahlen.filter(x => x % 2 == 0)
    println(geradeZahlen) // Erwartete Ausgabe: List(2, 4)

    // Übung 2
    val namen = List("Alice", "Bob", "Charlie", "Diana")
    val langeNamen = namen.filter(name => name.length > 4)
    println(langeNamen) // Erwartete Ausgabe: List("Alice", "Charlie", "Diana")

    // Übung 3
    val zahlen2 = List(12, 45, 68, 100)
    val grosseZahlen = zahlen2.filter(x => x > 50)
    println(grosseZahlen) // Erwartete Ausgabe: List(68, 100)

    // Übung 4
    val woerter = List("Scala", "ist", "fantastisch")
    val mitS = woerter.filter(wort => wort.startsWith("S"))
    println(mitS) // Erwartete Ausgabe: List("Scala")

    // Übung 5
    case class Buch(titel: String, autor: String, jahr: Int)
    val buecher = List(
      Buch("1984", "George Orwell", 1949),
      Buch("Brave New World", "Aldous Huxley", 1932),
      Buch("Fahrenheit 451", "Ray Bradbury", 1953)
    )
    val alteBuecherTitel = buecher.filter(buch => buch.jahr < 1950).map(_.titel)
    println(alteBuecherTitel) // Erwartete Ausgabe: List("1984", "Brave New World")

  }
}