package mz.co.cantinho.ceu.controlo.transportes.validator;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.service.FuncionarioService;

@Component
public class FuncionarioValidator implements Validator {

	@Autowired
	private FuncionarioService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Funcionario funcionario = (Funcionario) target;

		// Validar escolha de perfil
		if (funcionario.getPapel().equalsIgnoreCase("0")) {
			System.out.println("Nenhum papel selecionado");
			errors.rejectValue("papel", "PapelValido.Funcionario");
		}

		// validar nome
		if (!nomeValido(funcionario.getNome())) {
			errors.rejectValue("nome", "NomeValido.Funcionario");
		}

		if (!nomeValido(funcionario.getApelido())) {
			errors.rejectValue("apelido", "ApelidoValido.Funcionario");
		}

		// validar documento
		if (!documentoValido(funcionario.getTipoDocumento(), funcionario.getNrDocumento())) {
			errors.rejectValue("nrDocumento", "DocumentoValido.Funcionario");
		} else {// verifica se existe um documento com o mesmo número registado
			if (service.nrDocumentoExiste(funcionario.getNrDocumento())) {
				errors.rejectValue("nrDocumento", "Duplicado.Funcionario.nrDocumento");
			}
		}

		// validar celular
		if (!celularValido(funcionario.getTelefone())) {
			errors.rejectValue("telefone", "TelefoneValido.Funcionario");
		} else {// verifica se celular já foi registado
			if (service.celularExiste(funcionario.getTelefone())) {
				errors.rejectValue("telefone", "Duplicado.Funcionario.telefone");
			}
		}

		// validar celular alternativo, se for introduzido
		if (!funcionario.getTelefoneAlternativo().replace(" ", "").isEmpty()) {
			if (!celularValido(funcionario.getTelefoneAlternativo())) {
				errors.rejectValue("telefoneAlternativo", "TelefoneValido.Funcionario");
			} else {// verificações feitas caso número alternativo seja válido
				if (funcionario.getTelefone().trim().equals(funcionario.getTelefoneAlternativo().trim())) {
					errors.rejectValue("telefoneAlternativo", "Iguais.Funcionario.telefone");
				} else if (service.celularExiste(funcionario.getTelefoneAlternativo())) {
					errors.rejectValue("telefoneAlternativo", "Duplicado.Funcionario.telefone");
				}
			}
		}

		// Verificar se já existe o email, caso seja introduzido
		if (!funcionario.getEmail().replace(" ", "").isEmpty())

		{
			if (service.emailExiste(funcionario.getEmail())) {
				errors.rejectValue("email", "Duplicado.Funcionario.email");
			}
		}

		// verificar idade
		if (!idadeValida(funcionario.getDataNascimento(), funcionario.getPapel())) {
			if (funcionario.getPapel().equalsIgnoreCase("Motorista")) {
				errors.rejectValue("dataNascimento", "DataDeNascimentoValida.Funcionario.Motorista");
			} else {
				errors.rejectValue("dataNascimento", "DataDeNascimentoValida.Funcionario");
			}
		}

	}

	// AUXILIARES
	// Validar nome
	private boolean nomeValido(String nome) {
		return nome.matches("[A-Za-zÀ-Úà-ú ]*");
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
