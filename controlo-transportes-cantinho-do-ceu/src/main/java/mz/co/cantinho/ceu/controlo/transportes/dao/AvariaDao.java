package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;

public interface AvariaDao {

	void save(Avaria avaria);
	void update(Avaria avaria);
	void delete(Long id);
	List<Avaria> findAll();
	Avaria findById(Long id);
	
}
