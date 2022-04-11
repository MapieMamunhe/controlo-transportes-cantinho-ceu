package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

public interface EducadoraService {

	void gravar(Funcionario funcionario);
	void actualizar(Educadora educadora);
	void remover(Long id);
	Educadora buscarPorId(Long id);
	List<Educadora> buscarTodos();
	
}
