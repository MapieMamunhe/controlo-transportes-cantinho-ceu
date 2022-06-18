package mz.co.cantinho.ceu.controlo.transportes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;
import mz.co.cantinho.ceu.controlo.transportes.service.ZonaService;

@Controller
@RequestMapping("/zonas")
public class ZonaController {

	@Autowired
	private ZonaService service;
	
	@GetMapping("/listar")
	public String listar() {
		return "listar/zonas";
	}
	
	@ModelAttribute("zonas")
	public List<Zona> zonas(){
		return service.buscarTodos();
	}
}
