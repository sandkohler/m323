object FlapMap {
  def main(args: Array[String]): Unit = {

    // Übung 1
    val listOfLists = List(List(1, 2), List(3, 4), List(5, 6))
    val doubledFlatList = listOfLists.flatMap(innerList => innerList.map(_ * 2))
    println(doubledFlatList) // Ausgabe: List(2, 4, 6, 8, 10, 12)
 
    // Übung 2
    val people = List(
      ("Max", List("Blau", "Grün")),
      ("Anna", List("Rot")),
      ("Julia", List("Gelb", "Blau", "Grün"))
    )
    val uniqueColors = people.flatMap(_._2).distinct
    println(uniqueColors) // Ausgabe: List(Blau, Grün, Rot, Gelb)

  }
}