object MapExercises extends App {

  import scala.collection.immutable.Map

  // Übung 1: werte zuweisen
  val m1: Map[String, String] = Map("key" -> "value")
  println(m1)

  // Übung 2: Map aktualisieren
  val m2: Map[String, String] = m1 + ("key2" -> "value2")
  println(m2)

  // Übung 3: Map nochmals aktualisieren
  val m3: Map[String, String] = m2 + ("key2" -> "aDifferentValue")
  println(m3)

  // Übung 4: Element entfernen
  val m4: Map[String, String] = m3 - "key"
  println(m4)

  // Übung 5: Nach key suchen
  val valueFromM3: Option[String] = m3.get("key")
  println(valueFromM3)

  // Übung 6: kein existierender Wert
  val valueFromM4: Option[String] = m4.get("key")
  println(valueFromM4)
}