//> using dep org.typelevel::cats-effect:3.6.1
import cats.effect.{IO, IOApp, ExitCode}
import cats.syntax.parallel._
import scala.io.Source
import scala.util.matching.Regex
import java.net.URL
import java.io.PrintWriter
import java.time.Instant
import scala.util.Try

// Eine Fallklasse zur Darstellung eines Knotens im Crawl-Baum.
// Beinhaltet die URL der Seite und eine Liste der von dieser Seite gefundenen Links,
// die ebenfalls als CrawlNode dargestellt werden (rekursive Definition).
case class CrawlNode(url: String, links: List[CrawlNode])

object WebCrawler extends IOApp {

  // Eine zentrale Funktion für die Protokollierung von Nachrichten.
  // Kapselt den Nebeneffekt des Ausgebens auf die Konsole in einem IO.
  def log(msg: String): IO[Unit] =
    IO(println(s"[WebCrawler] $msg"))

  // Lädt den HTML-Inhalt einer gegebenen URL herunter.
  // Dies ist ein Effekt, da es eine Netzwerkoperation ist.
  // Es gibt ein Option[String] zurück, um das Scheitern des Downloads (z.B. 404, Netzwerkfehler) zu signalisieren.
  def downloadPage(url: String): IO[Option[String]] = IO {
    // Verwendung von Try zum Abfangen von Ausnahmen während des Downloads und Konvertierung in Option.
    Try(Source.fromURL(new URL(url), "UTF-8").mkString).toOption
  }

  // Extrahiert alle vollständigen HTTP/HTTPS-Links aus einem HTML-String.
  // Dies ist eine reine Funktion, da sie keine Nebeneffekte hat und bei gleichen Eingaben immer gleiche Ausgaben liefert.
  def extractLinks(html: String): List[String] = {
    // Regulärer Ausdruck, um href-Attribute zu finden, die mit http oder https beginnen.
    val linkRegex: Regex = """href=["'](http[s]?://[^"']+)["']""".r
    // Findet alle Übereinstimmungen und extrahiert die Gruppe (1), die die URL enthält.
    linkRegex.findAllMatchIn(html).map(_.group(1)).toList
  }

  // Überprüft, ob die Crawling-Limits (Tiefe, Seitenanzahl, Timeout) erreicht wurden.
  // Dies ist eine reine Funktion.
  def limitsReached(
    depth: Int,          // Aktuelle Crawling-Tiefe
    maxDepth: Int,       // Maximale erlaubte Tiefe
    visited: Set[String], // Bereits besuchte URLs
    maxPages: Int,       // Maximale Anzahl der zu crawlen Seiten
    startTime: Instant,  // Startzeit des Crawl-Vorgangs
    timeoutSeconds: Int  // Maximal erlaubte Zeit in Sekunden
  ): Boolean = {
    depth > maxDepth ||
    visited.size >= maxPages ||
    (timeoutSeconds > 0 && Instant.now().isAfter(startTime.plusSeconds(timeoutSeconds)))
  }

  // Die Hauptlogik des rekursiven Crawlens.
  // Diese Funktion ist "effektvoll", da sie andere IO-Operationen aufruft (log, downloadPage, crawl rekursiv).
  // Die Effekte werden jedoch durch IO verwaltet.
  def crawl(
    url: String,
    depth: Int,
    maxDepth: Int,
    visited: Set[String],
    maxPages: Int,
    startTime: Instant,
    timeoutSeconds: Int
  ): IO[CrawlNode] = {

    // Prüft, ob Limits erreicht wurden oder die URL bereits besucht wurde, um Endbedingungen zu definieren.
    if (limitsReached(depth, maxDepth, visited, maxPages, startTime, timeoutSeconds) || visited.contains(url)) {
      IO.pure(CrawlNode(url, Nil)) // Gibt einen CrawlNode ohne weitere Links zurück.
    } else {
      // Beginnt einen for-Comprehension-Block für sequentielle IO-Operationen.
      for {
        _ <- log(s"Crawle: $url (Tiefe: $depth)") // Protokolliert den aktuellen Crawl-Vorgang.
        htmlOpt <- downloadPage(url)               // Versucht, die Seite herunterzuladen.
        result <- htmlOpt match {                  // Pattern Matching auf das Ergebnis des Downloads.
          case Some(html) =>
            // Extrahiert Links, filtert bereits besuchte und entfernt Duplikate.
            // Nimmt nur so viele Links, wie noch Seiten übrig sind (gemäß maxPages).
            val links = extractLinks(html).filterNot(visited.contains).distinct
            val newVisited = visited + url // Fügt die aktuelle URL zu den besuchten hinzu.

            for {
              // Verwendet parTraverse, um die rekursiven Crawl-Aufrufe für Kind-Links parallel auszuführen.
              // Dies ist ein Schlüsselelement für die Skalierbarkeit und Leistung.
              children <- links
                .take(maxPages - newVisited.size) // Berücksichtigt das Seitenlimit für Kinder.
                .parTraverse(link => crawl(
                  link,
                  depth + 1,        // Erhöht die Tiefe für den nächsten Crawl-Level.
                  maxDepth,
                  newVisited,       // Übergibt den aktualisierten visited-Set.
                  maxPages,
                  startTime,
                  timeoutSeconds
                ))
            } yield CrawlNode(url, children) // Erstellt einen CrawlNode mit den gefundenen Kindern.

          case None =>
            // Fall, wenn der Download fehlschlägt. Protokolliert den Fehler und gibt einen leeren CrawlNode zurück.
            log(s"Fehler beim Laden von $url") *> IO.pure(CrawlNode(url, Nil))
        }
      } yield result // Gibt den endgültigen CrawlNode für die aktuelle URL zurück.
    }
  }

  // Speichert das Ergebnis des Crawl-Vorgangs in einer Datei im JSON-Format.
  // Dies ist ein Effekt, da es eine Dateisystemoperation ist.
  def saveResult(result: CrawlNode, path: String): IO[Unit] = IO {
    // Reine Hilfsfunktion zur Konvertierung eines CrawlNode in eine JSON-String-Repräsentation (rekursiv).
    def toJson(node: CrawlNode): String = {
      val childrenJson = node.links.map(toJson).mkString(",")
      s"""{"url":"${node.url}","links":[${childrenJson}]}"""
    }

    // Erstellt einen PrintWriter und schreibt den JSON-String in die Datei.
    val writer = new PrintWriter(path)
    writer.write(toJson(result))
    writer.close() // Wichtig: Den Writer schließen, um Ressourcen freizugeben.
  }

  // Eine einfache Funktion, um Benutzereingaben von der Konsole abzufragen.
  // Kapselt den Nebeneffekt der Konsolen-I/O in einem IO.
  def prompt(text: String): IO[String] = IO {
    print(text) // Gibt den Prompt-Text aus.
    scala.io.StdIn.readLine().trim // Liest die Benutzereingabe und entfernt Whitespace.
  }

  // Die Hauptausführung des Programms.
  // Dies ist der Einstiegspunkt für die IOApp und orchestriert die gesamte Crawl-Logik.
  override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- log("Willkommen zum funktionalen WebCrawler mit cats-effect")

      // Abfrage der Konfigurationsparameter vom Benutzer.
      startUrl <- prompt("Start-URL (z.B. https://digitec.ch): ")

      maxDepthStr <- prompt("Maximale Tiefe (z.B. 2): ")
      maxDepth = maxDepthStr.toIntOption.getOrElse(2) // Standardwert, falls ungültige Eingabe.

      maxPagesStr <- prompt("Maximale Seitenanzahl (z.B. 10): ")
      maxPages = maxPagesStr.toIntOption.getOrElse(10) // Standardwert.

      timeoutStr <- prompt("Timeout in Sekunden (z.B. 30): ")
      timeoutSeconds = timeoutStr.toIntOption.getOrElse(30) // Standardwert.

      outputPath <- prompt("Pfad für Ergebnisdatei (z.B. crawl_result.json): ")
      finalPath = if outputPath.isEmpty then "crawl_result.json" else outputPath // Standardpfad, falls leer.

      startTime = Instant.now() // Speichert die Startzeit für das Timeout.

      // Startet den eigentlichen Crawl-Vorgang und speichert das Ergebnis in 'result'.
      result <- crawl(startUrl, 0, maxDepth, Set.empty, maxPages, startTime, timeoutSeconds)

      // Speichert das Crawl-Ergebnis in der angegebenen Datei.
      _ <- saveResult(result, finalPath)
      // Protokolliert den Abschluss des Vorgangs.
      _ <- log(s"Ergebnis gespeichert in $finalPath")

    } yield ExitCode.Success // Signalisiert einen erfolgreichen Programmablauf.
  }
}