package mz.co.cantinho.ceu.controlo.transportes.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;
import mz.co.cantinho.ceu.controlo.transportes.service.PerfilService;

@Component
public class IdToPerfil implements Converter<String, Perfil>{

	@Autowired
	PerfilService service;
	
	@Override
	public Perfil convert(String id) {
		long longId = 0;
		try {
			longId = Long.parseLong(id.replace(" ", ""));
		}
		catch(NumberFormatException nfex) {
			System.out.println("Impossível converter '" + id + "' para um ID de perfil." );
			return null;
		}
		if(longId <= 0) {
			return null;
		}
		
		return service.buscarPorId(longId);
	}

}
