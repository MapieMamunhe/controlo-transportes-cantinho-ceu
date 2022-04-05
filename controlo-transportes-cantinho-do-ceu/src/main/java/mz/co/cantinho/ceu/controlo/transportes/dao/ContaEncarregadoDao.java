package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaEncarregado;

public interface ContaEncarregadoDao {

	void save(ContaEncarregado contaEncarregado);
	void update(ContaEncarregado contaEncarregado);
	void delete(Long id);
	List<ContaEncarregado> findAll();
	ContaEncarregado findById(Long id);
	
}
