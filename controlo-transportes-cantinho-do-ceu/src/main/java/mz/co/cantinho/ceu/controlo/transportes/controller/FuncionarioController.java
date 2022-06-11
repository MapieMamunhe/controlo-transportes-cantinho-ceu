package mz.co.cantinho.ceu.controlo.transportes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;
import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;
import mz.co.cantinho.ceu.controlo.transportes.service.ContaFuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.PerfilService;
import mz.co.cantinho.ceu.controlo.transportes.service.ZonaService;
import mz.co.cantinho.ceu.controlo.transportes.validator.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ContaFuncionarioService contaFuncService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private FuncionarioValidator funcionarioValidator;
	
	@Autowired
	private ZonaService zonaService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(funcionarioValidator);
	}

	@GetMapping("/novo")
	public String novo(Funcionario funcionario) {
		return "/cadastros/funcionario";
	}

	@GetMapping("/listar")
	public String listar() {
		return "/listar/funcionarios";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, ModelMap model,
			RedirectAttributes attr) {
		
		if (result.hasErrors()) {// verifica se campos têm erros
			return "/cadastros/funcionario";
		}
		funcionarioService.gravar(funcionario);
		attr.addFlashAttribute("success", "Funcionário cadastrado com sucesso");
		return "redirect:/funcionarios/novo";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "/cadastros/funcionario";
	}
	
	@PostMapping("/editar")
	public String actualizar(@Valid Funcionario funcionario, RedirectAttributes attr, BindingResult result) {
		funcionario.setConta(contaFuncService.buscarPorFuncionario(funcionario.getId()));
		if(result.hasErrors()) {
			return "/cadastros/funcionario";
		}
		funcionarioService.actualizar(funcionario);
		attr.addFlashAttribute("success", "Funcionário actualizado com sucesso.");
		return "redirect:/funcionarios/novo";
	}
	
	@GetMapping("/pesquisar")
	public String buscarPorNome(@RequestParam("nome")String nome, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
		return "/listar/funcionarios";
	}

	@ModelAttribute("funcionarios")
	public List<Funcionario> funcionarios() {
		return funcionarioService.buscarTodos();
	}
	
	@ModelAttribute("bairro")
	public List<Zona> bairros() {
		return zonaService.buscarTodos();
	}

	@ModelAttribute("perfis")
	public List<Perfil> perfis() {
		return perfilService.buscarTodos();
	}
	
}
