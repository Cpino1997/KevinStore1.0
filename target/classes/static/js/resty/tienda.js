// LET PRODUCTOS = [] ESTA DECLARADO EN LA VISTA DE 2THYMELEFT, POR LO QUE TRAE TODOS LOS PRODUCTOS DEL CONTROLADOR
let lista =[];

function agregarProd(id){
productos.forEach(producto =>{
if(producto.idProducto == id){
    console.log("producto encontrado");
    if(lista.includes(producto)) {
        producto.cantidad=producto.cantidad+1;
        producto.total=producto.cantidad*producto.precio;
        producto.stock=producto.stock-1;
        alert("producto agregado!");
    }else{
        producto.cantidad=1;
        producto.total=producto.cantidad*producto.precio;
        producto.stock=producto.stock-1;
        lista.push(producto);
        alert("producto agregado!");
    }
}
});
}

let totales=0;

function mostrarLista(){
    // FUNCION PARA MOSTRAR NUESTRA LISTA DE PRODUCTOS O CARRITO EN LA VISTA
let container = document.getElementById("carritoCompras");
if(lista.length==0){
    container.innerHTML = ``;
    alert("Carrito Vacio, Porfavor Agrega Tus Productos!");
}else{
container.innerHTML = ``;
lista.forEach(producto =>{
var tot=producto.total;
totales=totales+tot;
container.innerHTML = `
${container.innerHTML}
      <td>${producto.nombre}</td>
      <td>$${producto.precio}0</td>
      <td>${producto.cantidad}unidades</td>
      <td>$${producto.total}0</td>
      <td><a id="${producto.idProducto}" class="fa-solid fa-trash-can" onclick="deleteProd(this.id);"></a></td>
`;
});
obtenerTotales();
}
}




function obtenerTotales(){
let container = document.getElementById("totalCompra");
totales = 0;
lista.forEach(producto=>{
    totales = totales + producto.total;
});
container.innerHTML = ``;
container.innerHTML = `
  ${container.innerHTML}
  <td colspan=2 id="totalCompra">$${totales}0</td>
  `;

}
  
function deleteProd(id){    //FUNCION PARA ELIMINAR LOS PRODUCTOS DE LA LISTA PERO NO ACTUALIZA LOS TOTALES,EJ SI ELIMINAMOS TODOS LOS ARTICULOS EL TOTAL SERA EL DE LA LISTA MAS EL DE LA ELIMINACION.
lista.forEach(producto =>{
    if(producto.idProducto == id){
        if(producto.cantidad == 1){
            producto.cantidad=producto.cantidad-1;
            producto.stock = producto.stock+1;
            producto.total=producto.precio*producto.cantidad;
            lista.pop();
            mostrarLista();
        }else{
            console.log(producto);
            producto.cantidad=producto.cantidad-1;
            producto.stock = producto.stock+1;
            producto.total=producto.precio*producto.cantidad;
            console.log(lista);
            mostrarLista();
        }
    }
});
}

let venta={
    idVenta:0,
    productoDTOs:{},
    montoVenta: 0.0
}

function postVenta(valor){
    fetch("http://kevinstore.azurewebsites.net/api/ventas", { // direccion del api donde haremos el fetch
       // metodo que utilizaremos. 
       method: "POST",    
       // cuerpo o dato a enviar, en este caso es un objeto llamado Mensaje en formato JSON
       body: JSON.stringify(valor), 
       // los headers de la peticion
       headers: {
           "Content-Type": "application/json; charset=UTF-8", // el tipo de contenido a enviar
           "Authorization": "Basic cGlub2xhYnM6Y2FtaWxhYWVkbw==", // la autorizacion para utilizar el api
           "mode": "no-cors", // el modo, en este caso, no-cors, al ser de pruebas no necesita tanta proteccion.
           "Accept": "*/*"
       }
    });
    console.log("exito");
}


function pagar(){
    if(lista.length==0){
        alert("Carrito Vacio!, agrege productos porfavor");
    }else{
        venta ={  
            idVenta:0,
            productoDTOs:lista,
            montoVenta: totales
        }
        postVenta(venta);
    }
}