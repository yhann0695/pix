package br.com.estudo.pix.controller.dto;

import java.io.Serializable;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtratoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9095086936953214410L;

	private Long id;
	
	private ContaDto conta;
	
	private SelectedItemDto operacao;
	
	private Double valorExtrato;
	
	private Date dataExtrato;

}
