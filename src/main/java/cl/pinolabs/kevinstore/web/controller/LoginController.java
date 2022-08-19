package cl.pinolabs.kevinstore.web.controller;

import cl.pinolabs.kevinstore.model.domain.dto.User;
import cl.pinolabs.kevinstore.model.domain.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService service;
    Log logger = LogFactory.getLog(LoginController.class);

    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String login(){
        return "admin/login";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        service.save(user);
        return "redirect:admin/login";
    }

}