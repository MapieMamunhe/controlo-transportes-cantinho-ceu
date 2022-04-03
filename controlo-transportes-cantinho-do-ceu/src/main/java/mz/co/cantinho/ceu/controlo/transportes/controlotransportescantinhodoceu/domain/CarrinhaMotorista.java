package mz.co.cantinho.ceu.controlo.transportes.controlotransportescantinhodoceu.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "carrinhamotorista")
public class CarrinhaMotorista {

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = false)
	private LocalDate dataAlocacao;
	
	@ManyToOne
	@JoinColumn(name = "motorista")
	private Motorista motorista;
	
	@ManyToOne
	@JoinColumn(name = "carrinha")
	private Carrinha carrinha;

	public LocalDate getDataAlocacao() {
		return dataAlocacao;
	}

	public void setDataAlocacao(LocalDate dataAlocacao) {
		this.dataAlocacao = dataAlocacao;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Carrinha getCarrinha() {
		return carrinha;
	}

	public void setCarrinha(Carrinha carrinha) {
		this.carrinha = carrinha;
	}
	
}
