# 01 Einführung

## Aufgabe 1

### Anforderung
Wir wollen die Funktion so erweitern, dass die Punktzahl nur Zeichen zählt, ohne das Zeichen «a».

## Aufgabe 2

### Anforderung
Wir wollen eine Shopping-Cart (Warenkorb), wobei jedes Element (als String) in den Warenkorb hinzugefügt werden kann. Falls ein Buch hinzugefügt wurde, erhalten wir 5% Rabatt. Falls kein Buch hinzugefügt wurde, ist der Rabatt 0%. Die Elemente im Warenkorb können zu jeder Zeit ausgelesen werden. Die Elemente im Warenkorb können auch zu jeder Zeit wieder entfernt werden.

**Auf was müssen wir achten, wenn sich der Zustand im Warenkorb ändert?**

Prüfen, ob es ein Buch ist, um den Rabatt hinzuzufügen oder zu entfernen.

**Was geschieht, falls wir ein Buch aus dem Warenkorb entfernen?**

Es wird geprüft ob es entfernte Element ein Buch war, dann wird geprüft ob es noch andere Bücher im Warenkorb gibt und falls keine Bücher im Warenkorb mehr vorhanden sind, wird der Rabatt auf 0% reduziert.

## Aufgabe 3

### Anforderung
Der TipCalculator berechnet das Trinkgeld, der eine Gruppe von Gästen dem Kellner zahlt. Das Trinkgeld ist 10% des Betrags, wenn es sich um eine Gruppe von 1-5 Personen handelt. Falls die Gruppe grösser ist, ist das Trinkgeld 20%. Wenn es keine Gruppe ist, wird 0% berechnet.

**Pure Funktion bedeutet:**
- Funktion gibt einen Wert zurück
- Funktion berechnet den Rückgabewert aufgrund der erhaltenen Parameter
- Funktion ändert nicht den Zustand von bestehenden Werten