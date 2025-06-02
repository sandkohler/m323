# 04 Functions As Values

## 01 Map Übungen

### Übung 1

Gegeben ist eine Liste von Zahlen: List(1, 2, 3, 4, 5). Wenden Sie die map-Funktion an, um jede Zahl zu verdoppeln.

#### Erwartete Ausgabe

List(2, 4, 6, 8, 10)

### Übung 2

Gegeben ist eine Liste von Namen: List("Alice", "Bob", "Charlie"). Verwenden Sie map, um jeden Namen in Grossbuchstaben umzuwandeln.

#### Erwartete Ausgabe

List("ALICE", "BOB", "CHARLIE")

### Übung 3

Gegeben ist eine Liste von Zahlen: List(12, 45, 68, 100). Benutzen Sie map, um die Hälfte jeder Zahl zu berechnen.

#### Erwartete Ausgabe

List(6, 22.5, 34, 50)

### Übung 4

Gegeben: 

```scala
case class Adresse(strasse: String, hausnummer: Int, postleitzahl: String, stadt: String)

val adressen = List(
  Adresse("Hauptstrasse", 10, "12345", "Musterstadt"),
  Adresse("Nebenstrasse", 5, "23456", "Beispielburg")
)
```

Verwenden Sie map, um eine Liste von formatierten Adressstrings zu erstellen (z.B. "Hauptstrasse 10, 12345 Musterstadt").

#### Erwartete Ausgabe

List("Hauptstrasse 10, 12345 Musterstadt", "Nebenstrasse 5, 23456 Beispielburg")

### Übung 5

Gegeben:

`val namen = List("Max Mustermann", "Erika Mustermann")`

Verwenden Sie map, um eine Liste der Vornamen in Grossbuchstaben zu erstellen.

## 02 Filter Übungen

### Übung 1

Gegeben ist eine Liste von Zahlen: List(1, 2, 3, 4, 5). Wenden Sie die filter-Funktion an, um nur die geraden Zahlen zu behalten.

#### Erwartete Ausgabe

List(2, 4)

### Übung 2

Gegeben ist eine Liste von Namen: List("Alice", "Bob", "Charlie", "Diana"). Verwenden Sie filter, um Namen auszuwählen, die mehr als vier Buchstaben haben.

#### Erwartete Ausgabe

List("Alice", "Charlie", "Diana")

### Übung 3

Gegeben ist eine Liste von Zahlen: List(12, 45, 68, 100). Benutzen Sie filter, um alle Zahlen zu behalten, die grösser als 50 sind.

#### Erwartete Ausgabe

List(68, 100)

### Übung 4

Gegeben ist eine Liste von Wörtern: List("Scala", "ist", "fantastisch"). Verwenden Sie filter, um alle Wörter zu behalten, die mit "S" beginnen.

#### Erwartete Ausgabe

List("Scala")

### Übung 5 (filter und map)

Gegeben:

```scala
case class Buch(titel: String, autor: String, jahr: Int)

val buecher = List(
  Buch("1984", "George Orwell", 1949),
  Buch("Brave New World", "Aldous Huxley", 1932),
  Buch("Fahrenheit 451", "Ray Bradbury", 1953)
)
```

Verwenden Sie filter und map, um eine Liste der Titel aller Bücher zu erstellen, die vor 1950 veröffentlicht wurden.

#### Erwartete Ausgabe

List("1984", "Brave New World")

## 03 Map und Filter Übungen

## 04 FoldLeft Übungen

## 05 FlapMap Übungen

## 06 ForComprehensions Übungen
