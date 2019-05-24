--   cd \xampp\mysql\bin
--   mysql -u root -p

create database petshop;

use petshop;

create table animais (
	nome char(100),
	nascimnto date,
	peso decimal(5, 2)
);

INSERT INTO animais VALUES ('Rex', '2015-06-09', 7.5);


SELECT * FROM animais;