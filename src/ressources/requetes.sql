insert into agent(id,nom,prenom,date_de_naissance) values (1,"jean","rachid",to_date("10/03/1998","DD/MM/YYYY"));



delete from materiel where id = 1;
delete from materiel where id = 2;
delete from materiel where id = 3;
delete from materiel where id = 4;
delete from materiel where id = 5;
delete from materiel where id = 6;
delete from materiel where id = 7;
delete from materiel where id = 8;
delete from materiel where id = 9;
delete from materiel where id = 10;
delete from materiel where id = 11;
delete from materiel where id = 12;
delete from materiel where id = 13;
delete from materiel where id = 14;


insert into materiel(id,libelle,quantite) values (1,"mousqueton",15);
insert into materiel(id,libelle,quantite) values (2,"gant d intervention",10);
insert into materiel(id,libelle,quantite) values (3,"ceinture de sécurité tactique",20);
insert into materiel(id,libelle,quantite) values (4,"détecteur de métal",25);
insert into materiel(id,libelle,quantite) values (5,"brassard de sécurité",30);
insert into materiel(id,libelle,quantite) values (6,"lampe torche",5);
insert into materiel(id,libelle,quantite) values (7,"bandeau agent cynophile",5);
insert into materiel(id,libelle,quantite) values (8,"gilet pare-balles",12);
insert into materiel(id,libelle,quantite) values (9,"chemise manches courtes",30);
insert into materiel(id,libelle,quantite) values (10,"blouson",30);
insert into materiel(id,libelle,quantite) values (11,"coupe-vent",30);
insert into materiel(id,libelle,quantite) values (12,"talkie walkie",20);
insert into materiel(id,libelle,quantite) values (13,"kit oreillette",10);
insert into materiel(id,libelle,quantite) values (14,"taser",5);
commit;
