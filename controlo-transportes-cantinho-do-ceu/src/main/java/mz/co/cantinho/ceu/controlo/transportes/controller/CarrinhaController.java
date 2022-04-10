package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarrinhaController {
    @GetMapping("/carrinhas/nova")
    public String novaCarinha(){
        return "/cadastros/carrinha";}

       
}
