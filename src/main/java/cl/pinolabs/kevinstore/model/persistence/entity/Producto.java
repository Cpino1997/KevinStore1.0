package cl.pinolabs.kevinstore.model.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String sku;
    private String nombre;
    private Integer stock;
    private float precio;
    private Integer cantidad;
    private float total;

    @Column(name = "id_Categoria")
    private Integer idCategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Categoria", insertable = false, updatable = false)
    private Categoria categoria;
    
    

    public Integer getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }

    
}
