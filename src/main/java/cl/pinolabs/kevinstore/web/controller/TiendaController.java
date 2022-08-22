package cl.pinolabs.kevinstore.web.controller;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.service.ClienteService;
import cl.pinolabs.kevinstore.model.domain.service.ProductoService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    private final ProductoService productoservice;
    private final ClienteService clienteservice;
    Log logger = LogFactory.getLog(TiendaController.class);

    public TiendaController(ProductoService productoservice, ClienteService clienteservice) {
        this.productoservice = productoservice;
        this.clienteservice = clienteservice;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("productos",
            productoservice.findAll()
                        .orElse(new ArrayList<ProductoDTO>()));
        model.addAttribute("clientes",
                clienteservice.findAll()
                        .orElse(new ArrayList<ClienteDTO>()));

        return "tienda";
    }
}