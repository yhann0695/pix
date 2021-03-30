package br.com.producer.pix.model.dto;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class OperacaoBancariaDTO implements Serializable{

    private static final long serialVersionUID = 1764240110713813213L;

    private BigDecimal valor;

    private String numeroContaOrigem;

    private String numeroContaDestino;
}

