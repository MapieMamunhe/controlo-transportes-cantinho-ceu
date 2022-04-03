package mz.co.cantinho.ceu.controlo.transportes.domain;

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
@Table(name = "viagem")
public class Viagem extends EntidadeAbstrata<Long> {

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "hora_inicio", nullable = false)
	private LocalDate horaInicio;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "hora_fim")
	private LocalDate horaFim;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;

	public LocalDate getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDate horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDate getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalDate horaFim) {
		this.horaFim = horaFim;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
