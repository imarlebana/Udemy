package com.cletus.facturacion.controller;

import com.cletus.facturacion.model.entity.Cliente;
import com.cletus.facturacion.service.IClienteService;
import com.cletus.facturacion.service.IUploadFileService;
import com.cletus.facturacion.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired private IClienteService clienteService;
    @Autowired private IUploadFileService uploadFileService;

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

    @GetMapping(value = "/ver/{id}")
    public String ver(@PathVariable(value = "id") Long id, Map<String,Object> model, RedirectAttributes flash){
//        Cliente cliente = clienteService.findOne(id);
        Cliente cliente = clienteService.fetchByIdWithFac(id);
        if(cliente==null){
            flash.addFlashAttribute("error", "El cliente no existe.");
            return "redirect:/listar";
        }

        model.put("cliente", cliente);
        model.put("titulo", "Detalle cliente: " + cliente.getNombre());
        return "ver";
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
            Cliente cliente = clienteService.findOne(id);
            clienteService.delete(id);
            flash.addFlashAttribute("succes","Cliente eliminado con exito.");

            //Eliminamos foto
            if(uploadFileService.delete(cliente.getFoto())){
                flash.addFlashAttribute("succes","La foto se borro correctamente.");
            }
        }
        return "redirect:/listar";
    }

    @GetMapping(value="/uploads/{filename:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String filename){

        Resource recurso = null;
        try {
            recurso = uploadFileService.load(filename);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filanme=\"" + recurso.getFilename() + "\"").body(recurso);
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, @RequestParam("file") MultipartFile multipartFile, RedirectAttributes flash, SessionStatus sessionStatus){
        if(result.hasErrors()){
            model.addAttribute("titulo","Formulario de cliente");
            return "form";
        }

        if(!multipartFile.isEmpty()){
            if(cliente.getId()!=null && cliente.getId()>0 && cliente.getFoto()!=null && cliente.getFoto().length()>0){
              uploadFileService.delete(cliente.getFoto());
            }
            try {
                cliente.setFoto(uploadFileService.copy(multipartFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String msgFlash = (cliente.getId() !=  null) ? "cliente editado con exito" : "Cliente creado con exito";
        clienteService.save(cliente);
        sessionStatus.setComplete();
        flash.addFlashAttribute("succes",msgFlash);

        return "redirect:listar";
    }
}
