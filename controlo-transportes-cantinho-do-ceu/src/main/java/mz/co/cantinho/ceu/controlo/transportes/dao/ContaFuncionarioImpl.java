package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;

@Repository
public class ContaFuncionarioImpl extends AbstractDao<ContaFuncionario, Long> implements ContaFuncionarioDao{

	@Override
	public ContaFuncionario findByFuncionarioId(Long id) {
		return createQuery("select c from ContaFuncionario c where c.funcionario.id = ?1", id).get(0);
	}

	@Override
	public List<ContaFuncionario> findFuncionarioName(String nome) {
		return createQuery("select c from ContaFuncionario c where c.funcionario.nome like concat('%', ?1, '%')"
				+ "or c.funcionario.apelido like concat('%', ?1, '%')", nome);
	}

}
