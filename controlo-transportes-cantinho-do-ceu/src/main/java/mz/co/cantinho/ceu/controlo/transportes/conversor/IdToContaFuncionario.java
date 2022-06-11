package mz.co.cantinho.ceu.controlo.transportes.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;
import mz.co.cantinho.ceu.controlo.transportes.service.ContaFuncionarioService;

@Component
public class IdToContaFuncionario implements Converter<String, ContaFuncionario> {

	@Autowired
	private ContaFuncionarioService service;
	
	@Override
	public ContaFuncionario convert(String id) {
		long longId = 0;
		try {
			longId = Long.parseLong(id);
		}
		catch(NumberFormatException nfex) {
			System.out.println("Impossível converter id para conta.\n" + nfex.getMessage());
			return null;
		}
		return service.buscarPorId(longId);
	}

}
