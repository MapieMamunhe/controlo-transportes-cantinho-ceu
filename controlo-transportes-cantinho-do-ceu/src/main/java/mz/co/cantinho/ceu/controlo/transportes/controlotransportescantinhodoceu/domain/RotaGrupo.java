package mz.co.cantinho.ceu.controlo.transportes.controlotransportescantinhodoceu.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "rotagrupo")
public class RotaGrupo extends EntidadeAbstrata<Long> {

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_alocacao", nullable = false)
	private LocalDate dataAlocacao;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_fim", nullable = false)
	private LocalDate dataFim;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	@ManyToOne()
	@JoinColumn(name = "rota_id")
	private Rota rota;

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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
	
}
