create database 과제11;
use 과제11;

create table product(
	pNo int auto_increment primary key,
    pName varchar(20),
    pPrice int,
    pStock int
);

select * from product;