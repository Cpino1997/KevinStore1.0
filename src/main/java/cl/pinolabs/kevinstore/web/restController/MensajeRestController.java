package cl.pinolabs.kevinstore.web.restController;

import cl.pinolabs.kevinstore.model.domain.dto.MensajeDTO;
import cl.pinolabs.kevinstore.model.domain.service.MensajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/mensajes")
public class MensajeRestController {

    private final MensajeService service;

    public MensajeRestController(MensajeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MensajeDTO>> findAll(){
        return service.findAll()
                .map(mensajes -> new ResponseEntity<>(mensajes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idMensaje}")
    public ResponseEntity<MensajeDTO> findById(@PathVariable("idMensaje") int idMensaje){
        return service.findById(idMensaje)
                .map(mensajeDTO -> new ResponseEntity<>(mensajeDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MensajeDTO> save(@RequestBody MensajeDTO mensajeDTO){
        return new ResponseEntity<>(service.save(mensajeDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{idMensaje}")
    public ResponseEntity delete(@PathVariable("idMensaje") int idMensaje){
        if (service.delete(idMensaje)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}