package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;

@Repository
public class PerfilDaoImpl  extends AbstractDao<Perfil, Long> implements PerfilDao{

	@Override
	public Perfil findByName(String name) {
		List<Perfil> perfis = createQuery("select p from Perfil p where p.nome = ?1", name);
		if(!perfis.isEmpty()) {
			return perfis.get(0);
		}
		
		return null;
	}
	
}
