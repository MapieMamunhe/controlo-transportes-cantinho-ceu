package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "crianca_encarregado")
public class CriancaEncarregado implements Serializable{

	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "crianca_id")
	private Crianca crianca;
	
	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "encarregado_id")
	private Encarregado encarregado;

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public Encarregado getEncarregado() {
		return encarregado;
	}

	public void setEncarregado(Encarregado encarregado) {
		this.encarregado = encarregado;
	}
	
}
