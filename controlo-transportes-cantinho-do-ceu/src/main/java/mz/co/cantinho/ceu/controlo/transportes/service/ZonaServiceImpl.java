package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.ZonaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Zona;

@Service
@Transactional(readOnly = false)
public class ZonaServiceImpl implements ZonaService {

	@Autowired
	private ZonaDao dao;
	
	@Override
	public void gravar(Zona zona) {
		dao.save(zona);
		
	}

	@Override
	public void actualizar(Zona zona) {
		dao.update(zona);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Zona buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Zona> buscarTodos() {
		return sort(dao.findAll());
	}

	@Override
	public Zona buscarPorNome(String nome) {
		return dao.findByName(nome);
	}

	@Override
	public boolean bairroExiste(String bairro) {
		return dao.bairroExiste(bairro);
	}
	
	//========================================AUXILIARES======================================================
	
	private List<Zona> sort(List<Zona> zonas) {
		zonas.sort(Comparator.comparing(Zona::getNome).thenComparing(Zona::getCidade));
		return zonas;
	}

}
