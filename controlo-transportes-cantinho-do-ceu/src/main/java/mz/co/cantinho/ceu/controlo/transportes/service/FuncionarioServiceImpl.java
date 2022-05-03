package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.FuncionarioDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao dao;

	@Override
	public void gravar(Funcionario Funcionario) {
		dao.save(Funcionario);
		
	}

	@Override
	public void actualizar(Funcionario Funcionario) {
		dao.update(Funcionario);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean nrDocumentoExiste(String nrDocumento) {
		return dao.nrDocumentoExiste(nrDocumento);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean celularExiste(String telefone) {
		return dao.celularExiste(telefone);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean emailExiste(String email) {
		return dao.emailExiste(email);
	}


}
