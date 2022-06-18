package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.FuncionarioLog;

public interface FuncionarioLogDao {

	void save(FuncionarioLog log);
	void update(FuncionarioLog log);
	void delete(Long id);
	List<FuncionarioLog> findAll();
	FuncionarioLog findById(Long id);
	List<FuncionarioLog> findByFuncionario(ContaFuncionario conta);
}
