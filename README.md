# Appliation für die Buchung von Co-Working Arbeitsplätzen
Mit dieser Applikation kann man über Rest-Endpunkte Arbeitsplätze in einem Co-Workingspace buchen, wie auch ein Meetingraum falls nötigen oder zusätzliches Equipment. Als Besucher kann man sich Registrieren und Anmelden. Als Administrator kann man Buchungen editieren, löschen, akzeptieren oder ablehnen und Mitglieder verwalten.

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


### Logindaten für Applikation:
- Administrator: 
    Benutzername= maurin@schucan.ch
    Passwort= testlol1234

- Mitglied:
    Benutzername= mattia.loiarro@gmail.com
    Passwort= daddychamber69

### Link zum Repository
https://github.com/EniatinusJr/m223_project/tree/master