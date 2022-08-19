package cl.pinolabs.kevinstore.model.domain.repository;

import java.util.List;
import java.util.Optional;

import cl.pinolabs.kevinstore.model.domain.dto.CategoriaDTO;

public interface CategoriaDTORepository {
    Optional<List<CategoriaDTO>> findAll();
    Optional<CategoriaDTO> findById(int idCategoria);
    CategoriaDTO save(CategoriaDTO categoriaDTO);
    void delete(int idCategoria);
}
