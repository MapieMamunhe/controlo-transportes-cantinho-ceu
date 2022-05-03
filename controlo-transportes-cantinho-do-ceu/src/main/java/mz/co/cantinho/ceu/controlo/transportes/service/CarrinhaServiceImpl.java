package mz.co.cantinho.ceu.controlo.transportes.service;

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
		return dao.findAll();
	}

	@Override
	public boolean matriculaExiste(String matricula) {
		return dao.matriculaExiste(matricula);
	}

}
