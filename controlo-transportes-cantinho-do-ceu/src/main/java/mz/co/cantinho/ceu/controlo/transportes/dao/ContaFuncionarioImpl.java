package mz.co.cantinho.ceu.controlo.transportes.dao;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;

@Repository
public class ContaFuncionarioImpl extends AbstractDao<ContaFuncionario, Long> implements ContaFuncionarioDao{

	@Override
	public ContaFuncionario findByFuncionarioId(Long id) {
		return createQuery("select c from ContaFuncionario c where c.funcionario.id = ?1", id).get(0);
	}

}
