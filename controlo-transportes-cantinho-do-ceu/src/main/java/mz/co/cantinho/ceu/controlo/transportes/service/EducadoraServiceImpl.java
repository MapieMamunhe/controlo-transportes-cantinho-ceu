package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.EducadoraDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;

@Service
@Transactional(readOnly = false)
public class EducadoraServiceImpl implements EducadoraService{

	@Autowired
	private EducadoraDao dao;
	
	@Override
	public void gravar(Educadora educadora) {
		dao.save(educadora);
	}

	@Override
	public void actualizar(Educadora educadora) {
		dao.update(educadora);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Educadora buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Educadora> buscarTodos() {
		return dao.findAll();
	}

}
