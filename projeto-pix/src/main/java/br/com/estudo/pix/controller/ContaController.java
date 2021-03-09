package br.com.estudo.pix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.pix.controller.dto.OperacaoBancariaDto;
import br.com.estudo.pix.model.Conta;
import br.com.estudo.pix.service.ContaService;

@RestController
@RequestMapping(name = "/conta")
public class ContaController {
    
    @Autowired
    private ContaService service;

    @PostMapping("/criar")
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {
        return ResponseEntity.ok(service.criarConta(conta));
    }

    @PutMapping("/deposito/{codigo}")
    public ResponseEntity<Void> realizarDeposito(@PathVariable("codigo") String codigo, @RequestBody Conta conta) {
        service.realizarDeposito(conta.getNumConta(), conta.getValor());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/saque/{codigo}")
    public ResponseEntity<Void> realizarSaque(@PathVariable("codigo") String codigo, @RequestBody Conta conta) {
        service.realizarSaque(conta.getValor(), conta.getNumConta());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/transferencia/{codigo}")
    public ResponseEntity<Void> realizarTransferencia(@PathVariable("codigo") String codigo, @RequestBody Conta conta) {
        service.realizarTransferencia(conta.getValor(), conta.getNumConta());
        return ResponseEntity.ok().build();
    }
}