INSERT INTO "Role" (role) VALUES ('Mitglied');
INSERT INTO "Role" (role) VALUES ('Administrator');

INSERT INTO "MeetingRoom" (roomnumber, size) VALUES (2,4);
INSERT INTO "MeetingRoom" (roomnumber, size) VALUES (5,5);
INSERT INTO "MeetingRoom" (roomnumber, size) VALUES (7,6);
INSERT INTO "MeetingRoom" (roomnumber, size) VALUES (12,7);

INSERT INTO "Equipment" (name, price) VALUES ('Monitor',13.59);
INSERT INTO "Equipment" (name, price) VALUES ('Maus',5.50);
INSERT INTO "Equipment" (name, price) VALUES ('Tastatur',7.99);
INSERT INTO "Equipment" (name, price) VALUES ('Stift',2.30);

INSERT INTO "User" (email, password, prename, surname, role_id) VALUES ('maurin@schucan.ch','testlol1234','Maurin','Schucan',2);
INSERT INTO "User" (email, password, prename, surname, role_id) VALUES ('mattia.loiarro@gmail.com','daddychamber69','Mattia','Loiarro',1);
INSERT INTO "User" (email, password, prename, surname, role_id) VALUES ('tobias.bertschi@gmail.com','lostboy4ever','Tobias','Bertschi',1);

INSERT INTO "Booking" (bookingnumber, date, note, status, wholeday, user_id, endtime, starttime, meetingroom_id) VALUES (12345678, TO_TIMESTAMP('2022-11-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'approval awaiting', true, 2, NULL, NULL, NULL);
INSERT INTO "Booking" (bookingnumber, date, note, status, wholeday, user_id, endtime, starttime, meetingroom_id) VALUES (123456789, TO_TIMESTAMP('2022-11-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'approval awaiting', false, 3, TO_TIMESTAMP('2022-11-25 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-11-25 10:30:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

INSERT INTO "booking_equipments" (booking_id, equipment_id) VALUES (1, 2);