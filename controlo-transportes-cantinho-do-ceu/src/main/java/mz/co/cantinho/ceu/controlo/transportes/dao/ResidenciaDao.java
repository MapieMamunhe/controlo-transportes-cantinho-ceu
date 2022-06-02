package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Residencia;

public interface ResidenciaDao {

	void save(Residencia residencia);
	void update(Residencia residencia);
	void delete(Long id);
	List<Residencia> findAll();
	Residencia findById(Long id);
	
}
