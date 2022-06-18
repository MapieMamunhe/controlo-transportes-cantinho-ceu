package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.cantinho.ceu.controlo.transportes.dao.FuncionarioLogDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.FuncionarioLog;

@Service
public class FuncionarioLogServiceImpl implements FuncionarioLogService{

	@Autowired
	FuncionarioLogDao dao;
	
	@Override
	public void gravar(FuncionarioLog funcionarioLog) {
		dao.save(funcionarioLog);
	}

	@Override
	public void actualizar(FuncionarioLog funcionarioLog) {
		dao.update(funcionarioLog);
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
	}

	@Override
	public List<FuncionarioLog> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public FuncionarioLog buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<FuncionarioLog> buscarPorFuncionario(ContaFuncionario conta) {
		return dao.findByFuncionario(conta);
	}

}
