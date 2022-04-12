package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;

public interface EducadoraService {

	void gravar(Educadora educadora);
	void actualizar(Educadora educadora);
	void remover(Long id);
	Educadora buscarPorId(Long id);
	List<Educadora> buscarTodos();
	
}
