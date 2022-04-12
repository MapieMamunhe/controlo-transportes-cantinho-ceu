package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cantinho.ceu.controlo.transportes.service.EducadoraService;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

@Controller
@RequestMapping("/funcionarios/educadora")
public class EducadoraController {

	@Autowired
	private EducadoraService educadoraService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/novo")
	public String cadastrar(Funcionario funcionario) {
		return "/cadastros/secretaria";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario) {
		//Telefone alternativo é opcional. Ao clicar em submit é enviada uma string vazia, no
		//entanto a coluna tem a constraint 'UNIQUE', logo há necessidade de passar um nulo.
		if(funcionario.getTelefoneAlternativo().equals("")) {
			funcionario.setTelefoneAlternativo(null);
		}
				
		if(funcionario.getEmail().equals("")) {//Mesmo que telefone alternativo
			funcionario.setEmail(null);
		}
		
		funcionarioService.gravar(funcionario);
		
		Educadora educadora = new Educadora();
		educadora.setFuncionario(funcionario);
		
		educadoraService.gravar(educadora);
		return "redirect:/funcionarios/educadora/novo";
	}
}
