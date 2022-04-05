package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Grupo;

public interface GrupoService {

	void gravar(Grupo grupo);
	void actualizar(Grupo grupo);
	void remover(Long id);
	Grupo buscarPorId(Long id);
	List<Grupo> buscarTodos();
	
}
