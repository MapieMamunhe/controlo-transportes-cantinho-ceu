package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;

public interface EncarregadoDao {

	void save(Encarregado encarregado);
	void update(Encarregado encarregado);
	void delete(Long id);
	List<Encarregado> findAll();
	Encarregado findById(Long id);
	
}
