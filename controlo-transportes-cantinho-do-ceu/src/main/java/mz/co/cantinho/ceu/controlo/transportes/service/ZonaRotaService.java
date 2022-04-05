package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import mz.co.cantinho.ceu.controlo.transportes.domain.ZonaRota;

public interface ZonaRotaService {

	void gravar(ZonaRota zonaRota);
	void actualizar(ZonaRota zonaRota);
	void remover(Long id);
	ZonaRota buscarPorId(Long id);
	List<ZonaRota> buscarTodos();
	
}
