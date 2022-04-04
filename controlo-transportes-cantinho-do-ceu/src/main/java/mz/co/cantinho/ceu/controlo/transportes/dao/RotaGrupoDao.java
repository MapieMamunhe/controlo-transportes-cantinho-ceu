package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.RotaGrupo;

public interface RotaGrupoDao {

	void save(RotaGrupo rotaGrupo);
	void update(RotaGrupo rotaGrupo);
	void delete(Long id);
	List<RotaGrupo> findAll();
	
}
