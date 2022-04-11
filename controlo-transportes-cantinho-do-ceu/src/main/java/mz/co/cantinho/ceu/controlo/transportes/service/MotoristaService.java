package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;

public interface MotoristaService {

	void gravar(Motorista motorista);
	void actualizar(Motorista motorista);
	void remover(Long id);
	Motorista buscarPorId(Long id);
	List<Motorista> buscarTodos();
	List<Motorista> buscarPorNrDocumento(String nrDocumento);
	
}
