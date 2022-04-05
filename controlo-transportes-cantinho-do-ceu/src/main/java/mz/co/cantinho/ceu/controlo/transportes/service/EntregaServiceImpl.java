package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.EntregaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Entrega;

@Service
@Transactional(readOnly = false)
public class EntregaServiceImpl implements EntregaService {

	@Autowired
	private EntregaDao dao;
	
	@Override
	public void gravar(Entrega entrega) {
		dao.save(entrega);
		
	}

	@Override
	public void actualizar(Entrega entrega) {
		dao.update(entrega);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Entrega buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Entrega> buscarTodos() {
		return dao.findAll();
	}

}
