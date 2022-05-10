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
		
		
	}
	
	// AUXILIARES
	// Validar nome
	private boolean nomeValido(String nome) {
		return nome.matches("[A-Za-zÀ-Úà-ú ]*");
	}

}
