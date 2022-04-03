package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "encarregado")
public class Encarregado extends EntidadeAbstrata<Long>{

	@Column(nullable = false, length = 200)
	private String nome;
	
	@Column(nullable = false, length = 45)
	private String apelido;
	
	@Column(nullable = false, length = 16)
	private String telefone;
	
	@Column(name = "telefone_alternativo", nullable = false, length = 16)
	private String telefoneAlternativo;
	
	@Column(nullable = false)
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneAlternativo() {
		return telefoneAlternativo;
	}

	public void setTelefoneAlternativo(String telefoneAlternativo) {
		this.telefoneAlternativo = telefoneAlternativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
