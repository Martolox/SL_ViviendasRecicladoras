DROP SCHEMA IF EXISTS viviendas_recicladoras;
CREATE SCHEMA viviendas_recicladoras;
USE viviendas_recicladoras;

CREATE TABLE duenio (
	dni_duenio          VARCHAR(8) NOT NULL,
	nom_duenio          VARCHAR(40) NOT NULL,
	ape_duenio          VARCHAR(40) NOT NULL,
	correo              VARCHAR(60),
	telefono            VARCHAR(10),
	fecha               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(dni_duenio)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE vivienda (
	id_vivienda         VARCHAR(8) NOT NULL,
	dni_duenio          VARCHAR(8) NOT NULL,
	direccion           VARCHAR(80) NOT NULL,
	zona                VARCHAR(20) NOT NULL,
	barrio              VARCHAR(20) NOT NULL,
	PRIMARY KEY (id_vivienda),
	FOREIGN KEY(dni_duenio) REFERENCES duenio(dni_duenio) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ubicacion (
	id_ubicacion        VARCHAR(8) NOT NULL,
	dni_duenio          VARCHAR(8) NOT NULL,
	longitud            DOUBLE NOT NULL,
	latitud             DOUBLE NOT NULL,
	PRIMARY KEY (id_ubicacion),
	FOREIGN KEY(dni_duenio) REFERENCES duenio(dni_duenio) ON DELETE CASCADE ON UPDATE CASCADE
	) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE personal (
	dni_personal        VARCHAR(8) NOT NULL,
	nom_personal        VARCHAR(40) NOT NULL,
	ape_personal        VARCHAR(40) NOT NULL,
	PRIMARY KEY(dni_personal)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE campania (
	id_campania			VARCHAR(8) NOT NULL,
	dni_duenio          VARCHAR(8) NOT NULL,
	puntos              INT(6),
	benef_activos       VARCHAR(200),
	PRIMARY KEY(id_campania),
	FOREIGN KEY(dni_duenio) REFERENCES duenio(dni_duenio) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE orden (
	id_orden            INT(6) NOT NULL AUTO_INCREMENT,
	dni_duenio          VARCHAR(8) NOT NULL,
	dni_personal        VARCHAR(8) NOT NULL,
	fecha               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	estado              ENUM('PENDIENTE','EN_EJECUCION','CONCRETADO','CANCELADO') NOT NULL,
	plastico            FLOAT(6),   
	papel               FLOAT(6),
	vidrio              FLOAT(6),
	metal               FLOAT(6),
    vehiculo_pesado     BOOLEAN NOT NULL,
	obs_orden           VARCHAR(160) NOT NULL,
	PRIMARY KEY(id_orden),
	FOREIGN KEY(dni_duenio) REFERENCES duenio(dni_duenio) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(dni_personal) REFERENCES personal(dni_personal) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE visita (
	id_visita           INT(6) NOT NULL AUTO_INCREMENT,
	id_orden            INT(6),
	fecha_visita        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	obs_visita          VARCHAR(160),
	PRIMARY KEY(id_visita),
	FOREIGN KEY(id_orden) REFERENCES orden(id_orden) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO duenio VALUES('30237244','Javier','Rodriguez','javier@hotmail.com','2920000001','2024-07-18 15:02:39');
INSERT INTO duenio VALUES('30300455','Diego' ,'Fernandez','diego@hotmail.com' ,'2920000002','2024-05-12 12:24:25');
INSERT INTO duenio VALUES('30029911','Luis'  ,'Martinez' ,'luis@hotmail.com'  ,'2920000003','2024-06-24 08:09:13');
INSERT INTO duenio VALUES('25590587','Carlos','Gonzalez' ,'carlos@hotmail.com','2920000004','2024-07-20 22:34:55');
INSERT INTO duenio VALUES('08335628','Mario' ,'Gomez'    ,'mario@hotmail.com' ,'2920000005',current_timestamp()  );

INSERT INTO vivienda VALUES('30237244','30237244','Salvo P. M. 53','Norte' ,'San Martin'     );
INSERT INTO vivienda VALUES('30300455','30300455','Moreno 1053'   ,'Centro','Belgrano'       );
INSERT INTO vivienda VALUES('30029911','30029911','7 de Marzo 630','Centro','Fátima'         );
INSERT INTO vivienda VALUES('25590587','25590587','Santa Cruz 72' ,'Sur'   ,'Santa Clara'    );
INSERT INTO vivienda VALUES('08335628','08335628','Las Heras 1240','Este'  ,'Sargento Cabral');

INSERT INTO ubicacion VALUES('30237244','30237244',-40.80485058962254 , -63.012335681129805);
INSERT INTO ubicacion VALUES('30300455','30300455',-40.8096612612647  , -63.00209613467383 );
INSERT INTO ubicacion VALUES('30029911','30029911',-40.81670923363005 , -62.98988952368246 );
INSERT INTO ubicacion VALUES('25590587','25590587',-40.822750870756074, -62.98957477412253 );
INSERT INTO ubicacion VALUES('08335628','08335628',-40.810376207395485, -63.006517432922706);

INSERT INTO personal VALUES('12345678','Juan','Garcia' );
INSERT INTO personal VALUES('23456789','Ana' ,'Torres' );
INSERT INTO personal VALUES('34567890','Luis','Ramirez');

INSERT INTO campania VALUES('30237244','30237244',140 ,'Pedido de poda y retiro de árboles gratis');
INSERT INTO campania VALUES('30300455','30300455',180,'Boleto gratis ida/vuelta a El Condor\nReducción de impuesto ABL 15%');
INSERT INTO campania VALUES('30029911','30029911',0  ,'');
INSERT INTO campania VALUES('25590587','25590587',20 ,'Reducción de impuesto ABL 15%');
INSERT INTO campania VALUES('08335628','08335628',100,'');

INSERT INTO orden VALUES('101','30237244','12345678','2024-07-25 13:38:42','CONCRETADO'  ,'5.5','15.0','2.0' ,NULL ,'0',"");
INSERT INTO orden VALUES('102','30300455','23456789','2024-05-30 17:14:28','CANCELADO'   ,'3.0','5.0' ,'27.0','4.0','1',"Vivienda no encontrada");
INSERT INTO orden VALUES('103','30029911','34567890','2024-07-19 19:30:08','EN_EJECUCION','8.0',NULL  ,NULL  ,NULL ,'0',"");

INSERT INTO visita VALUES(1,'101','2024-07-27 09:50:12','No se encontraba en el domicilio.');
INSERT INTO visita VALUES(2,'101','2024-08-01 10:05:38','Finalizado.');
INSERT INTO visita VALUES(3,'102','2024-06-03 10:13:15','No se encontró el domicilio.');
INSERT INTO visita VALUES(4,'103','2024-07-20 09:49:03','Falta completar.');