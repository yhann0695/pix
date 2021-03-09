package br.com.estudo.pix.converter;

import org.springframework.stereotype.Component;

import br.com.estudo.pix.controller.dto.ContaDto;
import br.com.estudo.pix.model.Conta;

@Component
public class ContaConverter {

	public Conta converterContaParaContaDTO(ContaDto contaDTO) {
		Conta conta = new Conta();
		conta.setId(contaDTO.getId());
		conta.setNumConta(contaDTO.getNumConta());
		conta.setValor(contaDTO.getValor());
		return conta;
	}

	public ContaDto converterContaDTOParaConta(Conta conta) {
		ContaDto dto = new ContaDto();
		dto.setId(conta.getId());
		dto.setNumConta(conta.getNumConta());
		dto.setValor(conta.getValor());
		return dto;
	}
}