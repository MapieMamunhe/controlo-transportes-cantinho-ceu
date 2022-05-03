package mz.co.cantinho.ceu.controlo.transportes.dao;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

	@Override
	public boolean nrDocumentoExiste(String nrDocumento) {
		return !createQuery("select f from Funcionario f where f.nrDocumento = ?1", nrDocumento).isEmpty();
	}

	@Override
	public boolean celularExiste(String celular) {
		return !createQuery("select f from Funcionario f where f.telefone = ?1 or f.telefoneAlternativo = ?1", celular).isEmpty();
	}

	@Override
	public boolean emailExiste(String email) {
		return !createQuery("select f from Funcionario f where f.email = ?1", email).isEmpty();
	}

}
