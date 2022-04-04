package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaMotorista;

public interface CarrinhaMotoristaDao {

	void save(CarrinhaMotorista carrinhaMotorista);
	void update(CarrinhaMotorista carrinhaMotorista);
	void delete(Long id);
	List<CarrinhaMotorista> findAll();
	
}
