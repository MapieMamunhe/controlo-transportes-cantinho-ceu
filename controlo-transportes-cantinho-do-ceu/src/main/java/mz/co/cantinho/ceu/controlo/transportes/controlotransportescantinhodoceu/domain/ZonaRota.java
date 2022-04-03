package mz.co.cantinho.ceu.controlo.transportes.controlotransportescantinhodoceu.domain;

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
@Table(name = "zonaRota")
public class ZonaRota extends EntidadeAbstrata<Long> {

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_atribuicao", nullable = false)
	LocalDate dataAtribuicao;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_fim")
	LocalDate dataFim;
	
	@ManyToOne
	@JoinColumn(name = "rota_id", nullable = false)
	private Rota rota;
	
	@ManyToOne
	@JoinColumn(name = "zona_ud", nullable = false)
	private Zona zona;
	
}
