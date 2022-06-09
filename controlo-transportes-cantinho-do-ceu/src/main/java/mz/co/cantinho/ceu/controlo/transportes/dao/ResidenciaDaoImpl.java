package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Residencia;

@Repository
public class ResidenciaDaoImpl extends AbstractDao<Residencia, Long> implements ResidenciaDao{

	@Override
	public Residencia findByFuncionario(Funcionario funcionario) {
		List <Residencia> residencia = createQuery("select r from Residencia r where r.funcionario = ?1", funcionario);
		if(residencia.isEmpty()) {
			return null;
		}
		return residencia.get(0);
	}

}
