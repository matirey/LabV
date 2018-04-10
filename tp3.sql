create database tp3;

use tp3;

create table juegos (
id int auto_increment primary key,
mesa varchar (50) default null);

create table ganador (
id int not null,
jugador varchar (50) not null,
cartas int not null,
constraint fk_id_juego foreign key (id) references juegos(id));

