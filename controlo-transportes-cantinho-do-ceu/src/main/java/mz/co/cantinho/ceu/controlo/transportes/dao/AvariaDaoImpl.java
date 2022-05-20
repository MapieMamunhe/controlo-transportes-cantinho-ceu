package mz.co.cantinho.ceu.controlo.transportes.dao;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;

@Repository
public class AvariaDaoImpl extends AbstractDao<Avaria, Long> implements AvariaDao{

	@Override
	public boolean avariaExiste(String tipo) {
		return !createQuery("select a from Avaria a where a.tipo = ?1", tipo).isEmpty();
	}

}
