package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Rota;

public interface RotaService {

	void gravar(Rota rota);
	void actualizar(Rota rota);
	void remover(Long id);
	Rota buscarPorId(Long id);
	List<Rota> buscarTodos();
	
}
