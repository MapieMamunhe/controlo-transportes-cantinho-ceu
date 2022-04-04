package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.ZonaRotaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.ZonaRota;

@Service
@Transactional(readOnly = false)
public class ZonaRotaServiceImpl implements ZonaRotaService{

	@Autowired
	private ZonaRotaDao dao;
	
	@Override
	public void gravar(ZonaRota zonaRota) {
		dao.save(zonaRota);
		
	}

	@Override
	public void actualizar(ZonaRota zonaRota) {
		dao.update(zonaRota);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ZonaRota buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ZonaRota> buscarTodos() {
		return dao.findAll();
	}

}
