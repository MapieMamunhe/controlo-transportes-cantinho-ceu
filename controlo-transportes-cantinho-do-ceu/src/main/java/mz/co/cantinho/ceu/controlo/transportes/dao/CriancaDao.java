package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Crianca;

public interface CriancaDao {

	void save(Crianca crianca);
	void update(Crianca crianca);
	void delete(Long id);
	List<Crianca> findAll();
	Crianca findById(Long id);
	
}
