package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.AvariaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Avaria;

@Service
@Transactional(readOnly = false)
public class AvariaServiceImpl implements AvariaService{

	@Autowired
	private AvariaDao dao;
	
	@Override
	public void gravar(Avaria avaria) {
		dao.save(avaria);
		
	}

	@Override
	public void actualizar(Avaria avaria) {
		dao.update(avaria);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Avaria buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Avaria> buscarTodos() {
		return dao.findAll();
	}

}
