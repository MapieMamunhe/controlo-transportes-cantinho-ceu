package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.CarrinhaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Carrinha;

@Service
@Transactional(readOnly = false)
public class CarrinhaServiceImpl implements CarrinhaService{

	@Autowired
	private CarrinhaDao dao;
	
	@Override
	public void gravar(Carrinha carrinha) {
		dao.save(carrinha);
		
	}

	@Override
	public void actualizar(Carrinha carrinha) {
		dao.update(carrinha);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Carrinha buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Carrinha> buscarTodos() {
		return sort(dao.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public boolean matriculaExiste(String matricula, Long id) {
		return dao.matriculaExiste(matricula, id);
	}

	@Override
	public List<Carrinha> buscarPorMatricula(String matricula) {
		return sort(dao.findByRegistration(matricula));
	}
	
	//========================================AUXILIARES========================================================
	private List<Carrinha> sort(List<Carrinha> carrinhas) {
		carrinhas.sort(Comparator.comparing(Carrinha::getMatricula).thenComparing(Carrinha::getCapacidade).thenComparing(Carrinha::getLugaresOcupados));
		return carrinhas;
	}

}
