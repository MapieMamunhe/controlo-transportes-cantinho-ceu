package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;

public interface PerfilDao {

	void save(Perfil perfil);
	void update(Perfil perfil);
	void delete(Long id);
	List<Perfil> findAll();
	Perfil findById(Long id);
	Perfil findByName(String name);
}
