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

### Übung 1: Filterung von Mitarbeiterdaten

Gegeben:

```scala
case class Mitarbeiter(name: String, abteilung: String, gehalt: Int)

val mitarbeiter = List(
  Mitarbeiter("Max Mustermann", "IT", 50000),
  Mitarbeiter("Erika Musterfrau", "Marketing", 45000),
  Mitarbeiter("Klaus Klein", "IT", 55000),
  Mitarbeiter("Julia Gross", "HR", 40000)
)
```

Erstellen Sie eine Liste aller Mitarbeiter in der "IT"-Abteilung, deren Gehalt bei 50000 oder darüber liegt. Zusätzlich sollen alle Vornamen in Grossbuchstaben umgewandelt und der Nachname entfernt werden (z.B. "MAX").

#### Erwartete Ausgabe

List("MAX", "KLAUS")

### Übung 2: Kursnamen formatieren und sortieren

In dieser Übung werden wir eine Liste von Kursnamen bearbeiten und sortieren.

Gegeben ist eine Liste von Kursnamen:

```scala
val kurse = List(
  "Programmierung in Scala",
  "Datenbanken",
  "Webentwicklung mit JavaScript",
  "Algorithmen und Datenstrukturen"
)
```

- Filtern Sie die Kursnamen, um nur diejenigen zu behalten, die das Wort "Daten" enthalten.
- Entfernen Sie aus jedem Kursnamen alle Leerzeichen.
- Sortieren Sie die Kursnamen alphabetisch.
- Sortieren Sie umgekehrt alphabetisch.

## 04 FoldLeft Übungen

### Übung 1

Gegeben ist eine Liste von Zahlen: List(1, 2, 3, 4, 5). Berechnen Sie die Summe aller Zahlen mithilfe von foldLeft.

#### Erwartete Ausgabe

15

### Übung 2

Gegeben ist eine Liste von Strings: List("Hallo", " ", "Welt", "!"). Kombinieren Sie alle Strings zu einem einzigen String mithilfe von foldLeft.

#### Erwartete Ausgabe

Die erwartete Ausgabe ist ein einziger String, der alle Elemente der Liste kombiniert, also "Hallo Welt!".

### Übung 3

Gegeben ist eine Liste von Punkten in einem zweidimensionalen Raum.

`val points = List((1, 3), (2, 5), (4, 8), (6, 2))`

Jeder Punkt wird durch ein Tupel (x, y) repräsentiert, wobei x und y die Koordinaten des Punktes sind. Ihre Aufgabe ist es, den Schwerpunkt (den durchschnittlichen Punkt) aller Punkte in der Liste zu berechnen.

#### Erwartete Ausgabe

Die erwartete Ausgabe ist ein Tupel (x, y), das den Schwerpunkt aller Punkte in der Liste repräsentiert.

## 05 FlapMap Übungen

### Übung 1

Gegeben ist eine Liste von Listen, die Zahlen enthält: List(List(1, 2), List(3, 4), List(5, 6)). Ihre Aufgabe ist es, eine neue Liste zu erstellen, die alle Elemente der Unterlisten enthält, wobei jede Zahl verdoppelt wird. Verwenden Sie dazu die flatMap-Funktion in Kombination mit map.

### Übung 2

Gegeben ist eine Liste von Personen, wobei jede Person durch ein Tupel aus Name und einer Liste ihrer Lieblingsfarben dargestellt wird: List(("Max", List("Blau", "Grün")), ("Anna", List("Rot")), ("Julia", List("Gelb", "Blau", "Grün"))). Ihre Aufgabe ist es, eine Liste aller einzigartigen Farben zu erstellen, die als Lieblingsfarben angegeben wurden. Verwenden Sie dafür die flatMap-Funktion, gefolgt von distinct.

## 06 ForComprehensions Übungen

### Übung 1

Schreiben Sie eine for-Comprehension, die eine Liste von Ganzzahlen von 1 bis 10 durchläuft und jede Zahl quadriert.

Tipp: Sie können Zahlenlisten ganz einfach so generieren: val numbers = 1 to 10

### Übung 2

Schreiben Sie eine for-Comprehension, die eine Liste von Ganzzahlen von 1 bis 20 durchläuft und nur die geraden Zahlen auswählt.

### Übung 3

Gegeben sind zwei Listen von Strings: colors und fruits. Schreiben Sie eine for-Comprehension, die alle möglichen Paare aus einer Farbe und einer Frucht generiert.

```scala
val colors = List("Red", "Green", "Blue")
val fruits = List("Apple", "Banana", "Orange")
```

### Übung 4

Gegeben sind zwei Listen von Benutzern (users) und deren Aufgaben (tasks). Jeder Benutzer hat eine Liste von Aufgaben. Schreiben Sie eine for-Comprehension, die alle Kombinationen von Benutzer und Aufgabe anzeigt, aber nur diejenigen, bei denen die Aufgabe nicht abgeschlossen ist.

```scala
case class User(name: String, tasks: List[String])

val users = List(
  User("Alice", List("Task 1", "Task 2", "Task 3")),
  User("Bob", List("Task 1", "Task 4", "Task 5")),
  User("Charlie", List("Task 2", "Task 3", "Task 6"))
)

val tasksCompleted = List("Task 1", "Task 3", "Task 5")

// TODO find pending tasks for each User
```
