object TripPlanner {
    private var destinations: List[String] = List()

    def addDestination(city: String): Unit = {
        destinations = destinations :+ city
        println(s"Destination $city added.")
    }
    
    def editRoute(index: Int, newCity: String): Unit = {
        if (index >= 0 && index < destinations.length) {
            destinations = destinations.updated(index, newCity)
            println(s"Destination at index $index updated to $newCity.")
        } else {
            println(s"Invalid index: $index")
        }
    }
    
    def showRoute(): Unit = {
        if (destinations.isEmpty) {
            println("No destinations added yet.")
        } else {
            println("Current route:")
            destinations.zipWithIndex.foreach { case (city, index) =>
                println(s"$index: $city")
            }
        }
    }

    def main(args: Array[String]): Unit = {
        addDestination("Berlin")
        addDestination("Zurich")
        editRoute(1, "London")
        addDestination("Barcelona")
        showRoute()
    }
}
