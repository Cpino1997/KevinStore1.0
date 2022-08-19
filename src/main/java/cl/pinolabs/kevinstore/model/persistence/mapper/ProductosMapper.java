package cl.pinolabs.kevinstore.model.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface ProductosMapper {

        @Mappings({
                @Mapping(source = "idProducto", target = "idProducto"),
                @Mapping(source = "sku", target = "sku"),
                @Mapping(source = "nombre", target = "nombre"),
                @Mapping(source = "stock", target = "stock"),
                @Mapping(source = "precio", target = "precio"),
                @Mapping(source = "cantidad", target = "cantidad"),
                @Mapping(source = "total", target = "total"),
                @Mapping(source = "idCategoria", target = "idCategoria"),
                @Mapping(source = "categoria", target = "categoriaDTO"),

        })
        ProductoDTO toProductoDTO(Producto producto);
        List<ProductoDTO> toProductoDTOs(List<Producto> productos);

        @InheritInverseConfiguration
        Producto toProducto(ProductoDTO productoDTO);
}