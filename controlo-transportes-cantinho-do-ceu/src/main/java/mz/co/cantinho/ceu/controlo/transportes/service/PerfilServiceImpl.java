package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.PerfilDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Perfil;

@Service
@Transactional(readOnly = true)
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void gravar(Perfil perfil) {
		dao.save(perfil);
	}

	@Override
	@Transactional(readOnly = false)
	public void actualizar(Perfil perfil) {
		dao.update(perfil);
	}

	@Override
	@Transactional(readOnly = false)
	public void remover(Long id) {
		dao.delete(id);
	}

	@Override
	public Perfil buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Perfil> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public Perfil buscarPorNome(String nome) {
		return dao.findByName(nome);
	}

}
