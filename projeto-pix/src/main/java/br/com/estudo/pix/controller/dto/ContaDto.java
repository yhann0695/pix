package br.com.estudo.pix.controller.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDto implements Serializable{
    
    private static final long serialVersionUID = -5967339699399682360L;

	private Long id;
	
	private String numConta;
	
	private Double valor;
}