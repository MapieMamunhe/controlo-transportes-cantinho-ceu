package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.CarrinhaAvariaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaAvaria;

@Service
@Transactional(readOnly = false)
public class CarrinhaAvariaServiceImpl implements CarrinhaAvariaService {

	@Autowired
	private CarrinhaAvariaDao dao;
	
	@Override
	public void gravar(CarrinhaAvaria carrinhaAvaria) {
		dao.save(carrinhaAvaria);
		
	}

	@Override
	public void actualizar(CarrinhaAvaria carrinhaAvaria) {
		dao.update(carrinhaAvaria);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public CarrinhaAvaria buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CarrinhaAvaria> buscarTodos() {
		return sort(dao.findAll());
	}
	
	//====================================================AUXILIARES=========================================================================
	private List<CarrinhaAvaria>sort(List<CarrinhaAvaria> carAvaria){
		carAvaria.sort(Comparator.comparing(CarrinhaAvaria::getDataAvaria));
		return carAvaria;
	}

}
