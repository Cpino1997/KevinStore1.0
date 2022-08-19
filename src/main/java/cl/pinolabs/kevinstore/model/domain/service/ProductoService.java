package cl.pinolabs.kevinstore.model.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.repository.ProductoDTORepository;

@Service
public class ProductoService {
    private final ProductoDTORepository repo;

    public ProductoService(ProductoDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<ProductoDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<ProductoDTO> findById(int idProducto){
        return repo.findById(idProducto);
    }

    public ProductoDTO save(ProductoDTO productoDTO){
        return repo.save(productoDTO);
    }

    public boolean delete(int idProducto){
        return findById(idProducto)
                .map(productoDTO -> {
                    repo.delete(idProducto);
                    return true;})
                .orElse(false);
    }
}