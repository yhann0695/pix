package br.com.producer.pix.controller;

import java.util.List;

import br.com.producer.pix.model.dto.OperacaoBancariaDTO;
import br.com.producer.pix.model.dto.SelectItemDTO;
import br.com.producer.pix.service.ProducerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @ApiOperation(value = "endpoint para inserção de mensagem no broker")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperacaoBancariaDTO> salvarMensagem(@RequestBody OperacaoBancariaDTO operacao) {
        return ResponseEntity.ok(producerService.salvarMensagem(operacao));
    }

    @ApiOperation(value = "Endpoint para resgatar todos os valores da operação bancária")
    @GetMapping(value = "/consulta-itens", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SelectItemDTO>> recuperarItemsSelecionaveis() {
        return ResponseEntity.ok(producerService.recuperarItens());
    }
}
