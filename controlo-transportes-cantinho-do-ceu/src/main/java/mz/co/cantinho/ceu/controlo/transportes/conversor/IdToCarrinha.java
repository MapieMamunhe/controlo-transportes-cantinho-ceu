package mz.co.cantinho.ceu.controlo.transportes.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;
import mz.co.cantinho.ceu.controlo.transportes.service.CarrinhaService;

@Component
public class IdToCarrinha implements Converter<String, Carrinha>{

	@Autowired
	private CarrinhaService service;
	
	@Override
	public Carrinha convert(String id) {
		long longId = 0;
		System.out.println("ID recebido pela carrinha: " + id);
		try {
			longId = Long.parseLong(id.replace(" ", ""));
		}
		catch(NumberFormatException ex) {
			System.out.println("Impossível converter " + id + " para ID\n" + ex.getMessage());
			return null;
		}
		if(longId <= 0) {
			return null;
		}
		return service.buscarPorId(longId);
	}

}
