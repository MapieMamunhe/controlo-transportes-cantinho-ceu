package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;

public interface ZonaService {

	void gravar(Zona zona);
	void actualizar(Zona zona);
	void remover(Long id);
	Zona buscarPorId(Long id);
	List<Zona> buscarTodos();
	Zona buscarPorNome(String nome);
	boolean bairroExiste(String residencia);
	
}
