package cl.pinolabs.kevinstore.web.controller;

import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.domain.service.VentaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/venta")
public class VentaController {

    private final VentaService service;
    Log logger = LogFactory.getLog(VentaController.class);

    public VentaController(VentaService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("ventas",
                service.findAll()
                        .orElse(new ArrayList<VentaDTO>()));
        return "admin/ventas";
    }

    @GetMapping("/{idVenta}")
    public String findById(@PathVariable("idVenta") int idVenta, Model model){
        model.addAttribute("venta",
                service.findById(idVenta)
                        .orElse(new VentaDTO()));
        return "admin/venta";
    }

    @GetMapping("/new")
    public String create(){
        return "newVenta";
    }

    @GetMapping("/edit/{idVenta}")
    public String edit(@PathVariable("idVenta") int idVenta, Model model){
        model.addAttribute("venta",
                service.findById(idVenta)
                        .orElse(new VentaDTO()));

        return "editVenta";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute VentaDTO ventaDTO) {
        service.save(ventaDTO);
        return "redirect:/venta/all";
    }

    @GetMapping("/del/{idVenta}")
    public String delete ( @PathVariable("idVenta") int idVenta){
        service.delete(idVenta);
        return "redirect:/venta/all";
    }
}