package cl.pinolabs.kevinstore.model.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    private String nombre;
    
    public Integer getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
