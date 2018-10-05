package com.cletus.facturacion.controller;

import com.cletus.facturacion.model.entity.Cliente;
import com.cletus.facturacion.model.entity.Factura;
import com.cletus.facturacion.model.entity.ItemFactura;
import com.cletus.facturacion.model.entity.Producto;
import com.cletus.facturacion.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @PostMapping("/form")
    public String guardar(@Valid Factura factura, BindingResult result,Model model,
                          @RequestParam(name="item_id[]", required=false) Long[] itemId,
                          @RequestParam(name="cantidad[]", required=false) Integer[] cantidad, RedirectAttributes flash,
                          SessionStatus status) {

        if(result.hasErrors()){
            model.addAttribute("titulo", "crear factura");
            return "factura/form";
        }

        if(  itemId == null || itemId.length==0){
            model.addAttribute("titulo", "Crear factura");
            model.addAttribute("error","La factura esta vacia.");
            return "factura/form";
        }

        for(int i=0;i< itemId.length; i++){

            Optional opt = clienteService.findProductoById(itemId[i]);
            if (!opt.isPresent()){

                flash.addFlashAttribute("Error","El cliente no existe.");
                return "redirect:/listar";
            }
            Producto producto = (Producto) opt.get();
            ItemFactura itemFactura = new ItemFactura();
            itemFactura.setCantidad(cantidad[i]);
            itemFactura.setProducto(producto);

            factura.addItemFactura(itemFactura);
        }

        clienteService.saveFactura(factura);
        status.setComplete();
        flash.addFlashAttribute("Success","Factura creada con exito");
        return "redirect:/ver/" + factura.getCliente().getId();
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model model, RedirectAttributes flash){


        //Optional<Factura> opt = clienteService.findFacturaById(id);

//        if(!opt.isPresent()){
//            flash.addFlashAttribute("error","la factura no existe.");
//            return "redirect:/listar";
//        }

//        Factura factura = opt.get();
        Factura factura = clienteService.fetchFacturaById(id);
        model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));
        model.addAttribute("factura",factura);
        return "factura/ver";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id,RedirectAttributes flash){
        Optional<Factura> opt = clienteService.findFacturaById(id);
        if(!opt.isPresent()){
            flash.addFlashAttribute("error","No existe la factura");
            return "redirect:/listar";
        }

        Factura factura = opt.get();
        clienteService.deleteFactura(id);
        flash.addFlashAttribute("success","Factura eliminada con exito");

        return "redirect:/ver/" + factura.getId();



    }
}
