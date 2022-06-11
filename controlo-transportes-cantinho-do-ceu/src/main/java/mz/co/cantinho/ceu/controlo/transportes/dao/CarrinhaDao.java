package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;

public interface CarrinhaDao {

	void save(Carrinha carrinha);
	void update(Carrinha carrinha);
	void delete(Long id);
	List<Carrinha> findAll();
	Carrinha findById(Long id);
	boolean matriculaExiste(String matricula, Long id);
	List<Carrinha> findByRegistration(String matricula);
	
}
