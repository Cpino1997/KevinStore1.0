package cl.pinolabs.kevinstore.model.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cl.pinolabs.kevinstore.model.domain.dto.CategoriaDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    @Mappings({
        @Mapping(source = "idCategoria", target = "idCategoria"),
        @Mapping(source = "nombre", target = "nombre")
})
CategoriaDTO toCategoriaDTO(Categoria categoria);
List<CategoriaDTO> toCategoriaDTOs(List<Categoria> categorias);

@InheritInverseConfiguration
Categoria toCategoria(CategoriaDTO categoriaDTO);
}
    