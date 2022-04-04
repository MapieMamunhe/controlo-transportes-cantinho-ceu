package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ZonaRota;

public interface ZonaRotaDao {

	void save(ZonaRota zonaRota);
	void update(ZonaRota zonaRota);
	void delete(Long id);
	List<ZonaRota> findAll();
	
}
