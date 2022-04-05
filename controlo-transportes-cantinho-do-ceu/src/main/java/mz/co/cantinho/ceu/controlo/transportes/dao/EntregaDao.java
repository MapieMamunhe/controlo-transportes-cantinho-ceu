package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Entrega;

public interface EntregaDao {

	void save(Entrega entrega);
	void update(Entrega entrega);
	void delete(Long id);
	List<Entrega> findAll();
	Entrega findById(Long id);
	
}
