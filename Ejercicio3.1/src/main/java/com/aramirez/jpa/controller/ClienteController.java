package com.aramirez.jpa.controller;



import com.aramirez.jpa.model.dao.IClienteDao;
import com.aramirez.jpa.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    @Qualifier("clienteDaoJPA")
    private IClienteDao clienteDao;

    @RequestMapping(value="listar",method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","listado de clientes");
        model.addAttribute("clientes", clienteDao.findAll());
        return "listar";
    }


    @RequestMapping(value="/form")
    public String crear(Map<String,Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente",cliente);
        model.put("titulo","formulario de cliente");
        return "form";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente){
        clienteDao.save(cliente);
        return "redirect:listar";
    }
}
