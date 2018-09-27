package com.cletus.facturacion.controller;

import com.cletus.facturacion.model.entity.Cliente;
import com.cletus.facturacion.model.entity.Factura;
import com.cletus.facturacion.model.entity.Producto;
import com.cletus.facturacion.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {

    @Autowired private IClienteService clienteService;

    @GetMapping("/form/{clienteId}")
    public String create(@PathVariable Long clienteId, Map<String, Object> model, RedirectAttributes flash){

        Cliente cliente = clienteService.findOne(clienteId);
        if(cliente == null){
            flash.addFlashAttribute("Error","El cliente no existe.");
            return "redirect:/listar";
        }

        Factura factura = new Factura();
        factura.setCliente(cliente);

        model.put("factura",factura);
        model.put("titulo", "Crear factura");

        return "factura/form";
    }


    @GetMapping(value="/cargar-productos/{term}",produces = {"application/json"})
    public @ResponseBody List<Producto> cargarProducto(@PathVariable String term){
        return clienteService.findByNombre(term);
    }
}
