package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

public interface FuncionarioDao {

	void save(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Long id);
	List<Funcionario> findAll();
	Funcionario findById(Long id);
	boolean celularExiste(String celular, Long id);
	boolean emailExiste(String email, Long id);
	Funcionario findByCellOrEmail(String cellOrEmail);
	List<Funcionario> findByName(String nome);
	boolean nrDocumentoExiste(String nrDocumento, Long id);
	
}
