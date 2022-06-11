package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

public interface FuncionarioService {

	void gravar(Funcionario Funcionario);
	void actualizar(Funcionario Funcionario);
	void remover(Long id);
	Funcionario buscarPorId(Long id);
	List<Funcionario> buscarTodos();
	boolean celularExiste(String telefone, Long id);
	boolean emailExiste(String email, Long id);
	List<Funcionario> buscarPorNome(String nome);
	boolean nrDocumentoExiste(String nrDocumento, Long id);
	
}
