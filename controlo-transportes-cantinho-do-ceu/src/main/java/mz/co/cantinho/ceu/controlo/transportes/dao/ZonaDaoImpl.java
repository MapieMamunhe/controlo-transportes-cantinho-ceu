package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;

@Repository
public class ZonaDaoImpl extends AbstractDao<Zona, Long> implements ZonaDao{

	@Override
	public Zona findByName(String nome) {
		List<Zona> zona = createQuery("select z from Zona z where z.nome = ?1", nome);
		if(zona.isEmpty()) {
			return null;
		}
		return zona.get(0);
	}

	@Override
	public boolean bairroExiste(String bairro) {
		return findByName(bairro) != null;
	}

}
