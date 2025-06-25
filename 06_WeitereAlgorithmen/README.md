# 06 Weitere Algorithmen 

## Pipelines

Pipelines sind aneinander gekettete Funktionen. Der Return-Wert des vorangehenden Funktionsaufrufs kann jeweils im 
darauffolgenden Funktionsaufruf als Parameter verwendet werden.

Gegeben ist folgendes Beispiel:

```Scala
case class Course(title: String, students: List[String])

val courses = List(
    Course("M323", List("Peter", "Petra", "Paul", "Paula")),
    Course("M183", List("Paula", "Franz", "Franziska")),
    Course("M117", List("Paul", "Paula")),
    Course("M114", List("Petra", "Paul", "Paula")),
)

println(courses.map(_.students).filter(_.contains("Peter")).size) // 1
println(courses.map(_.students).filter(_.contains("Petra")).size) // 2
```

Bei der Ausführung der letzten beiden Zeilen geschieht Folgendes:
1. Als Erstes wird die map-Funktion verwendet. Diese kriegt courses vom Typ `List[Course]` als Parameter und als 
Rückgabewert wird eine `List[List[String]]` mit den Teilnehmerlisten aller Lernenden eines Moduls zurückgegeben.
2. Die filter-Funktion kriegt Ihrerseits den Rückgabewert von map als Parameter (vom Typ `List[List[String]]`) 
und gibt nur diejenigen Listen von Lernenden zurück wo entweder "Peter" (zweitletzte Zeile) oder "Petra" (letzte Zeile) 
im Modul eingeschrieben sind. Der Rückgabewert ist wieder vom Typ `List[List[String]]`
3. Als Letztes wird der size-Funktion die gefilterte Liste von Listen (Typ `List[List[String]]`) mit den Teilnehmern 
übergeben. Die size-Funktion zählt ihrerseits nun die Anzahl der Teilnehmerlisten und gibt diesen Wert zurück. 
Dieser entspricht auch der Anzahl (Typ `Int`) in wie vielen Modulen "Peter" respektive "Petra" eingeschrieben sind.

Die gegebene Pipeline transformiert folglich den Typ `List[Course]` in den Typ `Int`. Bei jedem Schritt wird auf einer 
veränderten Kopie der Daten weitergearbeitet.

Probieren Sie das Beispiel aus, indem Sie den Code kopieren und ausführen. Verändern Sie die Pipeline so, dass Sie 
anstelle der Anzahl Kurse folgende Strings zurückerhalten:
* Peter besucht folgende Module: M323
* Petra besucht folgende Module: M323, M114

Verändern Sie die Pipeline als Nächstes so, dass Sie eine Liste vom Typ `List[CourseSubscriptions]` zurückgeliefert 
wird. Der Typ `CourseSubscriptions` soll die folgende case class sein: `case class CourseSubscriptions(title: String, totalStudents: Int)`. 
Das Feld `totalStudents` soll dabei die Anzahl der Lernenden enthalten, die im Modul eingeschrieben sind.

## IO

Die Idee von IO ist, alle Operationen - seien es nun Inputs, Outputs oder andere Calls von impure functions - 
die dafür sorgen würden, dass die eigene pure function impure würde (Funktionen die Seiteneffekte verursachen) so zu 
kapseln, dass die pure functions dadurch nicht impure werden.

Mit IO kann auf einer abstrakten Ebene beschrieben werden (deklarativer Stil), dass mit Daten aus einer unsicheren 
Quelle gearbeitet wird. Mit `IO.delay(/* hier kommt call auf impure function */)` kann die Ausführung des Codes 
verzögert werden. Es wird quasi nur beschrieben, was ausgeführt werden soll, aber noch nicht ausgeführt. Damit bleibt 
die pure function vorerst pure und kann mit dem IO-Typen arbeiten wie mit allen anderen Werten auch.

Wird die Methode unsafeRunSync nun auf den konkreten IO-Daten aufgerufen, dann wird der zuvor in unserer pure function 
definierte unsichere Call der impure function ausgeführt. D. h. Die Ausführung des problematischen Calls kann auf diese 
Weise von der Businesslogik weg an eine Stelle ausgelagert werden, wo zentral alle unsauberen Dinge gemacht werden und/oder
wo mit der Aussenwelt kommuniziert wird.

Das hat die folgenden Vorteile:
* Bündeln der Logik für die Kommunikation zur Aussenwelt
* Business-Logik befreien von Überprüfung der Inhalte und verschiedenen Fälle (sind Daten vorhanden oder nicht, 
wurde Exception geworfen, läuft die Logik allenfalls in Timeouts)
* Der Datentyp IO hinterlässt eine einfach nachzuverfolgende Spur durch die Business-Logik. Dadurch können die 
Teile die von IO-Operationen abhängig sind einfach identifiziert werden.

Ein Beispiel:

```Scala
import scala.util.Random

def rollDiceImpure(): Int = {
    val random = new Random
    random.nextInt(6) + 1
}

// Beispielaufruf
val result = rollDiceImpure()
println("Der Würfel zeigt: $result")
```

Die Funktion `rollDiceImpure` liefert eine Zufallszahl von 1 bis 6. Die Methode ist impure, weil ihr Return-Wert 
nicht nur von den Input-Parametern abhängt, sondern auch von einem Zufallswert.

In der funktionalen Programmierung werden nun diese impure functions gewrappt und so von der Business-Logik getrennt. 
Stellen Sie sich vor, Sie programmieren ein Spiel, indem die Spieler mit Ihren Figuren erst ihre Basis verlassen 
können, wenn ein 6-er gewürfelt wurde. Dafür brauchen Sie die Funktion `allowedToLeafHome`, die aufgrund von einem 
Würfelergebnis entscheidet, ob Sie die Basis verlassen dürfen mit der Spielfigur oder nicht. Würden Sie die 
'impure function' direkt aufrufen, würde ihre neue Funktion ebenfalls impure. Das wollen Sie nicht und hier kommt IO ins Spiel.

Sie können zuerst eine pure function definieren die den Würfelwurf beschreibt:

```Scala
import cats.effect.IO

def rollDice(): IO[Int] = {
    IO.delay(rollDiceImpure())
}
```

Der Trick ist nun, dass die Zeile `IO.delay(rollDiceImpure())` die Funktion (die Impure ist), nicht ausführt, sondern nur zu 
Ausführung vormerkt wird. Die Funktion `rollDice()` gibt dabei nicht das bereits evaluierte Resultat des Würfelwurfes zurück, 
sondern lediglich die Beschreibung, dass ein 'Int' zurückgeliefert werden sollte, sobald der impure Teil ausgeführt wird/würde. 
Es ist also lediglich eine Beschreibung der Dinge die getan werden müssten, ohne dass diese auch tatsächlich ausgeführt werden. 
Dadurch bleibt die Funktion `rollDice()` eine pure Funktion.

Damit haben Sie nun eine pure Funktion die Ihnen das Resultat eines Münzwurfs liefern wird, sobald diese evaluiert wird 
(oder eben eine Exception oder sonstiges). Der IO-Wert wird jedoch erst später an einer Stelle evaluiert, die sowieso 
impure ist (in der Regel das 'main' - Ihr Hauptprogrammfluss). Sie können jetzt also einfach für die Funktion `allowedToLeafHome` 
die Methode `rollDice()` verwenden. Und weil diese 'pure' ist, bleibt auch Ihre `allowedToLeafHome` 'pure'.

In Code könnte die Funktion wie folgt aussehen:

```Scala
def allowToLeafHome: IO[Boolean] = {
    val checkRoll = rollDice()
    checkRoll.map(_ == 6)
}

// call der Funktion... in allowToLeaf ist nun ein IO[Boolean] enthalten
val allowToLeaf = allowToLeafHome
```

Erst wenn mit `unsafeRunSync()` die Evaluation des konkreten Würfelwurfs angestossen wird, wird der Teil der Applikation 
der diesen Anstösst impure (und nur der). Alle bisher definierten Funktionen bleiben weiterhin pure.

Nur der Teil ist impure:

```Scala
import cats.effect.unsafe.implicits.global
allowToLeaf.unsafeRunSync()
```

Versuchen Sie dieses Beispiel nachzuvollziehen, indem Sie dieses in Ihrer IDE zum Laufen bringen. Sie brauchen dafür 
die cats-Library. Diese können Sie beispielsweise dem Projekt hinzufügen, indem Sie in Ihrer build.sbt folgende Zeile ergänzen:

```Scala
libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.4"
```

Weitere Details zur cats-Library: https://typelevel.org/cats-effect/docs/getting-started
