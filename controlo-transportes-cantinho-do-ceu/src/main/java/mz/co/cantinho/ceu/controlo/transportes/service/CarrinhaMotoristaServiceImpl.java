package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.CarrinhaMotoristaDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.CarrinhaMotorista;

@Service
@Transactional(readOnly = false)
public class CarrinhaMotoristaServiceImpl implements CarrinhaMotoristaService{

	@Autowired
	private CarrinhaMotoristaDao dao;
	
	@Override
	public void gravar(CarrinhaMotorista carrinhaMotorista) {
		dao.save(carrinhaMotorista);
		
	}

	@Override
	public void actualizar(CarrinhaMotorista carrinhaMotorista) {
		dao.update(carrinhaMotorista);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public CarrinhaMotorista buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CarrinhaMotorista> buscarTodos() {
		return dao.findAll();
	}

	
	
}
