package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.ContaEncarregadoDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.ContaEncarregado;

@Service
@Transactional(readOnly = false)
public class ContaEncarregadoServiceImpl implements ContaEncarregadoService {

	@Autowired
	private ContaEncarregadoDao dao;
	
	@Override
	public void gravar(ContaEncarregado contaEncarregado) {
		dao.save(contaEncarregado);
		
	}

	@Override
	public void actualizar(ContaEncarregado contaEncarregado) {
		dao.update(contaEncarregado);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ContaEncarregado buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ContaEncarregado> buscarTodos() {
		return dao.findAll();
	}

}
