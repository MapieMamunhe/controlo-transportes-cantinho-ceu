package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AltHomeController {

	@GetMapping("/home")
	public String home() {
		return "/dashboards/funcionario";
	}
}
