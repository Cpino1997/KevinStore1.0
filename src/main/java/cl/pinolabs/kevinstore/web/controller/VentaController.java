package cl.pinolabs.kevinstore.web.controller;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.domain.service.ClienteService;
import cl.pinolabs.kevinstore.model.domain.service.ProductoService;
import cl.pinolabs.kevinstore.model.domain.service.VentaService;
import cl.pinolabs.kevinstore.model.persistence.entity.Cliente;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService service;
    private final ProductoService productoservice;
    private final ClienteService clienteservice;
    Log logger = LogFactory.getLog(VentaController.class);

    public VentaController(VentaService service,ProductoService productoservice,ClienteService clienteservice) {
        this.service = service;
        this.productoservice =productoservice;
        this.clienteservice = clienteservice;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("ventas",
            service.findAll()
                .orElse(new ArrayList<VentaDTO>()));
        model.addAttribute("productos",
            productoservice.findAll()
                .orElse(new ArrayList<ProductoDTO>()));
        model.addAttribute("clientes",
                clienteservice.findAll()
                        .orElse(new ArrayList<ClienteDTO>()));
                        
        return "admin/ventas";
    }

    @GetMapping("/{idVenta}")
    public String edit(@PathVariable("idVenta") int idVenta, Model model){
        model.addAttribute("venta",
                service.findById(idVenta)
                        .orElse(new VentaDTO()));

        return "admin/venta";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute VentaDTO ventaDTO) {
        service.save(ventaDTO);
        return "redirect:/ventas";
    }

    @GetMapping("/del/{idVenta}")
    public String delete ( @PathVariable("idVenta") int idVenta){
        service.delete(idVenta);
        return "redirect:/ventas";
    }
}