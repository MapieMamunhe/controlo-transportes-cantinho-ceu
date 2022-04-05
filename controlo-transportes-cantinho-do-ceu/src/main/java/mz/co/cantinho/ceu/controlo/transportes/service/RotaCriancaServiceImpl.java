package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.RotaCriancaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.RotaCrianca;

@Service
@Transactional(readOnly = false)
public class RotaCriancaServiceImpl implements RotaCriancaService {

	@Autowired
	private RotaCriancaDao dao;
	
	@Override
	public void gravar(RotaCrianca rotaCrianca) {
		dao.save(rotaCrianca);
		
	}

	@Override
	public void actualizar(RotaCrianca rotaCrianca) {
		dao.update(rotaCrianca);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public RotaCrianca buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RotaCrianca> buscarTodos() {
		return dao.findAll();
	}

}
