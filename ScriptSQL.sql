CREATE TABLE Centre_Interet
(
Id INTEGER NOT NULL IDENTITY,
Nom varchar(30)
);

CREATE TABLE Geek
(
Id Integer NOT NULL IDENTITY,
Nom varchar(30),
Prenom varchar(30),
Mail varchar(30),
CouleurCheveux varchar(30),
CouleurYeux varchar(30),
Taille Integer,
poids Integer
);

CREATE TABLE GEEK_CENTRE_INTERET
(
IDGEEK INTEGER NOT NULL,
IDCENTREINTERET INTEGER NOT NULL
);

INSERT INTO "PUBLIC"."CENTRE_INTERET"
( "NOM" )
VALUES ( 'Boxe');

INSERT INTO "PUBLIC"."CENTRE_INTERET"
( "NOM" )
VALUES ( 'Voiture');

INSERT INTO "PUBLIC"."CENTRE_INTERET"
( "NOM" )
VALUES ( 'Moto');

INSERT INTO "PUBLIC"."CENTRE_INTERET"
( "NOM" )
VALUES ( 'Vélo');


INSERT INTO "PUBLIC"."GEEK"
( "NOM", "PRENOM", "MAIL", "COULEURCHEVEUX", "COULEURYEUX", "TAILLE", "POIDS" )
VALUES ( 'Deydier', 'Julien', 'juliendeydier@gmail.com', 'Brun', 'Marron, Vert', 170,60 );

INSERT INTO "PUBLIC"."GEEK_CENTRE_INTERET"
( "IDGEEK", "IDCENTREINTERET" )
VALUES (0 ,1 );

INSERT INTO "PUBLIC"."GEEK_CENTRE_INTERET"
( "IDGEEK", "IDCENTREINTERET" )
VALUES (0 ,2 );

INSERT INTO "PUBLIC"."GEEK_CENTRE_INTERET"
( "IDGEEK", "IDCENTREINTERET" )
VALUES (0 ,3 );