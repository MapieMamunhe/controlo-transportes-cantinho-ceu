package mz.co.cantinho.ceu.controlo.transportes.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;
import mz.co.cantinho.ceu.controlo.transportes.service.AvariaService;

@Component
public class AvariaValidator implements Validator{

	@Autowired
	private AvariaService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Avaria.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Avaria avaria = (Avaria) target;
		
		if(service.avariaExiste(avaria.getTipo())) {
			errors.rejectValue("tipo", "Duplicado.Avaria.matricula");
		}
	}

}
