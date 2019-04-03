create database alugueis;

use alugueis;

create table alguel_carro (
	id int PRIMARY KEY AUTO_INCREMENT,
	modelo varchar(100),
	data_inicio date,
	dias int,
	valor_diaria decimal(6, 2)	
);