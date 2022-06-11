package mz.co.cantinho.ceu.controlo.transportes.validator;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;
import mz.co.cantinho.ceu.controlo.transportes.service.ZonaService;

@Component
public class FuncionarioValidator implements Validator {

	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private ZonaService zonaService;
	
	@Autowired
	PasswordEncoder passwordEncoder;;

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Funcionario funcionario = (Funcionario) target;
		
		if(funcionario.getId() == null) {
			funcionario.getConta().setFuncionario(funcionario);
			funcionario.getConta().setPalavraPasse(passwordEncoder.encode("0000"));
		}

		// validar nome
		if (!nomeValido(funcionario.getNome())) {
			errors.rejectValue("nome", "NomeValido.Utilizador");
		}

		if (!nomeValido(funcionario.getApelido())) {
			errors.rejectValue("apelido", "ApelidoValido.Utilizador");
		}

		//Validar sexo
		if(!funcionario.getSexo().equals("M") && !funcionario.getSexo().equals("F")) {
			errors.rejectValue("sexo", "SexoValido.Funcionario");
		}
		
		// validar documento
		if(tipoDocumentoValido(funcionario.getTipoDocumento())) {
			if (!documentoValido(funcionario.getTipoDocumento(), funcionario.getNrDocumento())) {
				errors.rejectValue("nrDocumento", "DocumentoValido.Funcionario");
			}
			//id não nulo significa que se trata de uma edição, devemos verificar se o documento existe no registo de outros funcionarios
			else{
				// verifica se existe um documento com o mesmo número registado
				if (service.nrDocumentoExiste(funcionario.getNrDocumento(), funcionario.getId())) {
					errors.rejectValue("nrDocumento", "Duplicado.Funcionario.nrDocumento");
				}
			}
		}
		else {
			errors.rejectValue("tipoDocumento", "DocumentoValido.tipo.Funcionario");
		}
		

		// validar celular
		if(!funcionario.getTelefone().replace(" ", "").isEmpty()) {
			if (!celularValido(funcionario.getTelefone())) {
				errors.rejectValue("telefone", "TelefoneValido.Utilizador");
			} 
			else {// verifica se celular já foi registado
				if (service.celularExiste(funcionario.getTelefone(), funcionario.getId())) {
					errors.rejectValue("telefone", "Duplicado.Funcionario.telefone");
				}
			}
		}

		// validar celular alternativo, se for introduzido
		if (!funcionario.getTelefoneAlternativo().replace(" ", "").isEmpty()) {
			if (!celularValido(funcionario.getTelefoneAlternativo())) {
				errors.rejectValue("telefoneAlternativo", "TelefoneValido.Utilizador");
			}
			else {// verificações feitas caso número alternativo seja válido
				if (funcionario.getTelefone().trim().equals(funcionario.getTelefoneAlternativo().trim())) {
					errors.rejectValue("telefoneAlternativo", "Iguais.Funcionario.telefone");
				}
				else if (service.celularExiste(funcionario.getTelefoneAlternativo(), funcionario.getId())) {
					errors.rejectValue("telefoneAlternativo", "Duplicado.Funcionario.telefone");
				}
			}
		}
		else {
			// Telefone alternativo é opcional. Ao clicar em submit é enviada uma string
			// vazia, no
			// entanto a coluna tem a constraint 'UNIQUE', logo há necessidade de passar um
			// nulo.
			funcionario.setTelefoneAlternativo(null);
		}

		// Verificar se já existe o email, caso seja introduzido
		if (!funcionario.getEmail().replace(" ", "").isEmpty()){
			if (service.emailExiste(funcionario.getEmail(), funcionario.getId())) {
				errors.rejectValue("email", "Duplicado.Funcionario.email");
			}
		}
		else {
			//Email, também é opcional, aplicamos a mesma lógica que do telefone alternativo.
			funcionario.setEmail(null);
		}
		
		//validar residencia
		//Em caso de edição, remover a parte da cidade da String de residência
		String residenciaForm = funcionario.getResidencia().replace(", Maputo", "");
		funcionario.setResidencia(residenciaForm);
		residenciaForm = funcionario.getResidencia().replace(", Matola", "");
		funcionario.setResidencia(residenciaForm);
		if(zonaService.bairroExiste(funcionario.getResidencia())) {
			if(funcionario.getResidenciaQuarteirao() <= 0) {
				errors.rejectValue("residenciaQuarteirao", "Residencia.QuarteiraoValido.Funcionario");
			}
		}
		else {
			errors.rejectValue("residencia", "Residencia.BairroValido.Funcionario");
		}

		// verificar idade
		if(funcionario.getDataNascimento() != null) {
			if (!idadeValida(funcionario.getDataNascimento(), funcionario.getConta().getPerfil().getNome())) {
				if (funcionario.getConta().getPerfil().getNome().equalsIgnoreCase("Motorista")) {
					errors.rejectValue("dataNascimento", "DataDeNascimentoValida.Funcionario.Motorista");
				}
				else {
					errors.rejectValue("dataNascimento", "DataDeNascimentoValida.Funcionario");
				}
			}
		}

	}

	// AUXILIARES
	// Validar nome
	private boolean nomeValido(String nome) {
		return nome.matches("[A-Za-zÀ-Úà-ú ]*");
	}

	//Validar tipo de dpcumento
	private boolean tipoDocumentoValido(String tipoDoc) {
		return tipoDoc.equals("BI") || tipoDoc.equals("Passaporte") || tipoDoc.equals("Carta de Condução");
	}
	
	// Validar número de documento de acordo com o tipo
	private boolean documentoValido(String tipo, String numero) {
		switch (tipo) {
			case "BI":
				return numero.matches("[0-9]{12}[A-Z]");

			case "Passaporte":
				return numero.matches("[0-9]{2}[A-Z]{2}[0-9]{5}");

			case "Carta de Condução":
				return numero.matches("[0-9]{8}[/][0-9]");

			default:
				return false;
		}
	}

	// Verifica se o número de celular é válido
	private boolean celularValido(String numero) {
		return numero.matches("8[2-7][0-9]{7}");
	}

	// Verifica se idade é maior ou igual à 18
	private boolean idadeValida(LocalDate dataNascimento, String papel) {
		LocalDate hoje = LocalDate.now();

		Period period = Period.between(dataNascimento, hoje);
		int idade = period.getYears();

		if (papel.equalsIgnoreCase("Motorista")) {
			return idade >= 21;
		}

		return idade >= 18;
	}

}
