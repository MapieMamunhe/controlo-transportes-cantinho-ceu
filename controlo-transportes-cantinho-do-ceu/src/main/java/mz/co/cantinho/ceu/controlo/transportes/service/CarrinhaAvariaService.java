package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaAvaria;

public interface CarrinhaAvariaService {

	void gravar(CarrinhaAvaria carrinhaAvaria);
	void actualizar(CarrinhaAvaria carrinhaAvaria);
	void remover(Long id);
	CarrinhaAvaria buscarPorId(Long id);
	List<CarrinhaAvaria> buscarTodos();
	
}
