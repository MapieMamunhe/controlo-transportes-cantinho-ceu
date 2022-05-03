package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "crianca")
public class Crianca extends EntidadeAbstrata<Long>{

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
	@Past
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
