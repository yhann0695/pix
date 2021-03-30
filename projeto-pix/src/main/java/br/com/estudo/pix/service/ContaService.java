package br.com.estudo.pix.service;

import javax.transaction.Transactional;

import br.com.estudo.pix.dto.dto.ContaDto;
import br.com.estudo.pix.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.pix.dto.dto.OperacaoBancariaDto;
import br.com.estudo.pix.model.Conta;
import br.com.estudo.pix.repository.ContaRepository;

import java.util.Optional;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;


	//TODO Não é uma boa prática service chamar service
//	@Autowired
//	private ExtratoService extratoService;

	@Transactional
	public void realizaDeposito(OperacaoBancariaDto operacao) {
//		Conta conta = contaRepository.findByNumConta(operacao.getNumeroContaDestino());
//		conta.setValor(conta.getValor() + operacao.getValor());
//		contaRepository.save(conta);
//
//		extratoService.inserirExtratoConta(operacao, conta);
	}

	@Transactional
	public void realizarSaque(OperacaoBancariaDto operacao) {
//		Conta conta = contaRepository.findByNumConta(operacao.getNumeroContaOrigem());

//		Double valorSubtracao = conta.getValor() - operacao.getValor();

//		if (valorSubtracao > 0) {
//			conta.setValor(valorSubtracao);
//			contaRepository.save(conta);
		//}//
//		extratoService.inserirExtratoConta(operacao, conta);
	}

	@Transactional
	public Conta consultarPorNumeroConta(String numeroConta) {
//		return contaRepository.findByNumConta(numeroConta);

		return null;
	}

	@Transactional
	public void realizarTransferencia(OperacaoBancariaDto operacao) {
//		Conta contaOrigem = contaRepository.findByNumConta(operacao.getNumeroContaOrigem());
//		Conta contaDestino = contaRepository.findByNumConta(operacao.getNumeroContaDestino());
//		if (operacao.getValor() <= contaOrigem.getValor()) {
//			contaOrigem.setValor(contaOrigem.getValor() - operacao.getValor());
//			contaDestino.setValor(contaDestino.getValor() + operacao.getValor());
//			contaRepository.save(contaOrigem);
//			contaRepository.save(contaDestino);
//			extratoService.inserirExtratoConta(operacao, contaOrigem);
//			operacao.setOperacaoBancaria(new SelectedItemDto(OperacaoBancariaEnum.DEPOSITO_DINHEIRO.getCodigo(),
//					OperacaoBancariaEnum.DEPOSITO_DINHEIRO.getDescricao()));
//			extratoService.inserirExtratoConta(operacao, contaDestino);
//		}
	}

    public ContaDto criaConta() {

		Conta contaSalva = contaRepository.save(new Conta());

		return new ContaDto(contaSalva.getId(), contaSalva.getNumero());
    }

	public ContaDto getConta(final Long id) {
		Optional<Conta> contaOptional = contaRepository.findById(id);

		if(contaOptional.isPresent()) {
			Conta conta = contaOptional.get();
			return new ContaDto(conta.getId(), conta.getNumero());
		}

//		throw NotFoundException

		return null;
	}

}
