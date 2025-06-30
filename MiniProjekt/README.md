# Mini Projekt: Web-Crawler

## Auftrag

Erstellen Sie eine Applikation, welche es dem Benutzer ermöglicht, Webseiten zu durchforsten, mit einer angegebenen Tiefe.

Als Resultat wird eine Liste der Seiten erstellt, inkl. die ausgehenden Hyperlinks.

Das Resultat wird als Baumstruktur ausgegeben.

Der WebCrawler kann folgendes:

- Nimmt eine URL als Startpunkt
- Lädt die Seite herunter
- Extrahiert alle Links
- Besucht jeden Link rekursiv (mit definierter Tiefe)
- Retourniert eine Übersicht der Seiten und deren ausgehenden Links und schreibt dies in eine Datei (Format ist offen)

### Skalierbar 

Die Crawl Limite kann auch max. Anzahl Seiten und ein TimeOut enthalten.

## Umsetzung

Stellen Sie sicher dasss Ihre Funktionen pure bleiben, wenn diese mit der "Aussenwelt" (sprich: http Requests, Speichern von Dateien) kommunizieren (wenn Sie mit Scala arbeiten: verwenden Sie dazu den Datentyp IO).

Zeigen Sie die Kompetenzen hinsichtlich Verwendung geeigneter Strukturen und Algorithmen.

Dokumentieren Sie Ihr Vorgehen. Zeigen Sie auf, wie Sie das Problem in Teilprobleme gegliedert haben (und somit in einzelne Funktionen).

## Erwartete Ergebnisse

- Verwendung von Pure Functions gem. Vorgaben in Kapitel 08 (siehe GitLab)
- Verwendung von Rekursion
- Kurze Präsentation des Programms (max. 5 Minuten)