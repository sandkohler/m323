object WordScorer {
    private var words: List[(String, Int)] = List()

    def addWord(word: String): Unit = {
        val points = calculatePoints(word)
        words = words :+ (word, points)
        println(s"Word '$word' added with $points points.")
    }

    def calculatePoints(word: String): Int = {
        word.count(w => w != 'a' && w != 'A')
    }

    def showSortedWords(): Unit = {
        if (words.isEmpty) {
            println("No words added yet.")
        } else {
            val sortedWords = words.sortBy(-_._2)
            println("Words sorted by points:")
            sortedWords.foreach { case (word, points) =>
                println(s"$word: $points points")
            }
        }
    }
    def main(args: Array[String]): Unit = {
        addWord("apple")
        addWord("banana")
        addWord("cherry")
        addWord("date")
        showSortedWords()
    }
}
