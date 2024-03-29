package mz.co.cantinho.ceu.controlo.transportes.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaService;
import mz.co.cantinho.ceu.controlo.transportes.validator.CarrinhaValidator;

@Controller
@RequestMapping("/carrinhas")
public class CarrinhaController {

	@Autowired
	private CarrinhaService service;

	@Autowired
	private CarrinhaValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@GetMapping("/listar")
	public String listar() {
		return "listar/carrinhas";
	}

	@GetMapping("/nova")
	public String novo(Carrinha carrinha) {
		return "/cadastros/carrinha";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Carrinha carrinha, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {// verifica se campos têm erros
			return "/cadastros/carrinha";
		}
		service.gravar(carrinha);
		attr.addFlashAttribute("success", "Carinha gravada");
		return "redirect:/carrinhas/nova";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id")Long id, ModelMap model) {
		model.addAttribute("carrinha", service.buscarPorId(id));
		return "/cadastros/carrinha";
	}
	
	@PostMapping("/editar")
	public String actualizar(@Valid Carrinha carrinha, RedirectAttributes attr, BindingResult result) {
		if(result.hasErrors()) {
			return "/cadastros/carrinha";
		}
		service.actualizar(carrinha);
		attr.addFlashAttribute("success", "Carrinha actualizada com sucesso.");
		return "redirect:/carrinhas/nova";
	}
	
	@GetMapping("/pesquisar")
	public String pesquisar(@RequestParam("matricula") String matricula, ModelMap model) {
		model.addAttribute("carrinhas", service.buscarPorMatricula(matricula));
		return "listar/carrinhas";
	}
	
	@ModelAttribute("carrinhas")
	public List<Carrinha> listaCarrinhas(){
		return service.buscarTodos();
	}
	

}
