package br.com.estudo.pix.dto.dto;

import java.io.Serializable;

public class ContaDto implements Serializable{
    
    private static final long serialVersionUID = -5967339699399682360L;


	private Long id;


	private String numero;

	public ContaDto(final Long id, final String numero) {
		this.id = id;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

}