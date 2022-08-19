package cl.pinolabs.kevinstore.model.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.repository.ProductoDTORepository;
import cl.pinolabs.kevinstore.model.persistence.crud.ProductoCrud;
import cl.pinolabs.kevinstore.model.persistence.entity.Producto;
import cl.pinolabs.kevinstore.model.persistence.mapper.ProductosMapper;

@Repository
public class ProductoRepository implements ProductoDTORepository {

    private final ProductoCrud crud;
    private final ProductosMapper mapper;

    public ProductoRepository(ProductoCrud crud, ProductosMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<ProductoDTO>> findAll() {
        return Optional.of(mapper.toProductoDTOs((List<Producto>) crud.findAll()));
    }

    @Override
    public Optional<ProductoDTO> findById(int idProducto) {

        return crud.findById(idProducto)
                .map(mapper::toProductoDTO);
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        return mapper.toProductoDTO(crud.save(mapper.toProducto(productoDTO)));
    }

    @Override
    public void delete(int idProducto) {
        crud.deleteById(idProducto);
    }
}