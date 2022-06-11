package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;

public interface EncarregadoService {

	void gravar(Encarregado encarregado);
	void actualizar(Encarregado encarregado);
	void remover(Long id);
	Encarregado buscarPorId(Long id);
	List<Encarregado> buscarTodos();
	List<Encarregado> buscarPorNome(String nome);
	boolean celularExiste(String celular, Long id);
	boolean emailExiste(String email, Long id);
	
}
