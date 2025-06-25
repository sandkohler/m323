//> using dep org.typelevel::cats-effect:3.6.1
import scala.util.Random
import cats.effect.IO
import cats.effect.unsafe.implicits.global

// Impure Funktion, wegen random -> liefert eine Zufallszahl von 1 bis 6
def rollDiceImpure(): Int = {
  val random = new Random
  random.nextInt(6) + 1
}

// Pure Funktion, die den impuren Call kapselt
def rollDice(): IO[Int] = {
  IO.delay(rollDiceImpure())
}

// Pure Funktion, die prüft, ob man die Basis verlassen darf (nur bei einer 6)
def allowToLeafHome: IO[Boolean] = {
  rollDice().map(_ == 6)
}

object Main extends App {
  val allowed = allowToLeafHome.unsafeRunSync()
  println(s"Darf die Figur die Basis verlassen? $allowed")
}
