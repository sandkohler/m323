object TipCalculator {
    def calculateTipPercentage(groupSize: Int): Int = {
        if (groupSize > 5) {
            20
        } else if (groupSize > 0) {
            10
        } else {
            0
        }
    }
}

object TipCalculatorApp {
    def main(args: Array[String]): Unit = {
        val groupSizes = List(0, 1, 5, 6)
  
        groupSizes.foreach { size =>
            val tipPercentage = TipCalculator.calculateTipPercentage(size)
            println(s"Group size: $size -> Tip Percentage: $tipPercentage%")
        }
    }
}