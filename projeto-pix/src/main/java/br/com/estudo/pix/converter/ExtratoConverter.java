package br.com.estudo.pix.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.estudo.pix.controller.dto.ExtratoDTO;
import br.com.estudo.pix.controller.dto.SelectedItemDto;
import br.com.estudo.pix.enums.OperacaoBancariaEnum;
import br.com.estudo.pix.model.Extrato;

@Component
public class ExtratoConverter {

    @Autowired
    private ContaConverter contaConverter;

    public Extrato converterExtratoDTOParaExtrato(ExtratoDTO extratoDTO) {
        Extrato extrato = new Extrato();
        extrato.setId(extratoDTO.getId());
        extrato.setConta(contaConverter.converterContaParaContaDTO(extratoDTO.getConta()));
        extrato.setOperacao(OperacaoBancariaEnum.recuperarEnum(extratoDTO.getOperacao().getValue()));
        extrato.setDataExtrato(extratoDTO.getDataExtrato());
        extrato.setValorExtrato(extratoDTO.getValorExtrato());
        return extrato;
    }

    public ExtratoDTO converterExtratoParaExtratoDTO(Extrato extrato) {
        ExtratoDTO dto = new ExtratoDTO();
        dto.setId(extrato.getId());
        dto.setConta(contaConverter.converterContaDTOParaConta(extrato.getConta()));
        dto.setOperacao(new SelectedItemDto(extrato.getOperacao().getCodigo(), extrato.getOperacao().getDescricao()));
		dto.setDataExtrato(extrato.getDataExtrato());
		dto.setValorExtrato(extrato.getValorExtrato());
		return dto;
	}
	
	public List<ExtratoDTO> converterListExtratoParaExtratoDTO(List<Extrato> extratos) {
		List<ExtratoDTO> listaDTO =  new ArrayList<ExtratoDTO>();
		for (Extrato extrato : extratos) {
			listaDTO.add(converterExtratoParaExtratoDTO(extrato));
		}
		return listaDTO;
	}
}
