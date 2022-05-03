package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.CriancaEncarregado;

public interface CriancaEncarregadoDao {

	void save(CriancaEncarregado criancaEncarregado);
	void update(CriancaEncarregado criancaEncarregado);
	void delete(Long id);
	List<CriancaEncarregado> findAll();
	CriancaEncarregado findById(Long id);
	
}
