package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;

@Repository
public class CarrinhaDaoImpl extends AbstractDao<Carrinha, Long> implements CarrinhaDao{

	@Override
	public boolean matriculaExiste(String matricula) {
		return !createQuery("select c from Carrinha c where c.matricula = ?1", matricula).isEmpty();
	}

	@Override
	public List<Carrinha> findByRegistration(String matricula) {
		return createQuery("select c from Carrinha c where c.matricula like concat('%', ?1, '%')", matricula);
	}

}
