package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Entrega;

public interface EntregaService {

	void gravar(Entrega entrega);
	void actualizar(Entrega entrega);
	void remover(Long id);
	Entrega buscarPorId(Long id);
	List<Entrega> buscarTodos();
	
}
