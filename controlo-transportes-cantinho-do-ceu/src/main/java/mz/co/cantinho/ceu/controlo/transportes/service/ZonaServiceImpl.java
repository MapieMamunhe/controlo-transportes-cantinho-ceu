package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.ZonaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;

@Service
@Transactional(readOnly = false)
public class ZonaServiceImpl implements ZonaService {

	@Autowired
	private ZonaDao dao;
	
	@Override
	public void gravar(Zona zona) {
		dao.save(zona);
		
	}

	@Override
	public void actualizar(Zona zona) {
		dao.update(zona);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Zona buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Zona> buscarTodos() {
		return dao.findAll();
	}

}
