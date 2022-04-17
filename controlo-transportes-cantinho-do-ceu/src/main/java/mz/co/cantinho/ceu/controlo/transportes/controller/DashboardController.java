package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

@Controller
public class DashboardController {
   
	@GetMapping("/funcionario")
   public String funcionario(){
       return "/dashboards/dashboard";
   } 
   
}
