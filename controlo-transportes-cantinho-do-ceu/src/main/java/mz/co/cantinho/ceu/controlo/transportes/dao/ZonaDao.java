package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;

public interface ZonaDao {

	void save(Zona zona);
	void update(Zona zona);
	void delete(Long id);
	List<Zona> findAll();
	Zona findById(Long id);
	Zona findByName(String nome);
	boolean bairroExiste(String bairro);
	
}
