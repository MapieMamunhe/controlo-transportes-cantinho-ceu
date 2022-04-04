package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaEncarregado;

public interface ContaEncarregadoService {

	void gravar(ContaEncarregado contaEncarregado);
	void actualizar(ContaEncarregado contaEncarregado);
	void remover(Long id);
	ContaEncarregado buscarPorId(Long id);
	List<ContaEncarregado> buscarTodos();
	
}
