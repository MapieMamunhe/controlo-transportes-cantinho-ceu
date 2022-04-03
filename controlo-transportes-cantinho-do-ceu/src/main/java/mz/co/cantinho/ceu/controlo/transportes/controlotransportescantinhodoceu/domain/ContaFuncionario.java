package mz.co.cantinho.ceu.controlo.transportes.controlotransportescantinhodoceu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "contafuncionario")
public class ContaFuncionario extends EntidadeAbstrata<Long>{

	@Column(name = "nome_utilizador", nullable = false, length = 30)
	private String nomeUtilizador;
	
	@Column(name = "palavra_passe", nullable = false, length = 100)
	private String palavraPasse;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
