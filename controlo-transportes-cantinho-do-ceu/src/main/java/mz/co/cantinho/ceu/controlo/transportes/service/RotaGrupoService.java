package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.RotaGrupo;

public interface RotaGrupoService {

	void gravar(RotaGrupo rotaGrupo);
	void actualizar(RotaGrupo rotaGrupo);
	void remover(Long id);
	RotaGrupo buscarPorId(Long id);
	List<RotaGrupo> buscarTodos();
	
}
