let datos = [];
function obtenerDatos(){
    ventas.forEach(venta => {
        let monto = venta.montoVenta;
        datos.push(monto);
        console.log(monto);
        console.log(datos);
    });
}


// Imprimimos la api insertando html dentro de la seccion #grilla-web

function obtenerPro() {

  const container = document.getElementById('listaProductos')

  productos.forEach(producto => {

    container.innerHTML = `

    ${container.innerHTML}
    
    <li class="list-group-item">${producto.nombre}</li>
    `; 
});
}

function obtenerCli() {

    const container = document.getElementById('listaClientes')
  
    clientes.forEach(cliente => {
  
      container.innerHTML = `
  
      ${container.innerHTML}
      
      <li class="list-group-item">${cliente.nombre}</li>
      `; 
  });
  }