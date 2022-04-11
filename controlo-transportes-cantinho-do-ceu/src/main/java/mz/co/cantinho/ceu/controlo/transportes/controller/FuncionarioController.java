package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
    @GetMapping("/secretaria/novo")
    public String secretaria(Funcionario funcionario){
    	return "/cadastros/secretaria";
    }
    
    @PostMapping("/secretaria/salvar")
    public String salvar(Funcionario funcionario){
    	service.gravar(funcionario);
    	return "redirect:/funcionarios/secretaria/novo";
    }
}
