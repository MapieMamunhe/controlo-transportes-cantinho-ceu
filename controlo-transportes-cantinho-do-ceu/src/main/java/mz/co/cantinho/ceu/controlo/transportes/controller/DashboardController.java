package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaAvariaService;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaService;
import mz.co.cantinho.ceu.controlo.transportes.service.ContaEncarregadoService;
import mz.co.cantinho.ceu.controlo.transportes.service.ContaFuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.CriancaService;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.ZonaService;

@Controller
public class DashboardController {
   
	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	CarrinhaService carrinhaService;
	
	@Autowired
	ZonaService zonaService;
	
	@Autowired
	ContaFuncionarioService contaFuncService;
	
	@Autowired
	ContaEncarregadoService contaEncService;
	
	@Autowired
	CarrinhaAvariaService carAvariaService;
	
	@Autowired
	CriancaService criancaService;
	
	@GetMapping("/funcionario")
	public String funcionario(){
		return "/dashboards/dashboard";
	}
	
	@ModelAttribute("totalFuncionarios")
	public int totalFuncionarios() {
		return funcionarioService.buscarTodos().size();
	}
	
	@ModelAttribute("totalZonas")
	public int totalZonas() {
		return zonaService.buscarTodos().size();
	}
	
	@ModelAttribute("totalUtilizadores")
	public int totalUtilizadores() {
		int totFuncionarios = contaFuncService.buscarTodos().size();
		int totEncarregados = contaEncService.buscarTodos().size();
		return totFuncionarios + totEncarregados;
	}
	
	@ModelAttribute("totalCarrinhas")
	public int totalCarrinhas() {
		return carrinhaService.buscarTodos().size();
	}
	
	@ModelAttribute("totalCarAvariadas")
	public int totalCarAvariadas() {
		return carAvariaService.buscarTodos().size();
	}
	
	@ModelAttribute("totalCriancas")
	public int totalCriancas() {
		return criancaService.buscarTodos().size();
	}
   
}
