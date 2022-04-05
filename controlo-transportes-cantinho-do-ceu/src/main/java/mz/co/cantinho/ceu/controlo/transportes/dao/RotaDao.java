package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Rota;

public interface RotaDao {

	void save(Rota rota);
	void update(Rota rota);
	void delete(Long id);
	List<Rota> findAll();
	Rota findById(Long id);
	
}
