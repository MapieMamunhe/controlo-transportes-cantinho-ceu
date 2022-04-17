package mz.co.cantinho.ceu.controlo.transportes.domain;

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
@Table(name = "contaencarregado")
public class ContaEncarregado extends EntidadeAbstrata<Long>{

	@NotNull
	@NotBlank
	@Size(min = 3, max = 30)
	@Column(name = "nome_utilizador", nullable = false, length = 30)
	private String nomeUtilizador;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max = 100)
	@Column(name = "palavra_passe", nullable = false, length = 100)
	private String palavraPasse;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "encarregado_id")
	private Encarregado encarregado;

	public String getNomeUtilizador() {
		return nomeUtilizador;
	}

	public void setNomeUtilizador(String nomeUtilizador) {
		this.nomeUtilizador = nomeUtilizador;
	}

	public String getPalavraPasse() {
		return palavraPasse;
	}

	public void setPalavraPasse(String palavraPasse) {
		this.palavraPasse = palavraPasse;
	}

	public Encarregado getEncarregado() {
		return encarregado;
	}

	public void setEncarregado(Encarregado encarregado) {
		this.encarregado = encarregado;
	}
	
}
