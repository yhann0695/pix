package br.com.estudo.pix.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.pix.dto.dto.OperacaoBancariaDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConsumoService {

    @Autowired
    private ContaService contaService;

    @RabbitListener(queues = "fila-deposito-dinheiro")
    public void consumerFilaDepositoDinheiro(Message message) {
        try {
            OperacaoBancariaDto dto = new ObjectMapper().readValue(new String(message.getBody()),
                    OperacaoBancariaDto.class);

            contaService.realizaDeposito(dto);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "fila-saque")
    public void consumerFilaSaque(Message message) {
        try {
            OperacaoBancariaDto dto = new ObjectMapper().readValue(new String(message.getBody()),
                    OperacaoBancariaDto.class);

            contaService.realizarSaque(dto);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "fila-transferencia")
    public void consumerFilaTransferencia(Message message) {
        try {
            OperacaoBancariaDto dto = new ObjectMapper().readValue(new String(message.getBody()),
					OperacaoBancariaDto.class);
			contaService.realizarTransferencia(dto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	
	

}
