package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cantinho.ceu.controlo.transportes.service.EducadoraService;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

@Controller
@RequestMapping("/educadora")
public class EducadoraController {

	@Autowired
	private EducadoraService educadoraService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario) {
		educadoraService.gravar(funcionario);
		return "redirect:/educadora/cadastrar";
	}
}
