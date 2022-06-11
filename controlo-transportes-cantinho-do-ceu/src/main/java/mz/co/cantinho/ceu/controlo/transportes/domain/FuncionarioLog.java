package mz.co.cantinho.ceu.controlo.transportes.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionario_logs")
public class FuncionarioLog extends EntidadeAbstrata<Long>{

	@Column
	@NotNull
	@PastOrPresent
	LocalDate login;
	
	@Column
	@PastOrPresent
	LocalDate logout;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_funcionario_id")
	ContaFuncionario conta;

	public LocalDate getLogin() {
		return login;
	}

	public void setLogin(LocalDate login) {
		this.login = login;
	}

	public LocalDate getLogout() {
		return logout;
	}

	public void setLogout(LocalDate logout) {
		this.logout = logout;
	}

	public ContaFuncionario getConta() {
		return conta;
	}

	public void setConta(ContaFuncionario conta) {
		this.conta = conta;
	}
	
}
