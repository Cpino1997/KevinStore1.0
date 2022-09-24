# <center>KevinStore</center>
<center>Created By PinoLabs.</center>


Somos una tienda E-commerce para mascotas
# <center><img src="https://i.ibb.co/gmGz0Qd/success.png"><center>
#
Manual de uso para la api de kevinStore! =D


```sql
Primero lo primero!
# Comandos MYSQL para Security
inser into rol(`rol_id`,`rol_name`)
VALUES(1,"ROLE_ADMIN"),(2,"ROLE_USER");

INSERT INTO usuario(`username`,`enabled`,`password`)
VALUES("demo", true , "$2a$10$jolbvPCOIOCm/bHp9IvX9OAFFo1h.sR8qYuF1KlRrFRAslOA4NfjS");

INSERT INTO roles_usuario(`username`,`rol_id`)
VALUES("demo",1);
```

Ahora Agregaremos los datos de prueba para el uso de kevinstore :

```sql
/* ingreso Categorias */

INSERT INTO test.categorias (id, nombre) VALUES( 1,"Alimentos") ,(2,"Jugetes"), (3,"Accesorios"), (4,"Salud");

/* ingreso productos */

INSERT INTO productos (id, cantidad, id_categoria, nombre, precio, sku, stock, total) VALUES (1,0,1,"Comida 25KG SuperEconomy Plus","5.990","ASL3002585",100,"0"), (2,0,1,"Comida 25KG SuperPLus Plus","5.990","ASL3002586",100,"0"), (3,0,1,"Comida 25KG SuperAction Plus","5.990","ASL3002587",100,"0"), (4,0,2,"Rascador Grande De Accion Plus","25.990","ASL3002588",100,"0"), (5,0,4,"Pipeta Anti Pulgas y otros Plus","5.990","ASL3002589",100,"0"), (6,0,3,"Collar Respeto Maximo gatito plus","12.990","ASL30025810",100,"0");

INSERT INTO clientes (id, direccion, nombre, numero, rut) VALUES (1,"Santa Manuelita 332","Anonymo","000000","00.000.000-0"), (0,"Santa Cazurla 332","Alam Brito Delgado","955555555","10.302.320-3"), (0,"Santa Gata 332","Marcianele Albino","955555555","10.302.320-3"), (0,"Santa jo 332","Pedro Picapiedra","955555555","10.302.320-3") ;
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
```

## Iniciando el backend
  se puede probar en https://localhost:8080/
```bash
$ git clone https://github.com/PinoLabs/KevinStore.git
$ mvn clean package install
$ mvn spring-boot:run
```
# Uso de la APi
  ```bash
  #Uso Categorias
 /api/categorias
     GET -> devuelve un JSON con todas las categorias existentes en la BD.
     POST -> Recive un JSON con un objeto categoria, se espera un id y nombre. Requiere de autenthication basic en su header y no-cors para la version en linea
 /api/categorias/{idCategoria}
    GET -> Devuelve un JSON con el objeto correspondiente al id solicitado. Requiere el idCategoria, autenthication basic en su header y no-cors para la version en linea.
    DELETE -> Elimina el Objeto de la BD. Requiere de autenthication basic en su header y no-cors para la version en linea.
  
  #Uso Productos
 /api/productos
     GET -> devuelve un JSON con todos los productos existentes en la BD.
     POST -> Recive un JSON con un objeto Producto, se espera un id, idCategoria, nombre, precio, sku, stock. Requiere de autenthication basic en su header y no-cors para la version en linea
 /api/productos{idProducto}
    GET -> Devuelve un JSON con el objeto correspondiente al id solicitado. Requiere el idProducto, autenthication basic en su header y no-cors para la version en linea.
    DELETE -> Elimina el Objeto de la BD.  Requiere el idProducto, autenthication basic en su header y no-cors para la version en linea.
  
  #Uso Clientes
  /api/clientes
     GET -> devuelve un JSON con todos los clientes existentes en la BD.
     POST -> Recive un JSON con un objeto Cliente, se espera un id, direccion, nombre, numero, rut Requiere de autenthication basic en su header y no-cors para la version en linea
 /api/clientes{idCliente}
    GET -> Devuelve un JSON con el objeto correspondiente al id solicitado. Requiere el idCliente, autenthication basic en su header y no-cors para la version en linea.
    DELETE -> Elimina el Objeto de la BD.  Requiere el idCliente, autenthication basic en su header y no-cors para la version en linea.
    
  #Uso Ventas
  /api/ventas
     GET -> devuelve un JSON con todas las ventas existentes en la BD.
     POST -> Recive un JSON con un objeto Venta, se espera un id, montoVenta, idCliente, lista de productos. Requiere de autenthication basic en su header y no-cors para la version en linea
 /api/ventas{idVenta}
    GET -> Devuelve un JSON con el objeto correspondiente al id solicitado. Requiere el idVenta, autenthication basic en su header y no-cors para la version en linea.
    DELETE -> Elimina el Objeto de la BD.  Requiere el idVenta, autenthication basic en su header y no-cors para la version en linea.
  
```

## Uso Web App
Su fronted esta creado con una convinacion entre Thymeleft y JS Puro.
Uso de la aplicacion web:
- Para ingresar desde la app solo basta con arrancar la aplicacion e ingresar a http://localhost:8080/
- para ingresar a la tienda solo debemos ir a http://localhost:8080/tienda
- para ingresar al crud de productos debemos ir a http://localhost:8080/admin
- para ingresar al crud de clientes debemos ir a http://localhost:8080/clientes
- para ingresar al crud de ventas debemos ir a http://localhost:8080/ventas
