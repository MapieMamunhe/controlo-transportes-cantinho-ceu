package mz.co.cantinho.ceu.controlo.transportes.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@SuppressWarnings("serial")
@Table(name = "funcionario_residencia")
public class Residencia extends EntidadeAbstrata<Long>{

	@NotNull
	@Digits(fraction = 0, integer = 2)
	@Positive
	int quarteirao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	Funcionario funcionario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_zona")
	Zona zona;

	public int getQuarteirao() {
		return quarteirao;
	}

	public void setQuarteirao(int quarteirao) {
		this.quarteirao = quarteirao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	
}
