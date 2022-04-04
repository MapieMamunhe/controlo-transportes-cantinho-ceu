package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.RotaCrianca;

public interface RotaCriancaDao {

	void save(RotaCrianca rotaCrianca);
	void update(RotaCrianca rotaCrianca);
	void delete(Long id);
	List<RotaCrianca> findAll();
	
}
