object FoldLeft {
  def main(args: Array[String]): Unit = {

    // Übung 1
    val numbers = List(1, 2, 3, 4, 5)
    val sum = numbers.foldLeft(0)(_ + _)
    println(sum) // Erwartete Ausgabe: 15

    // Übung 2
    val strings = List("Hallo", " ", "Welt", "!")
    val combined = strings.foldLeft("")(_ + _)
    println(combined) // Erwartete Ausgabe: Hallo Welt!

    // Übung 3
    val points = List((1, 3), (2, 5), (4, 8), (6, 2))
    val (sumX, sumY) = points.foldLeft((0, 0)) { case ((accX, accY), (x, y)) =>
      (accX + x, accY + y)
    }
    val count = points.length
    val center = (sumX.toDouble / count, sumY.toDouble / count)
    println(center) // Erwartete Ausgabe: (3.25, 4.5)

  }
}