package cl.pinolabs.kevinstore.web.controller;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.domain.service.ClienteService;
import cl.pinolabs.kevinstore.model.domain.service.ProductoService;
import cl.pinolabs.kevinstore.model.domain.service.VentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class inicioController {
    private final VentaService ventasservice;
    private final ProductoService productoservice;
    private final ClienteService clienteService;

    public inicioController(VentaService ventasservice, ProductoService productoservice,ClienteService clienteService) {
        this.ventasservice = ventasservice;
        this.productoservice =productoservice;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/tienda")
    public String tienda(Model model){
        model.addAttribute("productos",
                productoservice.findAll()
                        .orElse(new ArrayList<ProductoDTO>()));
        model.addAttribute("clientes",
                clienteService.findAll()
                        .orElse(new ArrayList<ClienteDTO>()));
        return "admin/tienda";
    }

        @PostMapping("tienda")
            public String save(@ModelAttribute VentaDTO ventaDTO){
                ventasservice.save(ventaDTO);
            return "?exito";
            }

}
