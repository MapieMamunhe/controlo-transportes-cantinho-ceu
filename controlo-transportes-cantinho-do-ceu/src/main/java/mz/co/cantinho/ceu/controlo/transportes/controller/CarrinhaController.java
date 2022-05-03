package mz.co.cantinho.ceu.controlo.transportes.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "/cadastros/carrinha";
	}
	@PostMapping("/salvar")
	public String salvar(@Valid Carrinha carrinha, BindingResult result) {
		if(result.hasErrors()) {//verifica se campos têm  erros
			return "/cadastros/carrinha";
		}
		service.gravar(carrinha);
		return "redirect:/carrinhas/nova";
	}

}
