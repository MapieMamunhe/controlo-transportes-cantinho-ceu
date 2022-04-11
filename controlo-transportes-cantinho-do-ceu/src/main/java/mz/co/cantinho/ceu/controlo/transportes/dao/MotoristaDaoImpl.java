package mz.co.cantinho.ceu.controlo.transportes.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;

@Repository
public class MotoristaDaoImpl extends AbstractDao<Motorista, Long> implements MotoristaDao{

	@Override
	public List<Motorista> findByDocument(String nrDocumento) {
		return createQuery("SELECT f.id FROM funcionario f WHERE f.nr_documento = ?1", nrDocumento);
	}

	
	
}
