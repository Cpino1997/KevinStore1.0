package cl.pinolabs.kevinstore.model.persistence.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.pinolabs.kevinstore.model.domain.dto.CategoriaDTO;
import cl.pinolabs.kevinstore.model.domain.repository.CategoriaDTORepository;
import cl.pinolabs.kevinstore.model.persistence.crud.CategoriaCrud;
import cl.pinolabs.kevinstore.model.persistence.entity.Categoria;
import cl.pinolabs.kevinstore.model.persistence.mapper.CategoriaMapper;

@Repository
public class CategoriaRepository implements CategoriaDTORepository {

    private final CategoriaCrud crud;
    private final CategoriaMapper mapper;

    public CategoriaRepository(CategoriaCrud crud, CategoriaMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<CategoriaDTO>> findAll() {
        return Optional.of(mapper.toCategoriaDTOs((List<Categoria>) crud.findAll()));
    }

    @Override
    public Optional<CategoriaDTO> findById(int idCategoria) {

        return crud.findById(idCategoria)
                .map(mapper::toCategoriaDTO);
    }

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        return mapper.toCategoriaDTO(crud.save(mapper.toCategoria(categoriaDTO)));
    }

    @Override
    public void delete(int idCategoria) {
        crud.deleteById(idCategoria);
    }
}