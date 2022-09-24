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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class adminController {
    private final VentaService ventasservice;
    private final ProductoService productoservice;
    private final ClienteService clienteService;

    public adminController(VentaService ventasservice, ProductoService productoservice, ClienteService clienteService) {
        this.ventasservice = ventasservice;
        this.productoservice = productoservice;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String admin(Model model){
        model.addAttribute("ventas",
                ventasservice.findAll()
                        .orElse(new ArrayList<VentaDTO>()));
        model.addAttribute("productos",
                productoservice.findAll()
                        .orElse(new ArrayList<ProductoDTO>()));
        model.addAttribute("clientes",
                clienteService.findAll()
                        .orElse(new ArrayList<ClienteDTO>()));
        return "admin/admin";}

}
