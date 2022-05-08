package mz.co.cantinho.ceu.controlo.transportes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;
import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaAvaria;
import mz.co.cantinho.ceu.controlo.transportes.service.AvariaService;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaAvariaService;

@Controller
@RequestMapping("/avarias")
public class AvariaController {
    
	@Autowired
	private AvariaService avariaService;
    @Autowired
	private CarrinhaAvariaService carrinhaAvaria;
    @GetMapping("/listar")
    public String index() {
        return "/listar/encarregados";
    }

    @GetMapping("/comunicar")
    public String comunicar(CarrinhaAvaria carrinhaAvaria) {
        
        return "/cadastros/avaria-carrinha";
    }

    @GetMapping("/nova")
    public String novo(Avaria avaria) {
        return "/cadastros/avaria";
    }
    
    @PostMapping("/salvar")
    public String salvar(@Valid Avaria avaria, BindingResult result, RedirectAttributes attr) {
    	if(result.hasErrors()) {
    		return "/cadastros/avaria";
    	}
    	avariaService.gravar(avaria);
    	attr.addFlashAttribute("success", "Avaria registada");
    	return "redirect:/avarias/nova";
    }
    
}
