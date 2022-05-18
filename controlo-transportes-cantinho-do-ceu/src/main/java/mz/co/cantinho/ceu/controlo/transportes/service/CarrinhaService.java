package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;

public interface CarrinhaService {

	void gravar(Carrinha carrinha);
	void actualizar(Carrinha carrinha);
	void remover(Long id);
	Carrinha buscarPorId(Long id);
	List<Carrinha> buscarTodos();
	boolean matriculaExiste(String matricula);
	List<Carrinha> buscarPorMatricula(String matricula);
	
}
