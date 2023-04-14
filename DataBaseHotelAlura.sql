CREATE DATABASE hotel_alura;

USE hotel_alura;

CREATE TABLE reservas(
id int auto_increment not null primary key,
fecha_entrada date,
fecha_salida date,
valor double,
forma_pago varchar(150)
);

CREATE TABLE huespedes(
id int auto_increment not null primary key,
nombre varchar(100),
apellido varchar(100),
fecha_nacimiento date,
nacionalidad varchar(250),
telefono varchar(25),
id_reserva int not null,
constraint fk_id_reserva foreign key (id_reserva) references reservas (id) on update cascade on delete cascade
);
