package mz.co.cantinho.ceu.controlo.transportes.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;

@Component
public class EncarregadoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Encarregado.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Encarregado encarregado = (Encarregado) target;
		
		if(!nomeValido(encarregado.getNome())) {
			System.out.println("nome n valido");
			errors.rejectValue("nome", "NomeValido.Utilizador");
		}
		
		if(!nomeValido(encarregado.getApelido())) {
			errors.rejectValue("apelido", "ApelidoValido.Utilizador");
		}
		
		if(!celularValido(encarregado.getTelefone())) {
			errors.rejectValue("telefone", "TelefoneValido.Utilizador");
		}
		
		if(!encarregado.getTelefoneAlternativo().replace(" ", "").isEmpty()) {
			if(!celularValido(encarregado.getTelefoneAlternativo())) {
				errors.rejectValue("telefoneAlternativo", "TelefoneValido.Utilizador");
			}
		}
		
		
		
	}
	
	// AUXILIARES
	// Validar nome
	private boolean nomeValido(String nome) {
		return nome.matches("[A-Za-zÀ-Úà-ú ]*");
	}
	
	// Verifica se o número de celular é válido
	private boolean celularValido(String numero) {
		return numero.matches("8[2-7][0-9]{7}");
	}

}
