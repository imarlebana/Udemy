package es.aramirez.ejercicio2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    @Value("${application.controller.text}")
    private String mensaje;

    @RequestMapping("/")
    public String hola(Model model) {
        model.addAttribute("mensaje", mensaje);
        return "hola";
    }


}
