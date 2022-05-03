package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "carrinha")
public class Carrinha extends EntidadeAbstrata<Long>{

	@NotNull
	@Positive
	@Min(value = 15)
	@Max(value = 30)
	@Digits(fraction = 0, integer = 2)
	@Column(nullable = false)
	private int capacidade;
	
	@NotNull
	@PositiveOrZero
	@Digits(fraction = 0, integer = 2)
	@Column(name = "lugares_ocupados",nullable = false)
	private int lugaresOcupados;
	
	@NotBlank
	@NotNull
	@Size(min = 3, max = 50)
	@Column(nullable = false, length = 50)
	private String matricula;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_registo", nullable = false)
	private LocalDate dataRegisto = LocalDate.now();

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
