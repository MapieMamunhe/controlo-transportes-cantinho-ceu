package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.ViagemDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Viagem;

@Service
@Transactional(readOnly = false)
public class ViagemServiceImpl implements ViagemService{

	@Autowired
	private ViagemDao dao;
	
	@Override
	public void gravar(Viagem viagem) {
		dao.save(viagem);
		
	}

	@Override
	public void actualizar(Viagem viagem) {
		dao.update(viagem);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Viagem buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Viagem> buscarTodos() {
		return dao.findAll();
	}

}
