package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "avaria")
public class Avaria extends EntidadeAbstrata<Long>{

	@Column(nullable = false, length = 250)
	private String tipo;
	
	@Column()
	private String descricaco;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricaco() {
		return descricaco;
	}

	public void setDescricaco(String descricaco) {
		this.descricaco = descricaco;
	}
		
}
