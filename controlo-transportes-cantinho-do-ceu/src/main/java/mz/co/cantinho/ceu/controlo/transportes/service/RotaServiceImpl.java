package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.RotaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Rota;

@Service
@Transactional(readOnly = false)
public class RotaServiceImpl implements RotaService{

	@Autowired
	private RotaDao dao;
	
	@Override
	public void gravar(Rota rota) {
		dao.save(rota);
		
	}

	@Override
	public void actualizar(Rota rota) {
		dao.update(rota);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Rota buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Rota> buscarTodos() {
		return dao.findAll();
	}

}
