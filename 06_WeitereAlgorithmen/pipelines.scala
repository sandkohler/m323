object PipelinesApp {
  case class Course(title: String, students: List[String])
  case class CourseSubscriptions(title: String, totalStudents: Int)

  val courses = List(
    Course("M323", List("Peter", "Petra", "Paul", "Paula")),
    Course("M183", List("Paula", "Franz", "Franziska")),
    Course("M117", List("Paul", "Paula")),
    Course("M114", List("Petra", "Paul", "Paula"))
  )

  def modulesForStudent(name: String): String = {
    val moduleTitles = courses.filter(_.students.contains(name)).map(_.title)
    s"$name besucht folgende Module: ${moduleTitles.mkString(", ")}"
  }

  def main(args: Array[String]): Unit = {
    println(modulesForStudent("Peter"))
    println(modulesForStudent("Petra"))
    val subscriptions: List[CourseSubscriptions] =
      courses.map(c => CourseSubscriptions(c.title, c.students.size))
    println(subscriptions)
  }
}
