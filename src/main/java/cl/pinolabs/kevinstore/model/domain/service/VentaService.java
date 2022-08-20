package cl.pinolabs.kevinstore.model.domain.service;

import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.domain.repository.VentaDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    private final VentaDTORepository repo;

    public VentaService(VentaDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<VentaDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<VentaDTO> findById(int idVenta){
        return repo.findById(idVenta);
    }

    public VentaDTO save(VentaDTO ventaDTO){
        return repo.save(ventaDTO);
    }

    public boolean delete(int idVenta){
        return findById(idVenta)
                .map(ventaDTO -> {
                    repo.delete(idVenta);
                    return true;})
                .orElse(false);
    }
}
