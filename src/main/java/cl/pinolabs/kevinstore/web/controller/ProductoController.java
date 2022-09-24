package cl.pinolabs.kevinstore.web.controller;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

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
    public String findById(@PathVariable("idProducto") int idProducto, Model model){
        model.addAttribute("producto",
                service.findById(idProducto)
                        .orElse(new ProductoDTO()));
        return "admin/producto";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ProductoDTO productoDTO){
        service.save(productoDTO);
        return "redirect:/productos?v";
    }
    @GetMapping("/del/{idProducto}")
    public String delete(@PathVariable("idProducto") int idProducto){
        service.delete(idProducto);
        return "redirect:/productos";
    }

}