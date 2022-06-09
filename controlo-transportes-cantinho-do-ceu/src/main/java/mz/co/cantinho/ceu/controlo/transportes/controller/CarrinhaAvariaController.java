package mz.co.cantinho.ceu.controlo.transportes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;
import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;
import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaAvaria;
import mz.co.cantinho.ceu.controlo.transportes.service.AvariaService;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaAvariaService;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaService;

@Controller
@RequestMapping("/carrinha-avaria")
public class CarrinhaAvariaController {

	@Autowired
	private CarrinhaService carrinhaService;
	
	@Autowired
	private AvariaService avariaService;
	
	@Autowired
	private CarrinhaAvariaService carrinhaAvariaService;
	
	@GetMapping("/comunicar")
	public String comunicar(CarrinhaAvaria carrinhaAvaria) {
		return "/cadastros/avaria-carrinha";
	}
	
	@PostMapping("/registar")
	public String registar(@Valid CarrinhaAvaria carrinhaAvaria, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			System.out.println("Found an error...");
			return "/cadastros/avaria-carrinha";
		}
		carrinhaAvariaService.gravar(carrinhaAvaria);
		attr.addFlashAttribute("success", "Avaria reportada com sucesso.");
		return "redirect:/carrinha-avaria/comunicar";
	}
	
	@ModelAttribute("carrinhas")
	public List<Carrinha> carrinhas(){
		return carrinhaService.buscarTodos();
	}
	
	@ModelAttribute("avarias")
	public List<Avaria> avarias(){
		return avariaService.buscarTodos();
	}
	
}
