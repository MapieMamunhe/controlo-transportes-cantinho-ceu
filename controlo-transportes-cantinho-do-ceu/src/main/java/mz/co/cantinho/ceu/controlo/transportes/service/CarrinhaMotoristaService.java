package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaMotorista;

public interface CarrinhaMotoristaService {
	
	void gravar(CarrinhaMotorista carrinhaMotorista);
	void actualizar(CarrinhaMotorista carrinhaMotorista);
	void remover(Long id);
	CarrinhaMotorista buscarPorId(Long id);
	List<CarrinhaMotorista> buscarTodos();
}
