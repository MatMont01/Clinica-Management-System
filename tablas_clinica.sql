/*
CREATE TABLE [IF NOT EXISTS] table_name (
   column1 datatype(length) column_contraint,
   column2 datatype(length) column_contraint,
   column3 datatype(length) column_contraint,
   table_constraints
);*/
--ALTER SEQUENCE users_id_seq RESTART WITH 1
ALTER sequence especialidadDoctor_id_seq RESTART WITH 1

CREATE TABLE persona(
ci varchar(20),
nombre varchar(20) not null,
apPaterno varchar(20) not null,
apMaterno varchar(20),
telefono text not null unique,
correo varchar(40) unique
);

CREATE TABLE familiarResponsable(
ci varchar(20),
parentesco varchar(20) not null
);

CREATE TABLE paciente(
ci varchar(20),
nombreAseguradora varchar(20) ,
esParticular boolean ,
esAlergico boolean ,
numeroSeguro varchar(20)
);

CREATE TABLE doctor(
ci varchar(20),
matricula varchar(20) unique ,
tarifaConsulta numeric 
);

CREATE TABLE especialidad(
id serial,
nombre varchar(20)
);

CREATE TABLE especialidadDoctor(
id_especialidad int,
ci_doctor varchar(20)
);


CREATE TABLE reserva(
id serial,
ci_doctor varchar(20),
ci_paciente varchar(20),
observaciones text,
fechacaptura date,
fechareserva date,
estatus int default 1

);

CREATE TABLE consulta(
id serial,
id_reserva int,
detalle_consulta text,
fecha date,

);

CREATE TABLE ingreso(
id serial,
id_reserva int,
id_habitacion int,
fecha_entrada date,
fecha_salida date,
Motivo text,
costo_de_internacion numeric
);

CREATE TABLE habitacion(
id serial,
piso int not null,
numero int not null
);

CREATE TABLE cirugia(
id serial,
ingreso_id int,
ci_familiar varchar(20),
costoCirugia numeric,
fecha date,
detalles text ,
horaInicio time,
horaFin time
);

CREATE TABLE doctorResponsable(

ci_doctor varchar(20),
id_cirugia int

);

-----ALTER TABLE ADD RESTRICTIONS
ALTER TABLE persona
ADD PRIMARY KEY (ci);


ALTER TABLE paciente
ADD PRIMARY KEY (ci);

ALTER TABLE paciente
ADD CONSTRAINT FK_Paciente_Persona
FOREIGN KEY (ci) REFERENCES persona(ci);

ALTER TABLE doctor
ADD PRIMARY KEY (ci);

ALTER TABLE doctor
ADD CONSTRAINT FK_Doctor_Persona
FOREIGN KEY (ci) REFERENCES persona(ci);


ALTER TABLE familiarResponsable
ADD PRIMARY KEY (ci);

ALTER TABLE familiarResponsable
ADD CONSTRAINT FK_familiarResponsable_Persona
FOREIGN KEY (ci) REFERENCES persona(ci);


ALTER TABLE especialidad
ADD PRIMARY KEY (id);


ALTER TABLE especialidadDoctor
ADD CONSTRAINT FK_EspecialidadDoctor_Doctor
FOREIGN KEY (ci_doctor) REFERENCES doctor(ci);

ALTER TABLE especialidadDoctor
ADD CONSTRAINT FK_EspecialidadDoctor_Especialidad
FOREIGN KEY (id_especialidad) REFERENCES especialidad(id);


ALTER TABLE reserva
ADD PRIMARY KEY (id);

ALTER TABLE reserva
ADD CONSTRAINT FK_Reserva_Paciente
FOREIGN KEY (ci_paciente) REFERENCES paciente(ci);


ALTER TABLE reserva
ADD CONSTRAINT FK_Reserva_Doctor
FOREIGN KEY (ci_doctor) REFERENCES doctor(ci);


ALTER TABLE consulta
ADD PRIMARY KEY (id,id_reserva);

ALTER TABLE consulta
ADD CONSTRAINT FK_Consulta_Reserva
FOREIGN KEY (id_reserva) REFERENCES reserva(id);

ALTER TABLE habitacion
ADD PRIMARY KEY (id);

ALTER TABLE ingreso
ADD PRIMARY KEY (id);

ALTER TABLE ingreso
ADD CONSTRAINT FK_ingreso_Reserva
FOREIGN KEY (id_reserva) REFERENCES reserva(id);

ALTER TABLE ingreso
ADD CONSTRAINT FK_ingreso_habitacion 
FOREIGN KEY (id_habitacion) REFERENCES habitacion(id);

ALTER TABLE cirugia
ADD PRIMARY KEY (id);

ALTER TABLE cirugia
ADD CONSTRAINT FK_cirugia_ingreso
FOREIGN KEY (ingreso_id) REFERENCES ingreso(id);

ALTER TABLE cirugia
ADD CONSTRAINT FK_cirugia_familiar
FOREIGN KEY (ci_familiar) REFERENCES familiarResponsable(ci);


ALTER TABLE doctorResponsable
ADD PRIMARY KEY (ci_doctor,id_cirugia);

ALTER TABLE doctorResponsable
ADD CONSTRAINT FK_doctorResponsable_doctor
FOREIGN KEY (ci_doctor) REFERENCES doctor(ci);

ALTER TABLE doctorResponsable
ADD CONSTRAINT FK_doctorResponsable_cirugia
FOREIGN KEY (id_cirugia) REFERENCES cirugia(id);



--insert personas
INSERT INTO persona values ('6962120LP','ERIKA CECILIA','ALI','AVERANGA','77045009','aliver12@hotmail.com');
INSERT INTO persona values ('3037257CB','JUAN GABRIEL','ORELLANA','ANZE','77022119','jorellana96@hotmail.com');
INSERT INTO persona values ('9350108CB','ERWIN AMILKAR','LOPEZ',' ANZE','76078129','lopezanuncios@hotmail.com');
INSERT INTO persona values ('2363705LP','RENE ','MORALES','ARANCIBIA','76009045','mmorales112@hotmail.com');
INSERT INTO persona values ('6532361CB','ALEJANDRO','FILY','ASISTIRI','76119045','ale1998@hotmail.com');
INSERT INTO persona values ('4021781OR','HANS GELMER','HUANACO','CACERES','760280987','hansc80@hotmail.com');
INSERT INTO persona values ('3830778SC','DENAR','ROSALES','CALLEJAS','74286154','drosales10@hotmail.com');
INSERT INTO persona values ('5376120SC','RONALD JESUS','ROJAS','CARRILLO','27535443','rcarrillo10@hotmail.com');
INSERT INTO persona values ('4337974LP','ENRIQUE RODRIGO','LIMPIAS','CASTRILLO','85864773','enriquel42@hotmail.com');
INSERT INTO persona values ('4874715LP','MAURICIO ROLANDO','LIMPIAS','CASTRILLO','83279482','mlimpias11@hotmail.com');--comentario familiarResponsable
INSERT INTO persona values ('3557566OR','MIGUEL ANGEL','SANTOS','CHAMBI','69397804','mangel123@hotmail.com');
INSERT INTO persona values ('5060421OR','JOSE LUIS','SANTOS','CHAMBI','83338106','josechambis2003@hotmail.com');--comentario familiarResponsable
INSERT INTO persona values ('3469800LP','MACARIO LEANDRO','MIRANDA','CHIRI','66954303','macarioproducciones1@hotmail.com');
INSERT INTO persona values ('4984222LP','CELESTINO','MIRANDA','CHIRI','90374034','celestinochiri1001@hotmail.com');
INSERT INTO persona values ('9180071LP','JUAN CARLOS','POMA','CHOQUE','93452128','jcpoma10@hotmail.com');
INSERT INTO persona values ('2271225LP','HERNANDO','SUCOJAYO','CHURA','92852123','hernandochura19@hotmail.com');
INSERT INTO persona values ('5241247CB','NELSON ALEX','FERNANDEZ','CONTRERAS','82025301','alexn99@hotmail.com');
INSERT INTO persona values ('4538107CB','FREDDY','FERNANDEZ','CONTRERAS','60129072','contreras100@hotmail.com');
INSERT INTO persona values ('5291354CB','NELLY','FERNANDEZ','CONTRERAS','70045001','nelisita1100@hotmail.com');--comentario familiarResponsable
INSERT INTO persona values ('3544360OR','BRUNO FIDEL','MORA','MORA','60993092','brunomora100@hotmail.com');
INSERT INTO persona values ('3522310OR','RONALD TOMAS','MORA','MORA','64305205','ronalt1000@hotmail.com');--comentario familiarResponsable

INSERT INTO persona values ('3358411LP','JUAN','SUCOJAYO','CHURA','70724828','juansucojayo2@hotmail.com');
INSERT INTO persona values ('4264413LP','DAVID ALBERTO','SADE','CORDERO','68237090','davidclp@hotmail.com');
INSERT INTO persona values ('6991036LP','FRANCISCO','ABELINO','CORTEZ','84606682','albinoc200@hotmail.com');
INSERT INTO persona values ('5059364TJ','DARWIN','VASQUEZ','DONAIRE','74355003','ddonaire1002@hotmail.com');
INSERT INTO persona values ('9756226SC','JUAN PABLO','DAVILA','FERNANDEZ','93345012','jpdavila1@hotmail.com');
INSERT INTO persona values ('6003976LP','JHANNETH','BARRA','FERNANDEZ','86446585','jhannethita94@hotmail.com');
INSERT INTO persona values ('3544300OR','LUDWINGNJOSEPHT','OTAZO','FRONTANILLA','96274838','ludwiconsultas@hotmail.com');

INSERT INTO paciente values('6962120LP','bisa',false,false,'059475472553');
INSERT INTO paciente values('3037257CB','bisa',false,false,'695975245951');
INSERT INTO paciente values('9350108CB','bisa',false,false,'566929540260');
INSERT INTO paciente values('2363705LP','bisa',false,false,'406418443280');
INSERT INTO paciente values('6532361CB','bisa',false,false,'908788888888');
INSERT INTO paciente values('4021781OR','bisa',false,false,'351805893212');
INSERT INTO paciente values('3830778SC','bisa',false,false,'961156499645');
INSERT INTO paciente values('5376120SC','bisa',false,false,'459720139159');
INSERT INTO paciente values('4337974LP','bisa',false,false,'661511790247');--cirujia
INSERT INTO paciente values('3557566OR','bisa',false,false,'488480694839');--cirujia
INSERT INTO paciente values('3469800LP','bisa',false,false,'483811364956');
INSERT INTO paciente values('4984222LP','bisa',false,false,'319178258459');
INSERT INTO paciente values('9180071LP','bisa',false,false,'416803700949');
INSERT INTO paciente values('2271225LP','bisa',false,false,'007730607758');
INSERT INTO paciente values('5241247CB','bisa',false,false,'868627171180');
INSERT INTO paciente values('4538107CB','bisa',false,false,'432548517855');--cirugia
INSERT INTO paciente values('3544360OR','bisa',false,false,'164480900639');--cirugia

INSERT INTO familiarResponsable values('4874715LP','HERMANO');
INSERT INTO familiarResponsable values('5060421OR','PADRE');
INSERT INTO familiarResponsable values('5291354CB','MADRE');
INSERT INTO familiarResponsable values('3522310OR','HERMANO');

INSERT INTO doctor values('3358411LP','331160',250);
INSERT INTO doctor values('4264413LP','934873',150.99);
INSERT INTO doctor values('6991036LP','385858',300);
INSERT INTO doctor values('5059364TJ','976572',250);
INSERT INTO doctor values('9756226SC','457070',399.99);
INSERT INTO doctor values('6003976LP','906042',399.99);
INSERT INTO doctor values('3544300OR','484021',380);

insert into reserva values (default,'3358411LP','6962120LP','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','3037257CB','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','9350108CB','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','2363705LP','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','6532361CB','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','4021781OR','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','3830778SC','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','5376120SC','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','4337974LP','cirujia','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','3557566OR','cirugia','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','3469800LP','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','4984222LP','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','9180071LP','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','2271225LP','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','5241247CB','consulta','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','4538107CB','cirugia','2022-06-17','2022-06-17');
insert into reserva values (default,'3358411LP','3544360OR','cirugia','2022-06-17','2022-06-17');

insert into consulta values(default,1,'resfriado','2002-07-18');
insert into consulta values(default,2,'resfriado','2002-07-18');
insert into consulta values(default,3,'resfriado','2002-07-18');
insert into consulta values(default,4,'resfriado','2002-07-18');
insert into consulta values(default,5,'resfriado','2002-07-18');
insert into consulta values(default,6,'resfriado','2002-07-19');
insert into consulta values(default,7,'resfriado','2002-07-19');
insert into consulta values(default,8,'resfriado','2002-07-19');
insert into consulta values(default,9,'resfriado','2002-07-19');
insert into consulta values(default,10,'resfriado','2002-07-20');
insert into consulta values(default,11,'resfriado','2002-07-20');
insert into consulta values(default,12,'resfriado','2002-07-20');
insert into consulta values(default,13,'resfriado','2002-07-20');
insert into consulta values(default,14,'resfriado','2002-07-20');
insert into consulta values(default,15,'resfriado','2002-07-21');


insert into habitacion values(default,1,101);
insert into habitacion values(default,1,102);
insert into habitacion values(default,1,103);
insert into habitacion values(default,1,104);
insert into habitacion values(default,2,201);
insert into habitacion values(default,2,202);
insert into habitacion values(default,2,203);
insert into habitacion values(default,2,204);




insert into ingreso(default,9,101,'2002-07-17','2002-07-19','operacion menor',1500);
insert into ingreso(default,10,102,'2002-07-18','2002-07-22','operacion mayor',2200);

insert into cirugia(default,1,'4874715LP',900,'2002-07-20','operacion exitosa','23:00:00','23:30:00');
insert into cirugia(default,2,'5060421OR',1900,'2002-07-20','operacion exitosa','23:00:00','23:30:00');


insert into especialidad values(default,'Medicina Interna');
insert into especialidad values(default,'Pediatria');
insert into especialidad values(default,'Ginecologia');
insert into especialidad values(default,'Oftalmologia');
insert into especialidad values(default,'Otorrinolaringologia');
insert into especialidad values(default,'Cardiologia');
insert into especialidad values(default,'Neurologia');
insert into especialidad values(default,'Urologia');
insert into especialidad values(default,'Dermatologia');
insert into especialidad values(default,'Cirugia');








--------consultas realizadas por doctor y por paciente----------------------
select p.nombre as doctor ,pa.nombre as paciente, (d.tarifaconsulta * count(c.id_reserva)) as total from doctor d
join reserva r on d.ci = r.ci_doctor and  r.estatus = 2
join consulta c on c.id_reserva = r.id 
join persona p on p.ci = d.ci 
join persona pa on pa.ci = r.ci_paciente 
group by p.nombre ,pa.nombre,d.tarifaconsulta;
----------------------------------------------------------------------------


---------------------------------funcion que limpia de la tabla reserva las reservas que estan caducadas.----------------------------
create or replace function limpiaReservas()
returns  void as

$$

begin 
	--select * from reserva;
	--select * from reserva r where r.estatus =1 and fechareserva < current_date-1;
	update reserva set estatus = 0 where estatus =1 and fechareserva < current_date-1;
	

	
end;
$$
language plpgsql;
------------------------------------------------------------------------------------------------------------------------------------
select limpiaReservas() ;

------------------------------------------------------------------------------------------------------------------------------------
------------------Funcion con trigger que limpia la tabla de reserva cuando una reserva fue atendida--------------------------------------------
create or replace function reservaRealizada()
returns trigger as

$$

begin 
	
	update reserva set estatus = 2 where id = new.id_reserva ;
	return new;
	

	
end;
$$
language plpgsql;

--trigger que que se ejecuta cuando una reserva es atendida en consulta
create or replace trigger  cambiarEstatusReserva
after insert  on consulta
for each row execute procedure reservaRealizada();

--trigger que que se ejecuta cuando una reserva es atendida en ingreso
create or replace trigger  cambiarEstatusReserva
after insert  on ingreso
for each row execute procedure reservaRealizada();

---------------------------------------------------------------------------------------------
---------------------------trigger que guarda el la tabla doctor responsable al doctor que figura en la tabla reserva-------------------
create or replace function insertarDoctorResponsable()
returns trigger as
$$
declare 
v_doctorID varchar;
begin 
	
	--select r.ci_doctor into v_doctorID from reserva r
	--join ingreso i on i.id_reserva = r.id 
	--join cirugia c on c.ingreso_id = i.id and c.id = new.id;


	select r.ci_doctor into v_doctorID from cirugia c 
	join ingreso i on c.ingreso_id = i.id 
	join reserva r on i.id_reserva = r.id 
	where c.id = new.id;
	
	
	insert into doctorresponsable values(v_doctorID,new.id);
	return new;
	
end
$$
language plpgsql;


create trigger  doctorResponsable
after insert  on cirugia
for each row execute procedure insertarDoctorResponsable();
-------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------
---Todas las reservas activas;
select r.id ,r.fechacaptura ,r.fechareserva  ,concat(p.nombre||' '||p.appaterno||' '||p.apmaterno  )as nombreDoctor, 
concat(pa.nombre||' '||pa.appaterno||' '||pa.apmaterno)as nombrepaciente, r.observaciones from reserva r 
join persona p on r.ci_doctor = p.ci 
join persona pa on r.ci_paciente = pa.ci
where r.estatus = 1;



select * from reserva where estatus = 1;

----------------------------------------------------------------------------------------------------------------------

--mostrar las reservas activas por doctor
select r.id ,r.fechacaptura ,r.fechareserva  ,concat(p.nombre||' '||p.appaterno||' '||p.apmaterno  )as nombreDoctor,
concat(pa.nombre||' '||pa.appaterno||' '||pa.apmaterno)as nombrepaciente, r.observaciones from reserva r
join persona p on r.ci_doctor = p.ci
join persona pa on r.ci_paciente = pa.ci
where r.estatus = 1 ;


 ---trigger para eliminar en cascada despues de eliminar un paciente;
create or replace function eliminarPaciente()
returns trigger as
$$
begin
	delete from persona where ci = new.ci;
	delete from ingreso where ci_paciente = new.ci;
	delete from cirugia where ci_paciente = new.ci;
	delete from consulta where ci_paciente = new.ci;
	delete from doctorresponsable where ci = new.ci;
	delete from reserva where ci_paciente = new.ci;
	return new;
end;
$$
language plpgsql;

create trigger eliminarPaciente
after delete on paciente
for each row execute procedure eliminarPaciente();
----------------------------------------------------------------------------------
--Informacion de doctor en apartado de doctor boton mostrar
select carnet,nombre,costo,especialidades from 
(select p.nombre ||' '|| p.appaterno  || ' '||p.apmaterno as nombre,p.ci as carnet,e2.nombre as especialidades,d.tarifaconsulta as costo from especialidaddoctor e
join doctor d on d.ci = e.ci_doctor 
join especialidad e2 on e2.id = e.id_especialidad 
join persona p on p.ci = d.ci)a


------Informacion de personas que no son paciente
select * from persona where ci not in (select ci from paciente);


----informacion de familiar responsable y del paciente del que son responsables

select p.ci as ciPaciente ,concat(p.nombre||' '||p.appaterno||' '||p.apmaterno)as nombrePaciente,p2.ci as cifamiliar, concat(p2.nombre||' '||p2.appaterno||' '||p2.apmaterno) as nombreFamiliarResponsable,f.parentesco  from persona p
join reserva r on r.ci_paciente = p.ci 
join ingreso  i on i.id_reserva = r.id
join cirugia c on c.ingreso_id = i.id
join familiarresponsable f on f.ci = c.ci_familiar 
join persona p2 on p2.ci  = f.ci;

--mostrar la el nombre del doctor responsable y del paciente de reservas que derivaron en una cirugia
--mostrar cirugias y doctor responsable

select c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre as doctorResponsable,d.ci_doctor from reserva r
join ingreso i on i.id_reserva = r.id
join cirugia c on c.ingreso_id = i.id
join doctorresponsable d on d.ci_doctor  = r.ci_doctor
join persona p on p.ci = d.ci_doctor
group by c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre ,d.ci_doctor;

create or replace function fechaCaptura()
returns trigger
as $$
begin
	new.fechacaptura = now();
	return new;
end
$$ language plpgsql;

CREATE or replace TRIGGER fechaCaptura
AFTER INSERT ON reserva
FOR EACH ROW EXECUTE PROCEDURE fechaCaptura();

create or replace procedure fechaCaptura()
as $$
begin
	update reserva set fechacaptura = now();
end
$$ language plpgsql;


--generar una view que muestre el historial clinico del paciente incluidas el costo de la cirugia o la consulta
create or replace view historialclinico as
select c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre as doctorResponsable,d.ci_doctor from reserva r
join ingreso i on i.id_reserva = r.id
join cirugia c on c.ingreso_id = i.id
join doctorresponsable d on d.ci_doctor  = r.ci_doctor
join persona p on p.ci = d.ci_doctor
group by c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre ,d.ci_doctor;

--lamar view historialclinico
select * from historialclinico;

--hacer que en el que el registro de una cirugia las horas tienen que se atravez de 4 numeros
create or replace function horaCirugia()
returns trigger
as $$
begin
	new.horainicio = new.horainicio::text::integer::text;
	new.horafin = new.horafin::text::integer::text;
	return new;
end
$$ language plpgsql;

CREATE or replace TRIGGER horaCirugia
AFTER INSERT ON cirugia
FOR EACH ROW EXECUTE PROCEDURE horaCirugia();

create or replace procedure horaCirugia()
as $$
begin
	update cirugia set horainicio = new.horainicio::text::integer::text;
	update cirugia set horafin = new.horafin::text::integer::text;
end
$$ language plpgsql;

--generar una view que muestre el historial clinico del paciente incluidas el costo de la cirugia o la consulta
create or replace view historialclinico as
select c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre as doctorResponsable,d.ci_doctor from reserva r
join ingreso i on i.id_reserva = r.id
join cirugia c on c.ingreso_id = i.id
join doctorresponsable d on d.ci_doctor  = r.ci_doctor
join persona p on p.ci = d.ci_doctor
group by c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre ,d.ci_doctor;

--lamar view historialclinico
select * from historialclinico;

--hacer que en el que el registro de una cirugia las horas tienen que se atravez de 4 numeros
create or replace function horaCirugia()
returns trigger
as $$
begin
	new.horainicio = new.horainicio::text::integer::text;
	new.horafin = new.horafin::
	return new;
end
$$ language plpgsql;




