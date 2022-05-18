package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;

public interface ContaFuncionarioDao {

	void save(ContaFuncionario contaFuncionario);
	void update(ContaFuncionario contaFuncionario);
	void delete(Long id);
	List<ContaFuncionario> findAll();
	List<ContaFuncionario> findFuncionarioName(String nome);
	ContaFuncionario findById(Long id);
	ContaFuncionario findByFuncionarioId(Long id);
}
