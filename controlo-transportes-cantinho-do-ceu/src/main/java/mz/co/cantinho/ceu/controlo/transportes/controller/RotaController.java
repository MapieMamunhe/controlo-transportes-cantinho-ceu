package mz.co.cantinho.ceu.controlo.transportes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cantinho.ceu.controlo.transportes.domain.Rota;
import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;
import mz.co.cantinho.ceu.controlo.transportes.service.RotaService;
import mz.co.cantinho.ceu.controlo.transportes.service.ZonaRotaService;
import mz.co.cantinho.ceu.controlo.transportes.service.ZonaService;

@Controller
@RequestMapping("/rota")
public class RotaController {

	@Autowired
	private RotaService rotaService;
	
	@Autowired
	private ZonaService zonaService;
	
	@Autowired
	private ZonaRotaService zonaRotaService;
	
	@GetMapping("/cadastrar")
	private String cadastrar(Rota rota) {
		return "";
	}
	
	@PostMapping("/salvar")
	public String salvar(Rota rota) {
		rotaService.gravar(rota);
		return "redirect:/rota/cadastrar";
	}
	
	@ModelAttribute("zona")
	public List<Zona> listaDeZonas(){
		return zonaService.buscarTodos();
	}
}
