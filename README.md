# Appliation für die Buchung von Co-Working Arbeitsplätzen
Mit dieser Applikation kann man über Rest-Endpunkte Arbeitsplätze in einem Co-Workingspace buchen, wie auch ein Meetingraum falls nötigen oder zusätzliches Equipment.

## Projekt aufsetzten
- Das Projekt klonen
- Mit VS Code öffnen in auf Reopen in Container klicken

## Projekt starten
- Im Dev Container die Quarkus Extension installieren
- Mit Quarkus: Debug current Quarkus Project die Applikation starten

## Testdaten
Die Testdaten werden im import.sql file definiert, welches im resources folder des projektes liegt. Da sie im resources folder des Projekt liegen, werden sie direkt beim starten der Applikation in die Datenbank geschrieben.

## Änderungen an den Fachklassen
- startTime und endTime aus der Entity MeetingRaum genommen und in die Booking Entity bewegt, dadurch können, falls ein Raum zu der Buchung dazu kommt, die Start- und Endzeit festgelegt werden.
- Namen der Entitäten von Deutsch auf Englisch geändert um konsistent beim naming zu bleiben.
