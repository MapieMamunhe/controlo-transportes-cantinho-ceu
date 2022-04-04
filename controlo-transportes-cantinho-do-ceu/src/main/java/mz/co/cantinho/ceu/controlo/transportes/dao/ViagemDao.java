package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Viagem;

public interface ViagemDao {

	void save(Viagem viagem);
	void update(Viagem viagem);
	void delete(Long id);
	List<Viagem> findAll();
	
}
