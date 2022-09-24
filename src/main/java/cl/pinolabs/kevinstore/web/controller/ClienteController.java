package cl.pinolabs.kevinstore.web.controller;


import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("clientes",
                service.findAll()
                        .orElse(new ArrayList<ClienteDTO>()));
        return "admin/clientes";
    }
    @GetMapping("/{idCliente}")
    public String findById(@PathVariable("idCliente") int idCliente, Model model){
        model.addAttribute("cliente",
                service.findById(idCliente)
                        .orElse(new ClienteDTO()));
        return "admin/cliente";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ClienteDTO clienteDTO){
        service.save(clienteDTO);
        return "redirect:/clientes?v";
    }
    @GetMapping("/del/{idCliente}")
    public String delete(@PathVariable("idCliente") int idCliente){
        service.delete(idCliente);
        return "redirect:/clientes";
    }

}
