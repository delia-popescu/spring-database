/*create table person(
	id integer,
	name varchar(255),
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);*/

/*insert into person values (10001, 'Delia', 'Bucuresti', CURRENT_TIMESTAMP());
insert into person values(10002, 'Lars', 'Munchen', CURRENT_TIMESTAMP());
insert into person values (10003, 'Dan', 'Cluj-Napoca', CURRENT_TIMESTAMP());*/

/*for schema auto generation - the order of the columns is different*/
insert into person values (10001, sysdate(), 'Bucuresti', 'Delia');
insert into person values(10002, sysdate(), 'Munchen', 'Lars');
insert into person values (10003, sysdate(), 'Cluj-Napoca', 'Dan');