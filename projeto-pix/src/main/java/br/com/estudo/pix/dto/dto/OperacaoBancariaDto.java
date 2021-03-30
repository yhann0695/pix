package br.com.estudo.pix.dto.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperacaoBancariaDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private SelectedItemDto operacaoBancaria;
    private String numeroContaOrigem;
	private String numeroContaDestino;
    private Double valor;
}