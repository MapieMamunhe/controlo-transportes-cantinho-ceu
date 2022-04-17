package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "encarregado")
public class Encarregado extends EntidadeAbstrata<Long>{

	@NotNull
	@NotBlank
	@Size(min = 3, max = 200)
	@Column(nullable = false, length = 200)
	private String nome;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 45)
	@Column(nullable = false, length = 45)
	private String apelido;
	
	@NotNull
	@NotBlank
	@Size(min = 9, max = 16)
	@Column(nullable = false, length = 16)
	private String telefone;
	
	@Column(name = "telefone_alternativo", nullable = false, length = 16)
	private String telefoneAlternativo;

	@Email
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
