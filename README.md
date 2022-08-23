# <center>KevinStore</center>
<center>Created By PinoLabs.</center>

Somos una tienda E-commerce para mascotas
# <center><img src="https://i.ibb.co/gmGz0Qd/success.png"><center>
#
# Comandos MYSQL para Security
inser into rol(`rol_id`,`rol_name`)
VALUES(1,"ROLE_ADMIN");

SELECT * FROM usuario;

INSERT INTO usuario(`username`,`enabled`,`password`)
VALUES("pinolabs", true , "$2a$10$jolbvPCOIOCm/bHp9IvX9OAFFo1h.sR8qYuF1KlRrFRAslOA4NfjS");

SELECT * FROM roles_usuario;

INSERT INTO roles_usuario(`username`,`rol_id`)
VALUES("pinolabs",1);

# Comandos mysql primarios
/* ingreso Categorias  */

INSERT INTO `test`.`categorias`
(`id`,
`nombre`)
VALUES(
1,"Alimentos")
,(2,"Jugetes"),
(3,"Accesorios"),
(4,"Salud");


/* ingreso productos */

INSERT INTO productos
(`id`,
`cantidad`,
`id_categoria`,
`nombre`,
`precio`,
`sku`,
`stock`,
`total`)
VALUES
(1,0,1,"Comida 25KG SuperEconomy Plus","5.990","ASL3002585",100,"0"),
(2,0,1,"Comida 25KG SuperPLus Plus","5.990","ASL3002586",100,"0"),
(3,0,1,"Comida 25KG SuperAction Plus","5.990","ASL3002587",100,"0"),
(4,0,2,"Rascador Grande De Accion Plus","25.990","ASL3002588",100,"0"),
(5,0,4,"Pipeta Anti Pulgas y otros Plus","5.990","ASL3002589",100,"0"),
(6,0,3,"Collar Respeto Maximo gatito plus","12.990","ASL30025810",100,"0");

select * from productos;

INSERT INTO `clientes`
(`id`,
`direccion`,
`nombre`,
`numero`,
`rut`)
VALUES
(1,"Santa Manuelita 332","Anonymo","000000","00.000.000-0"),
(0,"Santa Cazurla 332","Alam Brito Delgado","955555555","10.302.320-3"),
(0,"Santa Gata 332","Marcianele Albino","955555555","10.302.320-3"),
(0,"Santa jo 332","Pedro Picapiedra","955555555","10.302.320-3")
;

