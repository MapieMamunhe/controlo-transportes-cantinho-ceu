package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfil")
public class Perfil extends EntidadeAbstrata<Long>{

	@NotNull
	@NotBlank
	@Size(min = 3, max = 100)
	@Column
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
