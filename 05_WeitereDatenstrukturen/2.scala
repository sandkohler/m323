import java.time.LocalTime
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object WetterApp extends App {

  // Aufgabe 1: Funktion mit Tupel
  def wetterFunktion(): (String, LocalTime, Double) = {
    val wetterBeschreibung = "sonnig"
    val aktuelleZeit = LocalTime.now()
    val aktuelleTemperatur = 22.5 // Beispielwert
    (wetterBeschreibung, aktuelleZeit, aktuelleTemperatur)
  }

  // Aufgabe 2: Eine Liste von Wetterdaten
  def wetterDatenAuslesen(wetterDaten: List[(String, LocalTime, Double)], temperaturGrenze: Double): List[String] = {
    wetterDaten.filter(_._3 > temperaturGrenze).map(_._1)
  }

  // Zusatzaufgabe: Mit Listen von Tupel arbeiten
  def trending(rates: List[BigDecimal]): Boolean = {
    @tailrec
    def checkTrend(pairs: List[(BigDecimal, BigDecimal)]): Boolean = pairs match {
      case Nil => true
      case (prev, curr) :: tail if curr > prev => checkTrend(tail)
      case _ => false
    }
    
    if (rates.length < 2) true // Kein Trend bei weniger als zwei Werten
    else checkTrend(rates.zip(rates.drop(1)))
  }

  // ### Output ### 
  // Aufgabe 1
  val wetter = wetterFunktion()
  println(s"Wetter: $wetter")

  // Aufgabe 2
  val daten = List(
    ("sonnig", LocalTime.of(10, 0), 22.5),
    ("bewölkt", LocalTime.of(12, 0), 18.0),
    ("regnerisch", LocalTime.of(14, 0), 16.5),
    ("heiß", LocalTime.of(16, 0), 28.0)
  )
  val warmeTage = wetterDatenAuslesen(daten, 20.0)
  println(s"Wetterbeschreibungen über 20°C: $warmeTage")

  // Zusatzaufgabe
  val rates1 = List(BigDecimal(1), BigDecimal(2), BigDecimal(3))
  val rates2 = List(BigDecimal(3), BigDecimal(2), BigDecimal(1))
  println(s"Trend steigend (1,2,3): ${trending(rates1)}")
  println(s"Trend steigend (3,2,1): ${trending(rates2)}")

}