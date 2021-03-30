package br.com.estudo.pix;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.estudo.pix.exceptions.ErrorException;
import br.com.estudo.pix.model.Conta;
import br.com.estudo.pix.service.ContaService;

//@SpringBootTest
class DemoApplicationTests {

//	@Autowired
//	private ContaService service;
//
//	@Test
//	void contextLoads() {
//
//	}

       //	@Test
	void criarConta() {
		try {
			Conta conta = new Conta();
//			conta.setNumConta("1234567");
//			service.criarConta(conta);
		} catch (ErrorException e) {
			System.out.println("--------------- Erro: " + e.getMessage());
		}
	}

	void depositar() {
		
		
	}

}
