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
@RequestMapping("/home")
public class HomeController {

    private final ProductoService productoservice;
    Log logger = LogFactory.getLog(HomeController.class);

    public HomeController(ProductoService productoservice) {
        this.productoservice = productoservice;
    }
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("productos",
            productoservice.findAll()
                        .orElse(new ArrayList<ProductoDTO>()));
        return "home";
    }
}