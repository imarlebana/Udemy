package com.cletus.springbootdatajpa.controller;

import com.cletus.springbootdatajpa.model.entity.Cliente;
import com.cletus.springbootdatajpa.service.IClienteService;
import com.cletus.springbootdatajpa.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired private IClienteService clienteService;

    @RequestMapping(value="/listar",method = RequestMethod.GET)
    public String listar(@RequestParam(name="page", defaultValue ="0" ) int page, Model model){
        Pageable pageRequest =  PageRequest.of(page,4);
        Page<Cliente> clientes = clienteService.findAll(pageRequest);
        PageRender<Cliente> pageRender = new PageRender<Cliente>("/listar", clientes);
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clientes);
        model.addAttribute("page", pageRender);
        return "listar";
    }


    @RequestMapping(value="/form")
    public String crear(Map<String,Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente",cliente);
        model.put("titulo","Formulario de cliente");
        return "form";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus sessionStatus){
        if(result.hasErrors()){
            model.addAttribute("titulo","Formulario de cliente");
            return "form";
        }

        String msgFlash = (cliente.getId() !=  null) ? "cliente editado con exito" : "Cliente creado con exito";
        clienteService.save(cliente);
        sessionStatus.setComplete();
        flash.addFlashAttribute("succes",msgFlash);

        return "redirect:listar";
    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash){

        if(id<0){
            flash.addFlashAttribute("error","No existe el cliente.");
            return "redirect:listar";
        }

        Cliente cliente = new Cliente();
        cliente=clienteService.findOne(id);
        if(cliente == null){
            flash.addFlashAttribute("error","No existe el cliente.");
            return "redirect:listar";
        }

        flash.addFlashAttribute("succes","No existe el cliente.");
        model.put("cliente",cliente);
        model.put("titulo","Editar cliente");

        return "form";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash){

        if(id>0){
            clienteService.delete(id);
            flash.addFlashAttribute("succes","Cliente eliminado con exito.");
        }

        return "redirect:/listar";
    }



}
