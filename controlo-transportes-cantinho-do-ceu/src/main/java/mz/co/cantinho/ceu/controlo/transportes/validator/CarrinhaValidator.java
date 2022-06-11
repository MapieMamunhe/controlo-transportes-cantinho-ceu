package mz.co.cantinho.ceu.controlo.transportes.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaService;

@Component
public class CarrinhaValidator implements Validator{

	@Autowired
	private CarrinhaService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Carrinha.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Carrinha carrinha = (Carrinha) obj;
		
		//Elimina espaços em branco na matrícula
		carrinha.setMatricula(carrinha.getMatricula().replace(" ", ""));
		
		if(service.matriculaExiste(carrinha.getMatricula(), carrinha.getId())) {//verifica se matrícula já existe
			errors.rejectValue("matricula", "Duplicado.Carrinha.matricula");
		}
	}

}
