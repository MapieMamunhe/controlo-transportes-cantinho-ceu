package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Crianca;

public interface CriancaService {

	void gravar(Crianca crianca);
	void actualizar(Crianca crianca);
	void remover(Long id);
	Crianca buscarPorId(Long id);
	List<Crianca> buscarTodos();
	
}
