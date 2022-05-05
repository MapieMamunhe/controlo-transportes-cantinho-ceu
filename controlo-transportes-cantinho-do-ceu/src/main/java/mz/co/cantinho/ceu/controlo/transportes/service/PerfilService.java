package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;

public interface PerfilService {

	void gravar(Perfil perfil);
	void actualizar(Perfil perfil);
	void remover(Long id);
	Perfil buscarPorId(Long id);
	List<Perfil> buscarTodos();
	Perfil buscarPorNome(String nome);
}
