package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaService;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;

@Controller
public class DashboardController {
   
	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	CarrinhaService carrinhaService;
	
	@GetMapping("/funcionario")
	public String funcionario(){
		return "/dashboards/dashboard";
	}
	
	@ModelAttribute("totalFuncionarios")
	public int totalFuncionarios() {
		return funcionarioService.buscarTodos().size();
	}
	
	@ModelAttribute("totalCarrinhas")
	public int totalCarrinhas() {
		return carrinhaService.buscarTodos().size();
	}
   
}
