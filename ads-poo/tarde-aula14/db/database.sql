create database cartoon;

use cartoon;

create table personagem (
		id int NOT NULL AUTO_INCREMENT,
		nome char(100),
		altura decimal(7, 2),
		forca decimal(7, 2),
		habilidade varchar(255), 
		do_mal boolean, 
		nascimento date,
		PRIMARY KEY(id) );