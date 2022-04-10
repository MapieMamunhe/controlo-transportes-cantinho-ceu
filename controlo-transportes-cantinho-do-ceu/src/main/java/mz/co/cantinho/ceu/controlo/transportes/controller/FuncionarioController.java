package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuncionarioController {
    @GetMapping("/funcionarios/motorista/novo")
    public String funcionario(){
        return "/cadastros/motorista";}

        @GetMapping("/funcionarios/secretaria/novo")
        public String secretaria(){
            return "/cadastros/secretaria";}
}
