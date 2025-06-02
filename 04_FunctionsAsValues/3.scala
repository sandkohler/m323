object MapAndFilter {
  def main(args: Array[String]): Unit = {

    // Übung 1
    case class Mitarbeiter(name: String, abteilung: String, gehalt: Int)

    val mitarbeiter = List(
      Mitarbeiter("Max Mustermann", "IT", 50000),
      Mitarbeiter("Erika Musterfrau", "Marketing", 45000),
      Mitarbeiter("Klaus Klein", "IT", 55000),
      Mitarbeiter("Julia Gross", "HR", 40000)
    )

    val itMitarbeiterVornamen = mitarbeiter
      .filter(m => m.abteilung == "IT" && m.gehalt >= 50000)
      .map(m => m.name.split(" ").head.toUpperCase)

    println(itMitarbeiterVornamen) // Erwartete Ausgabe: List("MAX", "KLAUS")

    // Übung 2
    val kurse = List(
      "Programmierung in Scala",
      "Datenbanken",
      "Webentwicklung mit JavaScript",
      "Algorithmen und Datenstrukturen"
    )

    // 1. Filtern: nur Kursnamen mit "Daten"
    val datenKurse = kurse.filter(_.contains("Daten"))

    // 2. Leerzeichen entfernen
    val datenKurseOhneLeerzeichen = datenKurse.map(_.replaceAll(" ", ""))

    // 3. Alphabetisch sortieren
    val alphabetisch = datenKurseOhneLeerzeichen.sorted

    // 4. Umgekehrt alphabetisch sortieren
    val umgekehrt = datenKurseOhneLeerzeichen.sorted(using Ordering[String].reverse)

    println(datenKurseOhneLeerzeichen)
    println(alphabetisch)
    println(umgekehrt)

  }
}