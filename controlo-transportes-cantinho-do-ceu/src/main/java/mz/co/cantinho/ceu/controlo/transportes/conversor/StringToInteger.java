package mz.co.cantinho.ceu.controlo.transportes.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer>{

	@Override
	public Integer convert(String numero) {
		if(numero.trim().matches("{2}[0-9]")) {
			try {
				return Integer.parseInt(numero);
			}
			catch(NumberFormatException ex) {
				return null;
			}
		}
		return null;
	}

}
