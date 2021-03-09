package br.com.estudo.pix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.pix.controller.dto.ExtratoDTO;
import br.com.estudo.pix.controller.dto.PaginacaoDTO;
import br.com.estudo.pix.service.ExtratoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/consumer")
public class ContaController {

	@Autowired
	private ExtratoService extratoService;

	
	@ApiOperation(value = "Endpoint que retorna os extratos paginado")
	@PostMapping(value = "/consultar-paginadoE", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ExtratoDTO>> consultarPaginadoExtrato(@RequestBody PaginacaoDTO<String> paginacaoDTO){
		return ResponseEntity.ok(extratoService.consultarPaginadoExtrato(paginacaoDTO));
	}
}