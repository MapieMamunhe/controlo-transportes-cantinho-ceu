package mz.co.cantinho.ceu.controlo.transportes.controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;
import mz.co.cantinho.ceu.controlo.transportes.service.EncarregadoService;
import mz.co.cantinho.ceu.controlo.transportes.validator.EncarregadoValidator;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/encarregados")
public class EncarregadoController {
    
	@Autowired
	private EncarregadoService encarregadoService;
    
	@Autowired
	private EncarregadoValidator encarregadoValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(encarregadoValidator);
	}
	
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
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Long id, ModelMap model) {
    	model.addAttribute("encarregado", encarregadoService.buscarPorId(id));
    	return "/cadastros/encarregado";
    }
    
    @PostMapping("/editar")
    public String actualizar(@Valid Encarregado encarregado, RedirectAttributes attr, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/cadastros/encarregado";
    	}
    	encarregadoService.actualizar(encarregado);
    	attr.addFlashAttribute("success", "Encarregado actualizado com sucesso.");
    	return "redirect:/encarregados/novo";
    }
    
    @GetMapping("/pesquisar")
    public String pesquisar(@RequestParam("nome") String nome, ModelMap model) {
    	model.addAttribute("encarregados", encarregadoService.buscarPorNome(nome));
    	return "/listar/encarregados";
    }
    
    @ModelAttribute("encarregados")
    public List<Encarregado> encarregados(){
    	return encarregadoService.buscarTodos();
    }
}
