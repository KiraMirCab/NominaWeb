create table empleados(
dni varchar(9) not null primary key,
nombre varchar(100),
sexo char(1),
categoria int,
anyos int
);

create table nominas(
dni varchar(9) not null primary key,
sueldo int,
foreign key (dni) references empleados(dni)
);
