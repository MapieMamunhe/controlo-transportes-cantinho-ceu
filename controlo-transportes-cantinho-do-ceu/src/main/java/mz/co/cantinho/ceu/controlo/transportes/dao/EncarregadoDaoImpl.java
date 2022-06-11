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

	@Override
	public boolean telefoneExiste(String telefone, Long id) {
		if(id == null) {
			return !createQuery("select e from Encarregado e where e.telefone = ?1 or e.telefoneAlternativo = ?1", telefone).isEmpty();
		}
		return !createQuery("select e from Encarregado e where e.id != ?1 and (e.telefone = ?2 or e.telefoneAlternativo = ?2)", id, telefone).isEmpty();
	}

	@Override
	public boolean emailExiste(String email, Long id) {
		if(id == null) {
			return !createQuery("select e from Encarregado e where e.email = ?1", email).isEmpty();
		}
		return !createQuery("select e from Encarregado e where e.id != ?1 and e.email = ?2", id, email).isEmpty();
	}

}
