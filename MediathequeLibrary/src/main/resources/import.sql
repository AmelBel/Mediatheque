insert into user (login, password, nom, prenom) values ('amelbeloudane@gmail.com', 'secret','BELOUDANE','Amel');
insert into user (login, password, nom, prenom) values ('davidmax@gmail.com', 'secret','MAUX','David');
insert into user (login, password, nom, prenom) values ('camillechinaux@gmail.com', 'secret','CHINAUX','Camille');




insert into document (id, titre, nombre_Exemplaire, date_Parution) values (1, 'Good', 2, '12-10-16');
insert into document (id, titre, nombre_Exemplaire, date_Parution) values (2, 'True', 4, '01-01-17'); 

insert into livres (id, ecrivain, numero_isbn) values (1, 'amel', 1253); 
insert into cd (id, artiste_groupe, duree, nombre_titre) values (1, 'amel', 50, 5);
insert into dvd(id, realisateur, duree, type) values (1, 'amel', 80, 'blue_ray' ); 


insert into livres (id, ecrivain, numero_isbn) values (2, 'david', 5623); 
insert into cd (id, artiste_groupe, duree, nombre_titre) values (2, 'david', 120, 6);
insert into dvd(id, realisateur, duree, type) values (2, 'david', 200, 'normal' );


insert into user_documents (user_id, documents_id) values (1,1);
insert into user_documents (user_id, documents_id) values (1,2);  



 




