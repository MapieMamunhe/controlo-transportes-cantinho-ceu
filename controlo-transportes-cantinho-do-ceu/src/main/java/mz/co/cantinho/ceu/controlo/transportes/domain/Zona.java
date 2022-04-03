package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "zona")
public class Zona extends EntidadeAbstrata<Long>{

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
}
