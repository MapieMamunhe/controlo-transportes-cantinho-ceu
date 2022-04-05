package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.EncarregadoDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Encarregado;

@Service
@Transactional(readOnly = false)
public class EncarregadoServiceImpl implements EncarregadoService {

	@Autowired
	private EncarregadoDao dao;
	
	@Override
	public void gravar(Encarregado encarregado) {
		dao.save(encarregado);
		
	}

	@Override
	public void actualizar(Encarregado encarregado) {
		dao.update(encarregado);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Encarregado buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Encarregado> buscarTodos() {
		return dao.findAll();
	}

}
