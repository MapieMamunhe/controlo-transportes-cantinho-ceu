package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Grupo;

public interface GrupoDao {

	void save(Grupo grupo);
	void update(Grupo grupo);
	void delete(Long id);
	List<Grupo> findAll();
	
}
