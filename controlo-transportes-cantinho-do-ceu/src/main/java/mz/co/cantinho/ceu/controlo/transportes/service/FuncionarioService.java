package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

public interface FuncionarioService {

	void gravar(Funcionario cargo);
	void actualizar(Funcionario cargo);
	void remover(Long id);
	Funcionario buscarPorId(Long id);
	List<Funcionario> buscarTodos();
	
}
