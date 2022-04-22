package mz.co.cantinho.ceu.controlo.transportes.validator;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

public class FuncionarioValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Funcionario funcionario = (Funcionario)target;
		
		//validar documento
		if(!documentoValido(funcionario.getTipoDocumento(), funcionario.getNrDocumento())) {
			errors.rejectValue("doc-num", "Número de documento inválido.");
		}
		
		//validar celular
		if(!celularValido(funcionario.getTelefone())) {
			errors.rejectValue("telef-1", "Celular inválido.");
		}
		
		//validar celular alternativo, se for introduzido
		if(!funcionario.getTelefoneAlternativo().equals(null)) {
			if(!celularValido(funcionario.getTelefoneAlternativo())) {
				errors.rejectValue("telef-2", "Celular inválido.");
			}
		}
		
		//verificar idade
		if(!idadeValida(funcionario.getDataNascimento(), funcionario.getPapel())) {
			if(funcionario.getPapel().equalsIgnoreCase("Motorista")) {
				errors.rejectValue("", "Data de nascimento inválida. Motorista deve ter idade igual ou superior à 21 anos.");
			}
			else {
				errors.rejectValue("", "Data de nascimento inválida. Funcionário deve ter idade igual ou superior à 18 anos.");
			}
		}
		
	}
	
	//Validar número de documento de acordo com o tipo
	private boolean documentoValido(String tipo, String numero) {
		switch(tipo) {
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
	
	//Verifica se o número de celular é válido
	private boolean celularValido(String numero) {
		return numero.matches("8[2-7][0-9]{7}");
	}
	
	//Verifica se idade é maior ou igual à 18
	private boolean idadeValida(LocalDate dataNascimento, String papel) {
		LocalDate hoje = LocalDate.now();
		
		Period period = Period.between(dataNascimento, hoje);
		int idade = period.getYears();
		
		if(papel.equalsIgnoreCase("Motorista")) {
			return idade>=21;
		}
		
		return idade>=18;
	}
	
}
