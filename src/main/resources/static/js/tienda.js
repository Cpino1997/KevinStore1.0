// LET PRODUCTOS = [] ESTA DECLARADO EN LA VISTA DE THYMELEFT, POR LO QUE TRAE TODOS LOS PRODUCTOS DEL CONTROLADOR

let lista =[];
function agregarProd(id){//FUNCION PARA AGREGAR LOS PRODUCTOS Y A SU VEZ VERIFICAR SI ESTAN Y SACAR EL CANTIDAD DEL PRODUCTO Y SU VALOR
    productos.forEach(producto =>{
        if(producto.idProducto == id){
          if(lista.includes(producto)){
            console.log("El Producto ya Existe");
            producto.cantidad++;
            var cant = producto.cantidad;
            var pre = producto.precio;
            var total = cant*pre;
            producto.total = total;
            console.log(total);
            console.log(producto.total);
          }else{
            producto.cantidad++;
            var cant = producto.cantidad;
            var pre = producto.precio;
            var total = cant*pre;
            producto.total = total;
            lista.push(producto);
            alert("producto agregado con exito");
          }
        }
    });
    console.log(lista);// VEMOS NUESTRA LISTA DE PRODUCTOS
}

let totales=0;
function mostrarLista(){// FUNCION PARA MOSTRAR NUESTRA LISTA DE PRODUCTOS O CARRITO EN LA VISTA
  let container = document.getElementById("carritoCompras");
  container.innerHTML = ``;
  lista.forEach(producto =>{
  var tot=producto.total;
  totales=totales+tot;
  container.innerHTML = `
    ${container.innerHTML}
          <td>${producto.nombre}</td>
          <td>${producto.precio}</td>
          <td>${producto.cantidad}</td>
          <td>${producto.total}</td>
          <td><a id="${producto.idProducto}" class="fa-solid fa-trash-can" onclick="deleteProd(this.id);"></a></td>
  `;
  });
  obtenerTotales();
}
function obtenerTotales(){// FUNCION PARA OBTENER LOS TOTALES DEL CARRITO EN LA VISTA
    let container = document.getElementById("totalCompra");
    container.innerHTML = ``;
    container.innerHTML = `
      ${container.innerHTML}
        <td>${totales}</td>
      `;
  }
  
  function deleteProd(id){//FUNCION PARA ELIMINAR LOS PRODUCTOS DE LA LISTA PERO NO ACTUALIZA LOS TOTALES,EJ SI ELIMINAMOS TODOS LOS ARTICULOS EL TOTAL SERA EL DE LA LISTA MAS EL DE LA ELIMINACION.
    lista.forEach(producto =>{
      if(producto.idProducto == id){
         if(producto.cantidad != 1){
        var cant = producto.cantidad-1;
        var pre = producto.precio;
        var tot = cant*pre;
        producto.total = tot;
        producto.cantidad = cant;
        totales=totales+total;
        }else{
        lista.pop();
        }
      }
    });
    mostrarLista();
  }
  let VentaDTO={
        idVenta : 0,
        productoDTOs : {},
        idCliente : 1,
        clienteDTO :  null,
        montoTotal : totales
};
  function pagar(){ // al precionar el boton pagar se ingresan los datos a la venta
    VentaDTO = {
     idVenta : 0,
        productoDTOs : lista,
        idCliente : 1,
        clienteDTO : null,
        montoTotal : totales
      }
    console.log(VentaDTO);// hasta aqui la venta se ve bien.
    Confirmar(this.VentaDTO);
  } 
  /*
  function Confirmar(venta){//para enviar la venta 
      function exito() {
        xhr.send(venta);
        //xhr.send(JSON.stringify(venta)); tampoco como json la agarra :c 
        console.log(venta);
      }
      // funcion para la llamada fallida
      function error(err) {
          console.log('Solicitud fallida', err); //los detalles en el objecto "err"
      }
      var xhr = new XMLHttpRequest(); //invocar nueva instancia de XMLHttpRequest
      xhr.onload = exito; // llamar a la funcion exito si exitosa
      xhr.onerror = error;  // llamar a la funcion error si fallida
      xhr.open('POST', 'http://localhost:8080/kevinstore/api/venta/save'); // Abrir solicitud GET
      xhr.send(); // mandar la solicitud al vervidor.
  }*/
/*
function Confirmar(){ //OTRO METODO PARA CONFIRMAR LA VENTA QUE TAMPOCO SIRVE.
  var xhr = new XMLHttpRequest();
  xhr.open("post", "http://localhost:8080/kevinstore/venta/save", true);
  xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
  xhr.send(JSON.stringify(ventaDTO));
}*/
function Confirmar(VentaDTO){
fetch('http://localhost:8080/kevinstore/venta/save', {
  method: "POST",
  body: JSON.stringify(VentaDTO),
  headers: {"Content-type": "application/json;"}
})
}
