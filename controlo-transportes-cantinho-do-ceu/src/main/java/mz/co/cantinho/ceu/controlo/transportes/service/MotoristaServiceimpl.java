package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.MotoristaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;

@Service
@Transactional(readOnly = false)
public class MotoristaServiceimpl implements MotoristaService {

	@Autowired
	private MotoristaDao dao;
	
	@Override
	public void gravar(Motorista motorista) {
		dao.save(motorista);
		
	}

	@Override
	public void actualizar(Motorista motorista) {
		dao.update(motorista);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = false)
	public Motorista buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<Motorista> buscarTodos() {
		return dao.findAll();
	}

}
