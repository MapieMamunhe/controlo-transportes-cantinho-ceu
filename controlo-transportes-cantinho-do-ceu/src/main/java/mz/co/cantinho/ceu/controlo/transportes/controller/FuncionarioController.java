package mz.co.cantinho.ceu.controlo.transportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;
import mz.co.cantinho.ceu.controlo.transportes.service.EducadoraService;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.MotoristaService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private MotoristaService motoristaService;
	
	@Autowired
	private EducadoraService educadoraService;
	
    @GetMapping("/novo")
    public String secretaria(Funcionario funcionario){
    	return "/cadastros/funcionario";
    }

	@GetMapping("/")
    public String listar(){
    	return "/listar/funcionarios";
    }
    
    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario){
    	//Telefone alternativo é opcional. Ao clicar em submit é enviada uma string vazia, no
    	//entanto a coluna tem a constraint 'UNIQUE', logo há necessidade de passar um nulo.
    	if(funcionario.getTelefoneAlternativo().equals("")) {
    		funcionario.setTelefoneAlternativo(null);
    	}
    			
    	if(funcionario.getEmail().equals("")) {//Mesmo que telefone alternativo
    		funcionario.setEmail(null);
    	}		
    			
    	funcionarioService.gravar(funcionario);
    	
    	registarPorPapel(funcionario);
    	return "redirect:/funcionarios/novo";
    }
    
    //Regista funcionário de acordo com o papel (mototrista ou educadora)
    private void registarPorPapel(Funcionario funcionario) {
    	switch(funcionario.getPapel()) {
    		case "Motorista":
    			Motorista motorista = new Motorista();
    			motorista.setFuncionario(funcionario);
    			motoristaService.gravar(motorista);
    			break;
    			
    		case "Educadora":
    			Educadora educadora = new Educadora();
    			educadora.setFuncionario(funcionario);
    			educadoraService.gravar(educadora);
    			break;
    			
    		default:
    			break;
    	}
    }
}
