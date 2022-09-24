package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.CategoriaDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T22:55:00-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDTO toCategoriaDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setIdCategoria( categoria.getIdCategoria() );
        categoriaDTO.setNombre( categoria.getNombre() );

        return categoriaDTO;
    }

    @Override
    public List<CategoriaDTO> toCategoriaDTOs(List<Categoria> categorias) {
        if ( categorias == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( categorias.size() );
        for ( Categoria categoria : categorias ) {
            list.add( toCategoriaDTO( categoria ) );
        }

        return list;
    }

    @Override
    public Categoria toCategoria(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( categoriaDTO.getIdCategoria() );
        categoria.setNombre( categoriaDTO.getNombre() );

        return categoria;
    }
}
