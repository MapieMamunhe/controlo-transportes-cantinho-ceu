package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.FuncionarioLog;

public interface FuncionarioLogService {

	void gravar(FuncionarioLog funcionarioLog);
	void actualizar(FuncionarioLog funcionarioLog);
	void remover(Long id);
	List<FuncionarioLog> buscarTodos();
	FuncionarioLog buscarPorId(Long id);
	List<FuncionarioLog> buscarPorFuncionario(ContaFuncionario conta);
	
}
