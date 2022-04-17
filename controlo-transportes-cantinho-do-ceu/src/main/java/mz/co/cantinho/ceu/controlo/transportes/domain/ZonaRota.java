package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "zonarota")
public class ZonaRota extends EntidadeAbstrata<Long> {

	@NotNull
	@PastOrPresent
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_atribuicao", nullable = false)
	LocalDate dataAtribuicao;
	
	@PastOrPresent
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_fim")
	LocalDate dataFim;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "rota_id", nullable = false)
	private Rota rota;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "zona_id", nullable = false)
	private Zona zona;

	public LocalDate getDataAtribuicao() {
		return dataAtribuicao;
	}

	public void setDataAtribuicao(LocalDate dataAtribuicao) {
		this.dataAtribuicao = dataAtribuicao;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
}
