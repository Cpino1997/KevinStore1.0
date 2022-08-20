package cl.pinolabs.kevinstore.model.domain.repository;

import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;

import java.util.List;
import java.util.Optional;

public interface VentaDTORepository {
    Optional<List<VentaDTO>> findAll();
    Optional<VentaDTO> findById(int idVenta);
    VentaDTO save(VentaDTO ventaDTO);
    void delete(int idVenta);
}
