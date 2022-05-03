package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "contafuncionario")
public class ContaFuncionario extends EntidadeAbstrata<Long>{

	/*
	 * @NotNull
	 * 
	 * @NotBlank
	 * 
	 * @Size(min = 3, max = 30)
	 * 
	 * @Column(name = "nome_utilizador", nullable = false, length = 30) private
	 * String nomeUtilizador;
	 */
	
	@NotBlank
	@NotNull
	@Size(min = 4, max = 100)
	@Column(name = "palavra_passe", nullable = false, length = 100)
	private String palavraPasse;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	/*
	 * public String getNomeUtilizador() { return nomeUtilizador; }
	 * 
	 * public void setNomeUtilizador(String nomeUtilizador) { this.nomeUtilizador =
	 * nomeUtilizador; }
	 */

	public String getPalavraPasse() {
		return palavraPasse;
	}

	public void setPalavraPasse(String palavraPasse) {
		this.palavraPasse = palavraPasse;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
}
