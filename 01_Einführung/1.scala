// Imperative Version
def calculateScore(word: String): Int = {
    var score = 0
    for (c <- word.toCharArray) {
        if (c == 'a' || c == 'A') {
            // do nothing
        } else {
            score += 1
        }
    }
    score
  }
  
  // Declarative Version
  def wordScore(word: String): Int = {
    word.toCharArray.count(c => c != 'a' && c != 'A')
  }
  
  @main
  def main(): Unit = {
    println(calculateScore("imperative") == 9) // true
    println(calculateScore("no") == 2)        // true
    println(wordScore("declarative") == 9)    // true
    println(wordScore("yes") == 3)            // true
  }