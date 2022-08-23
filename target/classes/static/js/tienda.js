// LET PRODUCTOS = [] ESTA DECLARADO EN LA VISTA DE 2THYMELEFT, POR LO QUE TRAE TODOS LOS PRODUCTOS DEL CONTROLADOR
let lista =[];
function agregarProd(id){
productos.forEach(producto =>{
if(producto.idProducto == id){
    console.log("producto encontrado");
    if(lista.includes(producto)) {
        console.log("agregar cantidad");
        producto.cantidad=producto.cantidad+1;
        producto.total=producto.cantidad*producto.precio;
        producto.stock=producto.stock-1;
        console.log(producto);
    }else{
        console.log("agregar producto");
        producto.cantidad=1;
        producto.total=producto.cantidad*producto.precio;
        producto.stock=producto.stock-1;
        lista.push(producto);
        console.log(producto);
    }
}
});
}

let totales=0;
function mostrarLista(){// FUNCION PARA MOSTRAR NUESTRA LISTA DE PRODUCTOS O CARRITO EN LA VISTA
let container = document.getElementById("carritoCompras");
if(lista.length==0){
    container.innerHTML = ``;
    alert("Carrito Vacio, Porfavor Agrege Productos!");
}else{
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
  
function deleteProd(id){//FUNCION PARA ELIMINAR LOS PRODUCTOS DE LA LISTA PERO NO ACTUALIZA LOS TOTALES,EJ SI ELIMINAMOS TODOS LOS ARTICULOS EL TOTAL SERA EL DE LA LISTA MAS EL DE LA ELIMINACION.
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
let VentaDTO={
    idVenta : 0,
    productoDTOs : {},
    idCliente : 1,
    clienteDTO :  null,
    montoTotal : totales
};
function pagar(){ // al precionar el boton pagar se ingresan los datos a la venta
if(lista.length==0){
    alert("Carrito Vacio, Porfavor Agrege Productos!");
}else{
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





