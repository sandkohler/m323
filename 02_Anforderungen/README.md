# 02 Anforderungen

## Aufgabe 1

### Eine Reise planen

Wir planen eine Reise durch Europa und möchten, dass der Benutzer jeweils die Destinationen für die Reise eingibt.
Zudem soll es möglich sein, eine bereits festgelegte Route zu ändern
(z.Bsp. wenn Ihr Freund noch einen anderen Zwischenaufenthalt möchte).

- `void addDestination(String city)`: Fügt ein neues Reiseziel hinzu.
- `void editRoute(int index, String newCity)`: Ändert ein Reiseziel an einer bestimmten Position.
- `void showRoute()`: Zeigt die aktuelle Route an.

## Aufgabe 2

### Wörter mit Punkten bewerten

Wir wollen eine App, die dem User erlaubt, Wörter einzugeben. 
Jedes Wort erhält für jeden Buchstaben einen Punkt, solange der Buchstabe nicht "a" ist.
Zudem wollen wir eine Liste ausgeben, sortiert nach den Wörtern mit der höchsten Punktzahl.

- `void addWord(String word)`: Fügt ein Wort zur Liste hinzu und berechnet dessen Punktzahl.
- `int calculatePoints(String word)`: Berechnet die Punktzahl eines Wortes (1 Punkt pro Buchstabe, ausser für "a").
- `void showSortedWords()`: Gibt die Liste der Wörter aus, sortiert nach Punktzahl (absteigend)

## Aufgabe 3

### Autorennen

Wir möchten eine App, welche für ein Auto-Rennen die gesamte Zeit für alle Runden berechnet. 
Die App soll auch die Durchschnittszeit pro Auto berechnen. 
Die erste Runde wird nicht mitgezählt, da es sich hier um eine "Warm-up" Runde handelt.

- `void addLapTime(double time)`: Fügt die Zeit für eine Runde hinzu.
- `double calculateTotalTime()`: Berechnet die Gesamtzeit aller Runden (ohne die erste Runde).
- `double calculateAverageTime()`: Berechnet die Durchschnittszeit pro Runde (ohne die erste Runde).
- `void showResults()`: Zeigt die Gesamtzeit und Durchschnittszeit an.
