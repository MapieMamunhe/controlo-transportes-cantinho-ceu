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
@Table(name = "carrinhaavaria")
public class CarrinhaAvaria extends EntidadeAbstrata<Long>{

	@NotNull
	@PastOrPresent
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_avaria", nullable = false)
	private LocalDate dataAvaria;
	
	@NotNull
	@PastOrPresent
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_resolucao")
	private LocalDate dataResolucao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "carrinha_id")
	private Carrinha carrinha;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "avaria_id")
	private Avaria avaria;

	public LocalDate getDataAvaria() {
		return dataAvaria;
	}

	public void setDataAvaria(LocalDate dataAvaria) {
		this.dataAvaria = dataAvaria;
	}

	public LocalDate getDataResolucao() {
		return dataResolucao;
	}

	public void setDataResolucao(LocalDate dataResolucao) {
		this.dataResolucao = dataResolucao;
	}

	public Carrinha getCarrinha() {
		return carrinha;
	}

	public void setCarrinha(Carrinha carrinha) {
		this.carrinha = carrinha;
	}

	public Avaria getAvaria() {
		return avaria;
	}

	public void setAvaria(Avaria avaria) {
		this.avaria = avaria;
	}
	
	
}
