package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;

public interface AvariaService {

	void gravar(Avaria avaria);
	void actualizar(Avaria avaria);
	void remover(Long id);
	Avaria buscarPorId(Long id);
	List<Avaria> buscarTodos();
	
}
