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
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService service;
    Log logger = LogFactory.getLog(ProductoController.class);

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("productos",
                service.findAll()
                        .orElse(new ArrayList<ProductoDTO>()));
        return "productos";
    }

    @GetMapping("/{idProducto}")
    public String findById(@PathVariable("idProducto") int idProducto, Model model){
        model.addAttribute("producto",
                service.findById(idProducto)
                        .orElse(new ProductoDTO()));
        return "producto";
    }

    @GetMapping("/new")
    public String create(){
        return "newProducto";
    }

    @GetMapping("/edit/{idProducto}")
    public String edit(@PathVariable("idProducto") int idProducto, Model model){
        model.addAttribute("producto",
                service.findById(idProducto)
                        .orElse(new ProductoDTO()));

        return "editProducto";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ProductoDTO idProducto) {
        service.save(idProducto);
        return "redirect:/producto/all";
    }

        @GetMapping("/del/{idProducto}")
        public String delete ( @PathVariable("idProducto") int idProducto){
            service.delete(idProducto);
            return "redirect:/producto/all";
        }

    }