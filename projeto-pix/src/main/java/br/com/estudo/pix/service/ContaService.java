package br.com.estudo.pix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.pix.controller.dto.OperacaoBancariaDto;
import br.com.estudo.pix.exceptions.ErrorException;
import br.com.estudo.pix.model.Conta;
import br.com.estudo.pix.repository.IContaRepository;

@Service
public class ContaService {
    
    @Autowired
    private IContaRepository repository;

    public Conta criarConta(Conta conta)  {
        this.verificarNumeroConta(conta.getNumConta());
        return repository.save(conta);
    }

    public void realizarDeposito(String numConta, Double valor) {
		Double saldo = 0.0;
		Conta conta = repository.findByNumConta(numConta);
		this.verificarExistenciaCodigo(conta.getId());
		if(conta.getNumConta().equalsIgnoreCase(numConta)) {
			saldo += conta.getValor() + valor;
			conta.setValor(saldo);
			repository.save(conta);
		} else {
			throw new ErrorException("Número de conta não encontrado");
		}
	}

    public void realizarSaque(Double valor, String numConta) {
		Conta conta = repository.findByNumConta(numConta);
		Double valorSubtracao = conta.getValor() - valor;
		if(valorSubtracao < 0) {
			throw new ErrorException("Valor inválido");
		} else {
			conta.setValor(valorSubtracao);
			repository.save(conta);
		}
	}

    public void realizarTransferencia(Double valor, String numConta, OperacaoBancariaDto operacao) {
		Conta contaOrigem = repository.findByNumConta(operacao.getNumContaOrigem());
		Conta contaDestino = repository.findByNumConta(operacao.getNumContaDestino());
		if(valor >= 0) {
			contaOrigem.setValor(contaOrigem.getValor() - valor);
			contaDestino.setValor(contaDestino.getValor() + valor);
			repository.save(contaOrigem);
			repository.save(contaDestino);
		} else {
			throw new ErrorException("Valor inválido");
		}

	}

    private void verificarExistenciaCodigo(Long id) {
		Optional<Conta> conta = repository.findById(id);
		if(!conta.isPresent()) {
			throw new ErrorException("Conta não encontrada");
		}
	}

    private void verificarNumeroConta(String numConta) {
		Optional<Conta> isExiste = repository.buscarNumeroConta(numConta);
		if(isExiste.isPresent()){
			throw new ErrorException("Já existe uma conta criada");
		}
	}
}