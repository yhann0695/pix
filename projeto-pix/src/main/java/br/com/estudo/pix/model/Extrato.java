package br.com.estudo.pix.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.estudo.pix.enums.OperacaoBancariaEnum;
import br.com.estudo.pix.enums.OperacaoBancariaEnumConverter;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_EXTRATO")
@Getter
@Setter
public class Extrato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4797152393678864669L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_EXTRATO")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_CONTA")
	private Conta conta;
	
	@Convert(converter = OperacaoBancariaEnumConverter.class)
	@Column(name = "IC_EXTRATO")
	private OperacaoBancariaEnum operacao;
	
	@Column(name = "VL_EXTRATO")
	private Double valorExtrato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_EXTRATO")
	private Date dataExtrato;
}
