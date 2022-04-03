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
@Table(name = "grupo")
public class Grupo extends EntidadeAbstrata<Long>{

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_formacao", nullable = false)
	LocalDate dataFormacao;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_formacao")
	LocalDate dataFim;
	
	@ManyToOne
	@JoinColumn(name = "mototrista_funcionario_id")
	private Motorista motorista;
	
	@ManyToOne
	@JoinColumn(name = "educadora_funcionario_id")
	private Educadora educadora;

	public LocalDate getDataFormacao() {
		return dataFormacao;
	}

	public void setDataFormacao(LocalDate dataFormacao) {
		this.dataFormacao = dataFormacao;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Educadora getEducadora() {
		return educadora;
	}

	public void setEducadora(Educadora educadora) {
		this.educadora = educadora;
	}
	
}
