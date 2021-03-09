package br.com.estudo.pix.controller.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginacaoDTO<F> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1622084732964497537L;

	private Integer quantidadePorPagina;
	private Integer numeroPagina;
	private F filtro;
}
