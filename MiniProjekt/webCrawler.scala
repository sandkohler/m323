import scala.io.StdIn
import scala.io.Source
import java.net.URL
import java.io.PrintWriter
import scala.util.matching.Regex
import scala.util.Try
import java.time.Instant

// Datenstruktur für das Crawl-Ergebnis
case class CrawlNode(url: String, links: List[CrawlNode])

object WebCrawler {

  // Seite herunterladen (IO)
  def downloadPage(url: String): Try[String] = Try {
    Source.fromURL(new URL(url), "UTF-8").mkString
  }

  // Links extrahieren (pure)
  def extractLinks(html: String): List[String] = {
    val linkRegex: Regex = """href=["'](http[s]?://[^"']+)["']""".r
    linkRegex.findAllMatchIn(html).map(_.group(1)).toList
  }

  // Crawl-Limits prüfen (pure)
  def limitsReached(depth: Int, maxDepth: Int, visited: Set[String], maxPages: Int, startTime: Instant, timeoutSeconds: Int): Boolean = {
    depth > maxDepth || visited.size >= maxPages ||
      (timeoutSeconds > 0 && Instant.now().isAfter(startTime.plusSeconds(timeoutSeconds)))
  }

  // Rekursives Crawling (IO)
  def crawl(
    url: String,
    depth: Int,
    maxDepth: Int,
    visited: Set[String],
    maxPages: Int,
    startTime: Instant,
    timeoutSeconds: Int
  ): CrawlNode = {
    if (limitsReached(depth, maxDepth, visited, maxPages, startTime, timeoutSeconds) || visited.contains(url)) {
      CrawlNode(url, Nil)
    } else {
      val html = downloadPage(url).getOrElse("")
      val links = extractLinks(html).filterNot(visited.contains).distinct
      val newVisited = visited + url
      val children = links.take(maxPages - newVisited.size).map { link =>
        crawl(link, depth + 1, maxDepth, newVisited, maxPages, startTime, timeoutSeconds)
      }
      CrawlNode(url, children)
    }
  }

  // Ergebnis speichern (IO)
  def saveResult(result: CrawlNode, path: String): Unit = {
    def toJson(node: CrawlNode): String = {
      val childrenJson = node.links.map(toJson).mkString(",")
      s"""{"url":"${node.url}","links":[${childrenJson}]}"""
    }
    val writer = new PrintWriter(path)
    writer.write(toJson(result))
    writer.close()
  }

  // Hauptprogramm (IO)
  def main(args: Array[String]): Unit = {
    println("WebCrawler - Konsolenapplikation")
    print("Start-URL (z.B. https://digitec.ch): ")
    val startUrl = StdIn.readLine().trim
    print("Maximale Tiefe (z.B. 2): ")
    val maxDepth = StdIn.readLine().trim.toIntOption.getOrElse(2)
    print("Maximale Seitenanzahl (z.B. 10): ")
    val maxPages = StdIn.readLine().trim.toIntOption.getOrElse(10)
    print("Timeout in Sekunden (z.B. 30): ")
    val timeoutSeconds = StdIn.readLine().trim.toIntOption.getOrElse(30)
    print("Pfad für Ergebnisdatei (z.B. crawl_result.json): ")
    val outputPath = StdIn.readLine().trim match {
      case "" => "crawl_result.json"
      case path => path
    }

    val startTime = Instant.now()
    val result = crawl(startUrl, 0, maxDepth, Set.empty, maxPages, startTime, timeoutSeconds)
    saveResult(result, outputPath)
    println(s"Ergebnis gespeichert in $outputPath")
  }
}