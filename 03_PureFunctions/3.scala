object exercise3 {
   
    // Aufgabe 3.1: Eine Funktion, die aus einer Liste von Zahlen die Summe aller Listenelemente berechnet.
    def getSum(numbers: List[Double]): Double = {
        numbers.foldLeft(0.0)(_ + _)
    }

    // Aufgabe 3.2: Eine Funktion, die aus einer Liste von Zahlen den Mittelwert aller Listenelemente berechnet.
    def getAverage(numbers: List[Double]): Double = {
        if (numbers.isEmpty) 0.0
        else getSum(numbers) / numbers.length
    }

    // Aufgabe 3.3: Eine Funktion, die eine gegebene Liste von Strings alphabetisch sortiert.
    def sortStrings(strings: List[String]): List[String] = {
        strings.sorted
    }

    // Aufgabe 3.4: Eine Funktion, die eine Liste von Objekten anhand einer eigenen Sort-Funktion sortiert. Die Objekte sollen dabei die Properties Datum, Priorität und Titel enthalten. Die Funktion soll eine sortierte Liste der Objekte zurückgeben, wobei als Sortierkriterium zuerst das Datum, dann die Priorität und zum Schluss der Titel verwendet werden.
    case class CustomObject(date: String, priority: Int, title: String)

    def sortCustomObjects(objects: List[CustomObject]): List[CustomObject] = {
        objects.sortWith((a, b) => {
            if (a.date != b.date) a.date < b.date
            else if (a.priority != b.priority) a.priority < b.priority
            else a.title < b.title
        })
    }

    // Aufgabe 3.5: Eine Funktion, die aus einer Baumstruktur mit unterschiedlich tiefer Verschachtelung alle Blätter (Elemente ohne weitere Kinder) ausliest und in einer flachen Liste von Blättern zurückgibt.
    case class Tree(value: String, children: List[Tree])
    case class Leaf(value: String)

    def getLeaves(tree: Tree): List[Leaf] = {
        if (tree.children.isEmpty) List(Leaf(tree.value))
        else tree.children.flatMap(getLeaves)
    }


    def main(args: Array[String]): Unit = {
        
        val numbers = List(1.0, 2.0, 3.0, 4.0)
        println(s"Summe: ${getSum(numbers)}")
        println(s"Mittelwert: ${getAverage(numbers)}")

        val strings = List("Banane", "Apfel", "Orange")
        println(s"Sortierte Strings: ${sortStrings(strings)}")

        val objects = List(
            CustomObject("2023-10-01", 2, "Zweite Aufgabe"),
            CustomObject("2023-10-01", 1, "Erste Aufgabe"),
            CustomObject("2023-09-30", 1, "Letzte Aufgabe")
        )
        println(s"Sortierte Objekte: ${sortCustomObjects(objects)}")

        val tree = Tree("Wurzel", List(
            Tree("Kind1", List(Tree("Blatt1", Nil), Tree("Blatt2", Nil))),
            Tree("Kind2", List(Tree("Blatt3", Nil)))
        ))
        println(s"Blätter: ${getLeaves(tree)}")
    }
}
