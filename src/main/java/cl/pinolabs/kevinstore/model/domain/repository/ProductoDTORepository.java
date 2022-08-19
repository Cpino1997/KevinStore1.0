package cl.pinolabs.kevinstore.model.domain.repository;

import java.util.List;
import java.util.Optional;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;

public interface ProductoDTORepository {
    Optional<List<ProductoDTO>> findAll();
    Optional<ProductoDTO> findById(int idProducto);
    ProductoDTO save(ProductoDTO productoDTO);
    void delete(int idProducto);
}
