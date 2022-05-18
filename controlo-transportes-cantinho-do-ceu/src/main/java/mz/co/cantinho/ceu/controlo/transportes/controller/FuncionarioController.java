package mz.co.cantinho.ceu.controlo.transportes.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.cantinho.ceu.controlo.transportes.domain.CidadeDistrito;
import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;
import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;
import mz.co.cantinho.ceu.controlo.transportes.service.ContaFuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.EducadoraService;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.MotoristaService;
import mz.co.cantinho.ceu.controlo.transportes.service.PerfilService;
import mz.co.cantinho.ceu.controlo.transportes.validator.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private ContaFuncionarioService contaFuncionarioService;

	@Autowired
	private MotoristaService motoristaService;

	@Autowired
	private EducadoraService educadoraService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private FuncionarioValidator funcionarioValidator;

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
		// Telefone alternativo é opcional. Ao clicar em submit é enviada uma string
		// vazia, no
		// entanto a coluna tem a constraint 'UNIQUE', logo há necessidade de passar um
		// nulo.
		if (funcionario.getTelefoneAlternativo().equals("")) {
			funcionario.setTelefoneAlternativo(null);
		}

		if (funcionario.getEmail().equals("")) {// Mesmo que telefone alternativo
			funcionario.setEmail(null);
		}

		if (result.hasErrors()) {// verifica se campos têm erros
			return "/cadastros/funcionario";
		}
		funcionarioService.gravar(funcionario);
		criarConta(funcionario);
		registarPorPapel(funcionario);
		attr.addFlashAttribute("success", "Funcionário cadastrado com sucesso");
		return "redirect:/funcionarios/novo";
	}

	// Regista funcionário de acordo com o papel (mototrista ou educadora)
	private void registarPorPapel(Funcionario funcionario) {
		switch (funcionario.getPapel()) {
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

	// Cria conta de funcionário.
	private void criarConta(Funcionario funcionario) {
		ContaFuncionario contaF = new ContaFuncionario();
		contaF.setFuncionario(funcionario);
		contaF.setPerfil(perfilService.buscarPorNome(funcionario.getPapel()));
		contaF.setPalavraPasse(DigestUtils.sha256Hex("[0000]"));
		contaFuncionarioService.gravar(contaF);
	}
	
	@GetMapping("/pesquisar")
	public String buscarPorNome(@RequestParam("nome")String nome, ModelMap model) {
		model.addAttribute("funcionarios", contaFuncionarioService.buscarPorNomeFuncionario(nome));
		return "/listar/funcionarios";
	}

	@ModelAttribute("funcionarios")
	public List<ContaFuncionario> funcionarios() {
		return contaFuncionarioService.buscarTodos();
	}

	@ModelAttribute("bairro")
	public CidadeDistrito[] bairros() {
		return CidadeDistrito.values();
	}

	@ModelAttribute("perfis")
	public List<Perfil> perfis() {
		return perfilService.buscarTodos();
	}
	
}
