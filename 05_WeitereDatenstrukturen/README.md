# 05 Weitere Datenstrukturen

## 01 Datenstruktur Map

### Übung 1: werte zuweisen

Gegeben ist folgende Map `val m1: Map[String, String]`. 

Wie lautet die Zuweisung?

Wir wollen folgende Ausgabe: `Map("key" -> "value")`

### Übung 2: Map aktualisieren

Gegeben ist folgende Map `val m2: Map[String, String]`. 

Wir wollen die Map m1 aktualisieren mit einem neuen Wertepaar.

Wir wollen folgende Ausgabe: `Map("key" -> "value", "key2" -> "value2")`

### Übung 3: Map nochmals aktualisieren

Gegeben ist folgende Map `val m3: Map[String, String]`. 

Wir wollen die Map m2 aktualisieren mit einem neuen Wert.

Wir wollen folgende Ausgabe: `Map("key" -> "value", "key2" -> "aDifferentValue")`

### Übung 4: Element entfernen

Gegeben ist die Map `val m4: Map[String, String]`. 

Wir wollen die Map m3 aktualisieren und den key entfernen.

Wir wollen folgende Ausgabe: `Map("key2" -> "aDifferentValue")`

### Übung 5: Nach key suchen

Wir wollen den Wert aus key von `m3: val valueFromM3: Option[String]`

Wir wollen folgende Ausgabe: `Some("value")`

### Übung 6: kein existierender Wert

Wir wollen den Wert aus key von `m3: val valueFromM4: Option[String]`, wobei wir somit keinen Wert erhalten, weil der key nicht existiert.

Die Ausgabe wäre somit: `None`

### Hinweis zu Option

Wir werden diese Datenstruktur noch genauer kennenlernen wenn wir uns mit dem Error Handling befassen. 

Nur soviel: durch Option sichern wir, dass unsere Funktion keinen Fehler zur Laufzeit hat, sollte kein Wert retourniert werden.

## 02 Datenstruktur Tupel

### Aufgabe 1: Funktion mit Tupel

Schreiben Sie eine WetterFunktion, welches beim Aufruf drei Werte zurückgibt:

- eine Wetterbeschreibung (wie "sonnig", "regnerisch", etc.)
- die aktuelle Zeit (verwenden Sie LocalTime)
- die aktuelle Temperatur

Verwenden Sie dabei eine Tupel, um diese Werte zu retournieren.

### Aufgabe 2: Eine Liste von Wetterdaten

Erstellen Sie eine Liste mit Wetterdaten (wiederum als Tupel). 

Implementieren Sie eine Funktion, welche die Daten ausliest und nach bestimmten Kriterien wieder ausgibt. (z.Bsp. sollen alle Städte angezeigt werden, die wärmer als 20 Grad haben)

### Zusatzaufgabe: Mit Listen von Tupel arbeiten

Wir wollen eine Funktion trending, welche eine Liste von Kurswerten entgegennimmt (z.Bsp. von einer bestimmten Aktie). 

Dabei soll errechnet werden, ob der Kurs einem Trend folgt oder nicht (d.h. wenn der Kurs laufend höher wird, dann haben wir einen positiven Trend).

**Beispiel Aufruf:**

```scala
trending(List(BigDecimal(1), BigDecimal(4), BigDecimal(3), BigDecimal(8))) 
// ergibt false

trending(List(BigDecimal(1), BigDecimal(2), BigDecimal(3), BigDecimal(8))) 
// ergibt true
```

**Lösungsansatz:**

Verwenden Sie die zip-Funktion, um einen Tupel von zwei Werten zu bilden.

Die zip-Funktion nimmt die Liste und zipped sie mit sich selbst (ohne das erste Element): `rates.zip(rates.drop(1))`

Somit wird das erste Element mit dem zweiten Element "gezipped", das Zweite mit dem Dritten und soweiter. 

Wir erhalten eine Liste von 2er-Tupel, mit jeweils dem vorherigen Wert und dem aktuellen Wert.

Wenden Sie für jeden Tupel das Pattern Matching an (d.h. aktueller Wert > vorheriger Wert).