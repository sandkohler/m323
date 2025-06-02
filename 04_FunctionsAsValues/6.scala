object ForComprehensions {
  def main(args: Array[String]): Unit = {

    // Übung 1
    val numbers = 1 to 10
    val squares = for (n <- numbers) yield n * n
    println(s"Quadrate von 1 bis 10: $squares")

    // Übung 2
    val numbers2 = 1 to 20
    val evenNumbers = for (n <- numbers2 if n % 2 == 0) yield n
    println(s"Gerade Zahlen von 1 bis 20: $evenNumbers")

    // Übung 3
    val colors = List("Red", "Green", "Blue")
    val fruits = List("Apple", "Banana", "Orange")
    val colorFruitPairs = for {
      color <- colors
      fruit <- fruits
    } yield (color, fruit)
    println(s"Alle möglichen Paare (Farbe, Frucht): $colorFruitPairs")

    // Übung 4
    case class User(name: String, tasks: List[String])

    val users = List(
      User("Alice", List("Task 1", "Task 2", "Task 3")),
      User("Bob", List("Task 1", "Task 4", "Task 5")),
      User("Charlie", List("Task 2", "Task 3", "Task 6"))
    )

    val tasksCompleted = List("Task 1", "Task 3", "Task 5")

    val pendingTasks = for {
      user <- users
      task <- user.tasks
      if !tasksCompleted.contains(task)
    } yield (user.name, task)

    println(s"Offene Aufgaben pro Benutzer: $pendingTasks")
 
  }
}