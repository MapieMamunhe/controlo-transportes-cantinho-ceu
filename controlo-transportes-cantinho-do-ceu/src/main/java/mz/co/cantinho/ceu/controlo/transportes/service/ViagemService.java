package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Viagem;

public interface ViagemService {

	void gravar(Viagem viagem);
	void actualizar(Viagem viagem);
	void remover(Long id);
	Viagem buscarPorId(Long id);
	List<Viagem> buscarTodos();
	
}
