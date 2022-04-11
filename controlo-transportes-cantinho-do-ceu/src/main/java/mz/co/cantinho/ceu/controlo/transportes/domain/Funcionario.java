package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionario")
public class Funcionario extends EntidadeAbstrata<Long>{

	@Column(nullable = false, length = 200)
	private String nome;
	
	@Column(nullable = false, length = 45)
	private String apelido;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(nullable = false, length = 1)
	private String sexo;
	
	/*@Column(nullable = false)
	private String documento;*/
	
	@Column(name = "tipo_documento", nullable = false)
	private String tipoDocumento;
	
	@Column(name = "nr_documento", nullable = false)
	private String nrDocumento;
	
	@Column(nullable = false, length = 16)
	private String telefone;
	
	@Column(name = "telefone_alternativo", length = 16)
	private String telefoneAlternativo;
	
	@Column()
	private String email;
	
	@Column(nullable = false)
	private String residencia;

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
	
	
}
