package cl.pinolabs.kevinstore.web.restController;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
    private final ProductoService service;

    public ProductoRestController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll(){
        return service.findAll()
                .map(productos -> new ResponseEntity<>(productos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idProducto}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable("idProducto") int idProducto){
        return service.findById(idProducto)
                .map(productoDTO -> new ResponseEntity<>(productoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(service.save(productoDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{idProducto}")
    public ResponseEntity delete(@PathVariable("idProducto") int idProducto){
        if (service.delete(idProducto)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
