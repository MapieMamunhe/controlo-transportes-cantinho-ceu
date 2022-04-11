package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

public interface EducadoraDao {
	
	void save(Funcionario funcionario);
	void update(Educadora educadora);
	void delete(Long id);
	List<Educadora> findAll();
	Educadora findById(Long id);
	
}
