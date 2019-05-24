create database pizzaria;

use pizzaria;

create table pizza (
	id int AUTO_INCREMENT,
	sabor char(50),
	ingredientes varchar(255),
	preco decimal(7, 2),
	fabricacao date,
	tamanho varchar(25),
	PRIMARY KEY(id)
);

show databases;

show tables;

desc pizza;
