package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
   @GetMapping("/funcionario")
   public String funcionario(){
       return ("/dashboards/funcionario");
   } 
   
}
