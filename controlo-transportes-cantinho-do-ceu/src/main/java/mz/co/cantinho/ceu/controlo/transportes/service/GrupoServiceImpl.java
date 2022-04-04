package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.GrupoDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Grupo;

@Service
@Transactional(readOnly = false)
public class GrupoServiceImpl implements GrupoService{

	@Autowired
	private GrupoDao dao;
	
	@Override
	public void gravar(Grupo grupo) {
		dao.save(grupo);
		
	}

	@Override
	public void actualizar(Grupo grupo) {
		dao.update(grupo);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Grupo buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> buscarTodos() {
		return dao.findAll();
	}

}
