package com.springboot.app.springbootwebjsp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    @Value("${application.controller.titulo}")
    private String titulo;


    @RequestMapping("/index")
    public String test(Model model) {
        model.addAttribute("titulo", titulo);
        return "index";

    }
}
