package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Residencia;

public interface ResidenciaService {
	void gravar(Residencia residencia);
	void actualizar(Residencia residencia);
	void remover(Long id);
	Residencia buscarPorId(Long id);
	List<Residencia> buscarTodos();
}
