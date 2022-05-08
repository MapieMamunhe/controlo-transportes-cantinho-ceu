package mz.co.cantinho.ceu.controlo.transportes.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;
import mz.co.cantinho.ceu.controlo.transportes.service.EncarregadoService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/encarregados")
public class EncarregadoController {
    
	@Autowired
	private EncarregadoService encarregadoService;
    
    @GetMapping("/listar")
    public String index() {
        return "/listar/encarregados";
    }

    @GetMapping("/novo")
    public String novo(Encarregado encarregado) {
        return "/cadastros/encarregado";
    }
    
    @PostMapping("/salvar")
    public String salvar(@Valid Encarregado encarregado, BindingResult result, RedirectAttributes attr) {
    	if(encarregado.getTelefoneAlternativo().equals("")) {
    		encarregado.setTelefoneAlternativo(null);
    	}
    	
    	if(encarregado.getEmail().equals("")) {
    		encarregado.setEmail(null);
    	}
    	
    	if(result.hasErrors()) {
    		return "/cadastros/encarregado";
    	}
    	encarregadoService.gravar(encarregado);
    	attr.addFlashAttribute("success", "Encarregado registado.");
    	return "redirect:/encarregados/novo";
    }
    
    @ModelAttribute("encarregados")
    public List<Encarregado> encarregados(){
    	return encarregadoService.buscarTodos();
    }
}
