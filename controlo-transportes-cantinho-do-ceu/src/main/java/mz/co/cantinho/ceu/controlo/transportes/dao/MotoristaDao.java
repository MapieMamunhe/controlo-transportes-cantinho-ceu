package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;

public interface MotoristaDao {

	void save(Motorista motorista);
	void update(Motorista funcionario);
	void delete(Long id);
	List<Motorista> findAll();
	Motorista findById(Long id);
}
