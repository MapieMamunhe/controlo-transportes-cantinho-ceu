package mz.co.cantinho.ceu.controlo.transportes.controlotransportescantinhodoceu.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "entrega")
public class Entrega extends EntidadeAbstrata<Long>{

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "educadora_id")
	private Educadora educadora;
	
	@ManyToOne
	@JoinColumn(name = "crianca_id")
	private Crianca crianca;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Educadora getEducadora() {
		return educadora;
	}

	public void setEducadora(Educadora educadora) {
		this.educadora = educadora;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}
	
}
