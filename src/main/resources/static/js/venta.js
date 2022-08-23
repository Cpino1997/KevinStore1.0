function agregar(){
	console.log("hola");
}



function verProd(id){
    console.log(id);
    mostrarLista(id);
}

function agregaProd(id){
    productos.forEach(producto =>{
    if(producto.idProducto == id){
        console.log("producto encontrado");
        if(lista.includes(producto)) {
            console.log("agregar cantidad");
            producto.cantidad=producto.cantidad+1;
            producto.total=producto.cantidad*producto.precio;
            producto.stock=producto.stock-1;
            alert("Has agregado "+producto.nombre);
        }else{
            console.log("agregar producto");
            producto.cantidad=1;
            producto.total=producto.cantidad*producto.precio;
            producto.stock=producto.stock-1;
            lista.push(producto);
            console.log(producto);
            alert("Has agregado "+producto.nombre);
        }
    }
});
}

let lista=[];

function mostrarLista(id){
let container = document.getElementById("listaCompras");
container.innerHTML = ``;
ventas.forEach(venta =>{
if(venta.idVenta == id){
    console.log(venta.productoDTOs);
     venta.productoDTOs.forEach(productoDTO =>{
		container.innerHTML = `
		${container.innerHTML}
        <td>${productoDTO.nombre}</td>
        <td>$<a>${productoDTO.precio}</a>0</td>
        `;
  });
}
});
}



function verCarrito(){
let container = document.getElementById("carr");
console.log("pago de productos");
if(lista.length==0){ 
    container.innerHTML = ``;
    alert("Carrito Vacio, Porfavor Agrege Productos!");
}else{   
container.innerHTML = ``;
lista.forEach(producto =>{
    container.innerHTML = `
      ${container.innerHTML}
      <td>${producto.nombre}</td>
      <td>$${producto.precio}0</td>
      <td>${producto.cantidad}u</td>
      <td>$${producto.total}0</td>
      <td><a id="${producto.idProducto}" class="fa-solid fa-trash-can" onclick="deleteProd(this.id);">borrar</a></td>
    `;
    });
}
obtenerTotales();
}

function limpiar(){
    lista.splice();
    verCarrito();
}

function deleteProd(id){
    lista.forEach(producto =>{
        if(producto.idProducto == id){
            if(producto.cantidad == 1){
                producto.cantidad=producto.cantidad-1;
                producto.stock = producto.stock+1;
                producto.total=producto.precio*producto.cantidad;
                lista.pop();
                verCarrito();
            }else{
                console.log(producto);
                producto.cantidad=producto.cantidad-1;
                producto.stock = producto.stock+1;
                producto.total=producto.precio*producto.cantidad;
                console.log(lista);
                verCarrito();
            }
        }
    });
}
let totales = 0;
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


let id = 0;
function selectCliente(){
    id=document.getElementById("idCliente").value;
    if(id==0){
    alert("Error, Debes Seleccionar Un Cliente!")
    }else{
    document.getElementById("prodHid").style='display:block';
    }
}

let VentaDTO={
        idVenta : 0,
        productoDTOs : {},
        idCliente : 0,
        clienteDTO :  null,
        montoVenta : 0
};

function pagar(){
lista.forEach(producto=>{
    totales = totales + producto.total;
});
 VentaDTO = {
     idVenta : 0,
        productoDTOs : lista,
        idCliente : id,
        clienteDTO : null,
        montoVenta : totales
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
      window.location.href="http://localhost:8080/kevinstore/admin/success"
      }

