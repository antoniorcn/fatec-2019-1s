create database jogos;
use jogos;

create table jogo ( 
	id int AUTO_INCREMENT PRIMARY KEY, 
	nome char(100), 
	genero varchar(30), 
	preco decimal(6, 2), 
	lancamento date
);