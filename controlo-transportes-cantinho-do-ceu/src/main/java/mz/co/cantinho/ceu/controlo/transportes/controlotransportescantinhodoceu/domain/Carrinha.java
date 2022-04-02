package mz.co.cantinho.ceu.controlo.transportes.controlotransportescantinhodoceu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "carrinha")
public class Carrinha extends EntidadeAbstrata<Long>{

	@Column(nullable = false)
	private int capacidade;
	
	@Column(name = "lugares_ocupados",nullable = false)
	private int lugaresOcupados;
	
	@Column(nullable = false, length = 8)
	private String matricula;

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getLugaresOcupados() {
		return lugaresOcupados;
	}

	public void setLugaresOcupados(int lugaresOcupados) {
		this.lugaresOcupados = lugaresOcupados;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
}
