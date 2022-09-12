package cl.pinolabs.kevinstore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class inicioController {
    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/app")
    public String app(){
        return "app";
    }

    @GetMapping("/admin")
    public String adminSuccess(){return "admin";}



}