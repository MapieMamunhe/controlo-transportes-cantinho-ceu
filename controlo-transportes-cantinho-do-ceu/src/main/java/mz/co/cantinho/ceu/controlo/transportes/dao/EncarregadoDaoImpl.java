package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;

@Repository
public class EncarregadoDaoImpl extends AbstractDao<Encarregado, Long> implements EncarregadoDao{

	@Override
	public List<Encarregado> findByNome(String nome) {
		return createQuery("select e from Encarregado e where e.nome like concat('%', ?1, '%') or e.apelido like concat('%', ?1, '%')", nome);
	}

}
