--   cd \xampp\mysql\bin

--   mysql -u root -p

create database jogosdb;

show databases;

use jogosdb;

create table jogos (
	id int AUTO_INCREMENT,
	nome char(100),
	genero char(30),
	ja_jogou boolean,
	recomendar boolean,
	image_capa varchar(255),
	PRIMARY KEY(id)
);

show tables;

desc jogos;

INSERT INTO jogos VALUES (0, 'Pac man', 'labirinto', 1, 1, '');

SELECT * FROM jogos;

UPDATE jogos SET nome='Pac-man' WHERE id=1;