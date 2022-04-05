package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.CriancaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Crianca;

@Service
@Transactional(readOnly = false)
public class CriancaServiceImpl implements CriancaService {

	@Autowired
	private CriancaDao dao;
	
	@Override
	public void gravar(Crianca crianca) {
		dao.save(crianca);
		
	}

	@Override
	public void actualizar(Crianca crianca) {
		dao.update(crianca);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Crianca buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Crianca> buscarTodos() {
		return dao.findAll();
	}

}
