package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.ContaFuncionarioDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;

@Service
@Transactional(readOnly = false)
public class ContaFuncionarioServiceImpl implements ContaFuncionarioService{

	@Autowired
	private ContaFuncionarioDao dao;
	
	@Override
	public void gravar(ContaFuncionario contaFuncionario) {
		dao.save(contaFuncionario);
		
	}

	@Override
	public void actualizar(ContaFuncionario contaFuncionario) {
		dao.update(contaFuncionario);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = false)
	public ContaFuncionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<ContaFuncionario> buscarTodos() {
		return dao.findAll();
	}

}
