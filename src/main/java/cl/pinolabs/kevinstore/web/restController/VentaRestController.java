package cl.pinolabs.kevinstore.web.restController;

import cl.pinolabs.kevinstore.model.domain.dto.CategoriaDTO;
import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.domain.service.CategoriaService;
import cl.pinolabs.kevinstore.model.domain.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaRestController {
    private final VentaService service;

    public VentaRestController(VentaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VentaDTO>> findAll(){
        return service.findAll()
                .map(ventas -> new ResponseEntity<>(ventas, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idVenta}")
    public ResponseEntity<VentaDTO> findById(@PathVariable("idVenta") int idVenta){
        return service.findById(idVenta)
                .map(ventaDTO -> new ResponseEntity<>(ventaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<VentaDTO> save(@RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(service.save(ventaDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{idVenta}")
    public ResponseEntity delete(@PathVariable("idVenta") int idVenta){
        if (service.delete(idVenta)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}