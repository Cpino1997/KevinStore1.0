function agregar(){
	console.log("hola");
}

function pagar(){
	console.log("chao");
}
let idd=0;
function obtenerId(id){
	idd=id;
	mostrarLista(idd);
}

function mostrarLista(){// FUNCION PARA MOSTRAR NUESTRA LISTA DE PRODUCTOS O CARRITO EN LA VISTA
let container = document.getElementById("listaProductos");
container.innerHTML = ``;
ventas.forEach(venta =>{
if(venta.idVenta == idd){
    console.log(venta.productoDTOs);
     venta.productoDTOs.forEach(productoDTO =>{
			container.innerHTML = `
		${container.innerHTML}
        <td>${productoDTO.nombre}</td>
        <td>${productoDTO.precio}</td>
        `;
  });
}
});
}

function obtenerID(id){
  console.log(id);
}

function mostrarProductos(){// FUNCION PARA MOSTRAR NUESTRA LISTA DE PRODUCTOS O CARRITO EN LA VISTA
  let container = document.getElementById("listaProductos");
  container.innerHTML = ``;
  productos.forEach(producto =>{
        container.innerHTML = `
      ${container.innerHTML}
          <p>${producto.nombre}</p>
          <p>${producto.precio}</p>
          `;
    });
  }