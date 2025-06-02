object Main {
  def main(args: Array[String]): Unit = {

    // Übung 1
    val zahlen = List(1, 2, 3, 4, 5)
    val verdoppelt = zahlen.map(_ * 2)
    println(verdoppelt) // Ausgabe: List(2, 4, 6, 8, 10)

    // Übung 2
    val namen = List("Alice", "Bob", "Charlie")
    val grossNamen = namen.map(_.toUpperCase)
    println(grossNamen) // Ausgabe: List("ALICE", "BOB", "CHARLIE")
    
    // Übung 3
    val zahlen3 = List(12, 45, 68, 100)
    val halbiert = zahlen3.map(_ / 2.0)
    println(halbiert) // Ausgabe: List(6.0, 22.5, 34.0, 50.0)

    // Übung 4
    case class Adresse(strasse: String, hausnummer: Int, postleitzahl: String, stadt: String)
    val adressen = List(
      Adresse("Hauptstrasse", 10, "12345", "Musterstadt"),
      Adresse("Nebenstrasse", 5, "23456", "Beispielburg")
    )
    val adressStrings = adressen.map(a => s"${a.strasse} ${a.hausnummer}, ${a.postleitzahl} ${a.stadt}")
    println(adressStrings) // Ausgabe: List("Hauptstrasse 10, 12345 Musterstadt", "Nebenstrasse 5, 23456 Beispielburg")

   // Übung 5
    val namen5 = List("Max Mustermann", "Erika Mustermann")
    val vornamenGross = namen5.map(_.split(" ")(0).toUpperCase)
    println(vornamenGross) // Ausgabe: List("MAX", "ERIKA")

  }
}