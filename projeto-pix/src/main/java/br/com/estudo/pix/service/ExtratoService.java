package br.com.estudo.pix.service;

import br.com.estudo.pix.controller.dto.ExtratoDTO;
import br.com.estudo.pix.controller.dto.OperacaoBancariaDto;
import br.com.estudo.pix.controller.dto.PaginacaoDTO;
import br.com.estudo.pix.converter.ExtratoConverter;
import br.com.estudo.pix.enums.OperacaoBancariaEnum;
import br.com.estudo.pix.exceptions.NotFoundException;
import br.com.estudo.pix.model.Conta;
import br.com.estudo.pix.model.Extrato;
import br.com.estudo.pix.repository.IExtratoRepository;
import br.com.estudo.pix.utils.Mensagens;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExtratoService {

    @Autowired
    private IExtratoRepository extratoRepository;

    @Autowired
    private ExtratoConverter extratoConverter;

    @Transactional
    public void inserirExtratoConta(OperacaoBancariaDto operacao, Conta conta) {
		Extrato extrato = new Extrato();

		extrato.setConta(conta);
		extrato.setOperacao(OperacaoBancariaEnum.recuperarEnum(operacao.getOperacaoBancaria().getValue()));
		extrato.setValorExtrato(operacao.getValor());
		extrato.setDataExtrato(new Date());
		extratoRepository.save(extrato);
	}

	@Transactional
	public Page<ExtratoDTO> consultarPaginadoExtrato(PaginacaoDTO<String> paginacaoDTO) {
		Pageable paginacao = PageRequest.of(paginacaoDTO.getNumeroPagina(), paginacaoDTO.getQuantidadePorPagina());
		Page<Extrato> lista = null;
		lista = extratoRepository.findByContaNumConta(paginacao, paginacaoDTO.getFiltro());

		if (!lista.hasContent()) {
			throw new NotFoundException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
		}
		return new PageImpl<ExtratoDTO>(extratoConverter.converterListExtratoParaExtratoDTO(lista.getContent()), paginacao, lista.getTotalElements());
	}
}
