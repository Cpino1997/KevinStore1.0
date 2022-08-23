package cl.pinolabs.kevinstore.web.controller;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;
    Log logger = LogFactory.getLog(ProductoController.class);

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("productos",
                service.findAll()
                        .orElse(new ArrayList<ProductoDTO>()));
        return "admin/productos";
    }
    @GetMapping("/{idProducto}")
    public String edit(@PathVariable("idProducto") int idProducto, Model model){
        model.addAttribute("producto",
                service.findById(idProducto)
                        .orElse(new ProductoDTO()));

        return "admin/producto";
    }



   
    @PostMapping("/save")
    public String save(@ModelAttribute ProductoDTO idProducto) {
        service.save(idProducto);
        return "redirect:/productos";
    }

        @GetMapping("/del/{idProducto}")
        public String delete ( @PathVariable("idProducto") int idProducto){
            service.delete(idProducto);
            return "redirect:/productos";
        }

    }