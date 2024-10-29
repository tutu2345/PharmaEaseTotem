package br.com.fiap.pharmaeasetotem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna o nome da página de login, que deve estar em resources/templates/login.html
    }
}
