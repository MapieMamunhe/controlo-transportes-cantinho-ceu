package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.FuncionarioLog;

@Repository
public class FuncionarioLogDaoImpl  extends AbstractDao<FuncionarioLog, Long> implements FuncionarioLogDao {

	@Override
	public List<FuncionarioLog> findByFuncionario(ContaFuncionario conta) {
		return createQuery("select l from FuncionarioLog l where l.conta = ?1", conta);
	}

}
