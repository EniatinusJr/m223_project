# Applikation für die Buchung von Co-Working Arbeitsplätzen
Mit dieser Applikation kann man über Rest-Endpunkte Arbeitsplätze in einem Co-Workingspace buchen, wie auch ein Meetingraum falls nötigen oder zusätzliches Equipment. Als Besucher kann man sich Registrieren und Anmelden. Als Administrator kann man Buchungen editieren, löschen, akzeptieren oder ablehnen und Mitglieder verwalten.

## Projekt aufsetzten
- Das Projekt klonen
- Mit VS Code öffnen und auf Reopen in Container klicken

## Projekt starten
- Im Dev Container die Quarkus Extension installieren
- Mit Quarkus: Debug current Quarkus Project die Applikation starten

## Testdaten
Die Testdaten werden im import.sql file definiert, welches im resources folder des projektes liegt. Da sie im resources folder des Projekt liegen, werden sie direkt beim starten der Applikation in die Datenbank geschrieben.

## Änderungen an den Fachklassen
- startTime und endTime aus der Entity MeetingRaum genommen und in die Booking Entity bewegt, dadurch können, falls ein Raum zu der Buchung dazu kommt, die Start- und Endzeit festgelegt werden.
- Namen der Entitäten von Deutsch auf Englisch geändert um konsistent beim naming zu bleiben.

## API testen
Die API Dokumentation ist unter http://localhost:8080/q/swagger-ui/ zu finden.

## Testen
Die  Tests können mit ./mvnw quarkus:test ausgeführt werden oder nach dem starten der Applikation im Quarkus terminal r drücken.

### Logindaten für Applikation:
- Administrator: 
    Benutzername= maurin@schucan.ch
    Passwort= testlol1234

- Mitglied:
    Benutzername= mattia.loiarro@gmail.com
    Passwort= daddychamber69

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

### Link zum Repository
https://github.com/EniatinusJr/m223_project/tree/master