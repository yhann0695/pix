package br.com.producer.pix.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OperacaoBancariaDTO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1764240110713813213L;

    private SelectItemDTO operacaoBancaria;
    private Double valor;
    private String numeroContaOrigem;
    private String numeroContaDestino;
}

