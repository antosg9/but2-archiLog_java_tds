SET FEEDBACK OFF
SET LINESIZE 150
SET PAGESIZE 40

REM **************************************************************************
REM BASE AERO
REM Auteur : Jerome FESSY
REM ***************************************************************************

ALTER SESSION SET NLS_DATE_FORMAT = 'dd/mm/yyyy';

PROMPT --> DEBUT DU SCRIPT

REM ** Requête SQL de création des tables **

DROP TABLE reservation CASCADE CONSTRAINTS PURGE
/
DROP TABLE vol CASCADE CONSTRAINTS PURGE
/
DROP TABLE depart CASCADE CONSTRAINTS PURGE
/
DROP TABLE avion CASCADE CONSTRAINTS PURGE
/
DROP TABLE pilote CASCADE CONSTRAINTS PURGE
/
DROP TABLE passager CASCADE CONSTRAINTS PURGE
/

PROMPT CREATION DES TABLES

CREATE TABLE avion
(
Numav INTEGER CONSTRAINT pk_avion PRIMARY KEY,
Capacite INTEGER,
type VARCHAR2(10),
Entrepot VARCHAR2(30)
)
/

CREATE TABLE pilote
(
Matricule INTEGER CONSTRAINT pk_pilote PRIMARY KEY,
Nom VARCHAR2(25) NOT NULL,
Ville VARCHAR2(30),
Age INTEGER,
Salaire INTEGER
)
/

CREATE TABLE passager
(
Numab INTEGER CONSTRAINT pk_passager PRIMARY KEY,
Nomab VARCHAR2(25)
)
/

CREATE TABLE vol
(
Numvol VARCHAR2(10) CONSTRAINT pk_vol PRIMARY KEY,
HeureDepart DATE,
HeureArrivee DATE,
VilleDepart VARCHAR2(25),
VilleArrivee VARCHAR2(25)
)
/

CREATE TABLE depart
(
Numvol VARCHAR2(10),
DateDepart DATE,
numav INTEGER,
Matricule INTEGER,
CONSTRAINT pk_depart PRIMARY KEY (numvol, DateDepart)
)
/

CREATE TABLE Reservation
(
Numab INTEGER,
Numvol VARCHAR2(10),
DateDepart DATE,
CONSTRAINT pk_reservation PRIMARY KEY (numab, numvol, DateDepart)
)
/

ALTER TABLE depart
ADD CONSTRAINT fk_depart_vol
	FOREIGN KEY(numvol)
	REFERENCES Vol(numvol)
	ON DELETE CASCADE
ADD CONSTRAINT fk_depart_avion
	FOREIGN KEY(numav)
	REFERENCES Avion(numav)
	ON DELETE CASCADE
ADD CONSTRAINT fk_depart_pilote
	FOREIGN KEY(matricule)
	REFERENCES Pilote(matricule)
	ON DELETE CASCADE
/

ALTER TABLE Reservation
ADD CONSTRAINT fk_reservation_depart
	FOREIGN KEY(numvol, DateDepart)
	REFERENCES Depart(numvol, DateDepart)
	ON DELETE CASCADE
ADD CONSTRAINT fk_reservation_passager
	FOREIGN KEY(numab)
	REFERENCES Passager(numab)
	ON DELETE CASCADE
/


REM ** Les Requêtes d'insertion de données

PROMPT INSERTION D'AVIONS

insert into avion (Numav, Capacite, Type, Entrepot)
values(1,2,'COUCOU','Marolles-en-Hurepoix');
insert into avion (Numav, Capacite, Type, Entrepot)
values(2,600,'ICBM','New-York');
insert into avion (Numav, Capacite, Type, Entrepot)
values(3,100,'B907','Tarascon');
insert into avion (Numav, Capacite, Type, Entrepot)
values(4,500,'A320','Tarascon');
insert into avion (Numav, Capacite, Type, Entrepot)
values(5,50,'A220','Pogo Togo');
insert into avion (Numav, Capacite, Type, Entrepot)
values(6,500,'A320','Tarascon');
insert into avion (Numav, Capacite, Type, Entrepot)
values(7,600,'ICBM','New-York');
insert into avion (Numav, Capacite, Type, Entrepot)
values(8,600,'ICBM','New-York');
insert into avion (Numav, Capacite, Type, Entrepot)
values(9,100,'B907','Pogo Togo');

PROMPT INSERTION DE PILOTES

insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(10,'Amandier','Cherbourg',24,4000);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(20,'Dupond','Coutance',35,2600);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(30,'Citrae','Coutance',44,3300);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(40,'Soblet','Caen',25,3350);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(50,'Oliver','Bayeux',25,3600);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(60,'Razli','Caen',55,6500);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(70,'Traly','Caen',24,4000);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(80,'Buoin','Cherbourg',35,8600);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(90,'Datru','Saint Lo',44,7300);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(100,'Sableau','Herouville',19,2300);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(110,'Oliver','Herouville',25,5600);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(120,'Frona','Caen',50,NULL);

PROMPT INSERTION DE PASSAGERS

insert into passager (Numab, Nomab)
values(100,'Léonce');
insert into passager (Numab, Nomab)
values(200,'Bovary');
insert into passager (Numab, Nomab)
values(300,'Blanc');
insert into passager (Numab, Nomab)
values(400,'Marron');
insert into passager (Numab, Nomab)
values(500,'Vendeuvre');
insert into passager (Numab, Nomab)
values(600,'Gardoni');
insert into passager (Numab, Nomab)
values(700,'Martion');
insert into passager (Numab, Nomab)
values(800,'Venanu');

PROMPT INSERTION DE VOLS

insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF421', to_date('2:30','hh24:mi'), to_date('8:30','hh24:mi'),'Paris','New_York');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF422', to_date('8:30','hh24:mi'), to_date('9:30','hh24:mi'),'New_York','Boston');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF333', to_date('2:30','hh24:mi'), to_date('8:30','hh24:mi'),'New_York','Ajaccio');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AL1989', to_date('11:30','hh24:mi'), to_date('12:30','hh24:mi'),'New_York','Montréal');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF300', to_date('13:30','hh24:mi'), to_date('19:30','hh24:mi'),'New_York','Paris');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF900', to_date('13:30','hh24:mi'), to_date('19:30','hh24:mi'),'New_York','Paris');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF800', to_date('11:30','hh24:mi'), to_date('16:30','hh24:mi'),'New_York','Londres');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AL902', to_date('9:30','hh24:mi'), to_date('15:30','hh24:mi'),'Paris','Boston');

PROMPT INSERTION DE DEPARTS

insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF421','19-12-2019',1,10);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF422','19-12-2019',1,10);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AL1989','1-4-2019',1,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF333','13-10-2019',2,30);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF900','07-10-2019',9,30);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF333','25-12-2019',3,30);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF300','25-01-2019',9,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF900','07-11-2019',9,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF800','07-11-2019',9,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AL902','07-12-2019',9,10);

PROMPT INSERTION DE RESERVATIONS

insert into reservation (Numab, Numvol, DateDepart)
values(100,'AF333','25-12-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(100,'AF421','19-12-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF333','25-12-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(300,'AF333','13-10-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF421','19-12-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(400,'AF300','25-01-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AL1989','1-4-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF300','25-01-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF800','07-11-2019');
insert into reservation (Numab, Numvol, DateDepart)
values(100,'AF800','07-11-2019');


PROMPT --> SCRIPT COMPLETEMENT TERMINE

commit;

SET FEEDBACK ON
