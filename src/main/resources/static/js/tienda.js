// LET PRODUCTOS = [] ESTA DECLARADO EN LA VISTA DE 2THYMELEFT, POR LO QUE TRAE TODOS LOS PRODUCTOS DEL CONTROLADOR
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
            producto.montoTotal = total;
            console.log(total);
            console.log(producto.montoTotal);
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
        idCliente : 0,
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
    Confirmar();
  } 


  function Confirmar(){
    fetch("http://localhost:8080/kevinstore/api/venta/save", {
    
   // Adding method type
   method: "POST",
    
   // Adding body or contents to send
   body: JSON.stringify(VentaDTO),
    
   // Adding headers to the request
   headers: {
       "Content-type": "application/json; charset=UTF-8"
   }
});
alert("Gracias Por Su Compra!");
window.location.href="http://localhost:8080/kevinstore/success/"
}





