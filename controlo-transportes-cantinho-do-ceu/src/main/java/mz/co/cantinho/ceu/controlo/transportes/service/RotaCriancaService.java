package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.RotaCrianca;

public interface RotaCriancaService {

	void gravar(RotaCrianca rotaCrianca);
	void actualizar(RotaCrianca rotaCrianca);
	void remover(Long id);
	RotaCrianca buscarPorId(Long id);
	List<RotaCrianca> buscarTodos();
	
}
