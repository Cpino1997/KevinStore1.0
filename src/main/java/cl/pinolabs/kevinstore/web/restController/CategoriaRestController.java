package cl.pinolabs.kevinstore.web.restController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.pinolabs.kevinstore.model.domain.dto.CategoriaDTO;
import cl.pinolabs.kevinstore.model.domain.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaRestController {
    private final CategoriaService service;

    public CategoriaRestController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        return service.findAll()
                .map(categorias -> new ResponseEntity<>(categorias, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable("idCategoria") int idCategoria){
        return service.findById(idCategoria)
                .map(categoriaDTO -> new ResponseEntity<>(categoriaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoriaDTO){
        return new ResponseEntity<>(service.save(categoriaDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{idCategoria}")
    public ResponseEntity delete(@PathVariable("idCategoria") int idCategoria){
        if (service.delete(idCategoria)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
