package cl.pinolabs.kevinstore.model.persistence.repository;

import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.domain.repository.VentaDTORepository;
import cl.pinolabs.kevinstore.model.persistence.crud.VentaCrud;
import cl.pinolabs.kevinstore.model.persistence.entity.Venta;
import cl.pinolabs.kevinstore.model.persistence.mapper.VentaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VentaRepository implements VentaDTORepository {

    private final VentaCrud crud;
    private final VentaMapper mapper;

    public VentaRepository(VentaCrud crud, VentaMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<VentaDTO>> findAll() {
        return Optional.of(mapper.toVentaDTOs((List<Venta>) crud.findAll()));
    }

    @Override
    public Optional<VentaDTO> findById(int idVenta) {

        return crud.findById(idVenta)
                .map(mapper::toVentaDTO);
    }

    @Override
    public VentaDTO save(VentaDTO ventaDTO) {
        return mapper.toVentaDTO(crud.save(mapper.toVenta(ventaDTO)));
    }

    @Override
    public void delete(int idVenta) {
        crud.deleteById(idVenta);
    }
}