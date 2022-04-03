package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "crianca")
public class Crianca extends EntidadeAbstrata<Long>{

	@Column(nullable = false, length = 200)
	private String nome;
	
	@Column(nullable = false, length = 45)
	private String apelido;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	@ManyToOne
	@JoinColumn(name = "encarregado_id")
	private Encarregado encarregado;

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

	public Encarregado getEncarregado() {
		return encarregado;
	}

	public void setEncarregado(Encarregado encarregado) {
		this.encarregado = encarregado;
	}
	
	
}
