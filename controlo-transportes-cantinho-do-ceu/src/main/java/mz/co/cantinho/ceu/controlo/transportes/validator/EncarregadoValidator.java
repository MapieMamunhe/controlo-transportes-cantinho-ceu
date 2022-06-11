package mz.co.cantinho.ceu.controlo.transportes.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;
import mz.co.cantinho.ceu.controlo.transportes.service.EncarregadoService;

@Component
public class EncarregadoValidator implements Validator {

	@Autowired
	private EncarregadoService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Encarregado.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Encarregado encarregado = (Encarregado) target;
		
		//verifica se nome é válido
		if(!nomeValido(encarregado.getNome())) {
			System.out.println("nome n valido");
			errors.rejectValue("nome", "NomeValido.Utilizador");
		}
		
		//verifica se apelido é válido
		if(!nomeValido(encarregado.getApelido())) {
			errors.rejectValue("apelido", "ApelidoValido.Utilizador");
		}
		
		//verifica se celular é válido
		if(!celularValido(encarregado.getTelefone())) {
			errors.rejectValue("telefone", "TelefoneValido.Utilizador");
		}
		else {
			//verifiar se já existe um encarregado com um número de celular semelhante
			if(service.celularExiste(encarregado.getTelefone(), encarregado.getId())) {
				errors.rejectValue("telefone", "Duplicado.Funcionario.telefone");
			}
		}
		
		//verifica se celular alternativo é válido
		if(!encarregado.getTelefoneAlternativo().replace(" ", "").isEmpty()) {
			if(!celularValido(encarregado.getTelefoneAlternativo())) {
				errors.rejectValue("telefoneAlternativo", "TelefoneValido.Utilizador");
			}
			else {
				//verifiar se já existe um encarregado com um número de celular semelhante
				if(service.celularExiste(encarregado.getTelefoneAlternativo(), encarregado.getId())) {
					errors.rejectValue("telefoneAlternativo", "Duplicado.Funcionario.telefone");
				}
			}
		}
		
		//verifica se email é válido
		if(!encarregado.getEmail().replace(" ", "").isEmpty() && service.emailExiste(encarregado.getEmail(), encarregado.getId())) {
			errors.rejectValue("email", "Duplicado.Funcionario.email");
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
