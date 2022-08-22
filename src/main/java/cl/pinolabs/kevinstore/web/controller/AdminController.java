package cl.pinolabs.kevinstore.web.controller;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.domain.service.ClienteService;
import cl.pinolabs.kevinstore.model.domain.service.ProductoService;
import cl.pinolabs.kevinstore.model.domain.service.VentaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final VentaService service;
    private final ProductoService productoservice;
    private final ClienteService clienteservice;
    Log logger = LogFactory.getLog(TiendaController.class);

    public AdminController(ProductoService productoservice, ClienteService clienteservice,VentaService service) {
        this.productoservice = productoservice;
        this.clienteservice = clienteservice;
        this.service = service;
    }
    @GetMapping
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("/venta")
    public String venta(Model model){
        model.addAttribute("ventas",
                service.findAll()
                        .orElse(new ArrayList<VentaDTO>()));
        model.addAttribute("productos",
                productoservice.findAll()
                        .orElse(new ArrayList<ProductoDTO>()));
        return "admin/venta";
    }
}