package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;

public interface EducadoraDao {
	
	void save(Educadora educadora);
	void update(Educadora educadora);
	void delete(Long id);
	List<Educadora> findAll();
	
}
