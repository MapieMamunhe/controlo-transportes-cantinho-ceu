package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "carrinha")
public class Carrinha extends EntidadeAbstrata<Long>{

	@NotBlank
	@NotNull
	@Positive
	@Min(value = 15)
	@Column(nullable = false)
	private int capacidade;
	
	@NotNull
	@PositiveOrZero
	@Column(name = "lugares_ocupados",nullable = false)
	private int lugaresOcupados;
	
	@NotBlank
	@NotNull
	@Column(nullable = false, length = 8)
	private String matricula;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_registo", nullable = false)
	private LocalDate dataRegisto;

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
