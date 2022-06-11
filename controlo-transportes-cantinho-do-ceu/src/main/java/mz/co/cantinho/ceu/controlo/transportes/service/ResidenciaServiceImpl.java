package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.ResidenciaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Residencia;

@Service
@Transactional(readOnly = true)
public class ResidenciaServiceImpl implements ResidenciaService{

	@Autowired
	ResidenciaDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void gravar(Residencia residencia) {
		dao.save(residencia);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void actualizar(Residencia residencia) {
		dao.update(residencia);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Residencia buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Residencia> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public Residencia buscarPorFuncionario(Funcionario funcionario) {
		return dao.findByFuncionario(funcionario);
	}

}
