package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;

@Repository
public class PerfilDaoImpl  extends AbstractDao<Perfil, Long> implements PerfilDao{

	@Override
	public Perfil findByName(String name) {
		List<Perfil> perfis = createQuery("select p from Perfil p where p.nome = ?1", name);
		System.out.println(name + "\nEncontrdados: " + perfis.size());
		return perfis.get(0);
	}
	
}
