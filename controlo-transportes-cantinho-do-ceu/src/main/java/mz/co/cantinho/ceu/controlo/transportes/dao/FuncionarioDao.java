package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

public interface FuncionarioDao {

	void save(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Long id);
	List<Funcionario> findAll();
	Funcionario findById(Long id);
	
}
