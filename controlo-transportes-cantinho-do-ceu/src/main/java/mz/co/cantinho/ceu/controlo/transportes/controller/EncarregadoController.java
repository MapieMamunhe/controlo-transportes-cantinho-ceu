package mz.co.cantinho.ceu.controlo.transportes.controller;
import org.springframework.web.bind.annotation.*;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;
import mz.co.cantinho.ceu.controlo.transportes.service.EncarregadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;


@Controller
@RequestMapping("/encarregados")
public class EncarregadoController {
    @Autowired
	private EncarregadoService encarregadoService;
    @GetMapping("/listar")
    public String index() {
        return "/listar/encarregados";
    }

    @GetMapping("/novo")
    public String novo(Encarregado encarregado) {
        return "/cadastros/encarregado";
    }
    
}
