package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.RotaGrupoDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.RotaGrupo;

@Service
@Transactional(readOnly = false)
public class RotaGrupoServiceImpl implements RotaGrupoService {

	@Autowired
	private RotaGrupoDao dao;
	
	@Override
	public void gravar(RotaGrupo rotaGrupo) {
		dao.save(rotaGrupo);
		
	}

	@Override
	public void actualizar(RotaGrupo rotaGrupo) {
		dao.update(rotaGrupo);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public RotaGrupo buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RotaGrupo> buscarTodos() {
		return dao.findAll();
	}

	
	
}
