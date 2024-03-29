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
@Table(name = "rotacrianca")
public class RotaCrianca extends EntidadeAbstrata<Long>{

	@NotNull
	@PastOrPresent
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_alocacao", nullable = false)
	private LocalDate dataAlocacao;
	
	@PastOrPresent
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_fim")
	private LocalDate dataFim;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "rota_id")
	private Rota rota;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "crianca_id")
	private Crianca crianca;

	public LocalDate getDataAlocacao() {
		return dataAlocacao;
	}

	public void setDataAlocacao(LocalDate dataAlocacao) {
		this.dataAlocacao = dataAlocacao;
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

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}
	
}
