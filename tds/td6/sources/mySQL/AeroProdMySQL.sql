
drop database if exists aero  ;
create database aero;
use aero;

CREATE TABLE avion
(
Numav INTEGER,
Capacite INTEGER,
type VARCHAR(10),
Entrepot VARCHAR(30),
CONSTRAINT pk_avion PRIMARY KEY (Numav)
);

CREATE TABLE pilote
(
Matricule INTEGER ,
Nom VARCHAR(25) NOT NULL,
Ville VARCHAR(30),
Age INTEGER,
Salaire INTEGER,
CONSTRAINT pk_pilote PRIMARY KEY (Matricule)
);

CREATE TABLE passager
(
Numab INTEGER,
Nomab VARCHAR(25),
CONSTRAINT pk_passager PRIMARY KEY (Numab)
);

CREATE TABLE vol
(
Numvol VARCHAR(10),
HeureDepart TIME,
HeureArrivee TIME,
VilleDepart VARCHAR(25),
VilleArrivee VARCHAR(25),
CONSTRAINT pk_vol PRIMARY KEY (Numvol)
);

CREATE TABLE depart
(
Numvol VARCHAR(10),
DateDepart DATE,
numav INTEGER,
Matricule INTEGER,
CONSTRAINT pk_depart PRIMARY KEY (numvol, DateDepart)
);

CREATE TABLE Reservation
(
Numab INTEGER,
Numvol VARCHAR(10),
DateDepart DATE,
CONSTRAINT pk_reservation PRIMARY KEY (numab, numvol, DateDepart)
);

ALTER TABLE depart
ADD CONSTRAINT fk_depart_vol
	FOREIGN KEY(numvol)
	REFERENCES Vol(numvol)
	ON DELETE CASCADE;

ALTER TABLE depart
ADD CONSTRAINT fk_depart_avion
	FOREIGN KEY(numav)
	REFERENCES Avion(numav)
	ON DELETE CASCADE;
	
ALTER TABLE depart
ADD CONSTRAINT fk_depart_pilote
	FOREIGN KEY(matricule)
	REFERENCES Pilote(matricule)
	ON DELETE CASCADE;

ALTER TABLE Reservation
ADD CONSTRAINT fk_reservation_depart
	FOREIGN KEY(numvol, DateDepart)
	REFERENCES Depart(numvol, DateDepart)
	ON DELETE CASCADE;
	
ALTER TABLE Reservation
ADD CONSTRAINT fk_reservation_passager
	FOREIGN KEY(numab)
	REFERENCES Passager(numab)
	ON DELETE CASCADE;

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

insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF421', str_to_date('02:30','%H:%i'), str_to_date('08:30','%H:%i'),'Paris','New_York');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF422', str_to_date('8:30','%H:%i'), str_to_date('9:30','%H:%i'),'New_York','Boston');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF333', str_to_date('2:30','%H:%i'), str_to_date('8:30','%H:%i'),'New_York','Ajaccio');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AL1989', str_to_date('11:30','%H:%i'), str_to_date('12:30','%H:%i'),'New_York','Montréal');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF300', str_to_date('13:30','%H:%i'), str_to_date('19:30','%H:%i'),'New_York','Paris');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF900', str_to_date('13:30','%H:%i'), str_to_date('19:30','%H:%i'),'New_York','Paris');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AF800', str_to_date('11:30','%H:%i'), str_to_date('16:30','%H:%i'),'New_York','Londres');
insert into vol (Numvol, HeureDepart, HeureArrivee, VilleDepart, VilleArrivee)
values('AL902', str_to_date('9:30','%H:%i'), str_to_date('15:30','%H:%i'),'Paris','Boston');

insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF421','2019-12-19',1,10);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF422','2019-12-19',1,10);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AL1989','2019-4-1',1,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF333','2019-10-13',2,30);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF900','2019-10-07',9,30);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF333','2019-12-25',3,30);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF300','2019-01-25',9,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF900','2019-11-07',9,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF800','2019-11-07',9,20);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AL902','2019-12-07',9,10);

insert into reservation (Numab, Numvol, DateDepart)
values(100,'AF333','2019-12-25');
insert into reservation (Numab, Numvol, DateDepart)
values(100,'AF421','2019-12-19');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF333','2019-12-25');
insert into reservation (Numab, Numvol, DateDepart)
values(300,'AF333','2019-10-13');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF421','2019-12-19');
insert into reservation (Numab, Numvol, DateDepart)
values(400,'AF300','2019-01-25');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AL1989','2019-4-1');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF300','2019-01-25');
insert into reservation (Numab, Numvol, DateDepart)
values(200,'AF800','2019-11-07');
insert into reservation (Numab, Numvol, DateDepart)
values(100,'AF800','2019-11-07');

commit;