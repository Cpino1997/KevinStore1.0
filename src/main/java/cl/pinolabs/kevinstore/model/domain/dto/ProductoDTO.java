package cl.pinolabs.kevinstore.model.domain.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Integer idProducto;
    private String sku;
    private String nombre;
    private Integer stock;
    private float precio;
    private Integer cantidad;
    private float total;
    private Integer idCategoria;
    private CategoriaDTO categoriaDTO;
}