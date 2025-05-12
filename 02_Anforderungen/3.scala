object CarRacing {
    private var lapTimes: List[Double] = List()

    def addLapTime(time: Double): Unit = {
        lapTimes = lapTimes :+ time
        println(s"Lap time of $time seconds added.")
    }

    def calculateTotalTime(): Double = {
        if (lapTimes.length <= 1) {
            println("Not enough laps to calculate total time.")
            0.0
        } else {
            lapTimes.tail.sum // skip the first lap
        }
    }

    def calculateAverageTime(): Double = {
        if (lapTimes.length <= 1) {
            println("Not enough laps to calculate average time.")
            0.0
        } else {
            calculateTotalTime() / (lapTimes.length - 1) // skip the first lap
        }
    }

    def showResults(): Unit = {
        val totalTime = calculateTotalTime()
        val averageTime = calculateAverageTime()
        println(s"Total time (excluding first lap): $totalTime seconds")
        println(s"Average time per lap (excluding first lap): $averageTime seconds")
    }

    def main(args: Array[String]): Unit = {
        addLapTime(17.5)
        addLapTime(11.8)
        addLapTime(13.2)
        showResults()
    }
}