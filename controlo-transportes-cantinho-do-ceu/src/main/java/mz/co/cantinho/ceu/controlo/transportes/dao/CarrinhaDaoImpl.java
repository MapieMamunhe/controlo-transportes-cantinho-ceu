package mz.co.cantinho.ceu.controlo.transportes.dao;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;

@Repository
public class CarrinhaDaoImpl extends AbstractDao<Carrinha, Long> implements CarrinhaDao{

	@Override
	public boolean matriculaExiste(String matricula) {
		return !createQuery("select c from Carrinha c where c.matricula = ?1", matricula).isEmpty();
	}

}
