# Änderungen an den Fachklassen
- startTime und endTime aus der Entity MeetingRaum genommen und in die Booking Entity bewegt, dadurch können, falls ein Raum zu der Buchung dazu kommt, die Start- und Endzeit festgelegt werden.
- Namen der Entitäten von Deutsch auf Englisch geändert um konsistent beim naming zu bleiben.

# Testdaten
Die Testdaten werden im import.sql file definiert, welches im resources folder des projektes liegt. Da sie im resources folder des Projekt liegen, werden sie direkt beim starten der Applikation in die Datenbank geschrieben.