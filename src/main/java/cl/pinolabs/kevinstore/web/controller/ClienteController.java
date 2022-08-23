package cl.pinolabs.kevinstore.web.controller;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.service.ClienteService;

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
        public String edit(@PathVariable("idCliente") int idCliente, Model model){
            model.addAttribute("cliente",
                    service.findById(idCliente)
                            .orElse(new ClienteDTO()));
            return "admin/cliente";
        }
        @PostMapping("/save")
        public String save(@ModelAttribute ClienteDTO idCliente){
            service.save(idCliente);
            return "redirect:/clientes";
        }
        @GetMapping("/del/{idCliente}")
        public String delete(@PathVariable("idCliente") int idCliente){
            service.delete(idCliente);
            return "redirect:/clientes";
        }


}
