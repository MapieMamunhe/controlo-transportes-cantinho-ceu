package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaService;

@Controller
@RequestMapping("/carrinhas")
public class CarrinhaController {
    

	@Autowired
	private CarrinhaService service;
	

	@GetMapping("/nova")
		return "/cadastros/carrinha";
	}
	@PostMapping("/salvar")
	public String salvar(Carrinha carrinha) {
		service.gravar(carrinha);
		return "redirect:/carrinhas/nova";
	}

}
