package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;

public interface ContaFuncionarioService {

	void gravar(ContaFuncionario contaFuncionario);
	void actualizar(ContaFuncionario contaFuncionario);
	void remover(Long id);
	ContaFuncionario buscarPorId(Long id);
	List<ContaFuncionario> buscarTodos();
	List<ContaFuncionario> buscarPorNomeFuncionario(String nome);
	
}
