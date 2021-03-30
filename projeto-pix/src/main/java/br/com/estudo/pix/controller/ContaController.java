package br.com.estudo.pix.controller;

import br.com.estudo.pix.dto.dto.ContaDto;
import br.com.estudo.pix.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/v1/contas")
public class ContaController {

	//TODO ContaConntroller usando ExtratoService
//	@Autowired
//	private ExtratoService extratoService;

	@Autowired
	private ContaService contaService;


	//TODO poderia ter deixado documentacao pra depois
//	@ApiOperation(value = "Endpoint que retorna os extratos paginado")
	//TODO consulta não pode ser post
//	@PostMapping(value = "/consultar-paginadoE", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Page<ExtratoDTO>> consultarPaginadoExtrato(@RequestBody PaginacaoDTO<String> paginacaoDTO){
//		return ResponseEntity.ok(extratoService.consultarPaginadoExtrato(paginacaoDTO));
//	}



	//Na vidia real seria dados pessoais mas vamos deixar isso pra dpeois
	@PostMapping
	public ResponseEntity<ContaDto> criaConta() {
		ContaDto dto = contaService.criaConta();
		return ResponseEntity.created(URI.create("/v1/contas/" + dto.getId())).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaDto> getConta(@PathVariable("id") Long id){
		ContaDto dto = contaService.getConta(id);
		return ResponseEntity.ok(dto);
	}
}