package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaAvaria;

public interface CarrinhaAvariaDao {

	void save(CarrinhaAvaria carrinhaAvaria);
	void update(CarrinhaAvaria carrinhaAvaria);
	void delete(Long id);
	List<CarrinhaAvaria> findAll();
	
}
