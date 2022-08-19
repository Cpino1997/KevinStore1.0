package cl.pinolabs.kevinstore.model.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.pinolabs.kevinstore.model.domain.dto.CategoriaDTO;
import cl.pinolabs.kevinstore.model.domain.repository.CategoriaDTORepository;

@Service
public class CategoriaService {
    private final CategoriaDTORepository repo;

    public CategoriaService(CategoriaDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<CategoriaDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<CategoriaDTO> findById(int idCategoria){
        return repo.findById(idCategoria);
    }

    public CategoriaDTO save(CategoriaDTO categoriaDTO){
        return repo.save(categoriaDTO);
    }

    public boolean delete(int idCategoria){
        return findById(idCategoria)
                .map(categoriaDTO -> {
                    repo.delete(idCategoria);
                    return true;})
                .orElse(false);
    }
}
