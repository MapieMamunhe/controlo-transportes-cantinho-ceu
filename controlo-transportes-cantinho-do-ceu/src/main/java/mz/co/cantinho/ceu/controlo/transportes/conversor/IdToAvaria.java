package mz.co.cantinho.ceu.controlo.transportes.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;
import mz.co.cantinho.ceu.controlo.transportes.service.AvariaService;

@Component
public class IdToAvaria implements Converter<String, Avaria>{

	@Autowired
	private AvariaService service;
	
	@Override
	public Avaria convert(String id) {
		long longId = 0;
		try {
			longId = Long.parseLong(id);
		}
		catch(NumberFormatException ex) {
			System.out.println("Impossível converter " + id + " para ID:\n" + ex.getMessage());
			return null;
		}
		
		return service.buscarPorId(longId);
	}

}
