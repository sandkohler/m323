/*Übung 1
Gegeben ist eine Liste von Zahlen: List(1, 2, 3, 4, 5). Wenden Sie die map-Funktion an, um jede Zahl zu verdoppeln.

Erwartete Ausgabe
List(2, 4, 6, 8, 10)

Übung 2
Gegeben ist eine Liste von Namen: List("Alice", "Bob", "Charlie"). Verwenden Sie map, um jeden Namen in Grossbuchstaben umzuwandeln.

Erwartete Ausgabe
List("ALICE", "BOB", "CHARLIE")

Übung 3
Gegeben ist eine Liste von Zahlen: List(12, 45, 68, 100). Benutzen Sie map, um die Hälfte jeder Zahl zu berechnen.

Erwartete Ausgabe
List(6, 22.5, 34, 50)

Übung 4
Gegeben:

case class Adresse(strasse: String, hausnummer: Int, postleitzahl: String, stadt: String)

val adressen = List(
  Adresse("Hauptstrasse", 10, "12345", "Musterstadt"),
  Adresse("Nebenstrasse", 5, "23456", "Beispielburg")
)
Verwenden Sie map, um eine Liste von formatierten Adressstrings zu erstellen (z.B. "Hauptstrasse 10, 12345 Musterstadt").
Erwartete Ausgabe
List("Hauptstrasse 10, 12345 Musterstadt", "Nebenstrasse 5, 23456 Beispielburg")

Übung 5
Gegeben:

val namen = List("Max Mustermann", "Erika Mustermann")
Verwenden Sie map, um eine Liste der Vornamen in Grossbuchstaben zu erstellen.*/