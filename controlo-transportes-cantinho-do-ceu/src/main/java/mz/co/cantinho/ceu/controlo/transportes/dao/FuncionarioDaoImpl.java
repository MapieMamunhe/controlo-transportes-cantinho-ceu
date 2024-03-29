package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

	@Override
	public boolean nrDocumentoExiste(String nrDocumento, Long id) {
		if(id != null) {
			return !createQuery("select f from Funcionario f where f.id != ?1 and f.nrDocumento = ?2", id, nrDocumento).isEmpty();
		}
		return !createQuery("select f from Funcionario f where f.nrDocumento = ?1", nrDocumento).isEmpty();
	}

	@Override
	public boolean celularExiste(String celular, Long id) {
		if(id != null) {
			return !createQuery("select f from Funcionario f where f.id != ?1 and (f.telefone = ?2 or f.telefoneAlternativo = ?2)", id, celular).isEmpty();
		}
		return !createQuery("select f from Funcionario f where f.telefone = ?1 or f.telefoneAlternativo = ?1", celular).isEmpty();
	}

	@Override
	public boolean emailExiste(String email, Long id) {
		if(id != null) {
			return !createQuery("select f from Funcionario f where f.id != ?1 and f.email = ?2", id, email).isEmpty();
		}
		return !createQuery("select f from Funcionario f where f.email = ?1", email).isEmpty();
	}

	@Override
	public Funcionario findByCellOrEmail(String cellOrEmail) {
		List<Funcionario> lista = createQuery("select f from Funcionario f where f.telefone = ?1 or f.email = ?1", cellOrEmail);
		
		if(lista.isEmpty()) {
			return null;
		}
		
		return lista.get(0);
	}

	@Override
	public List<Funcionario> findByName(String nome) {
		return createQuery("select f from Funcionario f where f.nome like concat('%', ?1, '%') or f.apelido like concat('%', ?1, '%')", nome);
	}

}
