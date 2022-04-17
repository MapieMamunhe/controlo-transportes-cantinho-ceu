package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "avaria")
public class Avaria extends EntidadeAbstrata<Long>{

	@NotNull
	@NotBlank
	@Size(max = 250)
	@Column(nullable = false, length = 250)
	private String tipo;
	
	@NotNull
	@NotBlank
	@Column()
	private String descricao;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricaco) {
		this.descricao = descricaco;
	}
		
}
