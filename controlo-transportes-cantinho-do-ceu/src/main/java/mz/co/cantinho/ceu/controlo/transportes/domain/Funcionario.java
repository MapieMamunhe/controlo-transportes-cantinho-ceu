package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionario")
public class Funcionario extends EntidadeAbstrata<Long>{

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
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@NotNull
	@Column(nullable = false, length = 1)
	private String sexo;
	
	@NotNull
	@Column(name = "tipo_documento", nullable = false)
	private String tipoDocumento;
	
	@NotNull
	@NotBlank
	@Column(name = "nr_documento", nullable = false)
	private String nrDocumento;
	
	@NotNull
	@NotBlank
	@Size(min = 9, max = 16)
	@Column(nullable = false, length = 16)
	private String telefone;
	
	@Column(name = "telefone_alternativo", length = 16)
	private String telefoneAlternativo;
	
	@Column()
	private String email;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String residencia;
	
	@Valid
	@NotNull
	@Transient
	private String papel;

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

	public String getSexo() {
		return sexo;
	}

	
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNrDocumento() {
		return nrDocumento;
	}

	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	
}
