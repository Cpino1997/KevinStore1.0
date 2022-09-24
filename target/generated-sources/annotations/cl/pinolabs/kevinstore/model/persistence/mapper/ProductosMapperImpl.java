package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T22:55:00-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class ProductosMapperImpl implements ProductosMapper {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public ProductoDTO toProductoDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setIdProducto( producto.getIdProducto() );
        productoDTO.setSku( producto.getSku() );
        productoDTO.setNombre( producto.getNombre() );
        productoDTO.setStock( producto.getStock() );
        productoDTO.setPrecio( producto.getPrecio() );
        productoDTO.setCantidad( producto.getCantidad() );
        productoDTO.setTotal( producto.getTotal() );
        productoDTO.setIdCategoria( producto.getIdCategoria() );
        productoDTO.setCategoriaDTO( categoriaMapper.toCategoriaDTO( producto.getCategoria() ) );

        return productoDTO;
    }

    @Override
    public List<ProductoDTO> toProductoDTOs(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toProductoDTO( producto ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setIdProducto( productoDTO.getIdProducto() );
        producto.setSku( productoDTO.getSku() );
        producto.setNombre( productoDTO.getNombre() );
        producto.setStock( productoDTO.getStock() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setCantidad( productoDTO.getCantidad() );
        producto.setTotal( productoDTO.getTotal() );
        producto.setIdCategoria( productoDTO.getIdCategoria() );
        producto.setCategoria( categoriaMapper.toCategoria( productoDTO.getCategoriaDTO() ) );

        return producto;
    }
}
